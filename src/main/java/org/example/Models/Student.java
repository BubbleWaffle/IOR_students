package org.example.Models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
public class Student extends Person {

    private int indexNo;
    private int semester;


    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fos_id", foreignKey = @ForeignKey( name = "Fk_fos"))
    private FieldOfStudy fieldOfStudy;

    @OneToMany(mappedBy = "student")
    private List<Test> tests = new ArrayList<>();

    protected Student() {}

    public Student(int indexNo, int semester) {
        this.indexNo = indexNo;
        this.semester = semester;
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