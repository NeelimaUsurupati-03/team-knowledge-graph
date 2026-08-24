package com.neelima.teamknowledgegraph.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neelima.teamknowledgegraph.model.Project;
import com.neelima.teamknowledgegraph.repository.ProjectRepository;

@Service
public class ProjectService {
	
	@Autowired
	private ProjectRepository projectRepo;

	public List<Project> getAllProjects() {

		List<Project> project = projectRepo.findAll();
		return project;
	}


	public Optional<Project> getById(String id) {

		Optional<Project> project = projectRepo.findById(id);
		return project;
	}


	public void delete(String id) {
		projectRepo.deleteById(id);
	}
	
	public Project addProject(Project project) {
	    String id = java.util.UUID.randomUUID().toString();
	    return projectRepo.createProject(id, project.getName(), project.getDescription(), project.getStatus());
	}
}
