package com.daprdemo.CarService.Controller;

import com.daprdemo.CarService.Services.InMemoryStorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;


@RestController
public class CarController {

    Logger logger = LoggerFactory.getLogger(CarController.class);

    @Autowired
    InMemoryStorageService storageService;


    @GetMapping("/retryTest")
    public ResponseEntity<String> retryTest(){
        if(storageService.invoke()){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/car/{id}")
    public ResponseEntity<String> getCar(@PathVariable String id){
        logger.info("Car with id " + id + " has been requested");
        if(!storageService.isEnabled()) return ResponseEntity.badRequest().body("API is not enabled");
        return ResponseEntity.of(Optional.of("You have successfully requested a car with the id: " + id));
    }

    @GetMapping("/health")
    public ResponseEntity<String> getHealth(){
        if(!storageService.isEnabled()) return ResponseEntity.badRequest().body("Unhealthy");
        return ResponseEntity.ok().body("Healthy");
    }

    @PostMapping("/enabled/{enabled}")
    public String setEnabled(@PathVariable boolean enabled){
        storageService.setEnabled(enabled);
        return "Enabled set to "+ storageService.isEnabled();
    }
}
