package com.example.demo.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Table
@Entity
public class Review {

    @Id
    @Column(name = "review_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;

    @ManyToOne
    @JoinColumn(name = "film_id", nullable = false)
    private Film film;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "type_id", nullable = false)
    private ReviewType reviewType;

    @Temporal(TemporalType.DATE)
    private Date date;

    private String text;


    public Review() { }

    public Review(Film film, ReviewType type, String text) {
        this.film = film;
        this.reviewType = type;
        this.text = text;
    }

}
