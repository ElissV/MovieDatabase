package com.example.demo.repository;

import com.example.demo.domain.Film;
import com.example.demo.domain.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Set;

@CrossOrigin("http://localhost:4200")
public interface GenreRepo extends JpaRepository<Genre, Long> {
}
