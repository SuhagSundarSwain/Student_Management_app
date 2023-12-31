package com.suhag_rest_api.suhag_rest_api.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Student_Id")
    private int sId;

    @Column(name="Student_Name")
    private String sName;
    @Column(name="Student_Branch")
    private String sBranch;
    @Column(name="Student_Mark")
    private double sMark;
    @Column(name="Email")
    private String email;
    @Column(name="Gender")
    private String gender;


    public Student() {
    }
    

    public Student(int sId, String sName, String sBranch, double sMark, String email, String gender) {
        this.sId = sId;
        this.sName = sName;
        this.sBranch = sBranch;
        this.sMark = sMark;
        this.email = email;
        this.gender = gender;
    }


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
    public void setsId(int sid) {
        this.sId = sid;
    }
    public void setsName(String sName) {
        this.sName = sName;
    }
    public void setsBranch(String sBranch) {
        this.sBranch = sBranch;
    }
    public void setsMark(double sMark) {
        this.sMark = sMark;
    }
    public String getEmail() {
        return email;
    }
    public String getGender() {
        return gender;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    @Override
    public String toString() {
        return "Student [sId=" + sId + ", sName=" + sName + ", sBranch=" + sBranch + ", sMark=" + sMark + ", email="
                + email + ", gender=" + gender + "]";
    }


    

    
    
    
}
