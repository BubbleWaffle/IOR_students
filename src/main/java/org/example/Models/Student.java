package org.example.Models;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;


@Entity
@Table(name = "Student")
public class Student extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int indexNo;
    private int semester;


    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fos_id")
    private FieldOfStudy fieldOfStudy;

    @OneToMany(mappedBy = "student")
    private List<Test> tests;

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
    public FieldOfStudy getFieldOfStudy() {
        return fieldOfStudy;
    }

    public void setFieldOfStudy(FieldOfStudy fieldOfStudy) {
        this.fieldOfStudy = fieldOfStudy;
    }
}