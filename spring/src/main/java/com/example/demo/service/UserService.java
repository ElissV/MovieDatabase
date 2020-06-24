package com.example.demo.service;

import com.example.demo.domain.Role;
import com.example.demo.domain.User;
import com.example.demo.domain.forms.UserFormModel;
import com.example.demo.repository.RoleRepo;
import com.example.demo.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private RoleRepo roleRepo;

    public void saveUser(UserFormModel model) {
        String name = model.getName();
        String email = model.getEmail();
        String password = model.getPassword();
        Set<Role> role = Collections.singleton(roleRepo.findRoleByName("USER"));
        User user = new User(name, email, password, role);
        userRepo.save(user);
    }

}
