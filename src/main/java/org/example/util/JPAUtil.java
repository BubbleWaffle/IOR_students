package org.example.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtil {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("IoR_PU");

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public static void shutDown() {
        emf.close();
    }
}
