package com.example.demo.repository;

import com.example.demo.domain.Film;
import com.example.demo.domain.FilmI;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;


@CrossOrigin("http://localhost:4200")
@RepositoryRestResource(excerptProjection = FilmI.class)
public interface FilmRepo extends JpaRepository<Film, Long> {
}
