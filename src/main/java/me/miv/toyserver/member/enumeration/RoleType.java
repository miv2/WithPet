package me.miv.toyserver.member.enumeration;

public enum RoleType {

    ROLE_ADMIN("admin"),
    ROLE_USER("initial"),
    ROLE_NORMAL("normal");

    private final String value;

    RoleType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
