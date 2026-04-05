package com.example.librix_spring;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
    info = @Info(title = "Librix API", version = "1.0", description = "Dokumentasi API Librix"),
    security = @SecurityRequirement(name = "Bearer Authentication") // Menerapkan keamanan ke semua API di Swagger
)
@SecurityScheme(
    name = "Bearer Authentication",
    type = SecuritySchemeType.HTTP, 
    bearerFormat = "JWT", 
    scheme = "bearer"
)

public class LibrixSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibrixSpringApplication.class, args);
	}

}
