package com.invisiblegardening.services;

import com.invisiblegardening.Models.Job;

import java.util.List;

public interface JobService {
    List<Job> getJobs();

    Job getJob(Long id);
    Job saveJob(Job job);

    void updateJob(Long id, Job job);
    void deleteJob(Long id);
}
