package com.invisiblegardening.services;

import com.invisiblegardening.Exceptions.RecordNotFoundException;
import com.invisiblegardening.Models.Machine;
import com.invisiblegardening.Models.Request;
import com.invisiblegardening.Models.RequestMachine;
import com.invisiblegardening.Models.RequestMachineKey;
import com.invisiblegardening.repositories.MachineRepository;
import com.invisiblegardening.repositories.RequestMachineRepository;
import com.invisiblegardening.repositories.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequestMachineServiceImpl implements RequestMachineService{
    private final RequestRepository requestRepository;
    private final MachineRepository machineRepository;
    private final RequestMachineRepository requestMachineRepository;

    @Autowired
    public RequestMachineServiceImpl(RequestRepository requestRepository,
                                     MachineRepository machineRepository,
                                     RequestMachineRepository requestMachineRepository) {

        this.machineRepository = machineRepository;

        this.requestRepository = requestRepository;

        this.requestMachineRepository = requestMachineRepository;
    }

    @Override
    public RequestMachineKey addRequestMachine(long requestId, long machineId) {
        var requestMachine = new RequestMachine();
        if (!machineRepository.existsById(machineId)) { throw new RecordNotFoundException(); }
        Machine machine = machineRepository.findById(machineId).orElse(null);
        if (!requestRepository.existsById(requestId)) { throw new RecordNotFoundException(); }
        Request request = requestRepository.findById(requestId).orElse(null);
        requestMachine.setMachine(machine);
        requestMachine.setRequest(request);
        RequestMachineKey id = new RequestMachineKey(machineId, requestId);
        requestMachine.setId(id);
        requestMachineRepository.save(requestMachine);
        return id;
    }

}
