package com.fenlon.config;

import com.fenlon.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Fenlon {

    @Bean
    public User getUser() {
        return new User();
    }
}
