package com.CarRental.Backend.Repositories;

import com.CarRental.Backend.Entities.Lease;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpiredLeaseJPA extends JpaRepository<Lease, Id> {

}
