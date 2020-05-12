package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

//@Embeddable
public class FilmGenreRelationship implements Serializable {

   /* public FilmGenreRelationship() {}

    public FilmGenreRelationship(Long filmId, Long genreId) {
        this.filmId = filmId;
        this.genreId = genreId;
    }

    @Column(name = "film_id")
    Long filmId;

    @Column(name = "genre_id")
    Long genreId;

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        FilmGenreRelationship relObj = (FilmGenreRelationship) obj;
        boolean filmIdCompare = this.filmId == relObj.filmId;
        boolean genreIdCompare = this.genreId == relObj.genreId;
        return (filmIdCompare && genreIdCompare);
    }

    public Long getFilmId() {
        return filmId;
    }

    public void setFilmId(Long filmId) {
        this.filmId = filmId;
    }

    public Long getGenreId() {
        return genreId;
    }

    public void setGenreId(Long genreId) {
        this.genreId = genreId;
    }*/
}
