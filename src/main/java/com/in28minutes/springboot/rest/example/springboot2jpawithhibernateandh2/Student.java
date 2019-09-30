package com.in28minutes.springboot.rest.example.springboot2jpawithhibernateandh2;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.*;

@Entity
public class Student {

    @Id
    public long id;
    public String name;
    public String passportNumber;


    public Student(String name, String passportNumber) {
        this.id = System.nanoTime();
        this.name = name;
        this.passportNumber = passportNumber;
    }

    public Student(){
        this.id = System.nanoTime();
    }

    public long getMyId() {
        return id;
    }

    public void setMyId(long myId) {
        this.id = myId;
    }

    public void insertStudent(Connection connection, String name, String passportNumber) throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.execute("INSERT INTO Student " + "VALUES ("+ getMyId() +", '"+name+"', '"+passportNumber+"')");
        System.out.println("Action successfull...");
    }

    public void updateStudent(Connection connection, long id, String name, String passportNumber) throws SQLException {
        Statement stmt = connection.createStatement();
        if (name!=null){
            stmt.execute("UPDATE Student " + "SET NAME = '"+name+"' WHERE ID = "+id);
        }
        if (passportNumber!=null){
            stmt.execute("UPDATE Student " + "SET PASSPORT_NUMBER = '"+ passportNumber +"' WHERE ID = "+id);
        }

    }

    public void deleteStudent(Connection connection, long id) throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.execute("DELETE FROM Student WHERE ID = "+id);
    }

}
