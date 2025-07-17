package com.RestfulApi.TeacherInformationSystem.config;
/* 
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.config.Customizer;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .authorizeHttpRequests(auth -> auth
                .anyRequest().permitAll() // Tüm endpointler public
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
*/