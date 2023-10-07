package com.suhag_rest_api.suhag_rest_api.StudentClass;

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

    public Student() {
    }
    public Student(int sId, String sName, String sBranch, double sMark) {
        this.sId = sId;
        this.sName = sName;
        this.sBranch = sBranch;
        this.sMark = sMark;
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

    @Override
    public String toString() {
        return "Student [sid=" + sId + ", sName=" + sName + ", sBranch=" + sBranch + ", sMark=" + sMark + "]";
    }

    
    
    
}
