package com.invisiblegardening.repositories;

import com.invisiblegardening.Models.RequestMachine;
import com.invisiblegardening.Models.RequestMachineKey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface RequestMachineRepository extends JpaRepository<RequestMachine, RequestMachineKey> {
   Collection<RequestMachine> findAllByRequestId(Long requestId);
   Collection<RequestMachine> findAllByMachineId(Long machineId);
}
