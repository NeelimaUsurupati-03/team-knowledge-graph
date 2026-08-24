package com.neelima.teamknowledgegraph.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neelima.teamknowledgegraph.model.Person;
import com.neelima.teamknowledgegraph.model.Task;
import com.neelima.teamknowledgegraph.repository.TaskRepository;
import com.neelima.teamknowledgegraph.service.TaskService;

@RestController
@RequestMapping("/api/task")
public class TaskController {
	
	@Autowired
	private TaskService taskService;
	
	@Autowired
	private TaskRepository taskRepo;
	
	@GetMapping("getAllTasks")
	public List<Task> getAllTasks()
	{
		return taskService.getAllTasks();
	}
	
	@GetMapping("getById/{id}")
	public Optional<Task> getById(@PathVariable("id") String id)
	{
		 return taskService.getById(id);
	}
	
	@DeleteMapping("delete/{id}")
	public void delete(@PathVariable("id") String id)
	{
		taskService.delete(id);
	}
	
	@PostMapping("addTask")
	public Task addTask(@RequestBody Task task)
	{
		return taskService.addTask(task);
	}
	
	@PostMapping("assignToProject/{taskId}/{projectId}")
	public void assignToProject(@PathVariable String taskId, @PathVariable String projectId) {
	    taskService.assignToProject(taskId, projectId);
	}
	
	@PostMapping("addDependency/{taskId}/{dependsOnTaskId}")
	public void addDependency(@PathVariable String taskId, @PathVariable String dependsOnTaskId) {
	    taskService.addDependency(taskId, dependsOnTaskId);
	}
	
	@GetMapping("whoCanHelp/{taskId}")
	public List<Person> whoCanHelp(@PathVariable String taskId) {
	    return taskService.findPeopleWhoCanHelp(taskId);
	}

	@GetMapping("blockers/{taskId}")
	public List<Task> blockers(@PathVariable String taskId) {
	    return taskService.findAllBlockers(taskId);
	}
	
	@PostMapping("addSkill/{taskId}/{skillId}")
	public void addSkill(@PathVariable String taskId, @PathVariable String skillId) {
	    taskRepo.addSkillToTask(taskId, skillId);
	}
}