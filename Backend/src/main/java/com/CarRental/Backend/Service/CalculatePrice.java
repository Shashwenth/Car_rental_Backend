package com.CarRental.Backend.Service;


import com.CarRental.Backend.Entities.CarModel;
import com.CarRental.Backend.Entities.Customer;
import com.CarRental.Backend.Repositories.CarModelJPA;
import com.CarRental.Backend.Repositories.CustomerJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class CalculatePrice {

    @Autowired
    private CarModelJPA carModelJPA;

    @Autowired
    private CustomerJPA customerJPA;



    private  Long userId;
    private Long carId;
    private Double InterestRate;
    private Long Duration;

    public CalculatePrice(){

    }

    public CalculatePrice(Long userId, Long carId, Double interestRate, Long duration) {
        this.userId = userId;
        this.carId = carId;
        InterestRate = interestRate;
        Duration=duration;
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
        return InterestRate;
    }

    public void setInterestRate(Double interestRate) {
        InterestRate = interestRate;
    }

    public Long getDuration() {
        return Duration;
    }

    public void setDuration(Long duration) {
        Duration = duration;
    }

    @Override
    public String toString() {
        return "CalculatePrice{" +
                "userId=" + userId +
                ", carId=" + carId +
                ", InterestRate=" + InterestRate +
                ", Duration=" + Duration +
                '}';
    }

    public Double LeaseAmount(){
        Optional<CarModel> currentCar=carModelJPA.findById(getCarId());
        Optional<Customer> currCustomer=customerJPA.findById(userId);

        return (((currentCar.get().getMileage()/12)*getDuration())/currentCar.get().getNett())+(((getInterestRate()/100)*currentCar.get().getNett())/12);

    }

}
