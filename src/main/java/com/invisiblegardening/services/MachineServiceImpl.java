package com.invisiblegardening.services;

import com.invisiblegardening.Exceptions.RecordNotFoundException;
import com.invisiblegardening.Models.Machine;
import com.invisiblegardening.repositories.MachineRepository;
import com.invisiblegardening.repositories.PictureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MachineServiceImpl implements MachineService{
    private final MachineRepository machineRepository;
    private final PictureRepository pictureRepository;

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

            var storedMachine = optionalMachine.get();
            storedMachine.setId(storedMachine.getId());
            storedMachine.setMachineName(machine.getMachineName());
            storedMachine.setMachineDescription(machine.getMachineDescription());
            storedMachine.setMachineType(machine.getMachineType());
            storedMachine.setPicture(storedMachine.getPicture());
            storedMachine.setMachineLastService(machine.getMachineLastService());
            storedMachine.setMachinePlannedService(machine.getMachinePlannedService());
            storedMachine.setMachineMeasurements(machine.getMachineMeasurements());
            machineRepository.save(storedMachine);

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
