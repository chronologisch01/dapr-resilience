package com.daprdemo.CarService.Controller;

import com.daprdemo.CarService.Services.EnabledService;
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
    EnabledService enabledService;


    @GetMapping("/car/{id}")
    public ResponseEntity<String> getCar(@PathVariable String id){
        logger.info("This is a log for id "+ id);
        System.out.println("enabled is "+ enabledService.isEnabled()+ " and request id is " + id);
        if(!enabledService.isEnabled()) return ResponseEntity.badRequest().body("API is not enabled");
        return ResponseEntity.of(Optional.of("You have successfully requested a car with the id: " + id));
    }

    @GetMapping("/health")
    public ResponseEntity<String> getHealth(){
        return getCar("1");
    }

    @PostMapping("/enabled/{enabled}")
    public String setEnabled(@PathVariable boolean enabled){
        enabledService.setEnabled(enabled);
        return "Enabled set to "+ enabledService.isEnabled();
    }
}
