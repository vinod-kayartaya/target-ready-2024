package com.targetindia.resources;

public class EmployeeResource implements AutoCloseable {


    public void close()  {
        System.out.println("Closing EmployeeResource....");
    }
}
