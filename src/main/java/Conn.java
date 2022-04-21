import java.sql.*;

public class Conn {
    //create a database connection here
    Statement stmt = null;
    Connection conn = null;
    ResultSet rs = null;

    static Connection connection;
    static final String DB_URL = "jdbc:mysql://localhost/platform";
    static final String USER = "root";
    static final String PASS = "";

    private static void RegisterDriver(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    static Connection createConnection(){
        RegisterDriver();
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            connection = conn;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;

    }

    private static void closeCon(){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
