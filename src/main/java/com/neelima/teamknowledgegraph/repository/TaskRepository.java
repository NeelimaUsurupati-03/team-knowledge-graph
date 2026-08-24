package com.neelima.teamknowledgegraph.repository;

import java.util.List;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;
import com.neelima.teamknowledgegraph.model.Person;
import com.neelima.teamknowledgegraph.model.Task;

public interface TaskRepository extends Neo4jRepository<Task, String> {

    @Query("CREATE (t:Task {id: $id, title: $title, status: $status, priority: $priority}) RETURN t")
    Task createTask(@Param("id") String id, @Param("title") String title, @Param("status") String status, @Param("priority") String priority);
    
    @Query("MATCH (t:Task {id: $taskId}), (p:Project {id: $projectId}) MERGE (t)-[:BELONGS_TO]->(p) RETURN t")
    Task assignToProject(@Param("taskId") String taskId, @Param("projectId") String projectId);
    
    @Query("MATCH (t1:Task {id: $taskId}), (t2:Task {id: $dependsOnTaskId}) MERGE (t1)-[:DEPENDS_ON]->(t2) RETURN t1")
    Task addDependency(@Param("taskId") String taskId, @Param("dependsOnTaskId") String dependsOnTaskId);
    
    @Query("MATCH (t:Task {id: $taskId})-[:REQUIRES]->(s:Skill)<-[:HAS_SKILL]-(p:Person) RETURN DISTINCT p")
    List<Person> findPeopleWhoCanHelp(@Param("taskId") String taskId);
    
    @Query("MATCH (t:Task {id: $taskId})-[:DEPENDS_ON*1..5]->(blocker:Task) RETURN DISTINCT blocker")
    List<Task> findAllBlockers(@Param("taskId") String taskId);

    @Query("MATCH (t:Task {id: $taskId}), (s:Skill {name: $skillName}) MERGE (t)-[:REQUIRES]->(s) RETURN t")
    Task addSkillToTask(@Param("taskId") String taskId, @Param("skillName") String skillName);
}