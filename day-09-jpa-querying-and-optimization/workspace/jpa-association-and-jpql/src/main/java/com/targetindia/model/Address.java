package com.targetindia.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class Address {
    private String address;
    private String city;
    private String region;
    @Column(name="postal_code")
    private String postalCode;
    private String country;
    private String phone;
}
