package com.example.demo.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "users")
public class User {

    private long userId;
    private String name;
    private String email;
    private String password;

}
