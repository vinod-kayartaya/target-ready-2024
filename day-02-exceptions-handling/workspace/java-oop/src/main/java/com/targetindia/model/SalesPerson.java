package com.targetindia.model;

import lombok.Data;
import lombok.ToString;

import java.util.Arrays;

@Data
@ToString(callSuper = true)
public class SalesPerson extends Employee{ // SalesPerson IS-A Employee
    private double commissionPercent = .015;

    public SalesPerson() {
    }

    public SalesPerson(int id, String name, double salary, String department, double commissionPercent) {
        super(id, name, salary, department);
        this.commissionPercent = commissionPercent;
    }

    public void printInfo(){
        super.printInfo();
        System.out.printf("Commission  : %.2f%%\n", commissionPercent);
    }
}
