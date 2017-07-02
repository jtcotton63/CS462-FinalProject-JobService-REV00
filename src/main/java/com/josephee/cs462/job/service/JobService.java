package com.josephee.cs462.job.service;

import com.josephee.cs462.job.domain.Job;
import com.josephee.cs462.job.model.JobModel;
import com.josephee.cs462.job.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("jobService")
public class JobService {

    @Autowired
    private JobRepository jobRepository;

    public JobModel create(JobModel incoming) {
        incoming.setId(null);
        Job toBeSaved = new Job(incoming);
        Job saved = jobRepository.save(toBeSaved);
        JobModel toBeReturned = saved.toModel();
        return toBeReturned;
    }
}
