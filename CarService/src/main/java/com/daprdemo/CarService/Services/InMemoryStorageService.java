package com.daprdemo.CarService.Services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;

@Service
public class InMemoryStorageService {

    Logger logger = LoggerFactory.getLogger(InMemoryStorageService.class);

    private boolean enabled = true;
    private Instant startTime;
    private int counter=0;


    public boolean invoke(){
        counter++;
        if(counter==1){
            startTime = Instant.now();
            return false;
        }

        logger.info("This is call number " + counter +" and it has been " + Duration.between(startTime, Instant.now()).toSeconds() + " seconds since the first call");

        if(counter==5){
            counter=0;
            return true;
        }
        return false;


    }

    public synchronized boolean isEnabled(){
        return enabled;
    }

    public synchronized void setEnabled(boolean enabled){
        this.enabled=enabled;
    }

}
