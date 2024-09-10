package com.CarRental.Backend.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class Lease {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long leaseId;

    private Double leaseInterestRate;

    private Long leaseDuration;

    private Double leaseAmount;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "carId")
    @JsonBackReference("CarModelReference")
    private CarModel carModel;


    @ManyToOne
    @JoinColumn(name="customerId")
    @JsonBackReference("customerModelReference")
    private Customer customer;


    public CarModel getCarModel() {
        return carModel;
    }

    public void setCarModel(CarModel carModel) {
        this.carModel = carModel;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }



    public Lease(Long leaseId, Double leaseInterestRate, Long leaseDuration, Double amount) {
        this.leaseId = leaseId;
        this.leaseInterestRate = leaseInterestRate;
        this.leaseDuration = leaseDuration;
        this.leaseAmount = amount;
    }

    public Lease(){
        super();
    }

    public Long getLeaseId() {
        return leaseId;
    }

    public void setLeaseId(Long leaseId) {
        this.leaseId = leaseId;
    }
    public Double getLeaseInterestRate() {
        return leaseInterestRate;
    }

    public void setLeaseInterestRate(Double leaseInterestRate) {
        this.leaseInterestRate = leaseInterestRate;
    }

    public Long getLeaseDuration() {
        return leaseDuration;
    }

    public void setLeaseDuration(Long leaseDuration) {
        this.leaseDuration = leaseDuration;
    }

    public Double getLeaseAmount() {
        return leaseAmount;
    }

    public void setLeaseAmount(Double leaseAmount) {
        this.leaseAmount = leaseAmount;
    }
}
