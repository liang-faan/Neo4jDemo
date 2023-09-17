package com.lfa.neo4j.data.demo.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.*;

import java.util.ArrayList;
import java.util.List;

@Node("Movie")
@Getter
@Setter
public class MovieEntity {

    @Id
    @GeneratedValue(GeneratedValue.UUIDGenerator.class)
    private String id;

    @Property("title")
    private final String title;

    @Property("tagline")
    private final String description;

    @Property("relation")
    private Roles relation;

    @Property("released")
    private Long released;

    @Relationship(type = "ACTED_IN", direction = Relationship.Direction.INCOMING)
    private List<Roles> actorsAndRoles;

    @Relationship(type = "DIRECTED", direction = Relationship.Direction.INCOMING)
    private List<PersonEntity> directors = new ArrayList<>();

    public MovieEntity(String title, String description) {
        this.id = null;
        this.title = title;
        this.description = description;
    }
}


