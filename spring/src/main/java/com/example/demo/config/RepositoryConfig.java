package com.example.demo.config;

import com.example.demo.domain.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;
import org.springframework.http.MediaType;

@Configuration
public class RepositoryConfig implements RepositoryRestConfigurer {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.exposeIdsFor(Film.class);
        config.exposeIdsFor(Genre.class);
        config.exposeIdsFor(User.class);
        config.exposeIdsFor(Role.class);
        config.exposeIdsFor(Review.class);
        config.exposeIdsFor(ReviewType.class);
    }

}
