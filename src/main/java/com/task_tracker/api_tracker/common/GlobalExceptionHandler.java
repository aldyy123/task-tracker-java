package com.task_tracker.api_tracker.common;

import com.task_tracker.api_tracker.task.TaskNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(TaskNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiResponse<Object> handleNotFound(TaskNotFoundException ex){
        ApiError error = new ApiError(
                "NOT_FOUND",
                ex.getMessage(),
                null
        );

        return ApiResponse.fail("Resoruces not found", error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiResponse<Object> handleValidation(MethodArgumentNotValidException ex){
        List<ValidationErrorItem> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(e -> new ValidationErrorItem(e.getField(), e.getDefaultMessage()))
                .toList();

        ApiError apiError = new ApiError(
                "VALIDATION_ERROR",
                "Validation errors",
                Map.of("errors", errors)
        );
        return ApiResponse.fail("Validation errors", apiError);
    }
}
