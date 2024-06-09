package me.miv.toyserver.member.response;

import me.miv.toyserver.member.domain.Member;

public class MemberInfoResponse {
    private Long id;
    private String loginId;
    private String nickName;
    private String sexType;
    private int age;
    private String role;

    public MemberInfoResponse(Member member) {
        this.id = member.getId();
        this.loginId = member.getLoginId();
        this.nickName = member.getNickName();
        this.sexType = member.getSexType().toString();
        this.age = member.getAge();
        this.role = member.getRole().getRoleName();
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
}
