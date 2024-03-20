package com.targetindia.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Data
@ToString(exclude = {"category"})
@Entity
@Table(name="products")
public class Product {
    @Id
    @Column(name="product_id")
    private Integer productId;
    @Column(name="product_name")
    private String productName;
    @Column(name="supplier_id")
    private Integer supplierId;

    @Column(name="category_id")
    private Integer categoryId;

    @ManyToOne // for ManyToOne default is FetchType.EAGER
    @JoinColumn(name="category_id", insertable = false, updatable = false)
    private Category category;


    @Column(name="quantity_per_unit")
    private String quantityPerUnit;
    @Column(name="unit_price")
    private Double unitPrice;
    @Column(name="units_in_stock")
    private Integer unitsInStock;
    @Column(name="units_on_order")
    private Integer unitsOnOrder;
    @Column(name="reorder_level")
    private Integer reorderLevel;
    //@Column // this is optional; since the name of the column matches the name of the property
    private Boolean discontinued;
}
