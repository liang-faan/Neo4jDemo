package com.lfa.neo4j.data.demo.repository;

import com.lfa.neo4j.data.demo.entity.AppGroupNode;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.support.CypherdslConditionExecutor;
import org.springframework.data.neo4j.repository.support.CypherdslStatementExecutor;

public interface AppGroupRepository extends Neo4jRepository<AppGroupNode, String>,
        CypherdslConditionExecutor<AppGroupNode>,
        CypherdslStatementExecutor<AppGroupNode> {
}
