package com.targetindia.programs;

import com.targetindia.resources.EmployeeResource;

public class TryWithResourcesDemo {

    public static void main(String[] args) {


        try (
                EmployeeResource er = new EmployeeResource();
        ) {

            System.out.println("try block entered");

            System.out.println("doing something in try block...");

            int n = 123 / 0;

            System.out.println("exiting the try block successfully");
        } catch (Exception e) {
            System.out.println("Got an exception...");
        }


    }
}
