package com.targetindia.programs;


import com.targetindia.model.Book;
import com.targetindia.model.Employee;
import com.targetindia.model.Product;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Slf4j
public class ObjectsDemo {

//    private static Logger log;

    public static void main(String[] args) {
        Book b1;
        b1 = new Book();
        System.out.println("b1 is " + b1);
        b1 = new Book();
        b1.id = 123;
        b1.title = "Let us Java";
        b1.price = -999999999.0;
        System.out.println("b1 is " + b1);

        Product p1 = new Product();
        Product p2 = new Product(121, "Toshiba Laptop", 15000.0);
        Product p3 = new Product(221, "Lenovo TravelMate");

        p1.setId(292);
        p1.setName("Apple Macbook Pro");

        p3.setPrice(45000);

        System.out.println("p1 is " + p1);
        System.out.println("p2 is " + p2);
        System.out.println("p3 is " + p3);

        System.out.printf("Price of '%s' is %.2f\n", p3.getName(), p3.getPrice());

    }

    public static void logExample(String[] args) {
//        log = LoggerFactory.getLogger(ObjectsDemo.class);

        log.trace("lowest level logs");
        log.debug("level 2 logs");
        log.info("level 3 logs");
        log.warn("level 4 logs");
        log.error("level 5 logs");

    }
}
