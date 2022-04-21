import java.sql.*;

public class Driver extends JdbcCrud{
    public static void main(String[] args) {
        JdbcCrud j = new JdbcCrud();
        j.readData();
    }
}