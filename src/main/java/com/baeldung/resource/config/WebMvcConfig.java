package com.baeldung.resource.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableConfigurationProperties({WebCorsConfigProperties.class})
public class WebMvcConfig {

    private final WebCorsConfigProperties webCorsConfigProperties;


    public WebMvcConfig(WebCorsConfigProperties webConfigProperties) {
        this.webCorsConfigProperties = webConfigProperties;
    }

    @Bean
    public WebMvcConfigurer corsMappingConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                WebCorsConfigProperties cors = webCorsConfigProperties;
                registry.addMapping("/**")
                    .allowedOrigins(cors.getAllowedOrigins())
                    .allowedMethods(cors.getAllowedMethods())
                    .maxAge(cors.getMaxAge())
                    .allowedHeaders(cors.getAllowedHeaders())
                    .exposedHeaders(cors.getExposedHeaders());
            }
        };
    }

}