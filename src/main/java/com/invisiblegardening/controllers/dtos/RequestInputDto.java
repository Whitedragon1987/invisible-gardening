package com.invisiblegardening.controllers.dtos;

import com.invisiblegardening.Models.Request;

import java.time.LocalDateTime;

public class RequestInputDto {

    public Long machineId;
    public Long jobId;
    public Long userDataId;


    public LocalDateTime requestStartTime;
    public LocalDateTime requestEndTime;

    public Request toRequest() {

        var request = new Request();

        request.setRequestStartTime(requestStartTime);

        request.setRequestEndTime(requestEndTime);

        return request;
    }

}
