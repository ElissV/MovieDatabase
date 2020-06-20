package com.example.demo.domain.projection;

import com.example.demo.domain.Film;
import com.example.demo.domain.Genre;
import org.springframework.beans.factory.annotation.Value;
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
    @Value("#{target.getRating()}")
    Double getRating();
    Set<ReviewProjection> getFilmReviews();
}
