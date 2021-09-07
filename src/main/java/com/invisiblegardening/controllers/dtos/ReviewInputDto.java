package com.invisiblegardening.controllers.dtos;
import com.invisiblegardening.Models.Review;

public class ReviewInputDto {
    public Long id;

    public String value;
    public String description;
    public String name;

    public Review toReview() {
        var review = new Review();

        review.setValue(value);
        review.setDescription(description);
        review.setName(name);

        return review;
    }
}

