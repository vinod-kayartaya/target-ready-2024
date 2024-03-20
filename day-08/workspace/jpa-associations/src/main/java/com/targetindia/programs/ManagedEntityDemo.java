package com.targetindia.programs;

import com.targetindia.entity.Category;
import com.targetindia.utils.JpaUtil;
import jakarta.persistence.EntityManager;

import java.io.FileInputStream;

public class ManagedEntityDemo {
    public static void main(String[] args) throws Exception{

        try(EntityManager em = JpaUtil.createEntityManager()){
            System.out.println("em is an object of type: " + em.getClass().getName());

            // get a category by id (which becomes a managed object)
            Category cat = em.find(Category.class, 1);
            // update the picture member variable

            try(FileInputStream file = new FileInputStream("beverages.jpeg")){
                byte[] bytes = new byte[file.available()];
                file.read(bytes);

                // we are now mutating a managed object
                cat.setPicture(bytes);
            }
            // begin and commit the transaction
            em.getTransaction().begin();
            System.out.println("----committing...");
            em.getTransaction().commit();
            System.out.println("----committed!");
        }// em.close() is called here

    }
}
