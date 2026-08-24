package com.neelima.teamknowledgegraph.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;

import com.neelima.teamknowledgegraph.model.Skill;

public interface SkillRepository extends Neo4jRepository<Skill, String> {

	@Query("CREATE (s:Skill {id: $id, name: $name}) RETURN s")
	Skill createSkill(@Param("id") String id, @Param("name") String name);
}
