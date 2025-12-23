package com.task_tracker.api_tracker.common;

public class ValidationErrorItem {

    private String field;
    private String message;

    public ValidationErrorItem(String field, String message){
        this.field = field;
        this.message = message;
    }

    public String getField() { return field; }
    public String getMessage() { return message; }
}
