package com.targetindia.miniproject.utils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public final class JpaUtil {
    private JpaUtil() {
    }

    private static final EntityManagerFactory emf;

    static {
        emf = Persistence.createEntityManagerFactory("MINI-PROJECT");
    }


    public static EntityManager createEntityManager(){
        return emf.createEntityManager();
    }
}
