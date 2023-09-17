package com.lfa.neo4j.data.demo.entity.journey;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.Node;

@Node("APPLICATION")
@Getter
@Setter
public class ApplicationNode  extends BaseNode{
    private String appCode;
    private String appName;
    private String LOB;
}
