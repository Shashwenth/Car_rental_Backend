package com.CarRental.Backend.Controllers;


import com.CarRental.Backend.Entities.Lease;
import com.CarRental.Backend.Repositories.LeaseJPA;
import com.CarRental.Backend.Service.CalculatePrice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lease")
public class LeaseData {

    @Autowired
    private LeaseJPA leaseJPA;

    @Autowired CalculatePrice calculatePrice;

    @PostMapping("/New")
    public ResponseEntity<Lease> AddToLease(@RequestBody Lease lease) {
        Lease newLease = leaseJPA.save(lease);
        calculatePrice.setDuration(lease.getDuration());
        calculatePrice.setInterestRate(lease.getInterestRate());
        calculatePrice.setUserId(lease.getUserId());
        calculatePrice.setCarId(lease.getCarId());
        System.out.println(calculatePrice.toString());
        System.out.println(calculatePrice.LeaseAmount());
        return ResponseEntity.ok(newLease);
    }



}
