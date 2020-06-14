package com.example.demo.domain.projection;

import com.example.demo.domain.Film;
import com.example.demo.domain.Genre;
import com.example.demo.domain.Review;
import org.springframework.data.rest.core.config.Projection;

import java.util.Set;

@Projection(types = Film.class, name = "filmProjection")
public interface FilmProjection {
    Long getId();
    String getName();
    Integer getPublishingYear();
    String getDescription();
    String getImagePath();
    Set<Genre> getGenres();
    Set<ReviewProjection> getFilmReviews();
}
