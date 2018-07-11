package com.github.cinnojam.rating.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.cinnojam.rating.model.Rating;

public interface RatingJpaRepository extends JpaRepository<Rating, Integer> {

}
