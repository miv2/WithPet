package me.miv.toyserver.like.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "member_like")
public class MemberLike {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "member_id")
    private Long memberId;

    @Column(name = "like_profile_id")
    private Long likeProfileId;

    public MemberLike() {}

    public MemberLike(Long memberId, Long likeProfileId) {
        this.memberId = memberId;
        this.likeProfileId = likeProfileId;
    }

    public Long getId() {
        return id;
    }

    public Long getMemberId() {
        return memberId;
    }

    public Long getLikeProfileId() {
        return likeProfileId;
    }
}
