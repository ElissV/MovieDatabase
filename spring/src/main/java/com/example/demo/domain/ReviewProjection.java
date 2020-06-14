package com.example.demo.domain;

import org.springframework.data.rest.core.config.Projection;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;

@Projection(types = Review.class, name = "reviewProjection")
public interface ReviewProjection {

    Long getReviewId();
    ReviewType getReviewType();
    @DateTimeFormat(pattern = "ddMMyy")
    Timestamp getDate();
    String getText();

}
