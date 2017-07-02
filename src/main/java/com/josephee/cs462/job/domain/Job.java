package com.josephee.cs462.job.domain;

import com.josephee.cs462.job.model.JobModel;

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

    public Job() {
    }

    public Job(Long id, String address, String description, ZonedDateTime jobTime, ZonedDateTime rendevousTime) {
        this.id = id;
        this.address = address;
        this.description = description;
        this.jobTime = jobTime;
        this.rendevousTime = rendevousTime;
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

        return model;
    }
}
