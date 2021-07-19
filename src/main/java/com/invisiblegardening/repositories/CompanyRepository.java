package com.invisiblegardening.repositories;

import com.invisiblegardening.Models.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
