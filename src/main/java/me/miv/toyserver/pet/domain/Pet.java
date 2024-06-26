package me.miv.toyserver.pet.domain;

import jakarta.persistence.*;
import me.miv.toyserver.common.TimeAuditingBaseEntity;
import me.miv.toyserver.pet.dto.request.PetAddRequest;

@Entity
@Table(name = "pet")
public class Pet extends TimeAuditingBaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "size")
    private String size;

    @Column(name = "sex")
    private String sex;

    @Column(name = "age")
    private int age;

    @Column(name = "profile_image")
    private String profileImage;

    @Column(name = "introduction")
    private String introduction;

    @Column(name = "member_id")
    private Long memberId;

    public Pet() {}

    public Pet(PetAddRequest petAddRequest, String imageFileName) {
        this.size = petAddRequest.getSize();
        this.age = petAddRequest.getAge();
        this.profileImage = imageFileName;
        this.sex = petAddRequest.getSex();
        this.introduction = petAddRequest.getIntroduction();
        this.memberId = petAddRequest.getMemberId();
    }

    public void updatePet(PetAddRequest petAddRequest, String imageFileName) {
        this.size = petAddRequest.getSize();
        this.age = petAddRequest.getAge();
        this.profileImage = imageFileName;
        this.sex = petAddRequest.getSex();
        this.introduction = petAddRequest.getIntroduction();
        this.memberId = petAddRequest.getMemberId();
    }

    public Long getId() {
        return id;
    }

    public String getSize() {
        return size;
    }

    public String getSex() {
        return sex;
    }

    public int getAge() {
        return age;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public String getIntroduction() {
        return introduction;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }
}
