package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Formula;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Data
@Entity
@EqualsAndHashCode(exclude = {"genres", "filmReviews"})
public class Film {

    @Id
    @Column(name = "film_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Integer publishingYear;
    private String description;
    private String imagePath;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "film_genres",
            joinColumns = @JoinColumn(name = "film_id", referencedColumnName = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id", referencedColumnName = "genre_id"))
    private Set<Genre> genres = new HashSet<>();

    /*@Query("select ((select count(*) from review where review.type_id = 1 and review.film_id = :id) * 100)" +
            "/ (select count(*) from review where review.film_id = :id)")
    private Double rating;*/

    @OneToMany(mappedBy = "film", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Review> filmReviews = new HashSet<>();

    @NotNull
    @Formula(value = "((select count(*) from review where review.type_id = 1 and review.film_id = film_id) * 100)" +
                        "/ (select count(*) from review where review.film_id = film_id)")
    private Double rating;


    public Film() {
    }

    public Film(String name, Genre genres) {
        this.name = name;
        this.genres = Stream.of(genres).collect(Collectors.toSet());
        this.genres.forEach(x -> x.getFilms().add(this));
    }


    /*@JsonIgnore
    @PostLoad
    public void rating() {
        int reviewsCount = filmReviews.size();
        if (reviewsCount == 0) {
            rating = 0.0;
            return;
        }
            //return 0.0;

        int positive = getPositiveReviewsQty(filmReviews);
        rating = (double) ((positive * 100.0) / reviewsCount);
        //return (double) ((positive * 100.0) / reviewsCount);
    }*/

    private int getPositiveReviewsQty(Set<Review> reviews) {
        int positive = 0;
        for (Review r : reviews) {
            String reviewName = r.getReviewType().getName();
            if (reviewName.equalsIgnoreCase("positive"))
                positive++;
        }
        return positive;
    }

}