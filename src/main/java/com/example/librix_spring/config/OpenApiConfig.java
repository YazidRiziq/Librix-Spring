package com.example.librix_spring.config;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    OpenAPI productApiDoc() {
        return new OpenAPI()
            .info(new Info()
        .title("Library Management API Documentations")
        .description("Ini semua adalah dokumentasi dari API Library Management System")
        .version("1.0.0"));
    }

}
