package me.miv.toyserver.pet.dto.request;

import org.springframework.web.multipart.MultipartFile;

public class PetAddRequest {
    private String size;
    private String sex;
    private int age;
    private String introduction;
    private Long memberId;

    public String getSize() {
        return size;
    }

    public String getSex() {
        return sex;
    }

    public int getAge() {
        return age;
    }

    public String getIntroduction() {
        return introduction;
    }

    public Long getMemberId() {
        return memberId;
    }


}
