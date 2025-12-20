package com.example.librix_spring.dto.login;

public class MemberLoginRequestDTO {
    private String memEmail;
    private String memPassword;

    public MemberLoginRequestDTO() {}

    public String getMemEmail() {
        return memEmail;
    }

    public void setMemEmail(String memEmail) {
        this.memEmail = memEmail;
    }

    public String getMemPassword() {
        return memPassword;
    }

    public void setMemPassword(String memPassword) {
        this.memPassword = memPassword;
    }
}
