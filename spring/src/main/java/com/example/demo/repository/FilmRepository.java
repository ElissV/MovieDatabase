package com.example.demo.repository;

import com.example.demo.domain.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200")
public interface FilmRepository extends JpaRepository<Film, Long> {
}
