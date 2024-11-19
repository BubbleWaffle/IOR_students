package org.example;

import jakarta.persistence.EntityManager;
import org.example.Models.*;
import org.example.util.JPAUtil;

public class Main {
    public static void main(String[] args) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();

        Addresses address = new Addresses("Italy", "Rome", "3-4", "Pickerina");
        em.persist(address);

        //Subject subject = new Subject("Matematyka");
        //em.persist(subject);

        Student student = new Student(10, 10);
        student.setfName("Mikołaj");
        student.setsName("Desortes");
        student.setEmail("mikoaj@gmail.com");
        student.setAddress(address);

        /*Addresses address = new Addresses("Poland", "Wojnapiła", "33-100", "Bawarska");
        em.persist(address);

        Teacher teacher = new Teacher("Profesor");
        teacher.setfName("Majkel");
        teacher.setsName("August");
        teacher.setEmail("ma@gmail.com");
        teacher.setAddress(address);*/

        em.persist(student);
        //em.persist(teacher);

        em.getTransaction().commit();

        em.close();
        JPAUtil.shutDown();
    }
}