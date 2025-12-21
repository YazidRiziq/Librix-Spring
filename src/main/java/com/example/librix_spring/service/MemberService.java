package com.example.librix_spring.service;

import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.librix_spring.dto.Member.GetMemberDTO;
import com.example.librix_spring.dto.Member.PostMemberDTO;
import com.example.librix_spring.dto.Member.PutMemberDTO;
import com.example.librix_spring.model.MemberModel;
import com.example.librix_spring.repository.MemberRepository;

@Service
public class MemberService {
    
    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public List<MemberModel> getAllMembers() {
        return memberRepository.findAllMembers();
    }

    public void createMember(PostMemberDTO dto) {
        String hashPassword = passwordEncoder.encode(dto.getMemPassword());
        MemberModel memberModel = new MemberModel(
            dto.getMemName(),
            dto.getMemEmail(),
            dto.getMemTelp(),
            dto.getMemAddress(),
            hashPassword
        );
        memberRepository.insertMember(memberModel);
    }

    public GetMemberDTO getMemberById(String memID) {
        MemberModel memberModel = memberRepository.findById(memID);
        if (memberModel == null) {
            throw new RuntimeException("Member not found with memID: " + memID);
        }
        return GetMemberDTO.from(memberModel);
    }

    public List<GetMemberDTO> getAllMembersDTO() {
        return memberRepository.findAllMembers()
            .stream()
            .map(GetMemberDTO::from)
            .toList();
    }

    public void updateMember(String memID, PutMemberDTO dto) {
        int updated = memberRepository.updateMember(memID, dto);
        if (updated == 0) {
            throw new RuntimeException("Member not found with memID: " + memID);
        }
    }

    public void deleteMember(String memID) {
        int deleted = memberRepository.deleteMember(memID);
        if (deleted == 0) {
            throw new RuntimeException("Member not found with memID: " + memID);
        }
    }
}
