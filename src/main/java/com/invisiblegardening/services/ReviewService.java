package com.invisiblegardening.services;

import com.invisiblegardening.Models.Review;

import java.util.List;

public interface ReviewService {

    List<Review> getReviews();

    Review getReview(Long id);
    Review saveReview(Review review);

    void updateReview(Long id, Review review);
    void deleteReview(Long id);
    void assignPicture(Long id, Long pictureId);
}
