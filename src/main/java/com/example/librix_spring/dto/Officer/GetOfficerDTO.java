package com.example.librix_spring.dto.Officer;

import com.example.librix_spring.model.OfficerModel;

public class GetOfficerDTO {
    
    private String offID;
    private String offName;
    private String offEmail;

    public GetOfficerDTO(String offID, String offName, String offEmail) {
        this.offID = offID;
        this.offName = offName;
        this.offEmail = offEmail;
    }

    public static GetOfficerDTO from(OfficerModel m) {
        return new GetOfficerDTO(
            m.getOffID(),
            m.getOffName(),
            m.getOffEmail()
        );
    }

    public String getOffID() {
        return offID;
    }

    public String getOffName() {
        return offName;
    }

    public String getOffEmail() {
        return offEmail;
    }

}
