package com.CarRental.Backend.Controllers;


import com.CarRental.Backend.Entities.Customer;
import com.CarRental.Backend.Repositories.CustomerJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/User")
public class UserData {

    @Autowired
    private  CustomerJPA CustomerRepository;

    @PostMapping("signUp")
    public ResponseEntity<Customer> addUser(@RequestBody Customer customer){
        Customer NewUser=CustomerRepository.save(customer);
        return  ResponseEntity.ok(NewUser);
    }

    @GetMapping("/{id}")
    public Customer GetUser(@PathVariable Long id){
        return CustomerRepository.findByCustomerId(id);
    }

}
