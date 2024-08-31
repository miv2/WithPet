package me.miv.toyserver.member.controller;

import me.miv.toyserver.common.response.ApplicationResponse;
import me.miv.toyserver.member.domain.Member;
import me.miv.toyserver.member.response.MemberInfoResponse;
import me.miv.toyserver.region.domain.Region;
import me.miv.toyserver.region.service.RegionService;
import me.miv.toyserver.security.domain.MemberDetails;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/member")
public class MemberController {

    private final RegionService regionService;

    public MemberController(RegionService regionService) {
        this.regionService = regionService;
    }

    @GetMapping
    public ApplicationResponse getMemberInfo(@AuthenticationPrincipal MemberDetails memberDetails) {
        Member member = memberDetails.getMember();
        Region region = regionService.getUserRegionInfo(member.getId());

        MemberInfoResponse memberInfoResponse = new MemberInfoResponse(member, region);

        return ApplicationResponse.ok("내 정보 조회", memberInfoResponse);
    }

}
