package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;

@Data
@Table
@Entity
public class Review {

    @Id
    @Column(name = "review_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;

    @ManyToOne
    @JoinColumn(name = "filmId", nullable = false)
    private Film film;

    @ManyToOne
    @JoinColumn(name = "typeId", nullable = false)
    private ReviewType reviewType;

    @Column
    private String text;

}
