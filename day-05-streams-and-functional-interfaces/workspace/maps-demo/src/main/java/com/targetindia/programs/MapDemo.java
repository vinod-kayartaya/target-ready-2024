package com.targetindia.programs;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapDemo {

    public static void main(String[] args) {
        Map<String, String> customers = new TreeMap<>();

        customers.put("vinod@vinod.co", "Vinod Kumar");
        customers.put("ram@xmpl.co,", "Ram Kumar");
        customers.put("raj@xmpl.co,", "Rajesh Khanna");
        customers.put("uday@xmpl.co,", "Uday Ravi");
        customers.put("vinod@vinod.co", "Kayartaya Vinod");

        System.out.println(customers);
        line();
        for(var entry: customers.entrySet()){
            System.out.printf("%s --> %s\n", entry.getKey(), entry.getValue());
        }
        line();

        for(var key: customers.keySet()){
            System.out.printf("%s --> %s\n", key, customers.get(key));
        }

        line();
        for(var name: customers.values()){
            System.out.println(name);
        }

    }

    static void line() {
        System.out.println("----------------------------------------");
    }


}
