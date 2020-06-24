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


    @OneToMany(mappedBy = "film", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Review> filmReviews = new HashSet<>();


    @Formula(value = "((select count(*) from review where review.type_id = 1 and review.film_id = film_id) * 100)" +
                        "/ (select count(*) from review where review.film_id = film_id)")
    private Double rating = 0.00;


    public Film() {
    }

    public Film(String name, Genre genres) {
        this.name = name;
        this.genres = Stream.of(genres).collect(Collectors.toSet());
        this.genres.forEach(x -> x.getFilms().add(this));
    }

    public boolean hasGreaterRating(Film f) {
        return this.rating > f.rating;
    }

}