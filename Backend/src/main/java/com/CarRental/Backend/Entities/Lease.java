package com.CarRental.Backend.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
public class Lease {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    private Double interestRate;

    private Long duration;

    private Double amount;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private CarModel carModel;


    @ManyToOne
    @JoinColumn(name="user_id")
    @JsonBackReference
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



    public Lease(Long id, Double interestRate, Long duration, Double amount) {
        this.id = id;
        this.interestRate = interestRate;
        this.duration = duration;
        this.amount = amount;
    }

    public Lease(){
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Double interestRate) {
        this.interestRate = interestRate;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
