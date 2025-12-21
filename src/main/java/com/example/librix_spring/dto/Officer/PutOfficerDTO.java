package com.example.librix_spring.dto.Officer;

public class PutOfficerDTO {
    
    private String offName;
    private String offEmail;
    private String offTelp;

    public PutOfficerDTO(String offName, String offEmail, String offTelp) {
        this.offName = offName;
        this.offEmail = offEmail;
        this.offTelp = offTelp;
    }

    public String getOffName() {
        return offName;
    }

    public String getOffEmail() {
        return offEmail;
    }

    public String getOffTelp() {
        return offTelp;
    }

}
