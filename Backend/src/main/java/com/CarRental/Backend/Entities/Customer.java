package com.CarRental.Backend.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="customerId")
    private  Long customerId;
    private String customerName;
    private String customerStreet1;
    private String customerStreet2;
    private  String customerCity;
    private String customerState;
    private  String customerCountry;
    private String customerZipCode;
    private String customerEmail;
    private String customerpassword;
    private Integer customerCurrentActiveLeasesCount =0;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @JsonManagedReference("customerModelReference")
    private Set<Lease> customerActiveLeaseSet = new HashSet<>();


    public Set<Lease> getCustomerActiveLeaseSet() {
        return customerActiveLeaseSet;
    }


    public void setCustomerActiveLeaseSet(HashSet<Lease> customerActiveLeaseSet) {
        this.customerActiveLeaseSet = customerActiveLeaseSet;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + customerId +
                ", Name='" + customerName + '\'' +
                ", Street1='" + customerStreet1 + '\'' +
                ", Street2='" + customerStreet2 + '\'' +
                ", City='" + customerCity + '\'' +
                ", State='" + customerState + '\'' +
                ", Country='" + customerCountry + '\'' +
                ", ZipCode='" + customerZipCode + '\'' +
                ", Email='" + customerEmail + '\'' +
                ", password='" + customerpassword + '\'' +
                '}';
    }

    public Integer getCustomerCurrentActiveLeasesCount() {
        return customerCurrentActiveLeasesCount;
    }

    public void setCustomerCurrentActiveLeasesCount(Integer customerCurrentActiveLeasesCount) {
        this.customerCurrentActiveLeasesCount = customerCurrentActiveLeasesCount;
    }

    public Customer(Long customerId, String customerName, String customerStreet1, String street2, String customerCity, String customerState, String customerCountry, String customerZipCode, String customerEmail, String customerpassword, Integer count) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerStreet1 = customerStreet1;
        customerStreet2 = street2;
        this.customerCity = customerCity;
        this.customerState = customerState;
        this.customerCountry = customerCountry;
        this.customerZipCode = customerZipCode;
        this.customerEmail = customerEmail;
        this.customerpassword = customerpassword;
        customerCurrentActiveLeasesCount =count;
    }

    public Customer() {
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerStreet1() {
        return customerStreet1;
    }

    public void setCustomerStreet1(String customerStreet1) {
        this.customerStreet1 = customerStreet1;
    }

    public String getCustomerStreet2() {
        return customerStreet2;
    }

    public void setCustomerStreet2(String customerStreet2) {
        this.customerStreet2 = customerStreet2;
    }

    public String getCustomerCity() {
        return customerCity;
    }

    public void setCustomerCity(String customerCity) {
        this.customerCity = customerCity;
    }

    public String getCustomerState() {
        return customerState;
    }

    public void setCustomerState(String customerState) {
        this.customerState = customerState;
    }

    public String getCustomerCountry() {
        return customerCountry;
    }

    public void setCustomerCountry(String customerCountry) {
        this.customerCountry = customerCountry;
    }

    public String getCustomerZipCode() {
        return customerZipCode;
    }

    public void setCustomerZipCode(String customerZipCode) {
        this.customerZipCode = customerZipCode;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerpassword() {
        return customerpassword;
    }

    public void setCustomerpassword(String customerpassword) {
        this.customerpassword = customerpassword;
    }
}
