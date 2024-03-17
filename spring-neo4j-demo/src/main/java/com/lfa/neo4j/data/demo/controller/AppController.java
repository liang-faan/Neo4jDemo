package com.lfa.neo4j.data.demo.controller;

import com.lfa.neo4j.data.demo.constants.ApiPathRepo;
import com.lfa.neo4j.data.demo.entity.AppGroupNode;
import com.lfa.neo4j.data.demo.repository.AppGroupRepository;
import org.neo4j.cypherdsl.core.Cypher;
import org.neo4j.cypherdsl.core.Node;
import org.neo4j.cypherdsl.core.Statement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(ApiPathRepo.APP_PATH)
public class AppController {

    @Autowired
    private AppGroupRepository appGroupRepository;

    @PostMapping(path = ApiPathRepo.CREATE_APP_GROUP, produces = MediaType.APPLICATION_JSON_VALUE)
    public String createAppGroup(@RequestBody List<AppGroupNode> appGroupNodes) {
        appGroupRepository.saveAll(appGroupNodes);
        return "OK";

    }

    @GetMapping(path = ApiPathRepo.RETRIEVE_APPGROUP_BY_LABELS, produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<AppGroupNode> retrieveAllAppGroup(@RequestParam List<String> labels){
        Node node = Cypher.node("APP_GROUP", labels);
        Statement statement = Cypher.match(node).returning(node).build();
        return appGroupRepository.findAll(statement);
    }
}
