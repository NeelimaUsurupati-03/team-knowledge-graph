package com.neelima.teamknowledgegraph.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;

import com.neelima.teamknowledgegraph.model.Person;

public interface PersonRepository extends Neo4jRepository<Person, String> {

    @Query("CREATE (p:Person {id: $id, name: $name, role: $role, email: $email}) RETURN p")
    Person createPerson(@Param("id") String id, @Param("name") String name,
                         @Param("role") String role, @Param("email") String email);
    
    @Query("MATCH (p:Person {id: $personId}), (proj:Project {id: $projectId}) " +
            "MERGE (p)-[:WORKS_ON]->(proj) " +
            "RETURN count(*)")
     void assignToProject(@Param("personId") String personId, @Param("projectId") String projectId);
    
    @Query("MATCH (p:Person {id: $personId}), (t:Task {id: $taskId}) " +
    	       "MERGE (p)-[:ASSIGNED_TO]->(t) " +
    	       "RETURN count(*)")
    	void assignToTask(@Param("personId") String personId, @Param("taskId") String taskId);

    @Query("MATCH (p:Person {id: $personId}), (s:Skill {id: $skillId}) " +
    	       "MERGE (p)-[:HAS_SKILL]->(s) " +
    	       "RETURN count(*)")
    	void addSkillToPerson(@Param("personId") String personId, @Param("skillId") String skillId);


}