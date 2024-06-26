package me.miv.toyserver.pet.dto.request;

public class PetUpdateRequest {
    private String size;
    private String sex;
    private int age;
    private String introduction;
    private Long userPetInfoId;

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

    public Long getUserPetInfoId() {
        return userPetInfoId;
    }
}
