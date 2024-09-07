package com.CarRental.Backend.Repositories;

import com.CarRental.Backend.Entities.Lease;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaseJPA extends JpaRepository<Lease, Long> {
}
