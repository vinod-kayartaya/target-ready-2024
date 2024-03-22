package com.targetindia.entity;

import com.targetindia.model.Address;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.Set;

@Data
@ToString(exclude = {"employees"})
@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @Column(name = "customer_id")
    private String customerId;
    @Column(name = "company_name")
    private String companyName;
    @Column(name = "contact_name")
    private String contactName;
    @Column(name = "contact_title")
    private String contactTitle;

    @Embedded
    private Address address;

    @Column
    private String fax;

    @ManyToMany
    @JoinTable(name = "orders", joinColumns = {
            @JoinColumn(name = "customer_id")
    }, inverseJoinColumns = {
            @JoinColumn(name = "employee_id")
    })
    private Set<Employee> employees;
}
