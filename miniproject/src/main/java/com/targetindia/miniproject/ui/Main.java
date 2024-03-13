package com.targetindia.miniproject.ui;

import com.targetindia.miniproject.service.CustomerManager;
import com.targetindia.miniproject.service.ServiceException;
import com.targetindia.miniproject.utils.KeyboardUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.InputMismatchException;

@Slf4j
public class Main {

    // this has a dependency on the CustomerManager
    CustomerManager cm = new CustomerManager();


    int menu(){
        System.out.println("==== Main Menu ====");
        System.out.println("0. Exit");
        System.out.println("1. List all customers");
        System.out.println("2. Add a new customer");
        System.out.println("3. Search customer by id");
        System.out.println("4. Search customer by email");
        System.out.println("5. Search customer by phone");
        System.out.println("6. Search customers by city");
        try {
            return KeyboardUtil.getInt("Enter your choice: ");
        }
        catch(InputMismatchException e){
            log.warn("There wan error while accepting the menu choice", e);
            return -1;
        }
    }

    void start(){
        int choice;

        while((choice=menu())!=0){
            log.trace("user made a choice {}", choice);

            switch (choice){
                case 1:
                    displayCustomerList();
                    break;
                case 2:
                    addNewCustomerData();
                    break;
                case 3:
                    searchAndDisplayCustomer();
                    break;
                default:
                    System.out.println("Invalid choice. Please retry.");
            }
        }
    }

    void searchAndDisplayCustomer() {
        System.out.println("searching for customer..");
    }

    void addNewCustomerData() {
        System.out.println("adding new customer..");
    }

    void displayCustomerList() {
        try {
            var customers = cm.getAll();
            System.out.printf("%4s|%-20s|%-15s|%-25s|%-15s\n", "ID", "Name", "City", "Email", "Phone");
            System.out.println("-----------------------------------------------------------------------------------");
            for(var c: customers){
                System.out.printf("%4d|%-20s|%-15s|%-25s|%-15s\n",
                        c.getId(),
                        c.getName(),
                        c.getCity(),
                        c.getEmail(),
                        c.getPhone());
            }
            System.out.println("-----------------------------------------------------------------------------------");


        } catch (ServiceException e) {
            System.out.println("Something went wrong. Check the logs or contact tech support");
            log.warn("there was an error while calling cm.getAll()", e);
        }
    }

    public static void main(String[] args) {
        log.trace("starting the app...");
        new Main().start();
        log.trace("ending the app.");
    }

}
