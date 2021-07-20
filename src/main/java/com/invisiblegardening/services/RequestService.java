package com.invisiblegardening.services;

import com.invisiblegardening.Models.Request;

import java.time.LocalDateTime;
import java.util.List;

public interface RequestService {
    List<Request> getRequestBetweenDates(LocalDateTime start, LocalDateTime end);
    List<Request> getRequestsForMachine(Long machineId);
    List<Request> getRequestsForJob(Long jobId);
    List<Request> getRequestsForQuote(Long quoteId);
    List<Request> getRequestsForUserData(Long userDataId);
    List<Request> getRequests();

    Request getRequest(Long requestId);

    void planRequest(Long machineId, Long jobId, Long quoteId, Long customerDataId, LocalDateTime plannedStartTime, LocalDateTime plannedEndTime);

    Request completeRequest(Long requestId, LocalDateTime actualStartTime, LocalDateTime actualEndTime);
    Request cancelRequest(Long requestId);

}
