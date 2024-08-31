package me.miv.toyserver.matching;

import me.miv.toyserver.common.response.ApplicationResponse;
import me.miv.toyserver.common.response.ApplicationResult;
import me.miv.toyserver.security.domain.MemberDetails;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/match")
public class MatchingController {

    private final MatchingService matchingService;

    public MatchingController(MatchingService matchingService) {
        this.matchingService = matchingService;
    }

    @GetMapping
    public ApplicationResponse getMatchList(@AuthenticationPrincipal MemberDetails member) {
        return new ApplicationResponse<>(ApplicationResult.ok("매칭 조회"), matchingService.getMatchingList(member.getMember().getId()));
    }
}
