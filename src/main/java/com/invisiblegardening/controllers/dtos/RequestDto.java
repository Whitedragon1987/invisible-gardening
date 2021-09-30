package com.invisiblegardening.controllers.dtos;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.invisiblegardening.Models.Request;
import com.invisiblegardening.Models.RequestMachine;


import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Set;

public class RequestDto {

    public Long id;

    @JsonSerialize
    UserDataDto userData;

    @JsonSerialize
    Collection<RequestMachine> requestMachines;

    @JsonSerialize
    Set<JobDto> jobSet;

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    LocalDateTime requestStartTime;

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    LocalDateTime requestEndTime;

    public static RequestDto fromRequest(Request request) {

        var dto = new RequestDto();

        dto.id = request.getId();

        dto.userData = UserDataDto.fromUserData(request.getUserData());

        dto.requestMachines = request.getRequestMachines();
//
//        dto.jobSet = JobDto.fromJob(request.getJob());

        dto.requestStartTime = request.getRequestStartTime();

        dto.requestEndTime = request.getRequestEndTime();

        return dto;

    }

}
