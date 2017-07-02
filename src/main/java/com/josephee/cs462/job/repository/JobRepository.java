package com.josephee.cs462.job.repository;

import com.josephee.cs462.job.domain.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long> {
}
