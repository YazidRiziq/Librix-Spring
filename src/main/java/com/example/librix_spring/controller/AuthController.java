package com.example.librix_spring.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.librix_spring.dto.MemberLoginRequestDTO;
import com.example.librix_spring.dto.MemberLoginResponseDTO;
import com.example.librix_spring.dto.OfficerLoginRequestDTO;
import com.example.librix_spring.dto.OfficerLoginResponseDTO;
import com.example.librix_spring.service.AuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login/member")
    public ResponseEntity<MemberLoginResponseDTO> loginMember(@RequestBody MemberLoginRequestDTO request) {
        MemberLoginResponseDTO response = authService.loginMember(request.getMemEmail(), request.getMemPassword());
        return ResponseEntity.ok(response);
    }

    @PostMapping("/login/officer")
    public ResponseEntity<OfficerLoginResponseDTO> loginOfficer(@RequestBody OfficerLoginRequestDTO request) {
        OfficerLoginResponseDTO response = authService.loginOfficer(request.getOffEmail(), request.getOffPassword());
        return ResponseEntity.ok(response);
    }

}
