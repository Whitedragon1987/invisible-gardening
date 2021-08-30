package com.invisiblegardening.controllers.dtos;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.invisiblegardening.Models.Employee;
import com.invisiblegardening.Models.Job;

public class JobInputDto {
    public Long id;

    public String name;
    public String description;

    public Boolean employeeNeeded;

    @JsonSerialize
    Employee employee;

    public Job toJob() {
        var job = new Job();

        job.setId(id);

        job.setJobName(name);

        job.setJobDescription(description);

        job.setEmployeeNeeded(employeeNeeded);

        job.setEmployee(employee);

        return job;
    }

}
