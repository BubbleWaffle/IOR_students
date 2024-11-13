package org.example.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int indexNo;
    private int semester;

    protected Student() {}

    public Student(int indexNo, int semester) {
        this.indexNo = indexNo;
        this.semester = semester;
    }

    public Long getId() {
        return id;
    }

    public int getIndexNo() {
        return indexNo;
    }
    public void setIndexNo(int indexNo) {
        this.indexNo = indexNo;
    }

    public int getSemester() {
        return semester;
    }
    public void setSemester(int semester) {
        this.semester = semester;
    }
}