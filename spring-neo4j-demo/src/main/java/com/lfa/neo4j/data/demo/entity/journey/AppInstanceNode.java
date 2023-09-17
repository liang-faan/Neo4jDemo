package com.lfa.neo4j.data.demo.entity.journey;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Relationship;

@Node("APP_INSTANCE")
@Getter
@Setter
public class AppInstanceNode extends BaseNode {
    @Property("appCode")
    private String appCode;
    @Property("appName")
    private String appName;
    @Relationship(type = "IS_APP", direction = Relationship.Direction.OUTGOING)
    private ApplicationNode application;
}
