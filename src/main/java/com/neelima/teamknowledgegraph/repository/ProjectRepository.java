package com.neelima.teamknowledgegraph.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;

import com.neelima.teamknowledgegraph.model.Project;

public interface ProjectRepository extends Neo4jRepository<Project, String> {

    @Query("CREATE (p:Project {id: $id, name: $name, description: $description, status: $status}) RETURN p")
    Project createProject(@Param("id") String id, @Param("name") String name,
                           @Param("description") String description, @Param("status") String status);
}