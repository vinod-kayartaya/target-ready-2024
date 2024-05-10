package com.targetindia.utils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public final class JpaUtil {
    private JpaUtil() {
    }

    private static final EntityManagerFactory emf;

    static {
        emf = Persistence.createEntityManagerFactory("TARGET-READY-2024");
    }


    public static EntityManager createEntityManager(){
        return emf.createEntityManager();
    }
}
