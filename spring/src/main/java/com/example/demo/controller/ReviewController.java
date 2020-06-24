package com.example.demo.controller;

import com.example.demo.domain.forms.ReviewFormModel;
import com.example.demo.service.ReviewSubmitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:4200")
public class ReviewController {

    private ReviewSubmitService reviewService;

    @Autowired
    public ReviewController(ReviewSubmitService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping("/submitReview")
    public ReviewFormModel sendReview(@RequestBody ReviewFormModel model) {
        reviewService.saveNewReview(model);
        return model;
    }

}
