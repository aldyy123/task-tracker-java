package com.task_tracker.api_tracker.common;

public class ApiResponse<T> {
    private Boolean success;
    private String message;
    private T data;
    private ApiError error;

    public ApiResponse(boolean success, String message, T data, ApiError error) {
        this.success = success;
        this.message = message;
        this.data = data;
        this.error = error;
    }

    public static <T> ApiResponse<T> ok(String message, T data){
        return new ApiResponse<>(true, message, data, null);
    }

    public static <T> ApiResponse<T> fail(String message, ApiError error){
        return new ApiResponse<>(false, message, null, error);
    }

    public boolean isSuccess() { return success; }
    public String getMessage() { return message; }
    public T getData() { return data; }
    public ApiError getError() { return error; }
}
