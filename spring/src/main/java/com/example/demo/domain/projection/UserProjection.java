package com.example.demo.domain.projection;

import com.example.demo.domain.Review;
import com.example.demo.domain.Role;
import com.example.demo.domain.User;
import org.springframework.data.rest.core.config.Projection;

import java.util.Set;

@Projection(types = User.class, name = "userProjection")
public interface UserProjection {

    Long getUserId();
    String getName();
    String getPassword();
    String getEmail();
    Set<Role> getRoles();

}
