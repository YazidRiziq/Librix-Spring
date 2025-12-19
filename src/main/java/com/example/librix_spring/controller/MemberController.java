package com.example.librix_spring.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.librix_spring.model.MemberModel;
import com.example.librix_spring.service.MemberService;


@RestController
@RequestMapping("/api/members")
public class MemberController {
    
    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping()   
    public ResponseEntity<List<MemberModel>> getAllMembers() {
        return ResponseEntity.ok(memberService.getAllMembers());
    }

    @PostMapping()
    public ResponseEntity<String> createMember(@RequestBody MemberModel memberModel) {
        memberService.createMember(memberModel);
        return new ResponseEntity<>("Member created successfully", HttpStatus.CREATED);
    }
    
}
