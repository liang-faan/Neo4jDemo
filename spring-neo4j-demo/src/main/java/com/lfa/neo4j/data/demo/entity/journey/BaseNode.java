package com.lfa.neo4j.data.demo.entity.journey;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Version;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Property;

import java.time.OffsetDateTime;

@Getter
@Setter
public abstract class BaseNode {
    @Id
    @GeneratedValue
    private String id;
    @Property("createdBy")
    private String createdBy;
    @Property("updatedBy")
    private String updatedBy;
    @Property("createdDate")
    private OffsetDateTime createdDate;
    @Property("updatedDate")
    private OffsetDateTime updatedDate;
    @Property("status")
    private String status;
    @Version
    private Long version;
}
