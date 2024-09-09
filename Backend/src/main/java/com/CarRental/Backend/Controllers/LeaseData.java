package com.CarRental.Backend.Controllers;


import com.CarRental.Backend.Entities.CarModel;
import com.CarRental.Backend.Entities.Customer;
import com.CarRental.Backend.Entities.Lease;
import com.CarRental.Backend.Entities.LeaseDTO;
import com.CarRental.Backend.Repositories.CarModelJPA;
import com.CarRental.Backend.Repositories.CustomerJPA;
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

    @Autowired
    CustomerJPA customerJPA;

    @Autowired
    CarModelJPA carModelJPA;

    @PostMapping("/New")
    public ResponseEntity<Lease> AddToLease(@RequestBody LeaseDTO leaseDTO) {
        System.out.println("Inside New");
        System.out.println(leaseDTO.getUserID());
        System.out.println(leaseDTO.getCarId());
        System.out.println(leaseDTO.getAmount());
        System.out.println(leaseDTO.getDuration());
        Customer customer = customerJPA.findById(leaseDTO.getUserID()).orElseThrow(()-> new RuntimeException("User Not Found"));
        CarModel carModel= carModelJPA.findById(leaseDTO.getCarId()).orElseThrow(()->new RuntimeException("No car Found"));
        Lease lease=new Lease();
        System.out.println("Succesfully created lease");
        lease.setAmount(leaseDTO.getAmount());
        lease.setCarModel(carModel);
        lease.setCustomer(customer);
        lease.setDuration(leaseDTO.getDuration());
        lease.setInterestRate(leaseDTO.getInterestRate());
        System.out.println(lease.getCustomer());
        leaseJPA.save(lease);
        calculatePrice.setLease(lease);
        lease.setAmount(calculatePrice.LeaseAmount());
        //leaseJPA.save(lease);
        return ResponseEntity.ok(lease);
    }



}
