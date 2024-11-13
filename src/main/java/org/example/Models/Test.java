package org.example.Models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Test")
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date date;
    private double grade;

    protected Test() {}

    public Test(Date date, double grade) {
        this.date = date;
        this.grade = grade;
    }

    public Long getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public double getGrade() {
        return grade;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }
}
