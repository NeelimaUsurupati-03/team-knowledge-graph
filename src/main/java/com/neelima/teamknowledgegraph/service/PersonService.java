package com.neelima.teamknowledgegraph.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neelima.teamknowledgegraph.model.Person;
import com.neelima.teamknowledgegraph.repository.PersonRepository;

@Service
public class PersonService {
	
	@Autowired
	private PersonRepository personRepo;

	public List<Person> getAllPersons() {

		List<Person> person = personRepo.findAll();
		return person;
	}

	public Optional<Person> getById(String id) {
		Optional<Person> person = personRepo.findById(id);
		return person;
	}

	public Person addPerson(Person person) {
	    String id = java.util.UUID.randomUUID().toString();
	    return personRepo.createPerson(id, person.getName(), person.getRole(), person.getEmail());
	}

	public void deletePerson(String id) {

		personRepo.deleteById(id);
		System.out.println("DELETED");
	}
	public void assignToProject(String personId, String projectId) {
	    personRepo.assignToProject(personId, projectId);
	}
	
	public void assignToTask(String personId, String taskId) {
	    personRepo.assignToTask(personId, taskId);
	}
	
	public void addSkillToPerson(String personId, String skillId) {
	    personRepo.addSkillToPerson(personId, skillId);
	}
	

}
