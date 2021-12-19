package com.invisiblegardening.services;

import com.invisiblegardening.Models.Picture;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.stream.Stream;

public interface PictureService {

    Stream<Picture> getPictures();

    Picture getPicture(Long id);
    Picture getPictureByNameEquals(String name);

    Picture storePicture(MultipartFile file) throws IOException;

    void deletePicture(Long id);
}
