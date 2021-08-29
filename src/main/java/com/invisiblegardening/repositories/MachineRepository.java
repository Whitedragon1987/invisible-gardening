package com.invisiblegardening.repositories;

import com.invisiblegardening.Models.Machine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MachineRepository extends JpaRepository<Machine, Long> {
    Optional<Machine> findMachineByMachineNameEquals(String machineName);
}
