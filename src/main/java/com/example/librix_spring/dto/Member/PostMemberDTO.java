package com.example.librix_spring.dto.Member;

public class PostMemberDTO {
    
    private String memName;
    private String memEmail;
    private String memTelp;
    private String memAddress;
    private String memPassword;

    public PostMemberDTO(String memName, String memEmail, String memTelp, String memAddress, String memPassword) {
        this.memName = memName;
        this.memEmail = memEmail;
        this.memTelp = memTelp;
        this.memAddress = memAddress;
        this.memPassword = memPassword;
    }

    public String getMemName() {
        return memName;
    }

    public String getMemEmail() {
        return memEmail;
    }

    public String getMemTelp() {
        return memTelp;
    }

    public String getMemAddress() {
        return memAddress;
    }

    public String getMemPassword() {
        return memPassword;
    }

}
