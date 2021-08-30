package com.invisiblegardening.controllers.dtos;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.invisiblegardening.Models.Picture;
import com.invisiblegardening.Models.Review;

public class ReviewInputDto {
    public Long id;

    public String value;
    public String description;

    public Review toReview() {
        var review = new Review();

        review.setValue(value);
        review.setDescription(description);

        return review;
    }
}

