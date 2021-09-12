package com.invisiblegardening.repositories;

import com.invisiblegardening.Models.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface RequestRepository extends JpaRepository<Request, Long> {

    List<Request> findByRequestStartTimeBetween(LocalDateTime start, LocalDateTime end);

    List<Request> findByMachine(Machine machine);

    List<Request> findByJob(Job job);

    List<Request> findByUserData(UserData userData);

    List<Request> findByRequestEndTimeBetweenAndMachine(LocalDateTime startTime, LocalDateTime endTime, Machine machine);

    List<Request> findByRequestStartTimeBetweenAndMachine(LocalDateTime startTime, LocalDateTime endTime, Machine machine);

    List<Request> findByRequestStartTimeBetweenAndJob(LocalDateTime startTime, LocalDateTime endTime, Job job);

    List<Request> findByRequestEndTimeBetweenAndJob(LocalDateTime startTime, LocalDateTime endTime, Job job);

}
