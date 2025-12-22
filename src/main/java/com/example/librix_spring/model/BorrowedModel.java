package com.example.librix_spring.model;

public class BorrowedModel {
    
    private String copyCode;
    private String loanCode;
    private String returnCond;
    private String actualReturnDate;
    private String overdueFine;

    public BorrowedModel() {}

    public BorrowedModel(String copyCode, String loanCode, String returnCond, String actualReturnDate, String overdueFine) {
        this.copyCode = copyCode;
        this.loanCode = loanCode;
        this.returnCond = returnCond;
        this.actualReturnDate = actualReturnDate;
        this.overdueFine = overdueFine;
    }

    public String getCopyCode() {
        return copyCode;
    }

    public void setCopyCode(String copyCode) {
        this.copyCode = copyCode;
    }

    public String getLoanCode() {
        return loanCode;
    }

    public void setLoanCode(String loanCode) {
        this.loanCode = loanCode;
    }

    public String getReturnCond() {
        return returnCond;
    }

    public void setReturnCond(String returnCond) {
        this.returnCond = returnCond;
    }

    public String getActualReturnDate() {
        return actualReturnDate;
    }

    public void setActualReturnDate(String actualReturnDate) {
        this.actualReturnDate = actualReturnDate;
    }

    public String getOverdueFine() {
        return overdueFine;
    }

    public void setOverdueFine(String overdueFine) {
        this.overdueFine = overdueFine;
    }

}
