package com.invisiblegardening.controllers;

import com.invisiblegardening.Exceptions.BadRequestException;
import com.invisiblegardening.Models.Machine;
import com.invisiblegardening.ResponseFile.ResponseMessage;
import com.invisiblegardening.controllers.dtos.IdInputDto;
import com.invisiblegardening.controllers.dtos.MachineDto;
import com.invisiblegardening.controllers.dtos.MachineInputDto;
import com.invisiblegardening.services.MachineService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("machines")
public class MachineController {
    private final MachineService machineService;

    @Autowired
    public MachineController(MachineService machineService) {
        this.machineService = machineService;}

    @GetMapping
    public List<MachineDto> getMachines() {

        var dtos = new ArrayList<MachineDto>();

        var machines = machineService.getMachines();

        for (Machine machine : machines) {

            dtos.add(MachineDto.fromMachine(machine));

        }

        return dtos;

    }

    @GetMapping("/{id}")
    public MachineDto getMachine(@PathVariable("id") Long id) {

        var machine = machineService.getMachine(id);

        return MachineDto.fromMachine(machine);

    }

//    @GetMapping("/machine/{machineName}")
//    public MachineDto getMachineByMachineName(@PathVariable("machineName") String machineName) {
//
//        var machine = machineService.getMachineByMachineName(machineName);
//
//        return MachineDto.fromMachine(machine);
//
//    }

    @PostMapping
    public MachineDto saveMachine(@RequestBody MachineInputDto dto) {

        var machine = machineService.saveMachine(dto.toMachine());

        return MachineDto.fromMachine(machine);

    }

    @PutMapping("/{id}")
    public MachineDto updateMachine(@PathVariable("id") Long id, @RequestBody Machine machine) {

        machineService.updateMachine(id, machine);

        return MachineDto.fromMachine(machine);

    }

    @DeleteMapping("/{id}")
    public void deleteMachine(@PathVariable("id") Long id) {

        machineService.deleteMachine(id);

    }

    @PutMapping("/machine/{id}/picture")
    public void assignPictureToMachine(@PathVariable("id") Long machineId, @RequestBody IdInputDto input) {

        machineService.assignPictureToMachine(machineId, input.id);
    }

}

