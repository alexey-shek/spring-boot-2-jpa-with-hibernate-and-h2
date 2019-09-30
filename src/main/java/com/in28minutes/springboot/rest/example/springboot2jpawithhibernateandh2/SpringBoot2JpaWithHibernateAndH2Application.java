package com.in28minutes.springboot.rest.example.springboot2jpawithhibernateandh2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


@SpringBootApplication
public class SpringBoot2JpaWithHibernateAndH2Application {


	public static void main(String[] args) {
        SpringApplication.run(SpringBoot2JpaWithHibernateAndH2Application.class, args);


        Input input = new Input();
        try {
            input.menu();
        } catch (IOException e){
            System.out.println(e);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}
