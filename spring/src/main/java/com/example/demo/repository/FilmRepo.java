package com.example.demo.repository;

import com.example.demo.domain.Film;
import com.example.demo.domain.Genre;
import com.example.demo.domain.projection.FilmProjection;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Optional;
import java.util.Set;


@CrossOrigin("http://localhost:4200")
@RepositoryRestResource(excerptProjection = FilmProjection.class)
public interface FilmRepo extends JpaRepository<Film, Long> {
    Optional<Film> findById(Long id);
    List<Film> OrderByRatingDesc(Pageable pageable);
    List<Film> OrderByRatingAsc(Pageable pageable);

    Set<Film> findByGenres_genreId(Long id);
    Set<Film> findByGenres_genreIdOrderByRatingDesc(Long id);
    Set<Film> findByGenres_genreIdOrderByRatingAsc(Long id);
}
