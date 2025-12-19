package com.example.librix_spring.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

public class MemberModel {

    private String memID;
    private String memName;
    private String memEmail;
    private String memTelp;
    private String memAddress;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate regDate;
    private String memPassword;

    public MemberModel() {}

    public MemberModel(String memName, String memEmail, String memTelp, String memAddress, String memPassword) {
        this.memName = memName;
        this.memEmail = memEmail;
        this.memTelp = memTelp;
        this.memAddress = memAddress;
        this.memPassword = memPassword;
    }

    public String getMemID() {
        return memID;
    }

    public void setMemID(String memID) {
        this.memID = memID;
    }

    public String getMemName() {
        return memName;
    }

    public void setMemName(String memName) {
        this.memName = memName;
    }

    public String getMemEmail() {
        return memEmail;
    }

    public void setMemEmail(String memEmail) {
        this.memEmail = memEmail;
    }

    public String getMemTelp() {
        return memTelp;
    }

    public void setMemTelp(String memTelp) {
        this.memTelp = memTelp;
    }

    public String getMemAddress() {
        return memAddress;
    }

    public void setMemAddress(String memAddress) {
        this.memAddress = memAddress;
    }

    public LocalDate getRegDate() {
        return regDate;
    }

    public void setRegDate(LocalDate regDate) {
        this.regDate = regDate;
    }

    public String getMemPassword() {
        return memPassword;
    }

    public void setMemPassword(String memPassword) {
        this.memPassword = memPassword;
    }

}
