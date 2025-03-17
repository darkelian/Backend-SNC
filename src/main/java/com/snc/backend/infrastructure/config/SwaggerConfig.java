package com.snc.backend.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.tags.Tag;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI caseOpenAPI() {
        return new OpenAPI()
                .components(new Components())
                .info(new Info()
                        .title("Servicios Backend de SNC")
                        .description("Documentación detallada de los servicios y esquemas para los modulos de SNC")
                        .version("1.0.1"))
                .addTagsItem(new Tag().name("Administrador").description("Operaciones del modulo de administrador"));
    }
}