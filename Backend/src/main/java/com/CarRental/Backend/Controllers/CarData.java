package com.CarRental.Backend.Controllers;


import com.CarRental.Backend.Entities.CarModel;
import com.CarRental.Backend.Repositories.CarModelJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/Car")
public class CarData {

    @Autowired
    private CarModelJPA carRepository;

    @PostMapping(value = "/NewCar", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CarModel> addCar(@RequestBody CarModel carModel){
        CarModel newCar= carRepository.save(carModel);
        return  ResponseEntity.ok(newCar);
    }

    @GetMapping("/GetCar/{id}")
    public CarModel GetCar(@PathVariable Long id){
        return carRepository.findByCarId(id);
    }

}
