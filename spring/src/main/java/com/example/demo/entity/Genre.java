package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Genre {

    @Id
    /*@EmbeddedId
    @GeneratedValue*/
    private Long genreId;

    private String name;

    /*@OneToMany(mappedBy = "genres")
    @JoinTable(
            name = "film_genres",
            joinColumns = @JoinColumn(name = "genre_id"),
            inverseJoinColumns = @JoinColumn(name = "film_id"))
    Set<FilmGenres> films = new HashSet<>();*/

}
