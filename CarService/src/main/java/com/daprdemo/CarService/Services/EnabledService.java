package com.daprdemo.CarService.Services;

import org.springframework.stereotype.Service;

@Service
public class EnabledService {

    private boolean enabled = true;

    public synchronized boolean isEnabled(){
        return enabled;
    }

    public synchronized void setEnabled(boolean enabled){
        this.enabled=enabled;
    }

}
