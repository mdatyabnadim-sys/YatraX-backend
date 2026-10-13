package com.yatrax.yatrax_backend.controller;

import com.yatrax.yatrax_backend.model.Review;
import com.yatrax.yatrax_backend.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    @Autowired private ReviewRepository repo;

    @GetMapping("/{key}")
    public List<Review> getReviews(@PathVariable String key) {
        return repo.findByReviewKeyOrderByTimestampDesc(key);
    }

    @PostMapping
    public Review postReview(@RequestBody Review review) {
        if (review.getTimestamp() == null) {
            review.setTimestamp(System.currentTimeMillis());
        }
        if (review.getLikedBy() == null) review.setLikedBy("");
        if (review.getDislikedBy() == null) review.setDislikedBy("");
        return repo.save(review);
    }

    @PostMapping("/{id}/vote")
    public ResponseEntity<?> vote(
            @PathVariable Long id,
            @RequestParam String email,
            @RequestParam String type) {

        Review review = repo.findById(id).orElse(null);
        if (review == null) return ResponseEntity.notFound().build();

        List<String> liked = splitCsv(review.getLikedBy());
        List<String> disliked = splitCsv(review.getDislikedBy());

        if ("like".equalsIgnoreCase(type)) {
            if (liked.contains(email)) liked.remove(email);
            else { liked.add(email); disliked.remove(email); }
        } else if ("dislike".equalsIgnoreCase(type)) {
            if (disliked.contains(email)) disliked.remove(email);
            else { disliked.add(email); liked.remove(email); }
        }

        review.setLikedBy(String.join(",", liked));
        review.setDislikedBy(String.join(",", disliked));
        repo.save(review);
        return ResponseEntity.ok(review);
    }

    private List<String> splitCsv(String s) {
        if (s == null || s.isBlank()) return new ArrayList<>();
        return new ArrayList<>(Arrays.asList(s.split(",")));
    }
}
