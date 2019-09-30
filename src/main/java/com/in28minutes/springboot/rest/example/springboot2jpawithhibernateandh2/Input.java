package com.in28minutes.springboot.rest.example.springboot2jpawithhibernateandh2;


import javax.persistence.OneToMany;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Input {

    void menu() throws IOException, SQLException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        System.out.println("---[Choose your action:]---");
        System.out.println("1 - Insert");
        System.out.println("2 - Update");
        System.out.println("3 - Delete");
        System.out.println("4 - Show table");
        String input = br.readLine();
        if (input.equals("1")){
            System.out.println("INSERT");
            System.out.println("Give in the Name.");
            String name = br.readLine();
            System.out.println("Give in passport number.");
            String passport = br.readLine();
            Student student = new Student(name, passport);
            DBConnect dbConnect = new DBConnect();
            student.insertStudent(dbConnect.connect(), name, passport);
            dbConnect.disconnect();
            menu();
        }
        else if (input.equals("2")){
            String name=null;
            String passport=null;
            System.out.println("UPDATE");
            System.out.println("Give in ID number.");
            long id = Long.parseLong(br.readLine());
            System.out.println("Give in the Name.");
            name = br.readLine();
            System.out.println("Give in passport number.");
            passport = br.readLine();
            Student student = new Student(name, passport);
            DBConnect dbConnect = new DBConnect();
            student.updateStudent(dbConnect.connect(),id, name, passport);
            dbConnect.disconnect();
            menu();
        }
        else if (input.equals("3")){
            System.out.println("DELETE");
            System.out.println("Give in the ID of Student ");
            long id = Long.parseLong(br.readLine());
            DBConnect dbConnect = new DBConnect();
            Student student = new Student();
            student.deleteStudent(dbConnect.connect(), id);
            dbConnect.disconnect();
            menu();
        }
        else if (input.equals("4")){
            System.out.println("SHOW TABLE");
            DBConnect dbConnect = new DBConnect();
            showTable(dbConnect.connect());
            dbConnect.disconnect();

            menu();
        }
        else {
            System.out.println("Invalid choice, please choose 1-4");
            menu();
        }
    }

    private void showTable(Connection dbConnect) throws SQLException {
        Statement stmt = dbConnect.createStatement();
        stmt.execute("SELECT * FROM Student");
        ResultSet resultSet = stmt.getResultSet();
        while (resultSet.next()) {
            long studentID = resultSet.getLong("ID");
            String studentName = resultSet.getString("NAME");
            String passportNumber = resultSet.getString("PASSPORT_NUMBER");
            System.out.println(studentName + "\t" + studentID +
                    "\t" + passportNumber);
        }
    }
}
