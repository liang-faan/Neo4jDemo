package com.lfa.neo4j.data.demo.entity.journey;

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
public class AppGroupNode extends BaseNode{
    @Property("index")
    private Integer index;
    @Property("appGroupName")
    private String appGroupName;

    @Relationship(type = "HAS_APP_INSTANCE", direction = Relationship.Direction.OUTGOING)
    private List<AppInstanceNode> appInstances=new ArrayList<>();

    @Relationship(type = "NEXT_APP_GROUP", direction = Relationship.Direction.OUTGOING)
    private List<AppGroupRelationship> nextAppGroups=new ArrayList<>();
}
