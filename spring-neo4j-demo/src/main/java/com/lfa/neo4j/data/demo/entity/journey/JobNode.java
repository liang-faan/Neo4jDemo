package com.lfa.neo4j.data.demo.entity.journey;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.ArrayList;
import java.util.List;

@Node("JOB")
@Getter
@Setter
public class JobNode  extends BaseNode{

    @Relationship(type = "HAS_JOURNEY", direction = Relationship.Direction.OUTGOING)
    private List<JourneyNode> journeys = new ArrayList<>();
}
