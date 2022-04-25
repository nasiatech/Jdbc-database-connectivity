package Brunostar;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcCrud {
    static Statement stm = null;
    // Start by establishing a connection with the help of our connection class
    static Connection connection = Conn.creatConnection();

    // Let's write a function that creates a table called interns
    // which contains the id, age, first name, last name
    public static void createTable() throws SQLException {
        // first, let's create a statement
        System.out.println("Creating statement...");
        stm = connection.createStatement();

        System.out.println("Creating table...");
        String query = "CREATE TABLE IF NOT EXIST interns (" +
                " id int not null, " +
                " age int not null, " +
                " first_name varchar (255), " +
                " last_name varchar (255))";

        stm.executeQuery(query);
        System.out.println("Table created successfully");
        stm.close();
    }

    public static void insertInfo(int id, int age, String fName, String lName) throws SQLException {
        // first, let's create a statement
        System.out.println("Creating statement...");
        stm = connection.createStatement();

        System.out.println("Inserting data...");
        String query = "INSERT INTO interns VALUES (" +
                id + "," + age + "," + fName + "," + lName + ")";

        stm.executeQuery(query);
        System.out.println("Data inserted successfully");
        stm.close();
    }

    public static ResultSet readInfo() throws SQLException {
        // first, let's create a statement
        System.out.println("Creating statement...");
        stm = connection.createStatement();

        System.out.println("Reading data...");
        String query = "SELECT * FROM interns";

        ResultSet result  = stm.executeQuery(query);
        System.out.println("Data successfully retrieved");
        stm.close();
        return result;
    }

    public static void updateAge(int id, int age) throws SQLException {
        // first, let's create a statement
        System.out.println("Creating statement...");
        stm = connection.createStatement();

        System.out.println("updating age...");
        String query = "UPDATE interns SET age = " +
                age + " WHERE id = " + id;

        stm.executeQuery(query);
        System.out.println("Age updated successfully");
        stm.close();
    }

    public static void updateName(int id, String fName, String lName) throws SQLException {
        // first, let's create a statement
        System.out.println("Creating statement...");
        stm = connection.createStatement();

        System.out.println("updating name...");
        String query = "UPDATE interns SET first_name = " +
                fName + ", last_name = " + lName +
                " WHERE id = " + id;

        stm.executeQuery(query);
        System.out.println("Names updated successfully");
        stm.close();
    }

    public static void deleteData(int id) throws SQLException {
        // first, let's create a statement
        System.out.println("Creating statement...");
        stm = connection.createStatement();

        System.out.println("Deleting data...");
        String query = "DELETE FROM interns " +
                " WHERE id = " + id;

        stm.executeQuery(query);
        System.out.println("Data deleted successfully");
        stm.close();
    }
}
