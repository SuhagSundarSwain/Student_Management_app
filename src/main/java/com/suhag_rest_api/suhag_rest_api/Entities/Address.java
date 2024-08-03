package com.suhag_rest_api.suhag_rest_api.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "Address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int addressId;

    @Column(name = "address")
    @NotBlank()
    private String address;

    @Column(name = "city")
    @NotBlank()
    private String city;

    @Column(name = "state")
    @NotBlank
    private String state;

    public Address() {
    }

    public Address(int addressId, String address, String city, String state) {
        this.addressId = addressId;
        this.address = address;
        this.city = city;
        this.state = state;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String adress) {
        this.address = adress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Adress [addressId=" + addressId + ", adress=" + address + ", city=" + city + ", state=" + state
                + ", toString()=" + super.toString() + "]";
    }

}
