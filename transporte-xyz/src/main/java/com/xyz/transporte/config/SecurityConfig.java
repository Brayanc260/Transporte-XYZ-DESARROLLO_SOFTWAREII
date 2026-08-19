package com.xyz.transporte.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .authorizeHttpRequests(auth -> auth

                .requestMatchers("/h2-console/**").authenticated()

                
                .requestMatchers(org.springframework.http.HttpMethod.POST, "/api/camiones/**").hasRole("ADMIN")
                .requestMatchers(org.springframework.http.HttpMethod.GET, "/api/camiones/**").hasAnyRole("ADMIN", "SUPERVISOR")

                
                .requestMatchers(org.springframework.http.HttpMethod.POST, "/api/conductores/**").hasRole("ADMIN")
                .requestMatchers(org.springframework.http.HttpMethod.GET, "/api/conductores/**").hasAnyRole("ADMIN", "SUPERVISOR")

                
                .requestMatchers("/api/asociaciones/**").hasAnyRole("ADMIN", "SUPERVISOR")

                
                .anyRequest().authenticated()
            )
            .httpBasic(basic -> {})
            .headers(headers -> headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::sameOrigin));

        return http.build();
    }
}
