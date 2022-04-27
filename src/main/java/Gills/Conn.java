package Gills;

import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import com.sun.jdi.ClassNotLoadedException;
import java.lang.*;

import java.sql.*;

public class Conn {
    static final String driver = "com.mysql.cj.jdbc.Driver";
    static final String url = "jdbc:mysql://localhost:3306/triggers";
    static final String user = "root";
    static final String pw = "";
    public static Connection connection;

    public static void createConnection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        try{
            connection = DriverManager.getConnection(url, user, pw);
        }catch(SQLException sqlException){
           sqlException.printStackTrace();
        }
       
       
    }
    public static Connection getConnection() {
    	 return connection;
    }

}
