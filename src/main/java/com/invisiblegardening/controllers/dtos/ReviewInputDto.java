package com.invisiblegardening.controllers.dtos;
import com.invisiblegardening.Models.Picture;
import com.invisiblegardening.Models.Review;
import org.springframework.lang.Nullable;

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

