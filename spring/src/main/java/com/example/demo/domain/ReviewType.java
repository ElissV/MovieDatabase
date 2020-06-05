package com.example.demo.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "review_type")
public class ReviewType {

    @Id
    @Column(name = "type_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long typeId;

    private String name;

    @OneToMany(mappedBy = "reviewType")
    private Set<Review> reviews = new HashSet<>();

}