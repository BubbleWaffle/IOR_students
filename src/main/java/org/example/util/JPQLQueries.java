package org.example.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Root;
import org.example.Models.*;

import java.util.List;

public class JPQLQueries {
    String query1 = "SELECT p.fName, p.sName FROM Person p";
    String query2 =
            "SELECT t.grade, p.fName, p.sName FROM Test t\n" +
            "join\n" +
            "Student p on p.id = t.student.id\n" +
            "WHERE t.grade > 4";

    String query3 = "SELECT t, COUNT(s) FROM Teacher t " +
            "JOIN t.subjects s " +
            "GROUP BY t " +
            "HAVING COUNT(s) >= 2";

    //where DTYPE = "Student"

    public void FirstQuery(EntityManager em) {
        List<Object[]> result1 = em.createQuery(query1).getResultList();

        for (Object[] row : result1) {
            System.out.println("First Name: " + row[0] + ", Last Name: " + row[1]);
        }
    }

    public void SecondQuery(EntityManager em) {
        List<Object[]> result1 = em.createQuery(query2).getResultList();

        for (Object[] row : result1) {
            System.out.println("Grade: " + row[0] + " First Name: " + row[1] + ", Last Name: " + row[2]);
        }
    }

    public void ThridQuery(EntityManager em) {
        List<Object[]> result = em.createQuery(query3).getResultList();

        for (Object[] row : result) {
            Teacher teacher = (Teacher) row[0];
            Long subjectCount = (Long) row[1];
            System.out.println("Teacher: " + teacher.getfName() + " " + teacher.getsName() +
                    ", Number of Subjects: " + subjectCount);
        }
    }

    public void Criteria(EntityManager em) {
        CriteriaBuilder cb = em.getCriteriaBuilder();

        CriteriaQuery<Object[]> query1 = cb.createQuery(Object[].class);
        Root<Person> person = query1.from(Person.class);

        query1.multiselect(person.get("fName"), person.get("sName"));

        List<Object[]> result1 = em.createQuery(query1).getResultList();
        System.out.println("Zapytanie 1: SELECT p.fName, p.sName FROM Person p");
        for (Object[] row : result1) {
            System.out.println("First Name: " + row[0] + ", Last Name: " + row[1]);
        }

        CriteriaQuery<Object[]> query2 = cb.createQuery(Object[].class);
        Root<Test> test = query2.from(Test.class);
        Join<Test, Student> student = test.join("student");

        query2.multiselect(test.get("grade"), student.get("fName"), student.get("sName"))
                .where(cb.gt(test.get("grade"), 4));

        List<Object[]> result2 = em.createQuery(query2).getResultList();
        System.out.println("Zapytanie 2: SELECT t.grade, p.fName, p.sName FROM Test t JOIN Student p WHERE t.grade > 4");
        for (Object[] row : result2) {
            System.out.println("Grade: " + row[0] + ", First Name: " + row[1] + ", Last Name: " + row[2]);
        }

        CriteriaQuery<Object[]> query3 = cb.createQuery(Object[].class);
        Root<Teacher> teacher = query3.from(Teacher.class);
        Join<Teacher, Subject> subjects = teacher.join("subjects");

        query3.multiselect(teacher, cb.count(subjects))
                .groupBy(teacher)
                .having(cb.ge(cb.count(subjects), 2));

        List<Object[]> result3 = em.createQuery(query3).getResultList();
        System.out.println("Zapytanie 3: Agregacja z HAVING - nauczyciele z co najmniej 2 przedmiotami");
        for (Object[] row : result3) {
            Teacher t = (Teacher) row[0];
            Long subjectCount = (Long) row[1];
            System.out.println("Teacher: " + t.getfName() + " " + t.getsName() +
                    ", Number of Subjects: " + subjectCount);
        }
    }
}
