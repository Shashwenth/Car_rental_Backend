package com.CarRental.Backend.Service;


import com.CarRental.Backend.Entities.CarModel;
import com.CarRental.Backend.Entities.Customer;
import com.CarRental.Backend.Entities.Lease;
import com.CarRental.Backend.Repositories.CarModelJPA;
import com.CarRental.Backend.Repositories.CustomerJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

import static io.micrometer.core.instrument.config.validate.PropertyValidator.getDuration;

@Service
public class CalculatePrice {


    private Lease lease;

    public CalculatePrice() {
    }

    public CalculatePrice(Lease lease) {
        this.lease = lease;
    }

    public Lease getLease() {
        return lease;
    }

    public void setLease(Lease lease) {
        this.lease = lease;
    }
    public Double LeaseAmount(){
        Optional<CarModel> currentCar= Optional.ofNullable(lease.getCarModel());
        Optional<Customer> currCustomer= Optional.ofNullable(lease.getCustomer());

        return (((currentCar.get().getMileage()/12)*lease.getDuration())/currentCar.get().getNett())+(((lease.getInterestRate()/100)*currentCar.get().getNett())/12);

    }

}
