package com.targetindia.entity;

import com.targetindia.model.Address;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString(exclude = {"products"})
@Entity
@Table(name = "suppliers")
public class Supplier {
    @Id
    @Column(name="supplier_id")
    private Integer supplierId;
    @Column(name="company_name")
    private String companyName;
    @Column(name="contact_name")
    private String contactName;
    @Column(name="contact_title")
    private String contactTitle;

    @Embedded
    private Address address;

    private String fax;
    @Column(name="home_page")
    private String homePage;

    @OneToMany
    @JoinColumn(name="supplier_id")
    private List<Product> products;
}
