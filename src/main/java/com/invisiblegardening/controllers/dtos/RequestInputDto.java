package com.invisiblegardening.controllers.dtos;

import com.invisiblegardening.Models.Request;

import java.time.LocalDateTime;

public class RequestInputDto {

    public Long id;
    public Long machineId;
    public Long jobId;
    public Long userDataId;
    public Long quoteId;

    public LocalDateTime startTime;
    public LocalDateTime endTime;

    public Request toRequest() {

        var request = new Request();

        request.setRequestStartTime(startTime);

        request.setRequestEndTime(endTime);

        return request;
    }

}
