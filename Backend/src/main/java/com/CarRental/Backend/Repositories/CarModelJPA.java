package com.CarRental.Backend.Repositories;

import com.CarRental.Backend.Entities.CarModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarModelJPA extends JpaRepository<CarModel, Long> {

    CarModel findByCarId(Long carId);

}
