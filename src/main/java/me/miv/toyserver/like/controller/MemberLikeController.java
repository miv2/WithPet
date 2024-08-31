package me.miv.toyserver.like.controller;

import me.miv.toyserver.common.response.ApplicationResponse;
import me.miv.toyserver.common.response.ApplicationResult;
import me.miv.toyserver.like.service.MemberLikeService;
import me.miv.toyserver.member.domain.Member;
import me.miv.toyserver.security.domain.MemberDetails;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/like")
public class MemberLikeController {

    private final MemberLikeService memberLikeService;

    public MemberLikeController(MemberLikeService memberLikeService) {
        this.memberLikeService = memberLikeService;
    }

    @PostMapping
    public ApplicationResponse saveLike(@AuthenticationPrincipal MemberDetails memberDetails,
                                        @RequestBody Long likeProfileId) {
        return ApplicationResponse.ok("좋아요", memberLikeService.saveLike(memberDetails, likeProfileId));

    }

    @DeleteMapping("/{likeProfileId}")
    public ApplicationResponse deleteLike(@AuthenticationPrincipal MemberDetails memberDetails,
                                          @PathVariable Long likeProfileId) {
        return ApplicationResponse.ok("좋아요 삭제", memberLikeService.deleteLike(memberDetails, likeProfileId));
    }

}
