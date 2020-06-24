package com.example.demo.repository;

import com.example.demo.domain.User;
import com.example.demo.domain.projection.UserProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;


@CrossOrigin("http://localhost:4200")
@RepositoryRestResource(excerptProjection = UserProjection.class)
public interface UserRepo extends JpaRepository<User, Long> {
    User findByName(String name);
    User findByEmailAndPassword(String email, String password);
}
