package com.targetindia.model;

import com.targetindia.exceptions.InvalidIdException;
import com.targetindia.exceptions.InvalidNameException;
import com.targetindia.exceptions.InvalidSalaryException;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@ToString
public class Employee {
    private int id;
    private String name;
    private double salary;
    private Gender gender = Gender.MALE;

    public Employee(int id, String name, double salary, Gender gender) {
        setId(id);
        setName(name);
        setSalary(salary);
        this.gender = gender;
    }

    public void setId(int id) throws InvalidIdException {
        if (id < 0) {
            throw new InvalidIdException("Id must be >=0");
        }
        this.id = id;
    }

    public void setName(String name) throws InvalidNameException {
        if (name == null) {
            throw new InvalidNameException("Name cannot be null");
        }
        name = name.trim();
        if (name.length() == 0) {
            throw new InvalidNameException("Name cannot be blank");
        }
        if (name.length() < 3 || name.length() > 25) {
            throw new InvalidNameException("Length of name must be between 3 and 25");
        }
        this.name = name;
    }

    public void setSalary(double salary) throws InvalidSalaryException{
        if (salary < 50000) {
            throw new InvalidSalaryException("salary must be >=50000");
        }
        this.salary = salary;
    }
}
