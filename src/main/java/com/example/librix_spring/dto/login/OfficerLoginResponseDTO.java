package com.example.librix_spring.dto.login;

public class OfficerLoginResponseDTO {
    private String id;
    private String name;
    private String email;
    private String token;

    public OfficerLoginResponseDTO(String id, String name, String email, String token) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
