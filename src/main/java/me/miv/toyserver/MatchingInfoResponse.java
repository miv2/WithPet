package me.miv.toyserver;

import me.miv.toyserver.member.enumeration.SexType;

public class MatchingInfoResponse {
    private Long memberId;
    private String nickName;
    private int age;
    private SexType sexType;
    private String regionName;

    private String profileImage = "";
    private String introduction;
    private String petSize;
    private String petSex;
    private int petAge;
    private Boolean isLike;

    public MatchingInfoResponse(Long memberId, String nickName, int age, SexType sexType, String regionName,
                                String profileImage, String introduction, String petSize, String petSex,
                                int petAge, Boolean isLike) {
        this.memberId = memberId;
        this.nickName = nickName;
        this.age = age;
        this.sexType = sexType;
        this.regionName = regionName;
        this.profileImage = profileImage;
        this.introduction = introduction;
        this.petSize = petSize;
        this.petSex = petSex;
        this.petAge = petAge;
        this.isLike = isLike;
    }

    public Long getMemberId() {
        return memberId;
    }

    public String getNickName() {
        return nickName;
    }

    public int getAge() {
        return age;
    }

    public SexType getSexType() {
        return sexType;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public String getIntroduction() {
        return introduction;
    }

    public String getPetSize() {
        return petSize;
    }

    public String getPetSex() {
        return petSex;
    }

    public int getPetAge() {
        return petAge;
    }

    public String getRegionName() {
        return regionName;
    }

    public Boolean getLike() {
        return isLike;
    }
}
