package com.invisiblegardening.services;

import com.invisiblegardening.Exceptions.RecordNotFoundException;
import com.invisiblegardening.Models.Job;
import com.invisiblegardening.Models.Picture;
import com.invisiblegardening.repositories.EmployeeRepository;
import com.invisiblegardening.repositories.JobRepository;
import com.invisiblegardening.repositories.PictureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobService{
    private JobRepository jobRepository;
    private EmployeeRepository employeeRepository;
    private PictureRepository pictureRepository;

    @Autowired
    public JobServiceImpl(JobRepository jobRepository,
                          PictureRepository pictureRepository,
                          EmployeeRepository employeeRepository) {

        this.jobRepository = jobRepository;

        this.pictureRepository = pictureRepository;

        this.employeeRepository = employeeRepository;

    }

    @Override
    public List<Job> getJobs() {

        return jobRepository.findAll();

    }

    @Override
    public Job getJob(Long id) {

        Optional<Job> job = jobRepository.findById(id);

        if(job.isPresent()) {

            return job.get();

        } else {

            throw new RecordNotFoundException("Machine does not exist");

        }

    }

    @Override
    public Job saveJob(Job job) {

        return jobRepository.save(job);

    }

    @Override
    public void updateJob(Long id, Job job) {

        Optional<Job> optionalJob = jobRepository.findById(id);

        if (optionalJob.isPresent()) {

            jobRepository.save(job);

        } else {

            throw new RecordNotFoundException("job does not exist");

        }

    }

    @Override
    public void deleteJob(Long id) {

        jobRepository.deleteById(id);

    }

    @Override
    public void assignPicture(Long id, Long pictureId) {

        var optionalJob = jobRepository.findById(id);

        var optionalPicture = pictureRepository.findById(pictureId);

        if (optionalJob.isPresent() && optionalPicture.isPresent()) {

            var job = optionalJob.get();

            var picture = optionalPicture.get();

            job.setPicture(picture);

            jobRepository.save(job);

        } else {

            throw new RecordNotFoundException();

        }

    }

    @Override
    public void assignEmployee(Long jobId, Long employeeId) {

        var optionalJob = jobRepository.findById(jobId);

        var optionalEmployee = employeeRepository.findById(employeeId);

        if (optionalJob.isPresent() && optionalEmployee.isPresent()) {

            var job = optionalJob.get();

            var employee = optionalEmployee.get();

            job.setEmployee(employee);

            jobRepository.save(job);

        } else {

            throw new RecordNotFoundException("geen gegevens gevonden om op te slaan");

        }

    }

}
