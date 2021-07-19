package com.invisiblegardening.services;

import com.invisiblegardening.Exceptions.RecordNotFoundException;
import com.invisiblegardening.Models.Machine;
import com.invisiblegardening.repositories.MachineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MachineServiceImpl implements MachineService{
    private MachineRepository machineRepository;

    @Autowired
    public MachineServiceImpl(MachineRepository machineRepository) {

        this.machineRepository = machineRepository;

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

}
