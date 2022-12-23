package com.apigestionregion.springjwt.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CORSConfig {
    static private final String GET = "GET";
    static private final String POST = "POST";
    static private final String PUT = "PUT";
    static private final String DELETE = "DELETE";
    @Bean
    public WebMvcConfigurer corsConfigurer(){
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/api/auth/signin/**").allowedOrigins("http://localhost:4200",
                        "http://localhost:8100",
                        "http://localhost:8200")
                        .allowedMethods(POST, GET, PUT, DELETE)
                        .allowedHeaders("*");
            }
        };
    }
}
