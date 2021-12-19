package com.invisiblegardening.services;

import com.invisiblegardening.Exceptions.RecordNotFoundException;
import com.invisiblegardening.Models.*;
import com.invisiblegardening.repositories.JobRepository;
import com.invisiblegardening.repositories.RequestJobRepository;
import com.invisiblegardening.repositories.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequestJobServiceImpl implements RequestJobService {
    private final RequestRepository requestRepository;
    private final JobRepository jobRepository;
    private final RequestJobRepository requestJobRepository;

    @Autowired
    public RequestJobServiceImpl(RequestRepository requestRepository,
                                 JobRepository jobRepository,
                                 RequestJobRepository requestJobRepository) {

        this.requestRepository = requestRepository;

        this.jobRepository = jobRepository;

        this.requestJobRepository = requestJobRepository;
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
