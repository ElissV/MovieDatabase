package com.example.demo.repository;

import com.example.demo.domain.ReviewType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@Repository
@CrossOrigin("http://localhost:4200")
public interface ReviewTypeRepo extends JpaRepository<ReviewType, Long> {
}
