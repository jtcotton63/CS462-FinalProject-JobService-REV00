package com.josephee.cs462.job.service;

import com.josephee.cs462.common.dispatch.JobEventsDispatcher;
import com.josephee.cs462.common.model.event.CreateEvent;
import com.josephee.cs462.common.model.event.UpdatedEvent;
import com.josephee.cs462.job.domain.Job;
import com.josephee.cs462.common.model.job.JobModel;
import com.josephee.cs462.job.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

@Service("jobService")
public class JobService {

    @Autowired
    private JobRepository jobRepository;
    @Autowired
    private JobEventsDispatcher dispatcher;

    private JobModel save(JobModel incoming) {
        Job toBeSaved = new Job(incoming);
        Job saved = jobRepository.save(toBeSaved);
        JobModel toBeReturned = saved.toModel();
        return toBeReturned;
    }

    public JobModel create(JobModel incoming) {
        incoming.setId(null);
        JobModel toBeReturned = save(incoming);
        dispatcher.jobCreated(new CreateEvent<>(toBeReturned));
        return toBeReturned;
    }

    public JobModel update(JobModel incoming) {
        Assert.notNull(incoming);
        JobModel existing = jobRepository.getOne(incoming.getId()).toModel();
        Assert.notNull(existing);
        JobModel toBeReturned = save(incoming);
        dispatcher.jobUpdated(new UpdatedEvent<>(existing, toBeReturned));
        return toBeReturned;
    }

    public Page<JobModel> getJobs(Pageable pageable) {
        Page<Job> jobsPage = jobRepository.findAll(pageable);
        Page<JobModel> modelsPage = toModelsPage(jobsPage);
        return modelsPage;
    }

    private Page<JobModel> toModelsPage(Page<Job> jobsPage) {
        List<Job> jobs = jobsPage.getContent();
        List<JobModel> models = new ArrayList<>(jobs.size());
        for(Job job: jobs) {
            JobModel model = job.toModel();
            models.add(model);
        }

        return new PageImpl<>(
                models,
                new PageRequest(
                        jobsPage.getNumber(),
                        jobsPage.getSize(),
                        jobsPage.getSort()
                ),
                jobsPage.getTotalElements()
        );
    }
}
