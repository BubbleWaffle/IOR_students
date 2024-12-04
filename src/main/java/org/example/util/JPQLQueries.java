package org.example.util;

import jakarta.persistence.EntityManager;

import java.util.List;

public class JPQLQueries {
    String query1 = "SELECT p.fName, p.sName FROM Person p";
    String query2 =
            "SELECT t.grade, p.fName, p.sName FROM Test t\n" +
            "join\n" +
            "Student p on p.id = t.student.id\n" +
            "WHERE t.grade > 4";

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
}
