package com.targetindia.model;

import com.targetindia.utils.DateUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.targetindia.utils.DateUtil.toDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee implements Comparable<Employee> {

    private int id;
    private String firstname;
    private String lastname;
    private double salary;
    private Date birthDate;

    public long getAge() {
        // calculate the difference between the birthDate and currentDate
        // TODO: fix this logic; giving wrong result
        return (new Date().getTime() - birthDate.getTime()) / (1000 * 60 * 60 * 24 * 365);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", salary=" + salary +
                ", birthDate=" + DateUtil.toString(birthDate) +
                ", age=" + getAge() + " years" +
                '}';
    }

    public static List<Employee> getEmployeeList() {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee(189, "Rajesh", "Rao", 89999, toDate("1989-02-25")));
        list.add(new Employee(728, "Rohit", "Kumar", 78000, toDate("1978-12-12")));
        list.add(new Employee(673, "Vishal", "Kumar", 87000, toDate("1999-11-12")));
        list.add(new Employee(283, "Vijay", "Khanna", 88000, toDate("2001-06-13")));
        list.add(new Employee(164, "Anil", "SK", 67000, toDate("2002-09-15")));
        return list;
    }

    @Override
    public int compareTo(Employee that) {
        // return this.id - that.id;
        return Integer.compare(this.id, that.id);
    }
}
