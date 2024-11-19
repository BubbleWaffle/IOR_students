package org.example;

import jakarta.persistence.EntityManager;
import org.example.Models.*;
import org.example.util.JPAUtil;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();

        Addresses address = new Addresses("Italy", "Rome", "3-4", "Pickerina");
        em.persist(address);

        Teacher teacher = new Teacher("Doktor");
        teacher.setfName("Antek");
        teacher.setsName("Lark");
        teacher.setEmail("AL@gmail.com");
        teacher.setAddress(address);
        em.persist(teacher);

        Student student = new Student(10, 10);
        student.setfName("Błażej");
        student.setsName("Kubicius");
        student.setEmail("BeKa@gmail.com");
        student.setAddress(address);
        em.persist(student);

        Subject math = new Subject("Matematyka");
        math.setTeacher(teacher);
        em.persist(math);

        Test test = new Test(new Date(), 4.5);
        test.setStudent(student);
        test.setSubject(math);
        em.persist(test);

        em.getTransaction().commit();

        em.close();
        JPAUtil.shutDown();
    }
}