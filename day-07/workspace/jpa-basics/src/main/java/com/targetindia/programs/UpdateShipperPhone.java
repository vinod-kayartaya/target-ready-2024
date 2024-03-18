package com.targetindia.programs;

import com.targetindia.entity.Shipper;
import com.targetindia.utils.JpaUtil;
import com.targetindia.utils.KeyboardUtil;
import jakarta.persistence.EntityManager;

import java.util.concurrent.ExecutionException;

public class UpdateShipperPhone {

    static Shipper getShipperById(Integer id){
        try (EntityManager em = JpaUtil.createEntityManager();) {
            return em.find(Shipper.class, id); // SQL SELECT is created and executed by the JPA provider
        }// em.close() called here
    }

    public static void main(String[] args) {
        var id = KeyboardUtil.getInt("Enter shipper id to search: ");
        Shipper shipper = getShipperById(id);

        if(shipper==null){
            System.out.println("no data found for shipper id: " + id);
            return;
        }

        var phone = KeyboardUtil.getString("Enter new phone number: ");
        shipper.setPhone(phone);

        try (EntityManager em = JpaUtil.createEntityManager();) {
            var tx = em.getTransaction();
            tx.begin();
            try{
                em.merge(shipper);
                System.out.println("calling tx.commit...");
                tx.commit();
                System.out.println("tx.commit() done");
                System.out.println("phone number updated");
            }
            catch(Exception e){
                tx.rollback();
            }
        }
    }

}
