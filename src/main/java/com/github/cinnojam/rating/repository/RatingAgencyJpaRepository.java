package com.github.cinnojam.rating.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.cinnojam.rating.model.RatingAgency;

public interface RatingAgencyJpaRepository extends JpaRepository<RatingAgency, Integer> {

}
