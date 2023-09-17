package com.lfa.neo4j.data.demo.entity.journey;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.RelationshipId;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;

@RelationshipProperties
@Getter
@Setter
public class AppGroupRelationship {
    @RelationshipId
    private String id;
    @TargetNode
    private AppGroupNode nextAppGroup;
}
