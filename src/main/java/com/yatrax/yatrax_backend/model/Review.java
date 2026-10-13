package com.yatrax.yatrax_backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "reviews")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String reviewKey;
    private String userName;
    private String userEmail;

    @Column(length = 2000)
    private String text;

    private Integer rating;
    private Long parentId;
    private Long timestamp;

    @Column(length = 2000)
    private String likedBy;

    @Column(length = 2000)
    private String dislikedBy;
}
