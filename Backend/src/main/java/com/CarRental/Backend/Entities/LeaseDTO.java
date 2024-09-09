package com.CarRental.Backend.Entities;
public class LeaseDTO {

    private Double interestRate;

    private Long duration;

    private Double amount;

    private Long userID;

    private Long carId;  // Updated field name to follow camel case

    public LeaseDTO() {
    }

    public LeaseDTO(Double interestRate, Long duration, Double amount, Long userID, Long carId) {
        this.interestRate = interestRate;
        this.duration = duration;
        this.amount = amount;
        this.userID = userID;
        this.carId = carId;  // Updated
    }

    // Getters and Setters
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

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public Long getCarId() {  // Updated getter
        return carId;
    }

    public void setCarId(Long carId) {  // Updated setter
        this.carId = carId;
    }
}
