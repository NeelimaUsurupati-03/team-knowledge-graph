package com.neelima.teamknowledgegraph.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.data.neo4j.core.Neo4jClient;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private Neo4jClient neo4jClient;

    @Override
    public void run(String... args) throws Exception {
        try {
            String query = "UNWIND ['Java','Python','React','Angular','Node.js','Spring Boot','Docker','Kubernetes','AWS','SQL','MongoDB','JavaScript','TypeScript','HTML','CSS','Git','Jenkins','Microservices','REST API','GraphQL','Neo4j','MySQL','PostgreSQL','C++','C#','DevOps','Machine Learning','Data Structures','Algorithms','System Design'] AS skillName MERGE (s:Skill {name: skillName}) RETURN count(s)";
            neo4jClient.query(query).run();
            System.out.println("=== SEED SCRIPT EXECUTED SUCCESSFULLY ===");
        } catch (Exception e) {
            System.out.println("Seed skip: " + e.getMessage());
        }
    }
}