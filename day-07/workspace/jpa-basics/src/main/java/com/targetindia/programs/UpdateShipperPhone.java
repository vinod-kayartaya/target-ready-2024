package com.targetindia.programs;

import com.targetindia.entity.Shipper;
import com.targetindia.utils.JpaUtil;
import com.targetindia.utils.KeyboardUtil;
import jakarta.persistence.EntityManager;

import java.util.concurrent.ExecutionException;

public class UpdateShipperPhone {

    static Shipper getShipperById(Integer id){
        Shipper shipper = null;
        try (EntityManager em = JpaUtil.createEntityManager();) {
            shipper = em.find(Shipper.class, id); // SQL SELECT is created and executed by the JPA provider
            // shipper is a 'managed' object
        }// em.close() called here
        // shipper is a 'detached' object
        return shipper;
    }

    public static void main(String[] args) {
        var id = KeyboardUtil.getInt("Enter shipper id to search: ");
        Shipper shipper = getShipperById(id);
        // shipper is a detached object (not a new one);
        // since it came from another entity-manager

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
                em.merge(shipper); // shipper becomes a managed object again
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
