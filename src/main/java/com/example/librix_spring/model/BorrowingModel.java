package com.example.librix_spring.model;

public class BorrowingModel {
    
    private String loanCode;
    private String offID;
    private String memID;
    private String loanDate;
    private String returnDate;

    public BorrowingModel() {}

    public BorrowingModel(String loanCode, String offID, String memID, String loanDate, String returnDate) {
        this.loanCode = loanCode;
        this.offID = offID;
        this.memID = memID;
        this.loanDate = loanDate;
        this.returnDate = returnDate;
    }

    public String getLoanCode() {
        return loanCode;
    }

    public void setLoanCode(String loanCode) {
        this.loanCode = loanCode;
    }

    public String getOffID() {
        return offID;
    }

    public void setOffID(String offID) {
        this.offID = offID;
    }

    public String getMemID() {
        return memID;
    }

    public void setMemID(String memID) {
        this.memID = memID;
    }

    public String getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(String loanDate) {
        this.loanDate = loanDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

}
