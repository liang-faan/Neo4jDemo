package com.lfa.neo4j.data.demo.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;

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

    public MovieEntity(String title, String description) {
        this.id = null;
        this.title = title;
        this.description = description;
    }
}


