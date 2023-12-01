package com.lfa.neo4j.data.demo.entity;

import com.lfa.neo4j.data.demo.entity.base.BaseNode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.ArrayList;
import java.util.List;

@Node("APP_GROUP")
@Getter
@Setter
public class AppGroupNode extends BaseNode {
    @Property("domain")
    private String domain;
    @Relationship(type = "CONTAINS_APP", direction = Relationship.Direction.OUTGOING)
    private List<AppRelationship> appNodeList = new ArrayList<>();
}
