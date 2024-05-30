package me.miv.toyserver.member.enumeration;

public enum SexType {
    MALE, FEMALE;

    public static SexType fromValue(String value) {
        switch (value.toUpperCase()) {
            case "MALE":
                return MALE;
            case "FEMALE":
                return FEMALE;
            default:
                throw new IllegalArgumentException("Unknown value: " + value);
        }
    }
}