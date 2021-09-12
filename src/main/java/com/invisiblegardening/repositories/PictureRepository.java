package com.invisiblegardening.repositories;


import com.invisiblegardening.Models.Picture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PictureRepository extends JpaRepository<Picture, Long> {
    Picture findByNameEquals(String name);
}
