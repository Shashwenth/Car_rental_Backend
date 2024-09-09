package com.CarRental.Backend.Service;


import com.CarRental.Backend.Entities.CarModel;
import com.CarRental.Backend.Entities.Customer;
import com.CarRental.Backend.Entities.Lease;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

        return (((currentCar.get().getCarMileage()/12)*lease.getLeaseDuration())/currentCar.get().getCarNett())+(((lease.getLeaseInterestRate()/100)*currentCar.get().getCarNett())/12);

    }

    public void setCarUnAvailable(Lease lease){
        lease.getCarModel().setCarAvailable(false);
    }

    public void AddToCustomer(Lease lease){
        lease.getCustomer().getCustomerActiveLeaseSet().add(lease);
        lease.getCustomer().setCustomerCurrentActiveLeasesCount(lease.getCustomer().getCustomerCurrentActiveLeasesCount()+1);
    }

}
