package elroykanye.data;

import elroykanye.Connector;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Logger;

public class DataSource {
    private final Logger logger = Logger.getLogger(DataSource.class.getName());
    private static DataSource instance;

    public static Connection connection;

    public static DataSource getInstance() {
        if (instance == null) {
            instance = new DataSource();
        }
        return instance;
    }

    private DataSource() {
        logger.info("DataSource created");
        connection = new Connector(Config.DB_SERVER_URL, Config.DB_USER, Config.DB_PASS).getConnection();
    }

    public void init() {
        logger.info("DataSource initialized");
        createDatabase();
    }

    private void createDatabase() {
        try {
            new Connector().getConnection().createStatement()
                    .execute("CREATE DATABASE IF NOT EXISTS jdbc_elroykanye");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
