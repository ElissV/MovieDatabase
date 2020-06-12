package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Data
@Entity
//@EqualsAndHashCode(exclude = {"genres", "filmReviews"})
public class Film {

    @Id
    @Column(name = "film_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long filmId;

    private String name;
    private Integer publishingYear;
    private String description;
    private String imagePath;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "film_genres",
            joinColumns = @JoinColumn(name = "film_id", referencedColumnName = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id", referencedColumnName = "genre_id"))
    private List<Genre> genres = new ArrayList<>();


    @OneToMany(mappedBy = "film", cascade = CascadeType.ALL)
    private List<Review> filmReviews = new ArrayList<>();


    public Film() {
    }

    public Film(String name, Genre genres) {
        this.name = name;
        this.genres = Stream.of(genres).collect(Collectors.toList());
        this.genres.forEach(x -> x.getFilms().add(this));
    }

}