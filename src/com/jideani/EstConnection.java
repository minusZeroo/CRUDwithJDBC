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
}
