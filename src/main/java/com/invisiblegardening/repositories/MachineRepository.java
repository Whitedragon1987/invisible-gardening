package com.invisiblegardening.repositories;

import com.invisiblegardening.Models.Machine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MachineRepository extends JpaRepository<Machine, Long> {
}
