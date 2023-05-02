package com.lfa.neo4j.data.demo.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.RelationshipId;

import java.util.Set;

@Getter
@Setter
public class Roles {

    @RelationshipId
    @GeneratedValue
    private Long id;

    @Property("roles")
    private Set<String> roles;
}
