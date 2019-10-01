package com.in28minutes.springboot.rest.example.springboot2jpawithhibernateandh2.sampleOld;

import java.sql.Connection;

public abstract class DaoGeneric<T> {
    protected final String tableName;
    protected Connection con;

    protected DaoGeneric(Connection con, String tableName){
        this.tableName = tableName;
        this.con = con;
    }

    public abstract int count();

    public abstract T getRecords(int id);
}
