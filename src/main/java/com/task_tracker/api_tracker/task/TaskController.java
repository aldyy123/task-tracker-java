package com.task_tracker.api_tracker.task;

import com.task_tracker.api_tracker.common.ApiResponse;
import com.task_tracker.api_tracker.common.PageResponse;
import com.task_tracker.api_tracker.task.dto.TaskCreateRequest;
import com.task_tracker.api_tracker.task.dto.TaskResponse;
import com.task_tracker.api_tracker.task.dto.TaskUpdateRequest;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    private final TaskService service;

    public TaskController(TaskService service){
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse<TaskResponse> create(@Valid @RequestBody TaskCreateRequest req){
        Task t = service.create(req);
        return ApiResponse.ok("Success Created Data", TaskResponse.from(t));
    }

    @GetMapping
    public ApiResponse<PageResponse<TaskResponse>> findAll(
            @RequestParam(required = false) TaskStatus status,
            Pageable pageable
    ){
        Page<Task> page = service.findPage(status, pageable);
        PageResponse<TaskResponse> body = PageResponse.from(page, TaskResponse::from);
        return ApiResponse.ok("Berhasil", body);
    }

//    @GetMapping
//    public ApiResponse<List<TaskResponse>> findAll(){
//        var list = service.findAll()
//                .stream()
//                .map(TaskResponse::from)
//                .toList();
//        return ApiResponse.ok("Get all data", list);
//    }

    @GetMapping("/{id}")
    public ApiResponse<TaskResponse> findById(@PathVariable Long id){
        return ApiResponse.ok("Success get data", TaskResponse.from(service.findById(id)));
    }

    @PutMapping("/{id}")
    public ApiResponse<TaskResponse> update(@PathVariable Long id, @Valid @RequestBody TaskUpdateRequest req){
        return ApiResponse.ok("Success Update data", TaskResponse.from(service.update(id, req)));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ApiResponse<Object> delete(@PathVariable Long id){
        service.delete(id);
        return ApiResponse.ok("Task deleted", null);
    }
}
