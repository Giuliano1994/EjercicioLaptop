package com.example.EjercicioLaptop.config;

/**
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2

public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }
    private ApiInfo apiInfo() {
        return new ApiInfo(
                "REST API",
                "REST API de ejemplo para sacavix.com.",
                "v1.0",
                "Todos los derechos otorgados",
                new Contact("Giuliano nicolas", "https://google.com", "gomesdasilva.giuliano@gmail.com"),
                "Licencia del API",
                "http://www.fsf.org",
                Collections.emptyList());
    }

}
*/
