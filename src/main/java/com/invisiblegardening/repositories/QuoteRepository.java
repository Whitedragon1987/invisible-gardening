package com.invisiblegardening.repositories;

import com.invisiblegardening.Models.Quote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuoteRepository extends JpaRepository<Quote, Long> {
}
