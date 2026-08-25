package com.neelima.teamknowledgegraph.model;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Node("Project")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Project {
	@Id
	private String id;
	private String name;
	private String description;
	private String status;
}