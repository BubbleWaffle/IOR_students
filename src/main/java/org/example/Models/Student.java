package org.example.Models;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Student")
public class Student extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int indexNo;
    private int semester;

    @ManyToMany
    @JoinTable(
            name = "student_subject",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "subject_id")
    )
    private Set<Subject> subjects = new HashSet<>();

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