package com.in28minutes.springboot.rest.example.springboot2jpawithhibernateandh2;

public class StudentO {
    private long id = System.nanoTime();
    private String name;
    private String passportNumber;

    public StudentO(String name, String passport) {
        this.id = id;
        this.name = name;
        this.passportNumber = passport;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }
}
