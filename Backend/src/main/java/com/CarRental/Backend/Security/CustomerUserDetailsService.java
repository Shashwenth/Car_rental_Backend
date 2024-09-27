package com.CarRental.Backend.Security;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.CarRental.Backend.Entities.Customer;
import com.CarRental.Backend.Repositories.CustomerJPA;

@Service
public class CustomerUserDetailsService implements UserDetailsService {

    private final CustomerJPA customerJPA;

    public CustomerUserDetailsService(CustomerJPA customerJPA) {
        this.customerJPA = customerJPA;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Customer> customerOptional = customerJPA.findBycustomerName(username);
        if (!customerOptional.isPresent()) {
            throw new UsernameNotFoundException("User Not Found");
        }

        Customer customer = customerOptional.get();

        return new User(
                customer.getCustomerName(),
                customer.getCustomerpassword(),
                Arrays.stream(new String[]{"ROLE_USER"}) 
                        .map(SimpleGrantedAuthority::new)
                        .collect(Collectors.toList())
        );
    }
}
