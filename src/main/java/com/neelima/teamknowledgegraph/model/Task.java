package com.neelima.teamknowledgegraph.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;
import org.springframework.data.neo4j.core.support.UUIDStringGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Node("Task")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Task {
	
	@Id
	@GeneratedValue(UUIDStringGenerator.class)
	private String  id;
	private String title;
	private String status;
	private String priority;
	
	
	@Relationship(type = "BELONGS_TO", direction = Relationship.Direction.OUTGOING)
	private Project project;

	@Relationship(type = "DEPENDS_ON", direction = Relationship.Direction.OUTGOING)
	private List<Task> dependsOn = new ArrayList<>();

}
