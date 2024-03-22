package com.targetindia.programs;

import com.targetindia.entity.Employee;
import com.targetindia.utils.JpaUtil;
import com.targetindia.utils.KeyboardUtil;
import com.targetindia.utils.Printer;

public class GetEmployeeAndCorrespondingLaptop {
    public static void main(String[] args) {

        int id = KeyboardUtil.getInt("enter employee id to search: ");
        Employee emp;
        try (var em = JpaUtil.createEntityManager()) {
            emp = em.find(Employee.class, id);
        } // em.close() called; no more connection to db

        Printer.print(emp, "laptop");
        Printer.print(emp.getLaptop(), "assignedTo");
        Printer.print(emp.getLaptop().getAssignedTo(), "laptop");
    }
}
