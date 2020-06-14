package com.example.demo.domain;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@EqualsAndHashCode(exclude = "films")
public class Genre {

    @Id
    @Column(name = "genre_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long genreId;

    private String name;

    //@JsonIgnoreProperties("genres")
    @ManyToMany(mappedBy = "genres", fetch = FetchType.EAGER)
    private Set<Film> films = new HashSet<>();


    public Genre(String name) {
        this.name = name;
    }

    public Genre() {
    }

}