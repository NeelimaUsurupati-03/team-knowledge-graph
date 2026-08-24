package com.neelima.teamknowledgegraph.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neelima.teamknowledgegraph.model.Skill;
import com.neelima.teamknowledgegraph.repository.SkillRepository;

@Service
public class SkillService {
	
	@Autowired
	private SkillRepository skillRepo;

	public List<Skill> getAll() {

		List<Skill> skill = skillRepo.findAll();
		return skill;
	}

	public Optional<Skill> getById(String id) {

		 Optional<Skill> skill = skillRepo.findById(id);
		 return skill;
	}

	public void delete(String id) {

		skillRepo.deleteById(id);
	}

	public Skill addSkill(Skill skill) {
	    String id = java.util.UUID.randomUUID().toString();
	    return skillRepo.createSkill(id, skill.getName());
	}

}
