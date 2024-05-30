package me.miv.toyserver.common.response;

import org.springframework.http.HttpStatus;

public class ApplicationResult {
    private final int code;
    private final String message;

    public ApplicationResult(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public static ApplicationResult ok(String message) {
        return new ApplicationResult(HttpStatus.OK.value(), message);
    }

    public static ApplicationResult unauthorized(String message) {
        return new ApplicationResult(HttpStatus.UNAUTHORIZED.value(), message);
    }

    public static ApplicationResult forbidden(String message) {
        return new ApplicationResult(HttpStatus.FORBIDDEN.value(), message);
    }

    public static ApplicationResult badRequest(String message) {
        return new ApplicationResult(HttpStatus.BAD_REQUEST.value(), message);
    }

    public static ApplicationResult server(String message) {
        return new ApplicationResult(HttpStatus.INTERNAL_SERVER_ERROR.value(), message);
    }

    public static ApplicationResult notFound(String message) {
        return new ApplicationResult(HttpStatus.NOT_FOUND.value(), message);
    }
}
