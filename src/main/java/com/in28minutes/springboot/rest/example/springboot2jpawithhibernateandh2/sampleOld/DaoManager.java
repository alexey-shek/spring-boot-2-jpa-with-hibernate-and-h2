package com.in28minutes.springboot.rest.example.springboot2jpawithhibernateandh2.sampleOld;

import java.sql.Connection;
import java.sql.DriverManager;

public enum DaoManager {
    INSTANCE;

    private Connection con;
    private final String url = "jdbc:h2:mem:testdb";
    private final String userName = "sa";
    private final String password = "";

    DaoManager() {
    }

    private Connection getConnection(){
        try {
            Class.forName("org.h2.Driver");
            con = DriverManager.getConnection(url, userName, password);

            if (con != null){
                System.out.println("DB connection successfull!");
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Connection failed: "+e.getMessage());
        }
        return con;
    }

    public void open(){
        try {
            if (this.con == null || this.con.isClosed()){
                this.con = getConnection();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void close(){
        try {
            if (this.con!=null || !this.con.isClosed()){
                this.con.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
