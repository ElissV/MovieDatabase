package com.example.demo.controller;

import com.example.demo.domain.forms.UserFormModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    private UserService userService;

    @PostMapping
    public void register(@RequestBody UserFormModel model) {
        userService.saveUser(model);
    }

}
