package com.example.librix_spring.service;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.librix_spring.dto.Officer.GetOfficerDTO;
import com.example.librix_spring.dto.Officer.PostOfficerDTO;
import com.example.librix_spring.dto.Officer.PutOfficerDTO;
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
    
    public List<OfficerModel> getAllOfficers() {
        return officerRepository.findAllOfficers();
    }

    public void createOfficer(PostOfficerDTO dto) {
        String hashPassword = passwordEncoder.encode(dto.getOffPassword());
        OfficerModel officerModel = new OfficerModel(
            dto.getOffName(),
            dto.getOffEmail(),
            dto.getOffTelp(),
            hashPassword
        );
        officerRepository.insertOfficer(officerModel);
    }

    public GetOfficerDTO getOfficerById(String offID) {
        OfficerModel officerModel = officerRepository.findById(offID);
        if (officerModel == null) {
            throw new RuntimeException("Officer not found with offID: " + offID);
        }
        return GetOfficerDTO.from(officerModel);
    }

    public List<GetOfficerDTO> getAllOfficersDTO() {
        return officerRepository.findAllOfficers()
            .stream()
            .map(GetOfficerDTO::from)
            .toList();
    }

    public void updateOfficer(String offID, PutOfficerDTO dto) {
        int updated = officerRepository.updateOfficer(offID, dto);
        if (updated == 0) {
            throw new RuntimeException("Officer not found with offID: " + offID);
        }
    }

    public void deleteOfficer(String offID) {
        int deleted = officerRepository.deleteOfficer(offID);
        if (deleted == 0) {
            throw new RuntimeException("Officer not found with offID: " + offID);
        }
    }

}
