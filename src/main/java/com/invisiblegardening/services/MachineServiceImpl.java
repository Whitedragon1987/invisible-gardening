package com.invisiblegardening.services;

import com.invisiblegardening.Exceptions.RecordNotFoundException;
import com.invisiblegardening.Models.Machine;
import com.invisiblegardening.repositories.MachineRepository;
import com.invisiblegardening.repositories.PictureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@Service
public class MachineServiceImpl implements MachineService{
    private MachineRepository machineRepository;
    private PictureRepository pictureRepository;

    @Autowired
    public MachineServiceImpl(MachineRepository machineRepository,
                              PictureRepository pictureRepository) {

        this.machineRepository = machineRepository;

        this.pictureRepository = pictureRepository;

    }

    @Override
    public Machine getMachine(Long id) {

        Optional<Machine> machine = machineRepository.findById(id);

        if(machine.isPresent()) {

            return machine.get();

        } else {

            throw new RecordNotFoundException("Machine does not exist");

        }

    }

//    @Override
//    public Machine getMachineByMachineName(String machineName) {
//
//        var optionalMachine = machineRepository.findMachineByMachineNameEquals(machineName);
//
//        if(optionalMachine.isPresent()) {
//
//            var machine = optionalMachine.get();
//
//            return machine;
//
//        } else {
//
//            throw new RecordNotFoundException("Machine does not exist");
//
//        }
//
//    }

    @Override
    public List<Machine> getMachines() {

        return machineRepository.findAll();

    }

    @Override
    public Machine saveMachine(Machine machine) {

        return machineRepository.save(machine);

    }

    @Override
    public void updateMachine(Long id, Machine machine) {

        Optional<Machine> optionalMachine = machineRepository.findById(id);

        if(optionalMachine.isPresent()) {

            machineRepository.deleteById(id);

            machineRepository.save(machine);

        } else {

            throw new RecordNotFoundException("Machine does not exist");

        }

    }

    @Override
    public void deleteMachine(Long id) {

        machineRepository.deleteById(id);

    }

    @Override
    public void assignPictureToMachine(Long id, Long pictureId) {

        var optionalMachine = machineRepository.findById(id);

        var optionalPicture = pictureRepository.findById(pictureId);

        if (optionalMachine.isPresent() && optionalPicture.isPresent()) {

            var machine = optionalMachine.get();

            var picture = optionalPicture.get();

            machine.setPicture(picture);

            machineRepository.save(machine);

        } else {

            throw new RecordNotFoundException();

        }

    }



}
