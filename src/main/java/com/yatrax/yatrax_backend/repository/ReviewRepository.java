package com.yatrax.yatrax_backend.repository;

import com.yatrax.yatrax_backend.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByReviewKeyOrderByTimestampDesc(String reviewKey);
}
