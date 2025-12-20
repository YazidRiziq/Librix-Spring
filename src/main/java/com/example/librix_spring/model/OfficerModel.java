package com.example.librix_spring.model;

public class OfficerModel {
    
    private String offID;
    private String offName;
    private String offEmail;
    private String offTelp;
    private String offPassword;

    public OfficerModel(String offName, String offEmail, String offTelp, String offPassword) {
        this.offName = offName;
        this.offEmail = offEmail;
        this.offTelp = offTelp;
        this.offPassword = offPassword;
    }

    public OfficerModel() {}

    public String getOffID() {
        return offID;
    }

    public void setOffID(String offID) {
        this.offID = offID;
    }

    public String getOffName() {
        return offName;
    }

    public void setOffName(String offName) {
        this.offName = offName;
    }

    public String getOffEmail() {
        return offEmail;
    }

    public void setOffEmail(String offEmail) {
        this.offEmail = offEmail;
    }

    public String getOffTelp() {
        return offTelp;
    }

    public void setOffTelp(String offTelp) {
        this.offTelp = offTelp;
    }

    public String getOffPassword() {
        return offPassword;
    }

    public void setOffPassword(String offPassword) {
        this.offPassword = offPassword;
    }

}
