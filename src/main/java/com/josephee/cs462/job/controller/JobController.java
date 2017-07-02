package com.josephee.cs462.job.controller;

import com.josephee.cs462.job.model.JobModel;
import com.josephee.cs462.job.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.Clock;
import java.time.ZonedDateTime;

@RestController
@RequestMapping("/jobs")
public class JobController {

    @Autowired
    private JobService jobService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Long create(@RequestBody JobModel model) {
        JobModel saved = jobService.create(model);
        return saved.getId();
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public JobModel test() {
        JobModel model = new JobModel(1L, "1 Place way", "A job", ZonedDateTime.now(Clock.systemUTC()), ZonedDateTime.now(Clock.systemUTC()));
        return model;
    }
}
