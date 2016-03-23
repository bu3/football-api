package com.football.data

import com.google.common.base.Predicate
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.ResponseEntity
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.Tag
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2

import java.time.LocalDate

import static com.google.common.base.Predicates.or
import static springfox.documentation.builders.PathSelectors.regex

@EnableSwagger2
@Configuration
class SwaggerConfiguration {

    @Bean
    Docket docket() {
        new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(paths())
                .build()
                .pathMapping('/')
                .directModelSubstitute(LocalDate.class,
                String.class)
                .genericModelSubstitutes(ResponseEntity.class)
                .useDefaultResponseMessages(false)
                .tags(new Tag('Pet Service', 'All apis relating to pets'))
    }

    private Predicate<String> paths() {
        or(regex('/team.*'));
    }
}
