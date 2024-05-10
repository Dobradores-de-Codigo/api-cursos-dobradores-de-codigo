package com.example.cursos.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocOpenApiConfig {

    @Bean
    public OpenAPI openAPI(){
        return new OpenAPI()
                .info(
                        new Info()
                                .title("Rest API - Spring Curso")
                                .description("API para cadastrar cursos")
                                .version("v1")
                                .license(new License().name("Apache2.0").url("https://www.apache.org/licenses/LICENSE-2.0"))
                                .contact(new Contact().name("Vagner Ferreira").email("vagner.lima.pb@compasso.com.br"))
                                .contact(new Contact().name("Juliana Ransani").email("juliana.ransani.pb@compasso.com.br"))
                                .contact(new Contact().name("Jeferson Gomes").email("jeferson.gomes.pb@compasso.com.br"))
                );
    }
}