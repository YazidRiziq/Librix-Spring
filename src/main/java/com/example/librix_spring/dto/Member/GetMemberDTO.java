package com.example.librix_spring.dto.Member;

import java.time.LocalDate;

import com.example.librix_spring.model.MemberModel;

public class GetMemberDTO {
    
    private String memName;
    private String memEmail;
    private String memTelp;
    private String memAddress;
    private LocalDate regDate;

    public GetMemberDTO(String memName, String memEmail, String memTelp, String memAddress, LocalDate regDate) {
        this.memName = memName;
        this.memEmail = memEmail;
        this.memTelp = memTelp;
        this.memAddress = memAddress;
        this.regDate = regDate;
    }

    public static GetMemberDTO from(MemberModel m) {
        return new GetMemberDTO(
            m.getMemName(),
            m.getMemEmail(),
            m.getMemTelp(),
            m.getMemAddress(),
            m.getRegDate()
        );
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

    public LocalDate getRegDate() {
        return regDate;
    }
}
