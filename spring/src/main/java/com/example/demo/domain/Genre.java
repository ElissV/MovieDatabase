package com.example.demo.domain;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Genre {

    @Id
    @Column(name = "genre_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long genreId;

    private String name;

    //@JsonIgnoreProperties("genres")
    @ManyToMany(mappedBy = "genres", fetch = FetchType.EAGER)
    private List<Film> films = new ArrayList<>();


    public Genre(String name) {
        this.name = name;
    }

    public Genre() {
    }

}