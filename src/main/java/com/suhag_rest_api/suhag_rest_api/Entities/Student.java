package com.suhag_rest_api.suhag_rest_api.Entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Student_Id")
    private int sId;

    @Column(name = "Student_Name")
    @NotBlank(message = "Please enter your name.")
    // @Size(min = 2, max = 20, message = "Name should between 3 to 20 character.")
    private String sName;

    @Column(name = "Student_Branch")
    @NotBlank(message = "Please enter your branch.")
    private String sBranch;

    @Column(name = "Student_Mark")
    @NotNull(message = "Please enter your mark.")
    @PositiveOrZero(message = "Enter your mark correctly.")
    private Double sMark;

    @Column(name = "Email")
    @NotBlank(message = "Please enter your email.")
    @Email(message = "enter a valid email")
    private String email;

    @Column(name = "Gender")
    @NotBlank(message = "Please enter your gender.")
    private String gender;

    @ManyToOne(cascade = CascadeType.REMOVE)
    private Address address;

    public Student() {
    }

    public Student(int sId, String sName, String sBranch, Double sMark, String email, String gender, Address address) {
        this.sId = sId;
        this.sName = sName;
        this.sBranch = sBranch;
        this.sMark = sMark;
        this.email = email;
        this.gender = gender;
        this.address = address;
    }

    public int getsId() {
        return sId;
    }

    public void setsId(int sId) {
        this.sId = sId;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        if (sName != null)
            this.sName = sName;
    }

    public String getsBranch() {
        return sBranch;
    }

    public void setsBranch(String sBranch) {
        if (sBranch != null)
            this.sBranch = sBranch;
    }

    public Double getsMark() {
        return sMark;
    }

    public void setsMark(Double sMark) {
        if (sMark != null)
            this.sMark = sMark;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email != null)
            this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        if (gender != null)
            this.gender = gender;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        if (address != null)
            this.address = address;
    }

    @Override
    public String toString() {
        return "Student [sId=" + sId + ", sName=" + sName + ", sBranch=" + sBranch + ", sMark=" + sMark + ", email="
                + email + ", gender=" + gender + "]";
    }

}
