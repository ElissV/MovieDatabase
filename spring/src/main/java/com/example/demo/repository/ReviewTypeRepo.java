package com.example.demo.repository;

import com.example.demo.domain.ReviewType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Optional;

@CrossOrigin("http://localhost:4200")
public interface ReviewTypeRepo extends JpaRepository<ReviewType, Long> {
    Optional<ReviewType> findById(Long id);
}
