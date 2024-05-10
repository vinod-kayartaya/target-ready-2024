package com.targetindia.programs;

import com.targetindia.entity.Shipper;
import com.targetindia.utils.JpaUtil;
import com.targetindia.utils.KeyboardUtil;
import jakarta.persistence.EntityManager;

public class AddNewShipper {

    public static void main(String[] args) {

        System.out.println("Enter new shipper details: ");
        var id = KeyboardUtil.getInt("ID              : ");
        var cn = KeyboardUtil.getString("Company name    : ");
        var ph = KeyboardUtil.getString("Phone number    : ");
        Shipper shipper = new Shipper();
        shipper.setId(id);
        shipper.setCompanyName(cn);
        shipper.setPhone(ph);

        try (EntityManager em = JpaUtil.createEntityManager();) {
            var tx = em.getTransaction();

            try {
                em.persist(shipper);
                tx.begin();
                tx.commit(); // here is where all DML statements corresponding to the em will executed
                System.out.println("new shipper added successfully");
            } catch (Exception e) {
                tx.rollback();
                e.printStackTrace();
            }
        } // em.close() called here

    }
}
