package com.jonathandiz.screen_match.config;

import org.springframework.context.annotation.Bean; 
import org.springframework.context.annotation.Configuration; 
import org.springframework.lang.NonNull; 
import org.springframework.web.servlet.config.annotation.CorsRegistry; 
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
  @Override public void addCorsMappings(@NonNull CorsRegistry registry) { 
    registry.addMapping("/**") 
            .allowedOrigins("http://127.0.0.1:5500") // Aquí puedes especificar las direcciones permitidas 
            .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") 
            .allowedHeaders("*") 
            .allowCredentials(true);
    }
}
