package com.neelima.teamknowledgegraph.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.neelima.teamknowledgegraph.model.Person;
import com.neelima.teamknowledgegraph.model.Task;
import com.neelima.teamknowledgegraph.repository.TaskRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TaskService {
    
    @Autowired
    private TaskRepository taskRepo;

    public List<Task> getAllTasks() { return taskRepo.findAll(); }
    public Optional<Task> getById(String id) { return taskRepo.findById(id); }
    public void delete(String id) { taskRepo.deleteById(id); }

    public Task addTask(Task task) {
        String id = java.util.UUID.randomUUID().toString();
        return taskRepo.createTask(id, task.getTitle(), task.getStatus(), task.getPriority());
    }
    
    @Transactional
    public Task assignToProject(String taskId, String projectId) {
        return taskRepo.assignToProject(taskId, projectId);
    }
    
    @Transactional
    public Task addDependency(String taskId, String dependsOnTaskId) {
        return taskRepo.addDependency(taskId, dependsOnTaskId);
    }
    public List<Person> findPeopleWhoCanHelp(String taskId) {
        return taskRepo.findPeopleWhoCanHelp(taskId);
    }
    public List<Task> findAllBlockers(String taskId) {
        return taskRepo.findAllBlockers(taskId);
    }
}