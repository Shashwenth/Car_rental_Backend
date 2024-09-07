package com.CarRental.Backend.Controllers;


import com.CarRental.Backend.Entities.Customer;
import com.CarRental.Backend.Repositories.CustomerJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
