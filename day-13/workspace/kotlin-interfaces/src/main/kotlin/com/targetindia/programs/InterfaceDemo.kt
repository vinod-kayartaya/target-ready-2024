package com.targetindia.programs

import com.targetindia.model.Circle
import com.targetindia.model.IGeometricShape
import com.targetindia.model.Triangle

// polymorphic method

fun processGeometricShape(shape: IGeometricShape){
    println("Name of the shape given is ${shape.getName()}")
    println("It\'s area is ${shape.getArea()}")
}

fun main(){
    val c1 = Circle(12.34);
    val t1 = Triangle(12.34, 56.78)

    processGeometricShape(c1)
    processGeometricShape(t1)

}