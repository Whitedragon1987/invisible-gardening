package com.invisiblegardening.controllers.dtos;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.invisiblegardening.Models.Job;
import com.invisiblegardening.Models.Picture;

public class JobDto {
    public Long id;

    public String name;
    public String description;

    public Boolean employeeNeeded;

    @JsonSerialize
    Picture picture;


    public static JobDto fromJob(Job job) {

        var dto = new JobDto();

        dto.id = job.getId();

        dto.name = job.getJobName();

        dto.description = job.getJobDescription();

        dto.employeeNeeded = job.getEmployeeNeeded();

        dto.picture = job.getPicture();

        return dto;

    }

}
