package com.example.librix_spring.dto.login;

public class OfficerLoginResponseDTO {
    private String id;
    private String name;
    private String email;

    public OfficerLoginResponseDTO(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public String getOffID() {
        return id;
    }

    public String getOffName() {
        return name;
    }

    public String getOffEmail() {
        return email;
    }
}
