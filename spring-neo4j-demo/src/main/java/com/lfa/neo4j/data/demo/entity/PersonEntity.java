package com.lfa.neo4j.data.demo.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;

@Node("Person")
@Getter
@Setter
public class PersonEntity {

    @Id
    @GeneratedValue(GeneratedValue.UUIDGenerator.class)
    private String id;

    @Property("born")
    private Long born;

    @Property("name")
    private String name;


}
