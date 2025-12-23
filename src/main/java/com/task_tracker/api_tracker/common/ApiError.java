package com.task_tracker.api_tracker.common;

import java.util.Map;

public class ApiError {
    private String code;
    private String message;
    private Map<String, Object> details;

    public ApiError(String code, String message, Map<String, Object> details){
        this.code = code;
        this.details = details;
        this.message = message;
    }

    public String getCode() { return code; }
    public String getMessage() { return message; }
    public Map<String, Object> getDetails() { return details; }
}
