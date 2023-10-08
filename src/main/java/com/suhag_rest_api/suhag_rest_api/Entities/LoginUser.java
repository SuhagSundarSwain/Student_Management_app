package com.suhag_rest_api.suhag_rest_api.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Login_Table")
public class LoginUser {

    @Id
    int sid;

    @Column(name = "Email")
    private String email;

    @Column(name = "password")
    private String password;

  

    public int getSid() {
        return sid;
    }



    public void setSid(int sid) {
        this.sid = sid;
    }



    public String getEmail() {
        return email;
    }



    public void setEmail(String email) {
        this.email = email;
    }



    public String getPassword() {
        return password;
    }



    public void setPassword(String password) {
        this.password = password;
    }



    @Override
    public String toString() {
        return "Login [email=" + email + ", password=" + password + "]";
    }

    

    
}
