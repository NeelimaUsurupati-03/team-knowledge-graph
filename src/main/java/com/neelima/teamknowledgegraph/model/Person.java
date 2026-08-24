package com.neelima.teamknowledgegraph.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Node("Person")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
	
	@Id
	private String id;
	private String name;
	private String role;
	private String email;
	
	@Relationship(type = "WORKS_ON", direction = Relationship.Direction.OUTGOING)
	private List<Project> projects = new ArrayList<>();

	@Relationship(type = "ASSIGNED_TO", direction = Relationship.Direction.OUTGOING)
	private List<Task> tasks = new ArrayList<>();

	@Relationship(type = "HAS_SKILL", direction = Relationship.Direction.OUTGOING)
	private List<Skill> skills = new ArrayList<>();
	
	

}
