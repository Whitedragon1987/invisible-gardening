package com.invisiblegardening.services;

import com.invisiblegardening.Models.RequestMachineKey;


public interface RequestMachineService {

    RequestMachineKey addRequestMachine(long requestId, long machineId);

}
