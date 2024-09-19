package com.CarRental.Backend.Controllers;


import com.CarRental.Backend.Entities.CarModel;
import com.CarRental.Backend.Entities.Customer;
import com.CarRental.Backend.Entities.Lease;
import com.CarRental.Backend.Entities.LeaseDTO;
import com.CarRental.Backend.Repositories.CarModelJPA;
import com.CarRental.Backend.Repositories.CustomerJPA;
import com.CarRental.Backend.Repositories.ExpiredLeaseJPA;
import com.CarRental.Backend.Repositories.LeaseJPA;
import com.CarRental.Backend.Service.CalculatePrice;
import com.CarRental.Backend.Service.HandleReturn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/lease")
public class LeaseData {

    private final LeaseJPA leaseJPA;
    private final CalculatePrice calculatePrice;
    private final CustomerJPA customerJPA;
    private final CarModelJPA carModelJPA;
    private final ExpiredLeaseJPA expiredLeaseJPA;


    public LeaseData(LeaseJPA leaseJPA,
                         CalculatePrice calculatePrice,
                         CustomerJPA customerJPA,
                         CarModelJPA carModelJPA,
                         ExpiredLeaseJPA expiredLeaseJPA) {
        this.leaseJPA = leaseJPA;
        this.calculatePrice = calculatePrice;
        this.customerJPA = customerJPA;
        this.carModelJPA = carModelJPA;
        this.expiredLeaseJPA = expiredLeaseJPA;
    }
    @PostMapping("/New")
    public ResponseEntity<Lease> AddToLease(@RequestBody LeaseDTO leaseDTO) {
        Customer customer = customerJPA.findById(leaseDTO.getUserID()).orElseThrow(()-> new RuntimeException("User Not Found"));
        CarModel carModel= carModelJPA.findById(leaseDTO.getCarId()).orElseThrow(()->new RuntimeException("No car Found"));
        Lease lease=new Lease();
        lease.setLeaseAmount(leaseDTO.getAmount());
        lease.setCarModel(carModel);
        lease.setCustomer(customer);
        lease.setLeaseDuration(leaseDTO.getDuration());
        lease.setLeaseInterestRate(leaseDTO.getInterestRate());
        leaseJPA.save(lease);
        calculatePrice.setLease(lease);
        lease.setLeaseAmount(calculatePrice.LeaseAmount());
        calculatePrice.AddToCustomer(lease);
        calculatePrice.setCarUnAvailable(lease);
        leaseJPA.save(lease);
        return ResponseEntity.ok(lease);
    }

    @GetMapping("/{id}")
    public Optional<Lease> getLease(@PathVariable Long id){
        return leaseJPA.findById(id);
    }

    @PostMapping("return/{id}")
    public String EndLease(@PathVariable Long id){
        HandleReturn handleReturn= new HandleReturn(leaseJPA,carModelJPA,customerJPA,expiredLeaseJPA);
        System.out.println("COnstructor Initialization OCmpleted");
        handleReturn.UpdateCustomer(leaseJPA.findById(id).get());
        handleReturn.UpdateCar(leaseJPA.findById(id).get());
        System.out.println("Updated Car");
        return "Successfully returned";
    }



}
