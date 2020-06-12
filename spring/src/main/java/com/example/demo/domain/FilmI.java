package com.example.demo.domain;

import org.springframework.data.rest.core.config.Projection;

import java.util.List;

@Projection(types = Film.class, name = "filmI")
public interface FilmI {
    Long getFilmId();
    String getName();
    Integer getPublishingYear();
    String getDescription();
    String getImagePath();
    List<Genre> getGenres();
    List<Review> getFilmReviews();
}
