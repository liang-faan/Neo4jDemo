package com.lfa.neo4j.data.demo.controller;

import com.lfa.neo4j.data.demo.constants.ApiPathRepo;
import com.lfa.neo4j.data.demo.entity.MovieEntity;
import com.lfa.neo4j.data.demo.repo.MovieRepository;
import org.neo4j.driver.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(ApiPathRepo.MOVIES)
public class MoviesController {

    @Autowired
    private MovieRepository movieRepository;

    @GetMapping
    public List<MovieEntity> getAllMovies() {
        return movieRepository.findAll();
    }

    @GetMapping(path = "/movieByTitle")
    public List<Record> getMovieByTitle(@RequestParam String title){
        return movieRepository.customFindByTitle(title);
    }

}