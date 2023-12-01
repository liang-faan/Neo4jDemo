package com.lfa.neo4j.data.demo.entity.base;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.neo4j.core.schema.RelationshipId;

import java.time.OffsetDateTime;

@Getter
@Setter
public abstract class BaseRelationship {
    @RelationshipId
    private String id;
    @CreatedDate
    private OffsetDateTime createdDt;
    @LastModifiedDate
    private OffsetDateTime updatedDt;
    @CreatedBy
    private String createdBy;
    @LastModifiedBy
    private String updatedBy;
}
