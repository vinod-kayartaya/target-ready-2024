package com.targetindia.programs;

import com.targetindia.model.Employee;

import java.util.Collections;
import java.util.List;

public class SortEmployees {
    static void printEmployees(List<Employee> emps, String message) {
        System.out.println(message);
        emps.forEach(System.out::println);
        System.out.println("-----------------------------------------------------");
    }

    public static void main(String[] args) {


        List<Employee> emps = Employee.getEmployeeList();
        printEmployees(emps, "original order: ");

//        Collections.reverse(emps);
//        printEmployees(emps, "reverse order: ");
//
//        Collections.shuffle(emps);
//        printEmployees(emps, "random order: ");
//
//        Collections.shuffle(emps);
//        printEmployees(emps, "random order: ");
//
//        Collections.sort(emps);
//        printEmployees(emps, "by default order (id)");
//
//        Collections.sort(emps, (e1, e2)->Double.compare(e1.getSalary(), e2.getSalary()));
//        printEmployees(emps, "by salary (asc): ");
//
//
//        Collections.sort(emps, (e1, e2)->Double.compare(e2.getSalary(), e1.getSalary()));
//        printEmployees(emps, "by salary (desc): ");
//
//
//        Collections.sort(emps, (e1, e2)->Double.compare(e1.getAge(), e2.getAge()));
//        printEmployees(emps, "by age (asc): ");


        var emp = Collections.max(emps);
        System.out.println("emp with max id: " + emp);

        emp = Collections.max(emps, (e1, e2)->Double.compare(e1.getSalary(), e2.getSalary()));
        System.out.println("emp with max salary: " + emp);

        emp = Collections.min(emps, (e1, e2)->Double.compare(e1.getAge(), e2.getAge()));
        System.out.println("youngest emp: " + emp);
    }
}
