package org.example;

import jakarta.persistence.EntityManager;
import org.example.Models.Student;
import org.example.util.JPAUtil;

public class Main {
    public static void main(String[] args) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();

        Student student = new Student(11, 3);
        em.persist(student);

        em.getTransaction().commit();

        em.close();
        JPAUtil.shutDown();
    }
}