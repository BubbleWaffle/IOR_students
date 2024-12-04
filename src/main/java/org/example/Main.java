package org.example;

import jakarta.persistence.EntityManager;
import org.example.Models.*;
import org.example.util.DataLoad;
import org.example.util.JPAUtil;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();

        DataLoad test = new DataLoad(em);

        em.getTransaction().commit();

        em.close();
        JPAUtil.shutDown();
    }
}