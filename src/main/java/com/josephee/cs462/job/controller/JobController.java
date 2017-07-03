package com.josephee.cs462.job.controller;

import com.josephee.cs462.common.model.job.JobModel;
import com.josephee.cs462.job.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Long update(@PathVariable Long id, @RequestBody JobModel model) {
        model.setId(id);
        JobModel updated = jobService.update(model);
        return updated.getId();
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Page<JobModel> getJobs(Pageable pageable) {
        Page<JobModel> modelsPage = jobService.getJobs(pageable);
        return modelsPage;
    }
}
