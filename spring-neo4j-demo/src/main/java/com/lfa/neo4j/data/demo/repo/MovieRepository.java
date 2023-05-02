package com.lfa.neo4j.data.demo.repo;

import com.lfa.neo4j.data.demo.entity.MovieEntity;
import org.neo4j.driver.Record;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import java.util.List;

public interface MovieRepository extends Neo4jRepository<MovieEntity, Long> {

    MovieEntity findByTitle(String title);

    @Query("match(m:Movie)-[r]-(p:Person) where m.title=$title return m as Movie, r as Roles, p as Person")
    List<Record> customFindByTitle(String title);


}
