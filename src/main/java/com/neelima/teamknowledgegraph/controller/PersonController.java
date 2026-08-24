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
import com.neelima.teamknowledgegraph.service.PersonService;

@RestController
@RequestMapping("/api/persons")
public class PersonController {
	
	@Autowired
	private PersonService personService;
	
	@GetMapping("getAll")
	public List<Person> getAllPersons()
	{
		return personService.getAllPersons();
	}
	
	@GetMapping("getById/{id}")
	public Optional<Person> getById(@PathVariable("id") String  id)
	{
		return personService.getById(id);
	}
	
	@PostMapping("addPerson")
	public Person addPerson(@RequestBody Person person)
	{
		return personService.addPerson(person);
	}
	
	@DeleteMapping("deletePerson/{id}")
	public void deletePerson(@PathVariable("id") String  id)
	{
		personService.deletePerson(id);
	}
	
	@PostMapping("assignToProject/{personId}/{projectId}")
	public void assignToProject(@PathVariable String personId, @PathVariable String projectId) {
	    personService.assignToProject(personId, projectId);
	}
	
	@PostMapping("assignToTask/{personId}/{taskId}")
	public void assignToTask(@PathVariable String personId, @PathVariable String taskId) {
	    personService.assignToTask(personId, taskId);
	}
	
	@PostMapping("addSkill/{personId}/{skillId}")
	public void addSkillToPerson(@PathVariable String personId, @PathVariable String skillId) {
	    personService.addSkillToPerson(personId, skillId);
	}
	
}
