package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Film {

    @Id
    @GeneratedValue
    private int filmId;

    private String name;

    private int publishingYear;

    private String imagePath;


}
