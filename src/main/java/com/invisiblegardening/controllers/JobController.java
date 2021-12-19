package com.invisiblegardening.controllers;

import com.invisiblegardening.Models.Job;
import com.invisiblegardening.controllers.dtos.IdInputDto;
import com.invisiblegardening.controllers.dtos.JobDto;
import com.invisiblegardening.controllers.dtos.JobInputDto;
import com.invisiblegardening.services.JobService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("jobs")
public class JobController {
    private final JobService jobService;

    @Autowired
    public  JobController(JobService jobService) {

        this.jobService = jobService;

    }

    @GetMapping
    public List<JobDto> getJobs() {

        var dtos = new ArrayList<JobDto>();

        var jobs = jobService.getJobs();

        for (Job job : jobs) {

            dtos.add(JobDto.fromJob(job));

        }

        return dtos;

    }

    @GetMapping("/{id}")
    public JobDto getJob(@PathVariable("id") Long id) {

        var job = jobService.getJob(id);

        return JobDto.fromJob(job);

    }

    @PostMapping
    public JobDto saveJob(@RequestBody JobInputDto dto) {

        var job = jobService.saveJob(dto.toJob());

        if(dto.employee != null){

            var jobID= job.getId();

            var employeeID = dto.employee;

            assignEmployeeToJob(jobID, employeeID);

        }

        return JobDto.fromJob(job);

    }

    @PostMapping("/{id}/employee/{employeeId}")
    public void assignEmployeeToJob(@PathVariable("id") Long jobId,
                                    @PathVariable("employeeId") Long employeeId) {

        jobService.assignEmployee(jobId, employeeId);

    }

    @PutMapping("/{id}")
    public JobDto updateJob(@PathVariable Long id, @RequestBody Job job) {

        jobService.updateJob(id, job);

        return JobDto.fromJob(job);

    }

    @DeleteMapping("/{id}")
    public void deleteJob(@PathVariable("id") Long id) {

        jobService.deleteJob(id);

    }

    @PutMapping("/job/{id}/picture")
    public void assignPictureToJob(@PathVariable("id") Long jobId, @RequestBody IdInputDto input) {

        jobService.assignPicture(jobId, input.id);
    }

}
