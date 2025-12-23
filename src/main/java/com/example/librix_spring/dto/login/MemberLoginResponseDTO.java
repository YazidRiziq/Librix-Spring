package com.example.librix_spring.dto.login;

public class MemberLoginResponseDTO {
    private String id;
    private String name;
    private String email;

    public MemberLoginResponseDTO(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public String getMemID() {
        return id;
    }

    public String getMemName() {
        return name;
    }

    public String getMemEmail() {
        return email;
    }
}
