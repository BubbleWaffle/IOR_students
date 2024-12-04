package org.example;

import jakarta.persistence.EntityManager;
import org.example.Models.*;
import org.example.util.DataLoad;
import org.example.util.JPAUtil;
import org.example.util.JPQLQueries;

import java.util.Date;

public class Main {
    public static void main(String[] args) {

        int switchValue = 3; //1 tworzenie bazy //2 wczytanie danych //3 zapytnaia

        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();


        if(switchValue == 2) {
            DataLoad test = new DataLoad(em);
        }
        else if(switchValue == 3) {
            JPQLQueries queries = new JPQLQueries();

            System.out.println("JPQL queries:");
            queries.FirstQuery(em);
            System.out.println("\n\n");
            queries.SecondQuery(em);
            System.out.println("\n\n");
            queries.ThridQuery(em);
            System.out.println("\n\n");
            System.out.println("Criteria queries");
            queries.Criteria(em);
        }

        em.getTransaction().commit();
        em.close();
        JPAUtil.shutDown();
    }
}