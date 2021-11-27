package com.invisiblegardening.services;

import com.invisiblegardening.Models.Machine;
import com.invisiblegardening.Models.Request;
import com.invisiblegardening.Models.RequestMachine;
import com.invisiblegardening.Models.RequestMachineKey;

import java.util.Collection;

public interface RequestMachineService {

    Collection<RequestMachine> getAllMachineResults();

    Collection<Machine> getRequestMachinesByRequestId(long requestId);
    Collection<Request> getRequestMachinesByMachineId(long machineId);
    RequestMachine getRequestMachineById(long requestId, long machineId);
    RequestMachineKey addRequestMachine(long requestId, long machineId);
}
