package org.example.util;

import jakarta.persistence.EntityManager;
import org.example.Models.*;

import java.util.ArrayList;
import java.util.List;

public class DataLoad {

    public EntityManager em;

    public DataLoad (EntityManager emg){
        this.em = emg;
        InitData();
    }

    public void InitData(){
        LoadBase();
        AddFieldsOfStudy();
    }

    public void LoadBase(){
        Addresses address = new Addresses("Italy", "Rome", "3-4", "Pickerina");
        Addresses ad2 = new Addresses("Poland", "Bielsko-Białą", "54-111", "TestUlica");
        Addresses ad3 = new Addresses("Poland", "Warszawa", "11-111", "Prosta");

        Student student = new Student(10, 10);
        student.setfName("Błażej");
        student.setsName("Kubicius");
        student.setEmail("BeKa@gmail.com");
        student.setAddress(ad2);
        em.persist(student);

        Student student2 = new Student(10, 10);
        student2.setfName("Mikolaj");
        student2.setsName("Desortes");
        student2.setEmail("mail@gmail.com");
        student2.setAddress(ad3);
        em.persist(student2);

//        Student student3 = new Student(10, 10);
//        student3.setfName("Mikolaj");
//        student3.setsName("Desortes");
//        student3.setEmail("mail@gmail.com");
//        student.setAddress(ad2);
//        em.persist(student3);

        Teacher teacher = new Teacher("Doktor");
        teacher.setfName("Antek");
        teacher.setsName("Lark");
        teacher.setEmail("AL@gmail.com");
        teacher.setAddress(ad2);
        em.persist(teacher);

        Teacher teacher2 = new Teacher("Doktor");
        teacher2.setfName("Test");
        teacher2.setsName("Teacher");
        teacher2.setEmail("ALT@gmail.com");
        teacher2.setAddress(address);
        em.persist(teacher2);

        Subject math = new Subject("Matematyka");
        //math.setTeachers(teacher);
        math.setTeachers(teacher2);
        em.persist(math);
    }

    public void AddFieldsOfStudy() {
        List<FieldOfStudy> data = new ArrayList<>();
        data.add(new FieldOfStudy("Informatics","S1"));
        data.add(new FieldOfStudy("Informatics","N1"));
        data.add(new FieldOfStudy("Robotics","S1"));
        data.add(new FieldOfStudy("Robotics","N1"));

        for(int i = 0; i < data.size(); i++){
            em.persist(data.get(i));
        }
        //em.persist(data);
    }
}
