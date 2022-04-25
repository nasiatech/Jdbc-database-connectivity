package elroykanye;

import java.sql.Connection;

public class Connector {

    private final String USER = "root";
    private final String DB_URL = "jdbc:mysql://localhost:3306";
    private final String PASS = "";
    private static Connection connection;

    private void createConnection(String url, String user, String pass) {
        // register driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            connection = java.sql.DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Connector() {
        createConnection(DB_URL, USER, PASS);
    }

    public Connector(String url, String user, String pass) {
        createConnection(url, user, pass);
    }

    public Connection getConnection() {
        return connection;
    }
}
