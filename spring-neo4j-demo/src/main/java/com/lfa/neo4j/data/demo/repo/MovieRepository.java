package com.lfa.neo4j.data.demo.repo;

import com.lfa.neo4j.data.demo.entity.MovieEntity;
import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository;
import reactor.core.publisher.Mono;

public interface MovieRepository extends ReactiveNeo4jRepository<MovieEntity, Long> {

    Mono<MovieEntity> findByTitle(String title);
}
