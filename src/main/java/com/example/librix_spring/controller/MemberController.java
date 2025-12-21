package com.example.librix_spring.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.librix_spring.dto.Member.GetMemberDTO;
import com.example.librix_spring.dto.Member.PutMemberDTO;
import com.example.librix_spring.model.MemberModel;
import com.example.librix_spring.service.MemberService;


@RestController
@RequestMapping("/api/members")
public class MemberController {
    
    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/secret")
    public ResponseEntity<List<MemberModel>> getAllMembers() {
        return ResponseEntity.ok(memberService.getAllMembers());
    }

    @GetMapping()
    public ResponseEntity<List<GetMemberDTO>> getAllMembersDTO() {
        return ResponseEntity.ok(memberService.getAllMembersDTO());
    }

    @PostMapping()
    public ResponseEntity<String> createMember(@RequestBody MemberModel memberModel) {
        memberService.createMember(memberModel);
        return new ResponseEntity<>("Member created successfully", HttpStatus.CREATED);
    }

    @PutMapping("/{memID}")
    public ResponseEntity<String> updateMember(
        @PathVariable String memID,
        @RequestBody PutMemberDTO dto
    ) {
        memberService.updateMember(memID, dto);
        return ResponseEntity.ok("Member updated successfully");
    }

    @DeleteMapping("/{memID}")
    public ResponseEntity<Void> deleteMember(@PathVariable("memID") String memID) {
        memberService.deleteMember(memID);
        return ResponseEntity.noContent().build();
    }
    
}
