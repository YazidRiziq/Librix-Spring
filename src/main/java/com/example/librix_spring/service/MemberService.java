package com.example.librix_spring.service;

import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

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

    public void createMember(MemberModel memberModel) {
        String hashPassword = passwordEncoder.encode(memberModel.getMemPassword());
        memberModel.setMemPassword(hashPassword);
        memberRepository.insertMember(memberModel);
    }

    public List<MemberModel> getAllMembers() {
        return memberRepository.findAllMembers();
    }

}
