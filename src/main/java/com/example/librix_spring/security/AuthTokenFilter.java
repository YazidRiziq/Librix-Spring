package com.example.librix_spring.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.ArrayList;

@Component
public class AuthTokenFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtils jwtUtils;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        
        try {
            // 1. Ambil token dari header request
            String jwt = parseJwt(request);

            // 2. Jika token ada dan valid
            if (jwt != null && jwtUtils.validateToken(jwt)) {
                // Ambil email dari token
                String email = jwtUtils.getEmailFromToken(jwt);

                // Buat objek Authentication (Tanda pengenal resmi Spring Security)
                // Catatan: ArrayList kosong itu untuk "Roles/Authorities". Sementara kita kosongkan dulu.
                UsernamePasswordAuthenticationToken authentication = 
                        new UsernamePasswordAuthenticationToken(email, null, new ArrayList<>());
                
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                // 3. Simpan tanda pengenal ini ke Security Context (Biar Spring tahu siapa yang lagi login)
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        } catch (Exception e) {
            System.out.println("Gagal set user authentication: " + e.getMessage());
        }

        // Lanjutkan request ke controller tujuan
        filterChain.doFilter(request, response);
    }

    // Fungsi bantuan untuk mengambil token dari header "Authorization: Bearer <token>"
    private String parseJwt(HttpServletRequest request) {
        String headerAuth = request.getHeader("Authorization");

        if (StringUtils.hasText(headerAuth) && headerAuth.startsWith("Bearer ")) {
            return headerAuth.substring(7); // Potong kata "Bearer " untuk ambil token aslinya
        }
        return null;
    }
}
