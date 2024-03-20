package com.targetindia.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString(exclude = {"products"})
@Entity
@Table(name="categories")
public class Category {
    @Id
    @Column(name="category_id")
    private Integer categoryId;
    @Column(name="category_name")
    private String categoryName;
    @Column(name="description")
    private String description;
    @Column(name="picture")
    private byte[] picture;

    @OneToMany // (fetch = FetchType.EAGER) // default is FetchType.LAZY
    @JoinColumn(name="category_id") // this refers to the foreign key in the products table
    private List<Product> products;
}
