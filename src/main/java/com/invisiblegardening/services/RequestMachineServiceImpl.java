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

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.HashSet;

@Service
public class RequestMachineServiceImpl implements RequestMachineService{
    private RequestRepository requestRepository;
    private MachineRepository machineRepository;
    private RequestMachineRepository requestMachineRepository;

    @Autowired
    public RequestMachineServiceImpl(RequestRepository requestRepository,
                                     MachineRepository machineRepository,
                                     RequestMachineRepository requestMachineRepository) {

        this.machineRepository = machineRepository;

        this.requestRepository = requestRepository;

        this.requestMachineRepository = requestMachineRepository;
    }


    @Override
    public Collection<RequestMachine> getAllMachineResults() {
        Collection<RequestMachine> requestMachines = requestMachineRepository.findAll();
        return requestMachines;
    }

    @Override
    public Collection<Machine> getRequestMachinesByRequestId(long requestId) {
        Collection<Machine> machines = new HashSet<>();
        Collection<RequestMachine> requestMachines = requestMachineRepository.findAllByRequestId(requestId);
        for (RequestMachine requestmachine : requestMachines) {
            machines.add(requestmachine.getMachine());
        }
        return machines;
    }

    @Override
    public Collection<Request> getRequestMachinesByMachineId(long machineId) {
        Collection<Request> requests = new HashSet<>();
        Collection<RequestMachine> requestMachines = requestMachineRepository.findAllByRequestId(machineId);
        for (RequestMachine requestMachine : requestMachines) {
            requests.add(requestMachine.getRequest());
        }
        return requests;
    }

    @Override
    public RequestMachine getRequestMachineById(long requestId, long machineId) {
        return requestMachineRepository.findById(new RequestMachineKey(requestId, machineId)).orElse(null);    }

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
