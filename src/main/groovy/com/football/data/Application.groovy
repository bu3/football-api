package com.football.data

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import org.springframework.web.client.RestTemplate
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter

@SpringBootApplication
class Application extends WebMvcConfigurerAdapter {

    static void main(String[] args) {
        SpringApplication.run(Application.class, args)
    }

    @Bean
    RestTemplate restTemplate() {
        new RestTemplate()
    }
}
