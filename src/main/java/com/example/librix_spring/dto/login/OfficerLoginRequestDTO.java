package com.example.librix_spring.dto.login;

public class OfficerLoginRequestDTO {
    private String offEmail;
    private String offPassword;

    public OfficerLoginRequestDTO() {}

    public String getOffEmail() {
        return offEmail;
    }

    public void setOffEmail(String offEmail) {
        this.offEmail = offEmail;
    }

    public String getOffPassword() {
        return offPassword;
    }

    public void setOffPassword(String offPassword) {
        this.offPassword = offPassword;
    }
}
