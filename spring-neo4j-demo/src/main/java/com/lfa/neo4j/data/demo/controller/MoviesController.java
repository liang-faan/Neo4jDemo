package com.lfa.neo4j.data.demo.controller;

import com.lfa.neo4j.data.demo.constants.ApiPathRepo;
import com.lfa.neo4j.data.demo.entity.MovieEntity;
import com.lfa.neo4j.data.demo.entity.MovieEntity_;
import com.lfa.neo4j.data.demo.repo.MovieRepository;
import lombok.extern.log4j.Log4j2;
import org.neo4j.cypherdsl.core.Cypher;
import org.neo4j.cypherdsl.core.Statement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping(ApiPathRepo.MOVIES)
@Log4j2
public class MoviesController {

    @Autowired
    private MovieRepository movieRepository;

    @GetMapping
    public List<MovieEntity> getAllMovies() {
        return movieRepository.findAll();
    }

    @GetMapping(path = "/movieByTitle")
    public Collection<MovieEntity> getMovieByTitle(@RequestParam String title) {
        MovieEntity_ movieEntity = MovieEntity_.MOVIE_ENTITY.named("m");
        Statement statement = Cypher.match(movieEntity.withProperties(movieEntity.TITLE,
                        Cypher.parameter(movieEntity.TITLE.getName()).withValue(title)))
                .returning(movieEntity)
                .build();
        log.info(statement.getCypher());
        return movieRepository.findAll(statement);
    }

}