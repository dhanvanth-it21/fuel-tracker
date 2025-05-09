package com.projects.fueltracker.model.responseWrapper;


public class ResponseUtil {
    public static <T> ApiResponse<T> success(String message, T data, Object metadata) {
        return new ApiResponse<>(200, message, data, metadata);
    }

    public static <T> ApiResponse<T> error(int status, String message, T data) {
        return new ApiResponse<>(status, message, data, null);
    }
}
