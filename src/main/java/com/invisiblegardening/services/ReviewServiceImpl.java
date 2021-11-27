package com.invisiblegardening.services;

import com.invisiblegardening.Exceptions.RecordNotFoundException;
import com.invisiblegardening.Models.Review;
import com.invisiblegardening.repositories.PictureRepository;
import com.invisiblegardening.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService{
    private final ReviewRepository reviewRepository;
    private final PictureRepository pictureRepository;

    @Autowired
    public ReviewServiceImpl(ReviewRepository reviewRepository,
                             PictureRepository pictureRepository) {

        this.reviewRepository = reviewRepository;
        this.pictureRepository = pictureRepository;

    }


    @Override
    public List<Review> getReviews() {
        return reviewRepository.findAll();
    }

    @Override
    public Review getReview(Long id) {
        Optional<Review> review = reviewRepository.findById(id);

        if(review.isPresent()) {

            return review.get();

        } else{

            throw new RecordNotFoundException("Review does not exist");

        }

    }

    @Override
    public Review saveReview(Review review) {

        return reviewRepository.save(review);

    }

    @Override
    public void updateReview(Long id, Review review) {
        Optional<Review> optionalReview = reviewRepository.findById(id);

        if(optionalReview.isPresent()) {

            reviewRepository.deleteById(id);

            reviewRepository.save(review);

        } else {

            throw new RecordNotFoundException("Review does not exist");

        }

    }

    @Override
    public void deleteReview(Long id) {

        reviewRepository.deleteById(id);

    }

    @Override
    public void assignPicture(Long id, Long pictureId) {

        var optionalReview = reviewRepository.findById(id);

        var optionalPicture = pictureRepository.findById(pictureId);

        if (optionalReview.isPresent() && optionalPicture.isPresent()) {

            var review = optionalReview.get();

            var picture = optionalPicture.get();

            review.setPicture(picture);

            reviewRepository.save(review);

        } else {

            throw new RecordNotFoundException();

        }

    }

}
