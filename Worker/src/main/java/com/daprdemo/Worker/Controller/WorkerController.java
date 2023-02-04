package com.daprdemo.Worker.Controller;

import io.dapr.client.DaprClient;
import io.dapr.client.DaprClientBuilder;
import io.dapr.client.domain.HttpExtension;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WorkerController {


    @PostMapping("/start/work/{quantity}")
    public String startWorking(@PathVariable int quantity){

        for(int i=0; i<quantity; i++){
            DaprClient daprClient = new DaprClientBuilder().build();
            byte[] result = daprClient.invokeMethod("carservice", "car/"+i%10, null, HttpExtension.GET, byte[].class).block();
            System.out.println("result is "+ String.valueOf(result));
        }
        return "successfully created " + quantity + " requests";
    }
}
