package com.jideani;

import java.sql.SQLException;

public class Controller {
    public static void main(String[] args) throws SQLException {

        EstConnection estConnection = new EstConnection();
        estConnection.ConnectToDB();
    }
}
