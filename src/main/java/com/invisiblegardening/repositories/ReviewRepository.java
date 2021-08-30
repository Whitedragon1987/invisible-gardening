package com.invisiblegardening.repositories;

import com.invisiblegardening.Models.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
