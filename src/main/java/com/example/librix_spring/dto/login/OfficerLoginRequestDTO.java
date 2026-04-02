package com.example.librix_spring.dto.login;

public class OfficerLoginRequestDTO {
    private String email;
    private String password;

    public OfficerLoginRequestDTO() {}

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
