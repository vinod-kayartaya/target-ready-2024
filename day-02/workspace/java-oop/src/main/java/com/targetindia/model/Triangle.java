package com.targetindia.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Triangle implements GeometricShape{
    private double base;
    private double height;

    @Override
    public double calculateArea() {
        return 0.5*base*height;
    }

    @Override
    public String getShapeName() {
        return "TRIANGLE";
    }
}
