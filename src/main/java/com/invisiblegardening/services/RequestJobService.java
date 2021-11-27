package com.invisiblegardening.services;

import com.invisiblegardening.Models.*;

import java.util.Collection;

public interface RequestJobService {

    RequestJobKey addRequestJob(long requestId, long jobId);

}
