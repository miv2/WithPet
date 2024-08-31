package me.miv.toyserver.like.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;

@Repository
public class MemberLikeRepository {

    private final JPAQueryFactory jpaQueryFactory;
    private final MemberLikeJpaRepository memberLikeJpaRepository;

    public MemberLikeRepository(JPAQueryFactory jpaQueryFactory, MemberLikeJpaRepository memberLikeJpaRepository) {
        this.jpaQueryFactory = jpaQueryFactory;
        this.memberLikeJpaRepository = memberLikeJpaRepository;
    }

    public Boolean existsMemberIdAndLikeProfileId(Long memberId, Long likeProfileId) {
        return memberLikeJpaRepository.existsByMemberIdAndLikeProfileId(memberId, likeProfileId);
    }


}
