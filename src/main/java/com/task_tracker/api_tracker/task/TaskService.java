package com.task_tracker.api_tracker.task;

import com.task_tracker.api_tracker.task.dto.TaskCreateRequest;
import com.task_tracker.api_tracker.task.dto.TaskUpdateRequest;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepository repo;

    public TaskService(TaskRepository repo){
        this.repo = repo;
    }

    @Transactional
    public Task create(TaskCreateRequest req){
        Task t = new Task();

        t.setTitle(req.getTitle());
        t.setDescription(req.getDescription());
        if(req.getStatus() != null) t.setStatus(req.getStatus());
        return repo.save(t);
    }

    public List<Task> findAll(){
        return repo.findAll();
    }

    public Task findById(Long id){
        return repo.findById(id).orElseThrow(() -> new TaskNotFoundException(id));
    }

    public Page<Task> findPage(TaskStatus status, Pageable pageable){
        if(status != null){
            return repo.findAll(pageable);
        }

        return repo.findTaskByStatus(status, pageable);
    }

    @Transactional
    public Task update(Long id,TaskUpdateRequest req){
        Task t = findById(id);

        if(req.getTitle() != null) t.setTitle(req.getTitle());
        if(req.getDescription() != null) t.setDescription(req.getDescription());
        if (req.getStatus() != null) t.setStatus(req.getStatus());

        return repo.save(t);
    }

    @Transactional
    public void delete(Long id){
        Task t = findById(id);
        repo.delete(t);
    }
}
