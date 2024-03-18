package com.targetindia.programs;

import com.targetindia.entity.Shipper;
import com.targetindia.utils.KeyboardUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class GetOneShipper {
    public static void main(String[] args) {
        int id = KeyboardUtil.getInt("Enter shipper id to search: ");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TARGET-READY-2024");
        EntityManager em = emf.createEntityManager(); // represents a db connection
        var shipper = em.find(Shipper.class, id); // SQL SELECT is created and executed by the JPA provider

        if(shipper==null){
            System.out.println("No shipper found for id " + id);
        }
        else {
            System.out.printf("Company name: %s\n", shipper.getCompanyName());
            System.out.printf("Phone number: %s\n", shipper.getPhone());
        }
        em.close();
    }
}
