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

import com.neelima.teamknowledgegraph.model.Skill;
import com.neelima.teamknowledgegraph.service.SkillService;

@RestController
@RequestMapping("/api/skill")
public class SkillController {
	
	@Autowired
	private SkillService skillService;
	
	@GetMapping("getAll")
	public List<Skill> getAll()
	{
		return skillService.getAll();
	}
	
	@GetMapping("getById/{id}")
	public Optional<Skill> getById(@PathVariable("id") String id)
	{
		return skillService.getById(id);
	}
	
	@DeleteMapping("delete/{id}")
	public void delete(@PathVariable("id") String id)
	{
		skillService.delete(id);
	}
	
	@PostMapping("addSkill")
	public Skill addSkill(@RequestBody Skill skill)
	{
		return skillService.addSkill(skill);
	}

}
