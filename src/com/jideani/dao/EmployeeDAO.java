package com.jideani.dao;

import com.jideani.dbconnection.MySQLConnection;
import com.jideani.entity.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeeDAO {

    public void saveEmployee(Employee employee) {
        Connection connection = MySQLConnection.getConnection();
        if (connection != null) {
            String insertSQL = "INSERT INTO employees (last_name, first_name, email, department, salary) VALUES (?, ?, ?, ?, ?)";
            try {
                PreparedStatement ps = connection.prepareStatement(insertSQL);
                ps.setString(1, employee.getLastName());
                ps.setString(2, employee.getFirstName());
                ps.setString(3, employee.getEmail());
                ps.setString(4, employee.getDepartment());
                ps.setBigDecimal(5, employee.getSalary());
                ps.executeUpdate();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                closeConnection(connection);
            }
        }
    }

    private void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
