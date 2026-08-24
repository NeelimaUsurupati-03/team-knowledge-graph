package com.neelima.teamknowledgegraph.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neelima.teamknowledgegraph.model.Person;
import com.neelima.teamknowledgegraph.model.Task;
import com.neelima.teamknowledgegraph.repository.TaskRepository;

@Service
public class TaskService {
    
    @Autowired
    private TaskRepository taskRepo;

    public List<Task> getAllTasks() {
        return taskRepo.findAll();
    }

    public Optional<Task> getById(String id) {
        return taskRepo.findById(id);
    }

    public void delete(String id) {
        taskRepo.deleteById(id);
    }

    public Task addTask(Task task) {
        String id = java.util.UUID.randomUUID().toString();
        return taskRepo.createTask(id, task.getTitle(), task.getStatus(), task.getPriority());
    }
    
    public void assignToProject(String taskId, String projectId) {
        taskRepo.assignToProject(taskId, projectId);
    }
    
    public void addDependency(String taskId, String dependsOnTaskId) {
        taskRepo.addDependency(taskId, dependsOnTaskId);
    }
    public List<Person> findPeopleWhoCanHelp(String taskId) {
        return taskRepo.findPeopleWhoCanHelp(taskId);
    }

    public List<Task> findAllBlockers(String taskId) {
        return taskRepo.findAllBlockers(taskId);
    }
}
