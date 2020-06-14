package com.example.demo.repository;

import com.example.demo.domain.Review;
import com.example.demo.domain.projection.ReviewProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@Repository
@CrossOrigin("http://localhost:4200")
@RepositoryRestResource(excerptProjection = ReviewProjection.class)
public interface ReviewRepo extends JpaRepository<Review, Long> {
}
