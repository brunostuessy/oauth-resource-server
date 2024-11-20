package com.baeldung.resource.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.cors(c -> c.configurationSource(corsConfigurationSource()))
            .csrf(AbstractHttpConfigurer::disable)
            .authorizeHttpRequests(auth -> auth
                //.requestMatchers("/error/**").permitAll();
                //.requestMatchers("/api/auth/**").permitAll();
                .requestMatchers("/user/info", "/api/foos/**").hasAuthority("SCOPE_read")
                .requestMatchers("/api/foos").hasAuthority("SCOPE_write")
                .anyRequest().authenticated()
            )
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .oauth2ResourceServer((oauth2) -> oauth2.jwt(Customizer.withDefaults()));
        return http.build();
    }

    @Bean
    public WebCorsConfigProperties webCorsConfigProperties() {
        return new WebCorsConfigProperties();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        WebCorsConfigProperties cors = webCorsConfigProperties();

        CorsConfiguration configuration = new CorsConfiguration();

        //configuration.setAllowedOriginPatterns(Arrays.asList(cors.getAllowedOrigins()));
        configuration.setAllowedOrigins(Arrays.asList(cors.getAllowedOrigins()));
        configuration.setAllowedMethods(Arrays.asList(cors.getAllowedMethods()));
        configuration.setMaxAge(cors.getMaxAge());
        configuration.setAllowedHeaders(Arrays.asList(cors.getAllowedHeaders()));
        configuration.setExposedHeaders(Arrays.asList(cors.getExposedHeaders()));

        configuration.setAllowCredentials(true);
        //configuration.setAllowPrivateNetwork(false);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

        source.registerCorsConfiguration("/**", configuration);

        return source;
    }

}