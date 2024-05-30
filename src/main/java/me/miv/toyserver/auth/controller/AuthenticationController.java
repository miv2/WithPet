package me.miv.toyserver.auth.controller;

import me.miv.toyserver.auth.dto.request.LoginRequest;
import me.miv.toyserver.auth.dto.request.SignUpRequest;
import me.miv.toyserver.auth.service.AuthenticationService;
import me.miv.toyserver.common.response.ApplicationResponse;
import me.miv.toyserver.common.response.ApplicationResult;
import me.miv.toyserver.member.service.MemberService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthenticationController {
    private final MemberService memberService;
    private final AuthenticationService authenticationService;

    public AuthenticationController(MemberService memberService, AuthenticationService authenticationService) {
        this.memberService = memberService;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/sign-up")
    public ApplicationResponse signUp(@RequestBody SignUpRequest signUpRequest) {
        authenticationService.signUp(signUpRequest);
        return new ApplicationResponse(ApplicationResult.ok("회원가입"), "");
    }

    @PostMapping("/sign-in")
    public ApplicationResponse signIn(@RequestBody LoginRequest loginRequest) {
        return new ApplicationResponse(ApplicationResult.ok("로그인"), authenticationService.authentication(loginRequest));
    }

    @GetMapping("/check/duplicate")
    public ApplicationResponse checkDuplicatedLoginId(@RequestParam("loginId") String loginId) {
        return new ApplicationResponse(ApplicationResult.ok("이메일 중복 체크"), memberService.existsLoginId(loginId));
    }

    @PostMapping("/token/generate/access")
    public ApplicationResponse reGenerateAccessToken(@RequestHeader("X-REFRESH-TOKEN") String refreshToken) {
        return new ApplicationResponse(ApplicationResult.ok("액세스 토큰 재발행"), authenticationService.generateTokenByRefreshToken(refreshToken));
    }

    @PostMapping("/token/generate/refresh")
    public ApplicationResponse reGenerateRefreshToken(@RequestHeader("X-REFRESH-TOKEN") String refreshToken) {
        return new ApplicationResponse(ApplicationResult.ok("리프레쉬 토큰 재발생"), authenticationService.generateNewRefreshToken(refreshToken));
    }

}