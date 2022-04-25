package Brunostar;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Driver {
    // this is where we call and execute all our crud operations
    public static void main(String args[]) throws SQLException {
        // lest start by creating the table in our database
        JdbcCrud.createTable();

        // we then insert some data into our table
        JdbcCrud.insertInfo(101, 22,"Tanju", "Brunostar");
        JdbcCrud.insertInfo(102, 21, "Nfon", "Andrew");
        JdbcCrud.insertInfo(103, 20, "Elroy", "Kanye");
        JdbcCrud.insertInfo(104, 20, "Nyong", "Godwill");
        JdbcCrud.insertInfo(105, 20, "Ngumi", "Fien");
        JdbcCrud.insertInfo(106, 20, "Guills", "Lambiv");
        JdbcCrud.insertInfo(107, 18, "Last", "Person");

        // next let's update Fien's age
        JdbcCrud.updateAge(105, 19);

        // let's update Gill's name
        JdbcCrud.updateName(106, "Gills", "Lambive");

        // let's read the content of our table
        ResultSet rs = JdbcCrud.readInfo();
        //STEP 5: Extract data from result set
        displayResult(rs);

        //let's delete the last entry
        JdbcCrud.deleteData(107);

        // let's read the content of our table again
        rs = JdbcCrud.readInfo();

        //Extract data from result set
        displayResult(rs);
    }

    private static void displayResult(ResultSet rs) throws SQLException {
        while(rs.next()) {
            //Retrieve by column name
            int id = rs.getInt("id");
            int age = rs.getInt("age");
            String first = rs.getString("first_name");
            String last = rs.getString("last_name");

            //Display values
            System.out.print("ID: " + id);
            System.out.print(", Age: " + age);
            System.out.print(", First: " + first);
            System.out.println(", Last: " + last);
        }
    }
}
