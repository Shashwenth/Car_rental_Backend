package com.CarRental.Backend.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CarRental.Backend.Entities.Customer;
import com.CarRental.Backend.Repositories.CustomerJPA;
import com.CarRental.Backend.Service.CustomerService;

@RestController
@RequestMapping("/User")
public class UserData {
	
	@Autowired
    private  CustomerJPA CustomerRepository;
	
	

    @GetMapping("/{id}")
    public Customer GetUser(@PathVariable Long id){
        return CustomerRepository.findByCustomerId(id);
    }

    @PutMapping("/{id}")
    public Customer UpdateUser(@RequestBody Customer customer){
        Customer existingCustomer= CustomerRepository.findByCustomerId(customer.getCustomerId());
        // Finish the fields! Check is the fields are valid.
        return existingCustomer;
    }



}
