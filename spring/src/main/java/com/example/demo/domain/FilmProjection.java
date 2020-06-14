package com.example.demo.domain;

import org.springframework.data.rest.core.config.Projection;

import java.util.Set;

@Projection(types = Film.class, name = "filmProjection")
public interface FilmProjection {
    Long getFilmId();
    String getName();
    Integer getPublishingYear();
    String getDescription();
    String getImagePath();
    Set<Genre> getGenres();
    Set<Review> getFilmReviews();
}
