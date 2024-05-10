package com.targetindia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class LocationService {

    @Autowired
    KafkaTemplate<String, String> template;

    public void publishLocation(String location) {
        template.send("location-topic", location);
    }
}
