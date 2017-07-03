package com.josephee.cs462.job.domain;

import com.josephee.cs462.common.model.job.JobModel;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String address;
    private String description;
    @Column(columnDefinition = "TIMESTAMP")
    private ZonedDateTime jobTime;
    @Column(columnDefinition = "TIMESTAMP")
    private ZonedDateTime rendevousTime;
    private Long acceptedBy;
    private boolean completed;

    public Job() {
        this.completed = false;
    }

    public Job(Long id, String address, String description, ZonedDateTime jobTime, ZonedDateTime rendevousTime, Long acceptedBy, boolean completed) {
        this.id = id;
        this.address = address;
        this.description = description;
        this.jobTime = jobTime;
        this.rendevousTime = rendevousTime;
        this.acceptedBy = acceptedBy;
        this.completed = completed;
    }
    
    public Job(JobModel model) {
        if(model.getId() != null && model.getId() > 0)
            this.id = model.getId();

        if(model.getAddress() != null && !model.getAddress().isEmpty())
            this.address = model.getAddress();

        if(model.getDescription() != null && !model.getDescription().isEmpty())
            this.description = model.getDescription();

        if(model.getJobTime() != null)
            this.jobTime = model.getJobTime();

        if(model.getRendevousTime() != null)
            this.rendevousTime = model.getRendevousTime();

        if(model.getAcceptedBy() != null && model.getAcceptedBy() > 0)
            this.acceptedBy = model.getAcceptedBy();

        this.completed = model.isCompleted();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ZonedDateTime getJobTime() {
        return jobTime;
    }

    public void setJobTime(ZonedDateTime jobTime) {
        this.jobTime = jobTime;
    }

    public ZonedDateTime getRendevousTime() {
        return rendevousTime;
    }

    public void setRendevousTime(ZonedDateTime rendevousTime) {
        this.rendevousTime = rendevousTime;
    }

    public Long getAcceptedBy() {
        return acceptedBy;
    }

    public void setAcceptedBy(Long acceptedBy) {
        this.acceptedBy = acceptedBy;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public JobModel toModel() {
        JobModel model = new JobModel();

        if(this.getId() != null && this.getId() > 0)
            model.setId(this.getId());

        if(this.getAddress() != null && !this.getAddress().isEmpty())
            model.setAddress(this.getAddress());

        if(this.getDescription() != null && !this.getDescription().isEmpty())
            model.setDescription(this.getDescription());

        if(this.getJobTime() != null)
            model.setJobTime(this.getJobTime());

        if(this.getRendevousTime() != null)
            model.setRendevousTime(this.getRendevousTime());

        if(this.getAcceptedBy() != null && this.getAcceptedBy() > 0)
            model.setAcceptedBy(this.getAcceptedBy());

        model.setCompleted(this.isCompleted());

        return model;
    }
}
