package com.example.librix_spring.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.librix_spring.dto.Officer.GetOfficerDTO;
import com.example.librix_spring.dto.Officer.PostOfficerDTO;
import com.example.librix_spring.dto.Officer.PutOfficerDTO;
import com.example.librix_spring.model.OfficerModel;
import com.example.librix_spring.service.OfficerService;

import io.swagger.v3.oas.annotations.*;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Officer", description = "API Officer Management")
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

    @Operation(
        summary = "Get all officers",
        description = "Mengambil semua data officer tanpa password"
    )
    @GetMapping()
    public ResponseEntity<List<GetOfficerDTO>> getAllOfficerDTO() {
        return ResponseEntity.ok(officerService.getAllOfficersDTO());
    }

    @Operation(
        summary = "Get all Officers by ID",
        description = "Mengambil data Officer berdasarkan ID"
    )
    @GetMapping("/{offID}")
    public ResponseEntity<GetOfficerDTO> getOfficerById(@PathVariable String offID) {
        return ResponseEntity.ok(officerService.getOfficerById(offID));
    }
    
    @Operation(
        summary = "Post new Officer",
        description = "Digunakan untuk menambahkan data Officer baru"
    )
    @PostMapping()
    public ResponseEntity<String> createOfficer(@RequestBody PostOfficerDTO dto) {
        officerService.createOfficer(dto);
        return new ResponseEntity<>("Officer created successfully", HttpStatus.CREATED);
    }

    @Operation(
        summary = "Update Officer by ID",
        description = "Digunakan untuk mengubah data Officer berdasarkan ID"
    )
    @PutMapping("/{offID}")
    public ResponseEntity<String> updateOfficer(
        @PathVariable String offID,
        @RequestBody PutOfficerDTO dto
    ) {
        officerService.updateOfficer(offID, dto);
        return ResponseEntity.ok("Officer updated successfully");
    }

    @Operation(
        summary = "Delete Officer by ID",
        description = "Digunakan untuk menghapus data Officer berdasarkan ID"
    )
    @DeleteMapping("/{offID}")
    public ResponseEntity<Void> deleteOfficer(@PathVariable("offID") String offID) {
        officerService.deleteOfficer(offID);
        return ResponseEntity.noContent().build();
    }

}
