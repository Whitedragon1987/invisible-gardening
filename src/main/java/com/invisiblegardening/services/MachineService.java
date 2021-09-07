package com.invisiblegardening.services;

import com.invisiblegardening.Models.Machine;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface MachineService {

    List<Machine> getMachines();

    Machine getMachine(Long id);
//    Machine getMachineByMachineName(String machineName);
    Machine saveMachine(Machine machine);

    void updateMachine(Long id, Machine machine);
    void deleteMachine(Long id);
    void assignPictureToMachine(Long id, Long pictureId);
}