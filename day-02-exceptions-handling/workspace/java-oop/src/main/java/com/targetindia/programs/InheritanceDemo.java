package com.targetindia.programs;

import com.targetindia.model.Employee;
import com.targetindia.model.Manager;
import com.targetindia.model.SalesPerson;

public class InheritanceDemo {
    public static void main(String[] args) {
        Manager m1 = new Manager(1122, "Kishore", 125000, "RND", new String[]{"ABC", "MNB"});
        SalesPerson s1 = new SalesPerson(2211, "Kiran", 75000, "Sales", 0.5);


        Employee emp;

        emp = m1; // m1 is an instance of Manager, which IS-A Employee; hence m1 is also an instanceof Employee
        // upcasting; implicit
        System.out.println(emp); // emp.toString() --> the one from Manager class
        emp.printInfo(); // printInfo() from Manager class is used here

        emp = s1;
        System.out.println(emp); // emp.toString() --> the one from SalesPerson class
        emp.printInfo(); // printInfo() from SalesPerson class is used here

//        m1.printInfo();
//        System.out.println();
//        s1.printInfo();

    }
}
