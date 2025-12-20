package com.example.librix_spring.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.librix_spring.model.OfficerModel;
import com.example.librix_spring.service.OfficerService;

@RestController
@RequestMapping("/api/officers")
public class OfficerController {
    
    private final OfficerService officerService;

    public OfficerController(OfficerService officerService) {
        this.officerService = officerService;
    }

    @GetMapping("/secret")
    public ResponseEntity<List<OfficerModel>> getAllOfficers() {
        return ResponseEntity.ok(officerService.getAllOfficers());
    }

    @PostMapping()
    public ResponseEntity<String> createOfficer(@RequestBody OfficerModel officerModel) {
        officerService.createOfficer(officerModel);
        return new ResponseEntity<>("Officer created successfully", HttpStatus.CREATED);
    }

}
