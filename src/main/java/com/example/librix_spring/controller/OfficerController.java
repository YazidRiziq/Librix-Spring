package com.example.librix_spring.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.librix_spring.model.OfficerModel;
import com.example.librix_spring.service.OfficerService;

import io.swagger.v3.oas.annotations.*;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Officer", description = "Officer CRUD API")
@RestController
@RequestMapping("/api/officers")
public class OfficerController {
    
    private final OfficerService officerService;

    public OfficerController(OfficerService officerService) {
        this.officerService = officerService;
    }

    @Operation(
        summary = "Get all officers",
        description = "Data ini tidak boleh bocor ke bagian UI"
    )
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
