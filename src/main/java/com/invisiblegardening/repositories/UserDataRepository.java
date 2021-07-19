package com.invisiblegardening.repositories;

import com.invisiblegardening.Models.UserData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserDataRepository extends JpaRepository<UserData, Long> {

    List<UserData> findByUserFirstnameContainingIgnoreCase(String userFirstname);

    List<UserData> findByUserLastnameContainingIgnoreCase(String userLastname);
}
