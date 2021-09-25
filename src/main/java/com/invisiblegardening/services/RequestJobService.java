package com.invisiblegardening.services;

import com.invisiblegardening.Models.*;

import java.util.Collection;

public interface RequestJobService {

    Collection<RequestJob> getAllJobResults();

    Collection<Job> getRequestJobsByRequestId(long requestId);
    Collection<Request> getRequestJobsByJobId(long jobId);
    RequestJob getRequestJobById(long requestId, long jobId);
    RequestJobKey addRequestJob(long requestId, long jobId);
}
