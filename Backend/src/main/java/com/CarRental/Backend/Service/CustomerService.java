package com.CarRental.Backend.Service;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.CarRental.Backend.Entities.Customer;
import com.CarRental.Backend.Repositories.CustomerJPA;

@Service
public class CustomerService {

    private final CustomerJPA customerJPA;
    private final PasswordEncoder passwordEncoder;

    public CustomerService(CustomerJPA customerJPA, PasswordEncoder passwordEncoder) {
        this.customerJPA = customerJPA;
        this.passwordEncoder = passwordEncoder;
    }

    public void saveCustomer(Customer customer) {
        String encodedPassword = passwordEncoder.encode(customer.getCustomerpassword());
        customer.setCustomerpassword(encodedPassword);
        customerJPA.save(customer);
    }
}
