package com.invisiblegardening.controllers.dtos;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.invisiblegardening.Models.Request;


import java.time.LocalDateTime;

public class RequestDto {

    Long id;

    @JsonSerialize
    UserDataDto userData;

    @JsonSerialize
    MachineDto machine;

    @JsonSerialize
    JobDto job;

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    LocalDateTime requestStartTime;

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    LocalDateTime requestEndTime;

    public static RequestDto fromRequest(Request request) {

        var dto = new RequestDto();

        dto.id = request.getId();

        dto.userData = UserDataDto.fromUserData(request.getUserData());

        dto.machine = MachineDto.fromMachine(request.getMachine());

        dto.job = JobDto.fromJob(request.getJob());

        dto.requestStartTime = request.getRequestStartTime();

        dto.requestEndTime = request.getRequestEndTime();

        return dto;

    }

}
