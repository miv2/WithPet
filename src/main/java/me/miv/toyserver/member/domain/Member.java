package me.miv.toyserver.member.domain;

import jakarta.persistence.*;
import me.miv.toyserver.auth.dto.request.SignUpRequest;
import me.miv.toyserver.common.TimeAuditingBaseEntity;
import me.miv.toyserver.member.enumeration.SexType;


@Entity
@Table(name = "member")
public class Member extends TimeAuditingBaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "login_id")
    private String loginId;

    @Column(name = "password")
    private String password;

    @Column(name = "nick_name")
    private String nickName;

    @Column(name = "age")
    private int age;

    @Enumerated(EnumType.STRING)
    @Column(name = "sex_type")
    private SexType sexType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id")
    private Role role;

    public Member() {
    }

    public Member(SignUpRequest signUpRequest, Role userRole) {
        this.loginId = signUpRequest.getLoginId();
        this.password = signUpRequest.getPassword();
        this.nickName = signUpRequest.getNickName();
        this.age = signUpRequest.getAge();
        this.sexType = SexType.fromValue(signUpRequest.getSexType());
        this.role = userRole;
    }

    public Long getId() {
        return id;
    }

    public String getLoginId() {
        return loginId;
    }

    public String getPassword() {
        return password;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
