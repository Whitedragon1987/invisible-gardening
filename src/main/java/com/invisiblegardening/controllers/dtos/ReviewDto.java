package com.invisiblegardening.controllers.dtos;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.invisiblegardening.Models.Picture;
import com.invisiblegardening.Models.Review;

public class ReviewDto {
    public Long id;

    public String value;
    public String description;
    public String name;


    @JsonSerialize
    Picture picture;

    public static ReviewDto fromReview(Review review) {

        var dto = new ReviewDto();

        dto.id = review.getId();

        dto.value = review.getValue();

        dto.description = review.getDescription();

        dto.name = review.getName();

        dto.picture = review.getPicture();

        return dto;

    }

}