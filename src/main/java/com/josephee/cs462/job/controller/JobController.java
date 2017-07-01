package com.josephee.cs462.job.controller;

import com.josephee.cs462.job.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jobs")
public class JobController {

    @Autowired
    private JobService jobService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String test() {
        return jobService.test();
    }
}
