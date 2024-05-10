package com.targetindia.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="shippers")
public class Shipper {
    @Id
    @Column(name="shipper_id")
    private Integer id;
    @Column(name="company_name")
    private String companyName;
    private String phone;
}
