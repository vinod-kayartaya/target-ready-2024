package com.targetindia.programs;

import com.targetindia.model.Circle;
import com.targetindia.model.GeometricShape;
import com.targetindia.model.Triangle;

public class InterfaceDemo {

    static void processGeometricShape(GeometricShape shape){
        System.out.printf("Name of the shape is %s\n", shape.getShapeName());
        System.out.printf("Area of this %s is %f Sq.units\n", shape.getShapeName(), shape.calculateArea());
    }

    public static void main(String[] args) {
        Circle c1 = new Circle(2.34);
        Triangle t1 = new Triangle(2.3, 4.5);

        processGeometricShape(c1);
        processGeometricShape(t1);
    }
}
