package me.miv.toyserver.member.enumeration;

public enum RoleType {

    ROLE_ADMIN("어드민"),
    ROLE_USER("유저");

    private final String value;

    RoleType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
