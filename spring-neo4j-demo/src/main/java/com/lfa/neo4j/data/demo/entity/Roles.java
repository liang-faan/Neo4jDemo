package com.lfa.neo4j.data.demo.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;

import java.util.List;

@Getter
@Setter
@Node("relation")
public class Roles {

    @Property("role")
    private String role;

    @Id
    @GeneratedValue(GeneratedValue.UUIDGenerator.class)
    private String id;

    private List<PersonEntity> persons;
}
