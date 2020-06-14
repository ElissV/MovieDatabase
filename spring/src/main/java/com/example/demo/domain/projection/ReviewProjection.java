package com.example.demo.domain.projection;

import com.example.demo.domain.Review;
import com.example.demo.domain.ReviewType;
import org.springframework.data.rest.core.config.Projection;

import java.util.Date;

@Projection(types = Review.class, name = "reviewProjection")
public interface ReviewProjection {

    Long getReviewId();
    ReviewType getReviewType();
    Date getDate();
    String getText();

}
