package com.targetindia.model;

import lombok.Data;

import java.util.Date;

@Data
public class Greeting {
    private String message;
    private Date timestamp = new Date();

    public Greeting(String message) {
        this.message = message;
    }
}
