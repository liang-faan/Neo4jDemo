package com.lfa.neo4j.data.demo.entity;

import com.lfa.neo4j.data.demo.entity.base.BaseNode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;

@Getter
@Setter
@Node("APP")
public class AppNode extends BaseNode {
    @Property("appCode")
    private String appCode;
    @Property("owner")
    private String owner;
}
