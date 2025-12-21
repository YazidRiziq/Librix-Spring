package com.example.librix_spring.dto.Member;

public class PutMemberDTO {
    
    private String memName;
    private String memEmail;
    private String memTelp;
    private String memAddress;

    public PutMemberDTO(String memName, String memEmail, String memTelp, String memAddress) {
        this.memName = memName;
        this.memEmail = memEmail;
        this.memTelp = memTelp;
        this.memAddress = memAddress;
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

}
