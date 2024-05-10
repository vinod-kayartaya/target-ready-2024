package com.targetindia.entity;

import com.targetindia.model.Address;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.Date;
import java.util.Set;

@Data
@ToString(exclude = {"reportsTo", "customers"})
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @Column(name = "employee_id")
    private Integer employeeId;
    @Column(name = "last_name")
    private String lastname;
    @Column(name = "first_name")
    private String firstname;
    private String title;
    @Column(name = "title_of_courtesy")
    private String titleOfCourtesy;
    @Column(name = "hire_date")
    private Date hireDate;
    @Column(name = "birth_date")
    private Date birthDate;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "phone", column = @Column(name = "home_phone"))
    })
    private Address address;

    private String extension;
    private byte[] photo;
    private String notes;

    @Column(name = "reports_to")
    private Integer reportsTo;

//    @ManyToMany // (fetch = FetchType.EAGER)
//    @JoinTable(name = "orders",
//            joinColumns = {@JoinColumn(name = "employee_id")},
//            inverseJoinColumns = {@JoinColumn(name = "customer_id")})
//    private Set<Customer> customers;


    @OneToOne(mappedBy = "assignedTo", cascade = {CascadeType.ALL})
    private Laptop laptop;
}
