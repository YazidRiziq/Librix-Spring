package com.example.librix_spring.dto.login;

public class MemberLoginRequestDTO {
    private String email;
    private String password;

    public MemberLoginRequestDTO() {}

    public String getMemEmail() {
        return email;
    }

    public void setMemEmail(String email) {
        this.email = email;
    }

    public String getMemPassword() {
        return password;
    }

    public void setMemPassword(String password) {
        this.password = password;
    }
}
