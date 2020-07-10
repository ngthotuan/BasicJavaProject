package Main;

import Controllers.PojoController.UserController;
import pojo.User;

public class MainClass {

    public static void main(String[] args) {

        User user = new User();
        user.setUsername("admin");
        user.setPassword("admin");
        System.out.println("UserController.login(user.getUsername(), user.getPassword()) = " + UserController.login(user.getUsername(), user.getPassword()));

    }
}
