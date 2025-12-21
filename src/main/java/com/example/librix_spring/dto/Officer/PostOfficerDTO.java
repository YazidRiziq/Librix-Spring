package com.example.librix_spring.dto.Officer;

public class PostOfficerDTO {
    
    private String offName;
    private String offEmail;
    private String offTelp;
    private String offPassword;

    public PostOfficerDTO(String offName, String offEmail, String offTelp, String offPassword) {
        this.offName = offName;
        this.offEmail = offEmail;
        this.offTelp = offTelp;
        this.offPassword = offPassword;
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

    public String getOffPassword() {
        return offPassword;
    }

}
