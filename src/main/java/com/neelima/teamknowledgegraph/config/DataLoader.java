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
            String query = "MERGE (s:Skill {name: 'Java'}) RETURN s";
            neo4jClient.query(query).run();
            System.out.println("=== SEED SCRIPT EXECUTED SUCCESSFULLY ===");
        } catch (Exception e) {
            System.out.println("Seed skip: " + e.getMessage());
        }
    }
}
