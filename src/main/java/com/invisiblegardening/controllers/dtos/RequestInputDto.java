package com.invisiblegardening.controllers.dtos;

import com.invisiblegardening.Models.Status;

import java.time.LocalDateTime;
import java.util.List;

public class RequestInputDto {


    public List<Long> machineIdList;
    public List<Long> jobIdList;
    public Long userDataId;
    public Status status;

    public LocalDateTime requestStartTime;
    public LocalDateTime requestEndTime;
    public LocalDateTime confirmedStartTime;
    public LocalDateTime confirmedEndTime;


}
