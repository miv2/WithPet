package me.miv.toyserver.member.response;

import me.miv.toyserver.member.domain.Member;
import me.miv.toyserver.region.domain.Region;

public class MemberInfoResponse {
    private Long id;
    private String loginId;
    private String nickName;
    private String sexType;
    private int age;
    private String role;

    private Region region;

    public MemberInfoResponse(Member member, Region region) {
        this.id = member.getId();
        this.loginId = member.getLoginId();
        this.nickName = member.getNickName();
        this.sexType = member.getSexType().toString();
        this.age = member.getAge();
        this.role = member.getRole().getRoleName();
        this.region = region;
    }

    public Long getId() {
        return id;
    }

    public String getLoginId() {
        return loginId;
    }

    public String getNickName() {
        return nickName;
    }

    public String getSexType() {
        return sexType;
    }

    public int getAge() {
        return age;
    }

    public String getRole() {
        return role;
    }

    public Region getRegion() {
        return region;
    }
}
