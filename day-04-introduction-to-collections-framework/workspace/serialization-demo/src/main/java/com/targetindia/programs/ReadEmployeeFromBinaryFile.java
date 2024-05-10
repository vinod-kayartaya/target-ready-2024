package com.targetindia.programs;

import com.targetindia.model.Employee;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ReadEmployeeFromBinaryFile {
    public static void main(String[] args) {
        try (
                FileInputStream file = new FileInputStream("employees.dat");
                ObjectInputStream in = new ObjectInputStream(file);
        ) {
            while(true){
                Employee emp = null;
                try {
                    emp = (Employee) in.readObject();
                } catch (EOFException e) {
                    break;
                }
                System.out.println(emp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
