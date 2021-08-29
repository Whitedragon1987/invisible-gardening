package com.invisiblegardening.controllers.dtos;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.invisiblegardening.Models.Machine;
import com.invisiblegardening.Models.Picture;

import java.util.Date;

public class MachineDto {
    public Long id;

    public String name;
    public String description;
    public String type;
    public String measurements;

    public Date lastService;
    public Date plannedService;

    @JsonSerialize
    Picture picture;



    public static MachineDto fromMachine(Machine machine) {

        var dto = new MachineDto();

        dto.id = machine.getId();

        dto.name = machine.getMachineName();

        dto.description = machine.getMachineDescription();

        dto.type = machine.getMachineType();

        dto.measurements = machine.getMachineMeasurements();

        dto.lastService = machine.getMachineLastService();

        dto.plannedService = machine.getMachinePlannedService();

        dto.picture = machine.getPicture();

        return dto;

    }

}
