package elroykanye;

import elroykanye.data.DataSource;
import elroykanye.data.User;
import elroykanye.data.UserRepo;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
        User elroykanye = new User(null,"elroykanye", "Elroy", "Kanye", "elroykanye@gmail.com", "password");
        DataSource.getInstance().init();

        UserRepo userRepo = new UserRepo();

        userRepo.createUser(elroykanye);
        System.out.println(userRepo.findUserByUsername("elroykanye"));

        User elroykanye2 = new User(null,"elroykanye", "Elroy", "Kanye", "elroykdev@gmail.com", "password");
        userRepo.updateUser(elroykanye2);
        System.out.println(userRepo.findUserByUsername("elroykanye"));


    }
}
