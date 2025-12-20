package com.example.librix_spring.service;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.librix_spring.model.OfficerModel;
import com.example.librix_spring.repository.OfficerRepository;

@Service
public class OfficerService {
    
    private final OfficerRepository officerRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public OfficerService(OfficerRepository officerRepository) {
        this.officerRepository = officerRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public void createOfficer(OfficerModel officerModel) {
        String hashPassword = passwordEncoder.encode(officerModel.getOffPassword());
        officerModel.setOffPassword(hashPassword);
        officerRepository.insertOfficer(officerModel);
    }

    public List<OfficerModel> getAllOfficers() {
        return officerRepository.findAllOfficers();
    }

}
