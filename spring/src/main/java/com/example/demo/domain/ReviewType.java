package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "review_type")
@EqualsAndHashCode(exclude = "reviews")
public class ReviewType {

    @Id
    @Column(name = "type_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long typeId;

    private String name;

    @OneToMany(mappedBy = "reviewType", cascade = CascadeType.ALL)
    private Set<Review> reviews = new HashSet<>();

}