import java.sql.*;

public class Driver extends JdbcCrud{
    public static void main(String[] args) {
        JdbcCrud j = new JdbcCrud();
        j.createData("nfon", "blablabal");
        j.readData();
        j.deleteData(1);
        j.updateUserName(2, "tata");
    }
}