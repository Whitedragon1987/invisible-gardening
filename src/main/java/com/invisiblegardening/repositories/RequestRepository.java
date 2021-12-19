package com.invisiblegardening.repositories;

import com.invisiblegardening.Models.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface RequestRepository extends JpaRepository<Request, Long> {

    List<Request> findByRequestStartTimeBetween(LocalDateTime start, LocalDateTime end);

    List<Request> findByUserData(UserData userData);

}
