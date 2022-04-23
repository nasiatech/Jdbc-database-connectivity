package com.godydev.demjdbc;

import  java.sql.*;
public class Connect {

    //Driver for JDBC and Database URL
    static final String JDBC_D = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/nasiaintern";

    //Database Credentials
    static final String user = "root";
    static final String pass = "";

    //Database connection
    static Connection connection;


    Connection connect = null;
    Statement state = null;
    ResultSet rs = null;

    private static void RegDriver() {
        try {
            //Register driver
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    static Connection createConnection() {
        RegDriver();
        try {
            //open connection
            System.out.println("Connecting");
            Connection connect = DriverManager.getConnection(DB_URL, user, pass);
            connection = connect;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
       /* try {
            //Executing some queries
            System.out.println("Creating Connection");
            state = connect.createStatement();
            String sql;
            sql = "select * from nasiaintern";
            ResultSet rs = state.executeQuery(sql);

            while (rs.next()){
                System.out.println(rs.getString("track"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        */

    private static void closeConnect() {
        try {
            //closing connection
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}

