package com.invisiblegardening.services;

import com.invisiblegardening.Exceptions.RecordNotFoundException;
import com.invisiblegardening.Models.*;
import com.invisiblegardening.repositories.JobRepository;
import com.invisiblegardening.repositories.RequestJobRepository;
import com.invisiblegardening.repositories.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;

@Service
public class RequestJobServiceImpl implements RequestJobService {
    private RequestRepository requestRepository;
    private JobRepository jobRepository;
    private RequestJobRepository requestJobRepository;

    @Autowired
    public RequestJobServiceImpl(RequestRepository requestRepository,
                                 JobRepository jobRepository,
                                 RequestJobRepository requestJobRepository) {

        this.requestRepository = requestRepository;

        this.jobRepository = jobRepository;

        this.requestJobRepository = requestJobRepository;
    }

    @Override
    public Collection<RequestJob> getAllJobResults() {
        Collection<RequestJob> requestJobs = requestJobRepository.findAll();
        return requestJobs;
    }

    @Override
    public Collection<Job> getRequestJobsByRequestId(long requestId) {
        Collection<Job> jobs = new HashSet<>();
        Collection<RequestJob> requestJobs = requestJobRepository.findAllByRequestId(requestId);
        for (RequestJob requestJob : requestJobs) {
            jobs.add(requestJob.getJob());
        }
        return jobs;
    }

    @Override
    public Collection<Request> getRequestJobsByJobId(long jobId) {
        Collection<Request> requests = new HashSet<>();
        Collection<RequestJob> requestJobs = requestJobRepository.findAllByRequestId(jobId);
        for (RequestJob requestJob : requestJobs) {
            requests.add(requestJob.getRequest());
        }
        return requests;
    }

    @Override
    public RequestJob getRequestJobById(long requestId, long jobId) {
        return requestJobRepository.findById(new RequestJobKey(requestId, requestId)).orElse(null);
    }

    @Override
    public RequestJobKey addRequestJob(long requestId, long jobId) {
            var requestJob = new RequestJob();
            if (!jobRepository.existsById(jobId)) { throw new RecordNotFoundException(); }
            Job job = jobRepository.findById(jobId).orElse(null);
            if (!requestRepository.existsById(requestId)) { throw new RecordNotFoundException(); }
            Request request = requestRepository.findById(requestId).orElse(null);
            requestJob.setJob(job);
            requestJob.setRequest(request);
            RequestJobKey id = new RequestJobKey(jobId, requestId);
            requestJob.setId(id);
            requestJobRepository.save(requestJob);
            return id;
    }
}
