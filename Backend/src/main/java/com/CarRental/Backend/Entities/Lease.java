package com.CarRental.Backend.Entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Lease {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    private Long userId;

    private Long carId;

    private Double interestRate;

    private Long duration;

    private Long amount;

    public Lease(Long id, Long userId, Long carId, Double interestRate, Long duration, Long amount) {
        this.id = id;
        this.userId = userId;
        this.carId = carId;
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
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

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }
}
