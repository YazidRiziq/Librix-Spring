package com.example.librix_spring.dto;

public class OfficerLoginResponseDTO {
    private String offID;
    private String offName;
    private String offEmail;

    public OfficerLoginResponseDTO(String offID, String offName, String offEmail) {
        this.offID = offID;
        this.offName = offName;
        this.offEmail = offEmail;
    }
    
    public String getOffID() {
        return offID;
    }

    public String getOffName() {
        return offName;
    }

    public String getOffEmail() {
        return offEmail;
    }
}
