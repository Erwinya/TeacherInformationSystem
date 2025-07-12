package com.RestfulApi.TeacherInformationSystem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.config.Customizer;
import org.springframework.http.HttpMethod;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .authorizeHttpRequests(auth -> auth
                // Swagger ve H2 Console erişimi açık
                .requestMatchers(
                    "/swagger-ui/**",
                    "/v3/api-docs/**",
                    "/swagger-resources/**",
                    "/h2-console/**"
                ).permitAll()
                // Public endpoint örneği
                .requestMatchers(HttpMethod.GET, "/api/teachers/**").permitAll()
                // Sadece ADMIN rolüne açık endpoint örneği
                .requestMatchers(HttpMethod.POST, "/api/managers/**").hasRole("ADMIN")
                // Diğer tüm istekler için kimlik doğrulama gerekir
                .anyRequest().authenticated()
            )
            .formLogin(login -> login.disable())
            .httpBasic(Customizer.withDefaults())
            // H2 Console için frame options devre dışı
            .headers(headers -> headers.frameOptions(frame -> frame.disable()))
            // CORS örneği (gerekirse açılabilir)
            .cors(Customizer.withDefaults());
        return http.build();
    }
}