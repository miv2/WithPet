package me.miv.toyserver.auth.dto.request;

public class SignUpRequest {
    private String loginId;
    private String password;
    private String nickName;
    private int age;
    private String sexType;

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

    public String getSexType() {
        return sexType;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
