package com.lfa.neo4j.data.demo.controller;

import com.lfa.neo4j.data.demo.constants.ApiPathRepo;
import com.lfa.neo4j.data.demo.entity.journey.JobNode;
import com.lfa.neo4j.data.demo.repo.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ApiPathRepo.JOB)
public class JobController {

    @Autowired
    private JobRepository jobRepository;

    @PostMapping("/create")
    public JobNode createJob(@RequestBody JobNode jobNode){
        return jobRepository.save(jobNode);
    }

    @GetMapping
    public List<JobNode> getAllJobs(){
        return jobRepository.findAll();
    }
}
