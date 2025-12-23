package com.task_tracker.api_tracker.task;

public class TaskNotFoundException extends RuntimeException {
    public TaskNotFoundException(long id){
        super("Task with id" + id + "Not found");
    }
}
