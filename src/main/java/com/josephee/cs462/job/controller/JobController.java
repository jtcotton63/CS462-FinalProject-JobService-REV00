package com.josephee.cs462.job.controller;

import com.josephee.cs462.common.model.JobModel;
import com.josephee.cs462.job.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Page<JobModel> getJobs(Pageable pageable) {
        Page<JobModel> modelsPage = jobService.getJobs(pageable);
        return modelsPage;
    }
}
