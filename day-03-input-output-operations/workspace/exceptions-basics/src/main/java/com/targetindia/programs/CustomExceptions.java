package com.targetindia.programs;

import com.targetindia.exceptions.InvalidIdException;
import com.targetindia.exceptions.InvalidNameException;
import com.targetindia.exceptions.InvalidSalaryException;
import com.targetindia.model.Employee;

public class CustomExceptions {
    public static void main(String[] args) {
        Employee emp;

        emp = new Employee();
        try {
            emp.setId(1234);
            emp.setName("John Doe");
            emp.setSalary(115000);
            System.out.println(emp);
        } catch (InvalidIdException e) {
            System.out.println(e.getMessage());
        } catch (InvalidNameException e) {
            System.out.println(e.getMessage());
        } catch (InvalidSalaryException e) {
            System.out.println(e.getMessage());
        }
    }
}
