package com.example.RoleAndUser.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ConfigWebAuthorization {
    @Bean
    public SecurityFilterChain configure(HttpSecurity http)
            throws Exception {
        http.formLogin(Customizer.withDefaults());
        http.csrf(csrf -> csrf.disable())
                .httpBasic(Customizer.withDefaults())
                .authorizeHttpRequests(httpRequests ->
                        httpRequests

                        .requestMatchers("admin/**").hasAuthority("ADMIN")

                );
        return http.build();
    }
}
