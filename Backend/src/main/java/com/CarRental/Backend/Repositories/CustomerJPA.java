package com.CarRental.Backend.Repositories;

import com.CarRental.Backend.Entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerJPA extends JpaRepository<Customer, Long> {

    public Optional<Customer> findById(Long id);

}
