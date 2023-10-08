package com.suhag_rest_api.suhag_rest_api.Entities;




public class SignUpStudent {
    
    private int sId;
    private String sName;
    private String sBranch;
    private double sMark;
    private String sEmail;
    private String sGender;
    private String password;

    public int getsId() {
        return sId;
    }
    public String getsName() {
        return sName;
    }
    public String getsBranch() {
        return sBranch;
    }
    public double getsMark() {
        return sMark;
    }
    public String getsEmail() {
        return sEmail;
    }
    public String getsGender() {
        return sGender;
    }
    public String getPassword() {
        return password;
    }
    @Override
    public String toString() {
        return "SignUpStudent [sId=" + sId + ", sName=" + sName + ", sBranch=" + sBranch + ", sMark=" + sMark
                + ", sEmail=" + sEmail + ", sGender=" + sGender + ", password=" + password + "]";
    }



}
