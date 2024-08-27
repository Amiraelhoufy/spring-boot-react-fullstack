package com.agcodes.reactDemo.datasource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectTest {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:postgresql://localhost:5332/reactdemo";
        String username = "test";
        String password = "password";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
            System.out.println("Connection successful!");
        } catch (SQLException e) {
            System.err.println("Connection failed!");
            e.printStackTrace();
        }
    }
}

