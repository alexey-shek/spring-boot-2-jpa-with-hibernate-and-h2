package com.in28minutes.springboot.rest.example.springboot2jpawithhibernateandh2.sampleOld;

public class StudentO {
    private long id = -1;
    private String name = null;
    private String passportNumber = null;

    public StudentO(long id, String name, String passportNumber) {
        this.id = id;
        this.name = name;
        this.passportNumber = passportNumber;
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
