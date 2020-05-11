package com.example.demo.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
class Genre {

    @Id
    @GeneratedValue
    private Long genreId;

    private String name;

}
