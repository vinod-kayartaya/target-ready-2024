package com.targetindia.programs;

import com.targetindia.entity.Shipper;
import com.targetindia.utils.JpaUtil;
import com.targetindia.utils.KeyboardUtil;
import jakarta.persistence.EntityManager;

public class DeleteShipper {
    public static void main(String[] args) {
        int id = KeyboardUtil.getInt("Enter shipper id to delete: ");

        try(EntityManager em = JpaUtil.createEntityManager()){
            var shipper = em.find(Shipper.class, id);

            if(shipper==null){
                System.out.println("No shipper data found for id " + id);
                return;
            }

            System.out.println(shipper);
            var choice = KeyboardUtil.getString("are you sure to delete this? (yes/no) [no]: ");
            if(choice.equalsIgnoreCase("yes")){
                em.remove(shipper);
                em.getTransaction().begin();
                em.getTransaction().commit();
                // at this time em does not manage `shipper`; it is a detached object
                System.out.println("deleted - " + shipper);
            }
        } // em.close() is called here
    }
}
