package com.targetindia.programs;

import com.targetindia.entity.Employee;
import com.targetindia.entity.Laptop;
import com.targetindia.utils.JpaUtil;

public class IssueNewLaptopsToEmployees {
    public static void main(String[] args) {
        Laptop l1 = new Laptop();
        l1.setLaptopId(1);
        l1.setMake("ACER");
        l1.setModel("Travelmate 345");

        Laptop l2 = new Laptop();
        l2.setLaptopId(2);
        l2.setMake("Apple");
        l2.setModel("Macbook pro");

        try(var em = JpaUtil.createEntityManager()){
            em.getTransaction().begin();

            var emp1 = em.find(Employee.class, 3);
            var emp2 = em.find(Employee.class, 7);

            emp1.setLaptop(l1);
            l1.setAssignedTo(emp1);

            emp2.setLaptop(l2);
            l2.setAssignedTo(emp2);

            em.getTransaction().commit();
            System.out.println("new laptops assigned to employees");
        }
    }
}
