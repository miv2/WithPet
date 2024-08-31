package me.miv.toyserver.like.service;

import me.miv.toyserver.like.domain.MemberLike;
import me.miv.toyserver.like.repository.MemberLikeJpaRepository;
import me.miv.toyserver.member.domain.Member;
import me.miv.toyserver.security.domain.MemberDetails;
import org.springframework.stereotype.Service;

@Service
public class MemberLikeService {

    private final MemberLikeJpaRepository likeJpaRepository;

    public MemberLikeService(MemberLikeJpaRepository likeJpaRepository) {
        this.likeJpaRepository = likeJpaRepository;
    }

    public String saveLike(MemberDetails memberDetails, Long likeProfileId) {
        MemberLike memberLike = new MemberLike(memberDetails.getMember().getId(), likeProfileId);
        likeJpaRepository.save(memberLike);
        return "";
    }

    public String deleteLike(MemberDetails memberDetails, Long likeProfileId) {
        MemberLike memberLike = likeJpaRepository.findByMemberIdAndAndLikeProfileId(memberDetails.getMember().getId(), likeProfileId);
        likeJpaRepository.delete(memberLike);
        return "";
    }
}
