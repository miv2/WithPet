package me.miv.toyserver.like.repository;

import me.miv.toyserver.like.domain.MemberLike;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberLikeJpaRepository extends JpaRepository<MemberLike, Long> {
    Boolean existsByMemberIdAndLikeProfileId(Long memberId, Long likeProfileId);

    MemberLike findByMemberIdAndAndLikeProfileId(Long memberId, Long likeProfileId);
}
