package me.miv.toyserver.common.response;

public class ApplicationResponse<T> {
    private final ApplicationResult result;
    private final T payload;

    public ApplicationResponse(ApplicationResult result, T payload) {
        this.result = result;
        this.payload = payload;
    }

    public ApplicationResult getResult() {
        return result;
    }

    public T getPayload() {
        return payload;
    }

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
