package me.miv.toyserver.region.controller;

import me.miv.toyserver.common.response.ApplicationResponse;
import me.miv.toyserver.member.domain.Member;
import me.miv.toyserver.provider.kakao.KaKaoService;
import me.miv.toyserver.region.domain.Region;
import me.miv.toyserver.region.dto.request.CoordinatesRequest;
import me.miv.toyserver.region.dto.response.RegionResponse;
import me.miv.toyserver.region.service.RegionService;
import me.miv.toyserver.security.domain.MemberDetails;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/region")
public class RegionController {

    private final KaKaoService kaKaoService;
    private final RegionService regionService;

    public RegionController(KaKaoService kaKaoService, RegionService regionService) {
        this.kaKaoService = kaKaoService;
        this.regionService = regionService;
    }

    @GetMapping
    public ApplicationResponse getUserRegion(
            @AuthenticationPrincipal MemberDetails memberDetails) {
        Region regionInfo = regionService.getUserRegionInfo(memberDetails.getMember().getId());
        return ApplicationResponse.ok("지역 조회", regionInfo);
    }

    @PostMapping
    public ApplicationResponse saveUserRegionInfo(
            @AuthenticationPrincipal MemberDetails memberDetails,
            @RequestBody CoordinatesRequest coordinatesRequest) {
        Member member = memberDetails.getMember();
        // 좌표로 지역을 추출
        RegionResponse regionResponse = kaKaoService.getRegionName(coordinatesRequest);
        // 내 지역 저장
        regionService.saveUserRegionInfo(regionResponse, member);
        return ApplicationResponse.ok("내 지역 저장", "");
    }
}
