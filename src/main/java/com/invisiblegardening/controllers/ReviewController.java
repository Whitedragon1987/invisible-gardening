package com.invisiblegardening.controllers;

import com.invisiblegardening.Models.Review;
import com.invisiblegardening.controllers.dtos.IdInputDto;
import com.invisiblegardening.controllers.dtos.ReviewDto;
import com.invisiblegardening.controllers.dtos.ReviewInputDto;
import com.invisiblegardening.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("reviews")
public class ReviewController {
    private final ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping
    public List<ReviewDto> getReviews() {

        var dtos = new ArrayList<ReviewDto>();

        var reviews = reviewService.getReviews();

        for (Review review : reviews) {

            dtos.add(ReviewDto.fromReview(review));

        }

        return dtos;

    }

    @GetMapping("/{id}")
    public ReviewDto getReview (@PathVariable("id") Long id) {

        var review = reviewService.getReview(id);

        return ReviewDto.fromReview(review);

    }

    @PostMapping
    public ReviewDto saveReview(@RequestBody ReviewInputDto dto) {

        var review = reviewService.saveReview(dto.toReview());

        return ReviewDto.fromReview(review);

    }

    @PutMapping("/{id}")
    public ReviewDto updateReview(@PathVariable Long id, @RequestBody Review review) {

        reviewService.updateReview(id, review);

        return ReviewDto.fromReview(review);

    }

    @DeleteMapping("/{id}")
    public void deleteReview(@PathVariable("id") Long id) {

        reviewService.deleteReview(id);

    }

    @PostMapping("/review/{id}/picture")
    public void assignPictureToReview(@PathVariable("id") Long reviewId, @RequestBody IdInputDto input) {

        reviewService.assignPicture(reviewId, input.id);

    }

}
