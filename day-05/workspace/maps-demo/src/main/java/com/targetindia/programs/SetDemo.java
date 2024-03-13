package com.targetindia.programs;

import com.targetindia.model.Employee;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetDemo {
    public static void main(String[] args) {

        Set<Employee> emps = new TreeSet<>();
        Employee emp;

        emp = new Employee(12, "Ramesh", 78990);
        emps.add(emp);
        System.out.println(emp + " --> " + emp.hashCode());

        emp = new Employee(78, "Umesh", 56990);
        emps.add(emp);
        System.out.println(emp + " --> " + emp.hashCode());

        emp = new Employee(67, "Kishore", 98790);
        emps.add(emp);
        System.out.println(emp + " --> " + emp.hashCode());

        emp = new Employee(17, "Kiran", 75590);
        emps.add(emp);
        System.out.println(emp + " --> " + emp.hashCode());

        emp = new Employee(88, "Uday", 87990);
        emps.add(emp);
        System.out.println(emp + " --> " + emp.hashCode());

        emp = new Employee(17, "Kiran", 75590);
        emps.add(emp);
        System.out.println(emp + " --> " + emp.hashCode());

        emp = new Employee(17, "Kiran", 75590);
        emps.add(emp);
        System.out.println(emp + " --> " + emp.hashCode());

        emp = new Employee(88, "Uday", 87990);
        emps.add(emp);
        System.out.println(emp + " --> " + emp.hashCode());

        emp = new Employee(88, "Uday", 87990);
        emps.add(emp);
        System.out.println(emp + " --> " + emp.hashCode());

        emp = new Employee(67, "Kishore", 98790);
        emps.add(emp);
        System.out.println(emp + " --> " + emp.hashCode());

        emp = new Employee(67, "Kishore", 98790);
        emps.add(emp);
        System.out.println(emp + " --> " + emp.hashCode());

        emp = new Employee(88, "Uday", 87990);
        emps.add(emp);
        System.out.println(emp + " --> " + emp.hashCode());

        MapDemo.line();

        for(var e: emps){
            System.out.println(e + " --> " + e.hashCode());
        }
    }
}
