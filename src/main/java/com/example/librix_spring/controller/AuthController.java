package com.example.librix_spring.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.librix_spring.dto.Member.PostMemberDTO;
import com.example.librix_spring.dto.login.MemberLoginRequestDTO;
import com.example.librix_spring.dto.login.MemberLoginResponseDTO;
import com.example.librix_spring.dto.login.OfficerLoginRequestDTO;
import com.example.librix_spring.dto.login.OfficerLoginResponseDTO;

import com.example.librix_spring.service.AuthService;
import com.example.librix_spring.service.MemberService;

import io.swagger.v3.oas.annotations.*;
import io.swagger.v3.oas.annotations.security.SecurityRequirements;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Authentication", description = "API Authentication Management")
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    
    private final AuthService authService;
    private final MemberService memberService;

    public AuthController(AuthService authService, MemberService memberService) {
        this.authService = authService;
        this.memberService = memberService;
    }

    @Operation(
        summary = "Member Login",
        description = "Endpoint untuk login Member"
    )
    @SecurityRequirements()
    @PostMapping("/login/member")
    public ResponseEntity<MemberLoginResponseDTO> loginMember(@RequestBody MemberLoginRequestDTO request) {
        MemberLoginResponseDTO response = authService.loginMember(request.getEmail(), request.getPassword());
        return ResponseEntity.ok(response);
    }

    @Operation(
        summary = "Member Register",
        description = "Endpoint untuk mendaftar sebagai Member"
    )
    @SecurityRequirements()
    @PostMapping("/register/member")
    public ResponseEntity<String> createMember(@RequestBody PostMemberDTO dto) {
        memberService.createMember(dto);
        return new ResponseEntity<>("Member created successfully", HttpStatus.CREATED);
    }


    // -----------------------
    // Officer Login Endpoint
    // -----------------------
    @Operation(
        summary = "Officer Login",
        description = "Endpoint untuk login Officer"
    )
    @SecurityRequirements()
    @PostMapping("/login/officer")
    public ResponseEntity<OfficerLoginResponseDTO> loginOfficer(@RequestBody OfficerLoginRequestDTO request) {
        OfficerLoginResponseDTO response = authService.loginOfficer(request.getEmail(), request.getPassword());
        return ResponseEntity.ok(response);
    }

}
