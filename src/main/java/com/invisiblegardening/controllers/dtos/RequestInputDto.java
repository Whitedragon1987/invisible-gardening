package com.invisiblegardening.controllers.dtos;

import com.invisiblegardening.Models.Request;

import java.time.LocalDateTime;
import java.util.Collection;

public class RequestInputDto {

    public Collection<Long> machineIdList;
    public Collection<Long> jobIdList;
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
