package com.jdbcConnect.demojdbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.*;
import java.sql. *;
@SpringBootApplication
public class DemojdbcApplication {

    public static void main(String[] args) {

        final String DB_URL = "jdbc:mysql://localhost/platform";
        final String USER = "root";
        final String PASS = "";
        final String QUERY = "SELECT * from users";

        // Open a connection
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(QUERY);) {
            // Extract data from result set
            while (rs.next()) {
                System.out.println("ID: " +rs.getInt("id") + " EMAIL : " + rs.getString("email")+ " REALNAME: " +rs.getString("realname")+ " PASSWORD: " +rs.getString("password"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
