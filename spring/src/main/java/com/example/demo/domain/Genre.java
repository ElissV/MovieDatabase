package com.example.demo.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Genre {

    @Id
    @Column(name = "genre_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long genreId;

    private String name;

    @ManyToMany(mappedBy = "genres")
    private Set<Film> films = new HashSet<>();

    public Genre(String name) {
        this.name = name;
    }

    public Genre() {
    }

}