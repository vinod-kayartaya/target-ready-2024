package com.targetindia.programs;

import com.targetindia.entity.Customer;
import com.targetindia.entity.Employee;
import com.targetindia.utils.JpaUtil;
import com.targetindia.utils.KeyboardUtil;
import com.targetindia.utils.Printer;

public class GetCustomerAndCorrespondingEmployees {
    public static void main(String[] args) {

        var id = KeyboardUtil.getString("enter customer id to search: ");
        Customer customer;
        try(var em = JpaUtil.createEntityManager()){
            customer = em.find(Customer.class, id);
            Printer.print(customer, "employees");

            var emps = customer.getEmployees();
            System.out.println("here are the employees who have processed this customer's orders: ");
            for(var emp: emps){
                System.out.println(emp);
            }

        } // em.close() called; no more connection to db


    }
}
