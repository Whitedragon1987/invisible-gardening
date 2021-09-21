package com.invisiblegardening.controllers.dtos;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.invisiblegardening.Models.Request;


import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class RequestDto {

    public Long id;
//    public Set<MachineDto> machineSet;

    @JsonSerialize
    UserDataDto userData;

//    @JsonSerialize
//    MachineDto machine;
//
//    @JsonSerialize
//    Set<JobDto> jobSet;

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    LocalDateTime requestStartTime;

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    LocalDateTime requestEndTime;

    public static RequestDto fromRequest(Request request) {

        var dto = new RequestDto();

        dto.id = request.getId();

        dto.userData = UserDataDto.fromUserData(request.getUserData());

//        dto.machineSet = request.getMachineIdList());
//
//        dto.jobSet = JobDto.fromJob(request.getJob());

        dto.requestStartTime = request.getRequestStartTime();

        dto.requestEndTime = request.getRequestEndTime();

        return dto;

    }

}
