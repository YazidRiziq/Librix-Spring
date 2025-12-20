package com.example.librix_spring.dto;

public class LoginResponseDTO {
    private String memID;
    private String memName;
    private String memEmail;

    public LoginResponseDTO(String memID, String memName, String memEmail) {
        this.memID = memID;
        this.memName = memName;
        this.memEmail = memEmail;
    }

    public String getMemID() {
        return memID;
    }

    public String getMemName() {
        return memName;
    }

    public String getMemEmail() {
        return memEmail;
    }
}
