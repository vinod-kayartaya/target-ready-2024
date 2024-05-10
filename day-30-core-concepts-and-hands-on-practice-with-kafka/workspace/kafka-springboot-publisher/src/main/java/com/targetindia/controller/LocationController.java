package com.targetindia.controller;

import com.targetindia.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/location")
@CrossOrigin
public class LocationController {

    @Autowired
    private LocationService service;

    @PostMapping
    public void handlePostLocation(@RequestBody Map<String, Object> body){
        System.out.println("Got this as request body: " + body);
        String location = "latitude=" + body.get("latitude");
        location += ", longitude=" + body.get("longitude");

        service.publishLocation(location);
    }

}
