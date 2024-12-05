package org.example.Models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Entity
public class Teacher extends Person {

    private String title;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "Teacher_Subject",
            joinColumns = @JoinColumn(name = "teacher_id", foreignKey = @ForeignKey( name = "Fk_teacher")),
            inverseJoinColumns = @JoinColumn(name = "subject_id", foreignKey = @ForeignKey( name = "Fk_subject"))
    )
    private List<Subject> subjects = new ArrayList<>();

    protected Teacher() {}

    public Teacher(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public List<Subject> getSubjects() {
        return subjects;
    }
    public void addSubject(Subject subject) {
        if (!subjects.contains(subject)) { // Zapobieganie duplikatom
            subjects.add(subject);
            subject.getTeachers().add(this); // Aktualizacja relacji dwukierunkowej
        }
    }
}
