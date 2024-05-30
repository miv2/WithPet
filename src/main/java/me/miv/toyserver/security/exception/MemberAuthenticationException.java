package me.miv.toyserver.security.exception;

public class MemberAuthenticationException extends RuntimeException {
    public MemberAuthenticationException(String message) {
        super(message);
    }
}
