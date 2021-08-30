package com.invisiblegardening.controllers.dtos;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.invisiblegardening.Models.Picture;
import com.invisiblegardening.Models.Review;

public class ReviewDto {
    public Long id;

    public String value;
    public String description;
    public UserDataDto userData;

    @JsonSerialize
    Picture picture;

    public static ReviewDto fromReview(Review review) {

        var dto = new ReviewDto();

        dto.id = review.getId();

        dto.value = review.getValue();

        dto.description = review.getDescription();

        dto.userData = UserDataDto.fromUserData(review.getUserData());

        dto.picture = review.getPicture();

        return dto;

    }

}