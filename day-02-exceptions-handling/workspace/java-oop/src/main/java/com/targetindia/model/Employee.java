package com.targetindia.model;

import lombok.Data;

@Data
public abstract class Employee {
    private int id;
    private String name;
    private double salary;
    private String department;

    public Employee() {
    }

    public Employee(int id, String name, double salary, String department) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.department = department;
    }

    public void setSalary(double salary) {
        if(salary<25000){
            throw new RuntimeException("Salary must be >= 25000.");
        }
        this.salary = salary;
    }

    public void printInfo(){
        System.out.printf("ID          : %d\n", id);
        System.out.printf("Name        : %s\n", name);
        System.out.printf("Salary      : %.2f\n", salary);
        System.out.printf("Department  : %s\n", department);
    }
}
