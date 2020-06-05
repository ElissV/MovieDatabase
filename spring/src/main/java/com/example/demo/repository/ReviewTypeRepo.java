package com.example.demo.repository;

import com.example.demo.domain.ReviewType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewTypeRepo extends JpaRepository<ReviewType, Long> {
}
