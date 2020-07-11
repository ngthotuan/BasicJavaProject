package Main;

import Controllers.PojoController.UserController;
import Model.Pojo.User;

import java.util.List;

public class MainClass {

    public static void main(String[] args) {
        User user = new User();
        user.setUsername("admin1");
        user.setPassword("admin1");
        System.out.println(UserController.createUser(user));
        List<User> users = UserController.getUsers();
        System.out.println(users.get(0).getMeetingAccountsByUsername());
    }
}
