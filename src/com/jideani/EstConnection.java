package com.jideani;

import java.sql.*;

public class EstConnection {

    public void ConnectToDB() throws SQLException {

        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;

        try {
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "pathfinder");
            System.out.println("Database connection successful! \n");
            myStmt = myConn.createStatement();
            myRs = myStmt.executeQuery("select * from employees");
            while (myRs.next()){
                System.out.println(myRs.getString("last_name") + ", " + myRs.getString("first_name"));
            }
        } catch (Exception e){
            e.printStackTrace();
        }finally {
            if (myRs != null){
                myRs.close();
            }
            if (myStmt != null){
                myStmt.close();
            }
            if (myConn != null){
                myConn.close();
            }

        }
    }

    public void Insert() throws SQLException {
        String dbUrl = "jdbc:mysql://localhost:3306/demo";
        String user = "root";
        String pass = "pathfinder";


            Connection myConn = DriverManager.getConnection(dbUrl, user, pass);
            Statement myStmt = myConn.createStatement();
            System.out.println("Inserting a new employee to the database");
            int rowsAffected = myStmt.executeUpdate(
                    "insert into employees " +
                    "(last_name, first_name, email, department, salary) " + " values " +
                    "('Paul', 'Jideani', 'pcijideani@gmail.com', 'IT', 15000.00) ");

    }

    public void Update() throws  SQLException {
        String dbUrl = "jdbc:mysql://localhost:3306/demo";
        String user = "root";
        String pass = "pathfinder";


        Connection myConn = DriverManager.getConnection(dbUrl, user, pass);
        Statement myStmt = myConn.createStatement();
        System.out.println("Before the Update...");

        System.out.println("Executing the update for Paul Jideani\n");

        int rowsAffected = myStmt.executeUpdate("update employees " + "set email='paul@jideani.com' " + "where last_name= 'Paul' and first_name= 'Jideani'");

    }

    public void Delete() throws SQLException{
        String dbUrl = "jdbc:mysql://localhost:3306/demo";
        String user = "root";
        String pass = "pathfinder";


        Connection myConn = DriverManager.getConnection(dbUrl, user, pass);
        Statement myStmt = myConn.createStatement();
        System.out.println("Deleting...");

        int rowsAffected = myStmt.executeUpdate("delete from employees " + "where last_name='Paul' and first_name='Jideani'");


    }
}
