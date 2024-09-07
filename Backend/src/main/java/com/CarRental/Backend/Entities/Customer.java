package com.CarRental.Backend.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;
    private String Name;
    private String Street1;
    private String Street2;
    private  String City;
    private String State;
    private  String Country;
    private String ZipCode;
    private String Email;
    private String password;
    private int Current_Leases;

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", Name='" + Name + '\'' +
                ", Street1='" + Street1 + '\'' +
                ", Street2='" + Street2 + '\'' +
                ", City='" + City + '\'' +
                ", State='" + State + '\'' +
                ", Country='" + Country + '\'' +
                ", ZipCode='" + ZipCode + '\'' +
                ", Email='" + Email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public int getCurrent_Leases() {
        return Current_Leases;
    }

    public void setCurrent_Leases(int current_Leases) {
        Current_Leases = current_Leases;
    }

    public Customer(Long id, String name, String street1, String street2, String city, String state, String country, String zipCode, String email, String password, int count) {
        this.id = id;
        Name = name;
        Street1 = street1;
        Street2 = street2;
        City = city;
        State = state;
        Country = country;
        ZipCode = zipCode;
        Email = email;
        this.password = password;
        Current_Leases=count;
    }

    public Customer() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getStreet1() {
        return Street1;
    }

    public void setStreet1(String street1) {
        Street1 = street1;
    }

    public String getStreet2() {
        return Street2;
    }

    public void setStreet2(String street2) {
        Street2 = street2;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getZipCode() {
        return ZipCode;
    }

    public void setZipCode(String zipCode) {
        ZipCode = zipCode;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
