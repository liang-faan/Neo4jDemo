package com.lfa.neo4j.data.demo.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.RelationshipId;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;

import java.util.List;

@Getter
@Setter
@RelationshipProperties
public class Roles {

    @RelationshipId
    private Long id;

    private final List<String> roles;


    @TargetNode
    private final PersonEntity person;

    public Roles(PersonEntity person, List<String> roles) {
        this.person = person;
        this.roles = roles;
    }
}
