package org.example;

import jakarta.persistence.EntityManager;
import org.example.Models.*;
import org.example.util.DataLoad;
import org.example.util.JPAUtil;
import org.example.util.JPQLQueries;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();

        //DataLoad test = new DataLoad(em);

        //em.getTransaction().commit();

        JPQLQueries queries = new JPQLQueries();

        queries.FirstQuery(em);
        System.out.println("\n\n");
        queries.SecondQuery(em);

        em.getTransaction().commit();
        em.close();
        JPAUtil.shutDown();
    }
}