package com.josephee.cs462.job.service;

import com.josephee.cs462.common.handler.JobEventHandler;
import com.josephee.cs462.common.model.event.CreateEvent;
import com.josephee.cs462.common.model.event.UpdatedEvent;
import com.josephee.cs462.common.model.job.JobModel;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class JobEventHandlerImpl extends JobEventHandler {

    protected JobEventHandlerImpl() {
        super(LoggerFactory.getLogger(JobEventHandlerImpl.class));
    }

    @Override
    public void jobCreatedChild(CreateEvent<JobModel> event) {
        // Do nothing
    }

    @Override
    protected void jobUpdatedChild(UpdatedEvent<JobModel> event) {
        // Do nothing
    }
}
