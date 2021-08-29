package com.invisiblegardening.repositories;


import com.invisiblegardening.Models.Picture;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PictureRepository extends JpaRepository<Picture, Long> {
    Picture findByNameEquals(String name);
}
