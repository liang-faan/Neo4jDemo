package com.lfa.neo4j.data.demo.repo;

import com.lfa.neo4j.data.demo.entity.MovieEntity;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import java.util.List;


public interface MovieRepository extends Neo4jRepository<MovieEntity, String> {

    MovieEntity findByTitle(String title);

    @Query("match (m:Movie)-[r]-(p:Person) where m.title=$title \n" +
            "with elementId(m) as movieId, m, elementId(r) as typeId, type(r) as t, collect(p) as personList\n" +
            "return m {id: movieId, .title, .tagline, .released, relation: {role:t, id: typeId, Person: personList}} as Movie")
    List<MovieEntity> customFindByTitle(String title);


}
