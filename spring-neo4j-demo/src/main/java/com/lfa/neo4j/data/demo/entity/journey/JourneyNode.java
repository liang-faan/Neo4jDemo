package com.lfa.neo4j.data.demo.entity.journey;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.ArrayList;
import java.util.List;

@Node("JOURNEY")
@Setter
@Getter
public class JourneyNode  extends BaseNode{

    @Property("journeyId")
    private String journeyId;
    @Property("journeyName")
    private String journeyName;
    @Property("journeyDescription")
    private String journeyDescription;

    @Relationship(type = "HAS_APP_GROUP", direction = Relationship.Direction.OUTGOING)
    private List<AppGroupNode> appGroupNodes = new ArrayList<>();
}
