package com.invisiblegardening.controllers.dtos;

import com.invisiblegardening.Models.Job;

public class JobDto {
    public Long id;

    public String name;
    public String description;

    public Boolean employeeNeeded;


    public static JobDto fromJob(Job job) {

        var dto = new JobDto();

        dto.id = job.getId();

        dto.name = job.getJobName();

        dto.description = job.getJobDescription();

        dto.employeeNeeded = job.getEmployeeNeeded();

        return dto;

    }

}
