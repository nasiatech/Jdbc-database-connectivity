package elroykanye.data;

import elroykanye.Connector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.logging.Logger;

public class UserRepo {

    Connection connection;
    PreparedStatement preparedStatement;
    ResultSet resultSet;
    Logger logger;

    public UserRepo() {
        logger = Logger.getLogger(UserRepo.class.getName());

        this.connection = new Connector(Config.DB_URL, Config.DB_USER, Config.DB_PASS).getConnection();
        this.setCatalog();
        createUserTable();
    }

    private void setCatalog() {
        try {
            this.connection.setCatalog(Config.DB_NAME);
        } catch (SQLException e) {
            logger.warning("Could not use database");
        }
    }
    private void createUserTable() {
        try {
            this.connection.prepareStatement(
                    """
                            create table `users` (
                              `id` int(11) NOT NULL AUTO_INCREMENT,
                              `username` varchar(255) NOT NULL,
                              `password` varchar(255) NOT NULL,
                              `email` varchar(255) NOT NULL,
                              `first_name` varchar(255) NOT NULL,
                              `last_name` varchar(255) NOT NULL,
                              PRIMARY KEY (`id`)
                            ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
                    """).executeUpdate();
            logger.info("User table created successfully");
        } catch (SQLException e) {
            logger.severe("Error creating user table: " + e.getMessage());
        }
    }

    public boolean createUser(User user) {
        if(this.findUserByUsername(user.username()) != null) {
            logger.info("User already exists");
            return false;
        }
        String sql = "INSERT INTO " + Config.USER_TABLE + " (username, password, email, first_name, last_name) VALUES (?, ?, ?, ?, ?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.username());
            preparedStatement.setString(2, user.password());
            preparedStatement.setString(3, user.email());
            preparedStatement.setString(4, user.firstName());
            preparedStatement.setString(5, user.lastName());

            preparedStatement.executeUpdate();

            logger.info("User created successfully");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            // log an error
            logger.severe("Error creating user: " + e.getMessage());
        }
        return false;
    }

    public User findUserByUsername(String username) {
        String sql = "SELECT * FROM " + Config.USER_TABLE + " WHERE username = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);

            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                logger.info("User found");
                return new User(
                        resultSet.getInt("id"),
                        resultSet.getString("username"),
                        resultSet.getString("password"),
                        resultSet.getString("email"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name")
                        );
            } else {
                logger.info("User not found");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.severe("Error finding user: " + e.getMessage());
        }
        return null;
    }

    public boolean updateUser(User user) {
        String sql = "UPDATE users SET password = ?, email = ?, first_name = ?, last_name = ? WHERE username = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.password());
            preparedStatement.setString(2, user.email());
            preparedStatement.setString(3, user.firstName());
            preparedStatement.setString(4, user.lastName());
            preparedStatement.setString(5, user.username());

            preparedStatement.executeUpdate();

            logger.info("User updated successfully");
            return true;
        } catch (Exception e) {
            logger.severe("Error updating user: " + e.getMessage());
        }
        return false;
    }

    public boolean deleteUser(User user) {
        String sql = "DELETE FROM users WHERE username = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.username());
            preparedStatement.executeUpdate();
            return true;
        } catch (Exception e) {
            logger.severe("Error deleting user: " + e.getMessage());
        }
        return false;
    }
}
