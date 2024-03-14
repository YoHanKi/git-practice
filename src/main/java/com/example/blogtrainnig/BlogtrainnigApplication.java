package com.example.blogtrainnig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class BlogtrainnigApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogtrainnigApplication.class, args);
    }

}
