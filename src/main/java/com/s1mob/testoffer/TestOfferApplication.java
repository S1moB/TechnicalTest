package com.s1mob.testoffer;


import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication

public class TestOfferApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestOfferApplication.class, args);
    }

    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Offer technical test")
                        .description("Offer technical test solution")
                        .version("v1.0.0"))
                .externalDocs(new ExternalDocumentation()
                        .description("The solution code")
                        .url("https://github.com/s1mob"));
    }

}
