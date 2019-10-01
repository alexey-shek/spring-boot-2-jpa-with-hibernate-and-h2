package com.in28minutes.springboot.rest.example.springboot2jpawithhibernateandh2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;


@SpringBootApplication
public class SpringBoot2JpaWithHibernateAndH2Application {

    private static Dao studentDao;

	public static void main(String[] args) {
        SpringApplication.run(SpringBoot2JpaWithHibernateAndH2Application.class, args);

        studentDao = new StudentDao();

        StudentO studentO = getStudent(0);
        System.out.println(studentO);
        studentDao.update(studentO, new String[]{"Jake", "JA12345"});

//        Input input = new Input();
//        try {
//            input.menu();
//        } catch (IOException e){
//            System.out.println(e);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

    }

    private static StudentO getStudent(long id) {
        Optional<StudentO> student = studentDao.get(id);

        return student.orElseGet(
                ()-> new StudentO("non-existent user", "NO00000"));
    }


}
