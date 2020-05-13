package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@CrossOrigin("http://localhost:4200")
public class AuthController {

    @PostMapping("/user/registration")
    void registerUser(@RequestBody ) {

    }

}