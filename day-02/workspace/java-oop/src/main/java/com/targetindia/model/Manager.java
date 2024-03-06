package com.targetindia.model;

import lombok.Data;
import lombok.ToString;

import java.util.Arrays;

@Data
@ToString(callSuper = true)
public class Manager extends Employee{  // Manager IS-A Employee
    private String[] projects;

    // best practice

    public Manager() {
    }

    public Manager(int id, String name, double salary, String department, String[] projects) {
        super(id, name, salary, department);
        this.projects = projects;
    }

    public void printInfo(){
        super.printInfo();
        System.out.printf("Projects    : %s\n", Arrays.toString(projects));
    }
}
