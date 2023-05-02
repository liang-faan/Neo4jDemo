package com.lfa.neo4j.data.demo.controller;

import org.neo4j.driver.Driver;
import org.neo4j.driver.Session;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MoviesController {

    private final Driver driver;

    public MoviesController(Driver driver) {
        this.driver = driver;
    }

    @GetMapping(path = "/movies", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<String> getMovieTitles() {

        try (Session session = driver.session()) {
            return session.run("MATCH (m:Movie) RETURN m ORDER BY m.name ASC")
                    .list(r -> r.get("m").asNode().get("title").asString());
        }
    }
}