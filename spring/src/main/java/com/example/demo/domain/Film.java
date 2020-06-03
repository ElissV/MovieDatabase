package com.example.demo.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Data
@EqualsAndHashCode(exclude = "genres")
@Entity
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "film_id")
    private Long filmId;

    private String name;
    private Integer publishingYear;
    private String description;
    private String imagePath;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "film_genres",
            joinColumns = @JoinColumn(name = "film_id", referencedColumnName = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id", referencedColumnName = "genre_id"))
    private Set<Genre> genres = new HashSet<>();

    public Film() {
    }

    public Film(String name, Genre genres) {
        this.name = name;
        this.genres = Stream.of(genres).collect(Collectors.toSet());
        this.genres.forEach(x -> x.getFilms().add(this));
    }

}