package com.example.librix_spring.dto.login;

public class OfficerLoginRequestDTO {
    private String email;
    private String password;

    public OfficerLoginRequestDTO() {}

    public String getOffEmail() {
        return email;
    }

    public void setOffEmail(String email) {
        this.email = email;
    }

    public String getOffPassword() {
        return password;
    }

    public void setOffPassword(String password) {
        this.password = password;
    }
}
