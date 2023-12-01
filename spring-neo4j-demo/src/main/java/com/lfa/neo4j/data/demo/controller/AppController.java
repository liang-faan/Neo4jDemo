package com.lfa.neo4j.data.demo.controller;

import com.lfa.neo4j.data.demo.constants.ApiPathRepo;
import com.lfa.neo4j.data.demo.entity.AppGroupNode;
import com.lfa.neo4j.data.demo.repository.AppGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
