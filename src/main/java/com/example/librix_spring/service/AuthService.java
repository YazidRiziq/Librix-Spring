package com.example.librix_spring.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.librix_spring.dto.login.MemberLoginResponseDTO;
import com.example.librix_spring.dto.login.OfficerLoginResponseDTO;
import com.example.librix_spring.model.MemberModel;
import com.example.librix_spring.model.OfficerModel;
import com.example.librix_spring.repository.MemberRepository;
import com.example.librix_spring.repository.OfficerRepository;
import com.example.librix_spring.security.JwtUtils;

@Service
public class AuthService {
    
    private final MemberRepository memberRepository;
    private final OfficerRepository officerRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final JwtUtils jwtUtils;

    public AuthService(MemberRepository memberRepository, OfficerRepository officerRepository, JwtUtils jwtUtils) {
        this.memberRepository = memberRepository;
        this.officerRepository = officerRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
        this.jwtUtils = jwtUtils;
    }

    public MemberLoginResponseDTO loginMember(String email, String password) {
        MemberModel member = memberRepository.findByEmail(email);

        if (member == null) {
            throw new RuntimeException("User not found");
        }

        boolean match = passwordEncoder.matches(password, member.getMemPassword());

        if (!match) {
            throw new RuntimeException("Invalid credentials");
        }

        String token = jwtUtils.generateToken(email);

        return new MemberLoginResponseDTO(
            member.getMemID(),
            member.getMemName(),
            member.getMemEmail(),
            token
        );   
    }

    public OfficerLoginResponseDTO loginOfficer(String email, String password) {
        OfficerModel officer = officerRepository.findByEmail(email);

        if (officer == null) {
            throw new RuntimeException("Officer not found");
        }

        boolean match = passwordEncoder.matches(password, officer.getOffPassword());

        if (!match) {
            throw new RuntimeException("Invalid credentials");
        }

        String token = jwtUtils.generateToken(email);

        return new OfficerLoginResponseDTO(
            officer.getOffID(),
            officer.getOffName(),
            officer.getOffEmail(),
            token
        );   
    }

}