package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Film {

    @Id
    //@EmbeddedId
    @GeneratedValue
    private Long filmId;

    private String name;
    private int publishingYear;
    private String imagePath;

    /*@OneToMany//(mappedBy = "film")
    @JoinTable(
            name = "film_genres",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id"))
    Set<FilmGenres> genres = new HashSet<>();*/

}