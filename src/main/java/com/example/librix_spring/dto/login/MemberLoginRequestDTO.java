package com.example.librix_spring.dto.login;

public class MemberLoginRequestDTO {
    private String email;
    private String password;

    public MemberLoginRequestDTO() {}

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
