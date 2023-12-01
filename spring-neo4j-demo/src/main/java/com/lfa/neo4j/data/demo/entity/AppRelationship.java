package com.lfa.neo4j.data.demo.entity;

import com.lfa.neo4j.data.demo.entity.base.BaseRelationship;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;

@RelationshipProperties
@Getter
@Setter
public class AppRelationship extends BaseRelationship {
    @TargetNode
    private AppNode appNode;
}
