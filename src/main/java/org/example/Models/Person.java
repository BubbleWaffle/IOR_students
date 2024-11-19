package org.example.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "Person")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String fName;
    private String sName;
    private String email;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Addresses address;

    public Addresses getAddress() {
        return address;
    }

    public void setAddress(Addresses address) {
        this.address = address;
    }

    protected Person() {}

    public Person(String fName, String sName, String email) {
        this.fName = fName;
        this.sName = sName;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getfName() {
        return fName;
    }
    public String getsName() {
        return sName;
    }
    public String getEmail() {
        return email;
    }
    public void setfName(String fName) {
        this.fName = fName;
    }
    public void setsName(String sName) {
        this.sName = sName;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}
