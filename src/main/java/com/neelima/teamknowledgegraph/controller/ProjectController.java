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

import com.neelima.teamknowledgegraph.model.Project;
import com.neelima.teamknowledgegraph.service.ProjectService;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {
	
	@Autowired
	private ProjectService projectService;
	
	@GetMapping("getAllProject")
	public List<Project> getAllProjects()
	{
		return projectService.getAllProjects();
	}
	
	@GetMapping("getById/{id}")
	public Optional<Project> getById(@PathVariable("id") String id)
	{
		return projectService.getById(id);
	}
	
	@DeleteMapping("delete/{id}")
	public void delete(@PathVariable("id") String id)
	{
		projectService.delete(id);
	}
	
	@PostMapping("addProject")
	public Project addProject(@RequestBody Project project)
	{
	    return projectService.addProject(project);
	}
	

}
