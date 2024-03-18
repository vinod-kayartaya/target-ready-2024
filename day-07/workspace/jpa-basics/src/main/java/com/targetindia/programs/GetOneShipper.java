package com.targetindia.programs;

import com.targetindia.entity.Shipper;
import com.targetindia.utils.JpaUtil;
import com.targetindia.utils.KeyboardUtil;
import jakarta.persistence.EntityManager;

public class GetOneShipper {
    public static void main(String[] args) {
        int id = KeyboardUtil.getInt("Enter shipper id to search: ");

        try (EntityManager em = JpaUtil.createEntityManager();) {
            var shipper = em.find(Shipper.class, id); // SQL SELECT is created and executed by the JPA provider

            if (shipper == null) {
                System.out.println("No shipper found for id " + id);
            } else {
                System.out.printf("Company name: %s\n", shipper.getCompanyName());
                System.out.printf("Phone number: %s\n", shipper.getPhone());
            }
        } // em.close() is called here

    }
}
