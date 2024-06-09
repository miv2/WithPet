package me.miv.toyserver;

import me.miv.toyserver.common.response.ApplicationResponse;
import me.miv.toyserver.common.response.ApplicationResult;
import me.miv.toyserver.file.FileUploadService;
import me.miv.toyserver.member.service.MemberService;
import me.miv.toyserver.security.provider.JwtTokenProvider;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1/test")
public class TestController {

    private final MemberService memberService;
    private final JwtTokenProvider jwtTokenProvider;
    private final FileUploadService fileUploadService;

    public TestController(MemberService memberService, JwtTokenProvider jwtTokenProvider, FileUploadService fileUploadService) {
        this.memberService = memberService;
        this.jwtTokenProvider = jwtTokenProvider;
        this.fileUploadService = fileUploadService;
    }

    @GetMapping
    public ApplicationResponse getTest() {
        System.out.println("테스트");
        return ApplicationResponse.ok("Test API", "");
    }

    @PostMapping("/upload")
    public ApplicationResponse test(@RequestPart("image") MultipartFile multipartFile) {
        String filePath = fileUploadService.fileUpload(multipartFile);
        System.out.println("File path : " + filePath);
        return new ApplicationResponse<>(ApplicationResult.ok("파일 업로드 완료"), "test");
    }

}
