package com.targetindia.programs;

import com.targetindia.model.Employee;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectOutputStream;

public class PersistEmployeeData {

    public static void main(String[] args) {
        String filename = "employees.dat";

        Employee[] emps = {
                new Employee(123, "Ramesh", 45999),
                new Employee(152, "Rohit", 67151),
                new Employee(826, "Santosh", 76529),
                new Employee(472, "Mahesh", 87152),
        };

        try (
                FileOutputStream file = new FileOutputStream(filename);
                ObjectOutputStream out = new ObjectOutputStream(file);
        ) {
            for (Employee emp : emps) {
                out.writeObject(emp);
            }
            System.out.println("Employee data written to: " + filename);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
