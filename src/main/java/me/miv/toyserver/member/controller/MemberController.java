package me.miv.toyserver.member.controller;

import me.miv.toyserver.common.response.ApplicationResponse;
import me.miv.toyserver.member.domain.Member;
import me.miv.toyserver.member.response.MemberInfoResponse;
import me.miv.toyserver.security.domain.MemberDetails;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/member")
public class MemberController {

    @GetMapping
    public ApplicationResponse getMemberInfo(@AuthenticationPrincipal MemberDetails memberDetails) {
        Member member = memberDetails.getMember();
        MemberInfoResponse memberInfoResponse = new MemberInfoResponse(member);
        return ApplicationResponse.ok("내 정보 조회", memberInfoResponse);
    }

}
