package com.lfa.neo4j.data.demo.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.*;
import org.springframework.data.neo4j.core.schema.Relationship.Direction;

import java.util.ArrayList;
import java.util.List;

@Node("Movie")
@Getter
@Setter
public class MovieEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Property("title")
    private final String title;

    @Property("tagline")
    private final String description;

    @Relationship(type = "ACTED_IN", direction = Direction.INCOMING)
    private List<Roles> actorsAndRoles;

    @Relationship(type = "DIRECTED", direction = Direction.INCOMING)
    private List<PersonEntity> directors = new ArrayList<>();

    @Property("released")
    private Long released;

    public MovieEntity(String title, String description) {
        this.id = null;
        this.title = title;
        this.description = description;
    }

    public MovieEntity withId(Long id) {
        if (this.id.equals(id)) {
            return this;
        } else {
            MovieEntity newObject = new MovieEntity(this.title, this.description);
            newObject.id = id;
            return newObject;
        }
    }

    // Getters omitted for brevity
}


