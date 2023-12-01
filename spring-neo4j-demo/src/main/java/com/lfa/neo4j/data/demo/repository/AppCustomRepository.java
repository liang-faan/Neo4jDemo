package com.lfa.neo4j.data.demo.repository;

import com.lfa.neo4j.data.demo.entity.AppGroupNode;

import java.util.List;

public interface AppCustomRepository {
    List<AppGroupNode> customSaveAllAppGroup(List<AppGroupNode> appGroupNodeList);
    AppGroupNode customSaveAppGroup(AppGroupNode appGroupNode);
}
