package org.example.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.example.Models.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DataLoad {


    private EntityManager em;

    public DataLoad(EntityManager em) {
        this.em = em;
        InitData();
    }

    public void InitData() {
        LoadAddresses();
        LoadSubjectsAndTeachers();
        LoadStudentsAndFieldsOfStudy();
        LoadTests();
    }

    private void LoadAddresses() {
        Addresses address1 = new Addresses("Italy", "Rome", "3-4", "Pickerina");
        Addresses address2 = new Addresses("Poland", "Bielsko-Biała", "54-111", "TestUlica");
        Addresses address3 = new Addresses("Poland", "Warszawa", "11-111", "Prosta");
        Addresses address4 = new Addresses("Germany", "Berlin", "44-999", "Hauptstrasse");

        em.persist(address1);
        em.persist(address2);
        em.persist(address3);
        em.persist(address4);
    }

    private void LoadSubjectsAndTeachers() {
        Subject math = new Subject("Mathematics");
        Subject physics = new Subject("Physics");
        Subject programming = new Subject("Programming");

        em.persist(math);
        em.persist(physics);
        em.persist(programming);

        Teacher teacher1 = new Teacher("Dr.");
        teacher1.setfName("Antek");
        teacher1.setsName("Lark");
        teacher1.setEmail("AL@gmail.com");
        teacher1.setAddress(em.find(Addresses.class, 2L));
        teacher1.addSubject(math);
        teacher1.addSubject(physics);
        em.persist(teacher1);

        Teacher teacher2 = new Teacher("Professor");
        teacher2.setfName("Maria");
        teacher2.setsName("Kowalska");
        teacher2.setEmail("MK@gmail.com");
        teacher2.setAddress(em.find(Addresses.class, 1L));
        teacher2.addSubject(programming);
        em.persist(teacher2);
    }

    private void LoadStudentsAndFieldsOfStudy() {
        FieldOfStudy informatics = new FieldOfStudy("Informatics", "S1");
        FieldOfStudy robotics = new FieldOfStudy("Robotics", "N1");
        em.persist(informatics);
        em.persist(robotics);

        Student student1 = new Student(101, 1);
        student1.setfName("Błażej");
        student1.setsName("Kubicius");
        student1.setEmail("BeKa@gmail.com");
        student1.setAddress(em.find(Addresses.class, 2L));
        student1.setFieldOfStudy(informatics);
        em.persist(student1);

        Student student2 = new Student(102, 2);
        student2.setfName("Mikołaj");
        student2.setsName("Desortes");
        student2.setEmail("mail@gmail.com");
        student2.setAddress(em.find(Addresses.class, 3L));
        student2.setFieldOfStudy(robotics);
        em.persist(student2);

        Student student3 = new Student(103, 3);
        student3.setfName("Anna");
        student3.setsName("Nowak");
        student3.setEmail("anna.nowak@gmail.com");
        student3.setAddress(em.find(Addresses.class, 4L));
        student3.setFieldOfStudy(informatics);
        em.persist(student3);
    }

    private void LoadTests() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Student> query = cb.createQuery(Student.class);
        Root<Student> root = query.from(Student.class);
        query.select(root);
        List<Student> students = em.createQuery(query).getResultList();

        Student student1 = students.get(0);
        Student student2 = students.get(1);

        Subject math = em.find(Subject.class, 1L);
        Subject programming = em.find(Subject.class, 3L);

        Test test1 = new Test(new Date(), 4.5);
        test1.setStudent(student1);
        test1.setSubject(math);
        em.persist(test1);

        Test test2 = new Test(new Date(), 5.0);
        test2.setStudent(student1);
        test2.setSubject(programming);
        em.persist(test2);

        Test test3 = new Test(new Date(), 3.5);
        test3.setStudent(student2);
        test3.setSubject(math);
        em.persist(test3);
    }
}