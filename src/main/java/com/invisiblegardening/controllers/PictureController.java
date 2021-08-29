package com.invisiblegardening.controllers;

import com.invisiblegardening.Models.Picture;
import com.invisiblegardening.ResponseFile.ResponseFile;
import com.invisiblegardening.ResponseFile.ResponseMessage;
import com.invisiblegardening.services.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@CrossOrigin
@RequestMapping("/pictures")
public class PictureController {
    private final PictureService pictureService;

    @Autowired
    public PictureController(PictureService pictureService) {
        this.pictureService = pictureService;
    }

    @GetMapping
    public ResponseEntity<List<ResponseFile>> getPictures() {

        List<ResponseFile> files = pictureService.getPictures().map(picture -> {

            String fileDownloadUri = ServletUriComponentsBuilder
                    .fromCurrentContextPath()
                    .path("/pictures/")
                    .path(String.valueOf(picture.getId()))
                    .toUriString();

            return new ResponseFile(
                    picture.getName(),
                    fileDownloadUri,
                    picture.getType(),
                    picture.getData().length);
        }).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(files);

    }

    @GetMapping("/{id}")
    public ResponseEntity<byte[]> getPicture(@PathVariable("id") Long id) {
        Picture picture = pictureService.getPicture(id);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename =\"" + picture.getName() + "\"")
                .body(picture.getData());
    }


    @PostMapping("/upload")
    public ResponseEntity<ResponseMessage> uploadPicture(@RequestBody MultipartFile file) {

        String message = "";

        try {

            pictureService.storePicture(file);

            var picture = pictureService.getPictureByNameEquals(file.getOriginalFilename()).getId();

            message = "" + picture;

            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));

        } catch (Exception e) {

            message = "Could not upload the file: " +file.getOriginalFilename() + "!";

            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));

        }

    }

    @DeleteMapping( "/{id}")
    public void deletePicture(@PathVariable("id")Long id) {

        pictureService.deletePicture(id);

    }


}
