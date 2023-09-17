package com.lfa.neo4j.data.demo.repo;

import com.lfa.neo4j.data.demo.entity.journey.JobNode;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.support.CypherdslStatementExecutor;

public interface JobRepository extends Neo4jRepository<JobNode, String>, CypherdslStatementExecutor<JobNode> {
}
