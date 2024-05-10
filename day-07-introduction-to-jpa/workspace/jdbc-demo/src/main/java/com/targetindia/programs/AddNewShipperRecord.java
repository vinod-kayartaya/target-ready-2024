package com.targetindia.programs;

import java.sql.DriverManager;
import java.util.ResourceBundle;

public class AddNewShipperRecord {

    public static void main(String[] args) throws Exception{

//        System.out.println("drivers that are currently loaded in JVM:");
//        var drivers = DriverManager.getDrivers();
//        while(drivers.hasMoreElements()){
//            var driver = drivers.nextElement();
//            System.out.printf("instance of type \"%s\" is in JVM\n", driver.getClass().getName());
//        }

        ResourceBundle rb = ResourceBundle.getBundle("jdbc-config");
        String url = rb.getString("jdbc.driver.url");
        String username = rb.getString("jdbc.driver.username");
        String password = rb.getString("jdbc.driver.password");

        var conn = DriverManager.getConnection(url, username, password);
        System.out.printf("got a connection of type \"%s\".\n", conn.getClass().getName());

        var stmt = conn.prepareStatement("insert into shippers values (?, ?, ?)");
        stmt.setInt(1, 4);
        stmt.setString(2, "KVinod Transports");
        stmt.setString(3, "(973) 142-4784");
        stmt.executeUpdate();

        System.out.println("New shipper data added successfully");
    }
}
