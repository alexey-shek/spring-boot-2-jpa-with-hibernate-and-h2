package com.in28minutes.springboot.rest.example.springboot2jpawithhibernateandh2.sampleOld;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoStudent extends DaoGeneric<StudentO> {
    private static final String TABLENAME = DbTables.STUDENT.toString();

    private final String S_ID = "s_id";
    private final String S_NAME = "s_name";
    private final String S_PASSPORT = "s_passport";

    public DaoStudent(Connection con){
        super(con, TABLENAME);
    }

    @Override
    public int count() {
        String query = "SELECT COUNT as count from "+TABLENAME;
        PreparedStatement prepCounter;

        int recordCount = 0;

        try {
            prepCounter = this.con.prepareStatement(query);
            ResultSet rs = prepCounter.executeQuery();

            if (rs.next()){
                recordCount = rs.getInt("count");
            }
        }catch (SQLException e){
            e.printStackTrace();
            recordCount = -1;
        }
        return recordCount;
    }

    @Override
    public StudentO getRecords(int id) {
        ResultSet rs = null;
        StudentO selectedRecord = null;

        String query = "SELECT "+S_ID+", "+S_NAME+", "+S_PASSPORT+" FROM "+TABLENAME+" WHERE "+S_ID + "= ?";

        try {
            PreparedStatement prepStatement = con.prepareStatement(query);
            prepStatement.setInt(1, id);

            rs = prepStatement.executeQuery();
            if (rs.next()){
                selectedRecord = new StudentO(rs.getInt(S_ID), rs.getString(S_NAME), rs.getString(S_PASSPORT));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return selectedRecord;
    }
}
