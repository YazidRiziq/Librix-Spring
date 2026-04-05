package com.example.librix_spring.security;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    // Inject filter yang baru kita buat
    @Bean
    public AuthTokenFilter authTokenFilter() {
        return new AuthTokenFilter();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .cors(cors -> cors.configurationSource(corsConfigurationSource()))
            
            // 1. Matikan CSRF karena API kita menggunakan Token JWT (bukan session cookies)
            .csrf(csrf -> csrf.disable()) 
            
            // 2. Set manajemen sesi menjadi STATELESS (server tidak menyimpan state login)
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) 
            
            // 3. Atur izin akses rute endpoint
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/auth/**", "/error").permitAll() // BUKA gembok untuk semua API di bawah /api/auth/
                .requestMatchers("/v3/api-docs/**", "/swagger-ui/**", "/swagger-ui.html").permitAll() // BUKA gembok untuk Swagger UI
                .anyRequest().authenticated() // Rute lainnya WAJIB bawa token
            );
        
        // PASANG SATPAM DI SINI:
        // Tambahkan filter JWT kita sebelum UsernamePasswordAuthenticationFilter (filter bawaan Spring)
        http.addFilterBefore(authTokenFilter(), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        
        // Izinkan semua origin untuk tahap development. 
        // Nanti saat rilis production, ganti dengan domain asli kamu (misal: https://kitaatur.com)
        configuration.setAllowedOriginPatterns(List.of("*")); 
        
        // Izinkan metode HTTP yang dibutuhkan
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS"));
        
        // Izinkan header yang penting, terutama Authorization untuk bawa token
        configuration.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type", "X-Requested-With"));
        
        // Izinkan frontend membaca header tertentu dari response kita
        configuration.setExposedHeaders(List.of("Authorization"));
        
        // Wajib true jika kamu mengirimkan kredensial (seperti cookies atau Authorization headers)
        configuration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        // Terapkan aturan ini ke seluruh endpoint API kita
        source.registerCorsConfiguration("/**", configuration); 
        return source;
    }
}
