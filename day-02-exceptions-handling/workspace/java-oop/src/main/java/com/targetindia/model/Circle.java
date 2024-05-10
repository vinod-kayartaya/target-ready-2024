package com.targetindia.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Circle implements GeometricShape{
    private double radius;

    @Override
    public double calculateArea() {
        return PI*radius*radius;
    }

    @Override
    public String getShapeName() {
        return "CIRCLE";
    }
}
