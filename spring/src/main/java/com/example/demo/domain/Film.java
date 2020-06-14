package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
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
    @JsonIgnoreProperties("film")
    private Set<Review> filmReviews = new HashSet<>();


    public Film() {
    }

    public Film(String name, Genre genres) {
        this.name = name;
        this.genres = Stream.of(genres).collect(Collectors.toSet());
        this.genres.forEach(x -> x.getFilms().add(this));
    }

}