package com.targetindia.miniproject.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="customers")
public class Customer {
    @Id
    @GeneratedValue(generator = "increment")
    private Integer id;
    private String name;
    private String city;
    private String email;
    private String phone;
}
