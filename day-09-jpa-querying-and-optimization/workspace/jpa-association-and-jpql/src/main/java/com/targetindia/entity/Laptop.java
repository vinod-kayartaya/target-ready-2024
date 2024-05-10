package com.targetindia.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Data
@ToString(exclude = {"assignedTo"})
@Entity
@Table(name="laptops")
public class Laptop {
    @Id
//    @GeneratedValue(generator = "increment")
    @Column(name="laptop_id")
    private Integer laptopId;

    private String make;
    private String model;

    @ManyToOne
    @JoinColumn(name="employee_id", unique = true)
    private Employee assignedTo;
}
