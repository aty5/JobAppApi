package com.aty.jobappapi.review;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies/{id}")
public class ReviewController {
    private ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> getAllReviews(@PathVariable Long id) {
        return new ResponseEntity<>(reviewService.getAllReviews(id), HttpStatus.OK);
    }

    @PostMapping("/reviews")
    public ResponseEntity<String> addReview(@PathVariable Long id,
                                            @RequestBody Review review) {
        boolean isReviewSaved = reviewService.addReview(id, review);

        if (isReviewSaved)
            return new ResponseEntity<>("Review saved successfully", HttpStatus.OK);
        else
            return new ResponseEntity<>("Review not saved", HttpStatus.NOT_FOUND);

    }

}
