package com.example.librix_spring.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.librix_spring.dto.LoginResponseDTO;
import com.example.librix_spring.model.MemberModel;
import com.example.librix_spring.repository.MemberRepository;

@Service
public class AuthService {
    
    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public AuthService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public LoginResponseDTO login(String email, String password) {

        MemberModel member = memberRepository.findByEmail(email);

        if (member == null) {
            throw new RuntimeException("User not found");
        }

        boolean match = passwordEncoder.matches(password, member.getMemPassword());

        if (!match) {
            throw new RuntimeException("Invalid credentials");
        }

        return new LoginResponseDTO(
            member.getMemID(),
            member.getMemName(),
            member.getMemEmail()
        );
        
    }
}
