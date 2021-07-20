package com.invisiblegardening.controllers.dtos;

import com.invisiblegardening.Models.Job;

public class JobInputDto {
    public Long id;

    public String name;
    public String description;

    public Boolean employeeNeeded;

    public Job toJob() {
        var job = new Job();

        job.setId(id);

        job.setJobName(name);

        job.setJobDescription(description);

        job.setEmployeeNeeded(employeeNeeded);

        return job;
    }

}
