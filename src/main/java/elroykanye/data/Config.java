package elroykanye.data;

public class Config {
    public static final String DB_NAME = "jdbc_elroykanye";
    public static final String DB_USER = "root";
    public static final String DB_PASS = "";

    public static final String DB_SERVER_URL = "jdbc:mysql://localhost:3306/";
    public static final String DB_URL = DB_SERVER_URL.concat(DB_NAME);

    public static final String DB_HOST = "localhost";
    public static final String DB_PORT = "3306";

    // users
    public static final String USER_TABLE = "users";
}
