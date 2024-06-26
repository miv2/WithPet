package me.miv.toyserver.common.response;

public record ApplicationResponse<T>(ApplicationResult result, T payload) {

    public static <T> ApplicationResponse<T> ok(String message, T payload) {
        return new ApplicationResponse<>(ApplicationResult.ok(message), payload);
    }

    public static <T> ApplicationResponse<T> unauthorized(String message, T payload) {
        return new ApplicationResponse<>(ApplicationResult.unauthorized(message), payload);
    }

    public static <T> ApplicationResponse<T> forbidden(String message, T payload) {
        return new ApplicationResponse<>(ApplicationResult.forbidden(message), payload);
    }

    public static <T> ApplicationResponse<T> badRequest(String message, T payload) {
        return new ApplicationResponse<>(ApplicationResult.badRequest(message), payload);
    }

    public static <T> ApplicationResponse<T> server(String message, T payload) {
        return new ApplicationResponse<>(ApplicationResult.server(message), payload);
    }

    public static <T> ApplicationResponse<T> notFound(String message, T payload) {
        return new ApplicationResponse<>(ApplicationResult.notFound(message), payload);
    }
}
