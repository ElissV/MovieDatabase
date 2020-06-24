package com.example.demo.service;

import com.example.demo.domain.Film;
import com.example.demo.domain.Review;
import com.example.demo.domain.forms.ReviewFormModel;
import com.example.demo.domain.ReviewType;
import com.example.demo.repository.FilmRepo;
import com.example.demo.repository.ReviewRepo;
import com.example.demo.repository.ReviewTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReviewSubmitService {

    @Autowired
    private ReviewRepo reviewRepo;
    @Autowired
    private FilmRepo filmRepo;
    @Autowired
    ReviewTypeRepo reviewTypeRepo;

    public boolean saveNewReview(ReviewFormModel model) {
        Review review = getReview(model);
        if (filmAndTypeNotEmpty(review)) {
            reviewRepo.save(review);
            return true;
        }
        return false;
    }

    private Review getReview(ReviewFormModel model) {
        Film film = getFilm(model);
        ReviewType type = getType(model);
        String text = model.getText();

        return new Review(film, type, text);
    }

    private Film getFilm(ReviewFormModel model) {
        Long id = model.getFilmId();
        Optional<Film> film = filmRepo.findById(id);
        return film.orElse(null);
    }

    private ReviewType getType(ReviewFormModel model) {
        Long id = model.getReviewTypeId();
        Optional<ReviewType> type = reviewTypeRepo.findById(id);
        return type.orElse(null);
    }

    private boolean filmAndTypeNotEmpty(Review review) {
        return review.getFilm() != null && review.getReviewType() != null;
    }

}
