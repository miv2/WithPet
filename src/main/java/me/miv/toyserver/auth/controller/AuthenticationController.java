package me.miv.toyserver.auth.controller;

import jakarta.servlet.http.HttpServletResponse;
import me.miv.toyserver.auth.dto.request.LoginRequest;
import me.miv.toyserver.auth.dto.request.SignUpRequest;
import me.miv.toyserver.auth.service.AuthenticationService;
import me.miv.toyserver.common.response.ApplicationResponse;
import me.miv.toyserver.member.service.MemberService;
import me.miv.toyserver.security.exception.MemberAuthenticationException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
//@Tag(name = "User API", description = "User API 입니다.")
public class AuthenticationController {
    private final MemberService memberService;
    private final AuthenticationService authenticationService;

    public AuthenticationController(MemberService memberService, AuthenticationService authenticationService) {
        this.memberService = memberService;
        this.authenticationService = authenticationService;
    }

    //@Operation(summary = "회원가입", description = "유저 회원가입")
    @PostMapping("/sign-up")
    public ApplicationResponse signUp(@RequestBody SignUpRequest signUpRequest) {
        return ApplicationResponse.ok("회원가입", authenticationService.signUp(signUpRequest));
    }

    @PostMapping("/sign-in")
    public ApplicationResponse signIn(@RequestBody LoginRequest loginRequest, HttpServletResponse response) {
        authenticationService.authentication(loginRequest, response);
        return ApplicationResponse.ok("로그인",  "");
    }

    @GetMapping("/check/duplicate")
    public ApplicationResponse checkDuplicatedLoginId(@RequestParam("loginId") String loginId) {
        return ApplicationResponse.ok("이메일 중복 체크", memberService.existsLoginId(loginId));
    }

    @PostMapping("/token/generate/access")
    public ApplicationResponse reGenerateAccessToken(@RequestHeader("X-REFRESH-TOKEN") String refreshToken) {
        return ApplicationResponse.ok("액세스 토큰 재발행", authenticationService.generateTokenByRefreshToken(refreshToken));
    }

    @PostMapping("/token/generate/refresh")
    public ApplicationResponse reGenerateRefreshToken(@RequestHeader("X-REFRESH-TOKEN") String refreshToken) {
        return ApplicationResponse.ok("리프레쉬 토큰 재발생", authenticationService.generateNewRefreshToken(refreshToken));
    }

    @ExceptionHandler
    public ApplicationResponse handleMemberAuthenticationException(MemberAuthenticationException exception) {
        return ApplicationResponse.ok(exception.getMessage(), "");
    }

}
