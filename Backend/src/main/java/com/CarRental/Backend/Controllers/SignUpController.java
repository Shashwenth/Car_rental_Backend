package com.CarRental.Backend.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CarRental.Backend.Entities.Customer;
import com.CarRental.Backend.Repositories.CustomerJPA;
import com.CarRental.Backend.Service.CustomerService;


@RestController
@RequestMapping("/formlogin")
public class SignUpController {
	
	@Autowired
    private  CustomerJPA CustomerRepository;
	
	@Autowired
	private CustomerService customerService;

    @PostMapping("/signUp")
    public ResponseEntity<String> addUser(@RequestBody Customer customer){
    	customerService.saveCustomer(customer);
    	return ResponseEntity.ok("Customer registered successfully");
    }
    
}
