package com.invisiblegardening.controllers.dtos;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.invisiblegardening.Models.Request;
import com.invisiblegardening.Models.UserData;

import java.time.LocalDateTime;

public class RequestDto {

    Long id;

    @JsonSerialize
    UserData userData;

    @JsonSerialize
    MachineDto machine;

    @JsonSerialize
    JobDto job;

    @JsonSerialize
    QuoteDto quote;

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    LocalDateTime startTime;

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    LocalDateTime endTime;

    public static RequestDto fromRequest(Request request) {

        var dto = new RequestDto();

        dto.id = request.getId();

        dto.userData = request.getUserData();

        dto.machine = MachineDto.fromMachine(request.getMachine());

        dto.job = JobDto.fromJob(request.getJob());

        dto.quote = QuoteDto.fromQuote(request.getQuote());

        dto.startTime = request.getRequestStartTime();

        dto.endTime = request.getRequestEndTime();

        return dto;

    }

}
