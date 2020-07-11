package Controllers.PojoController;

import Model.Pojo.User;
import Utils.Password;

import java.util.List;

public class UserController extends BasicDAO{

    public static User getUser(String username){
        return (User) get(username, User.class);
    }
    public static List<User> getUsers(){
        return (List<User>) getAll("User");
    }

    public static boolean createUser(User user) {
        if(getUser(user.getUsername()) != null){
            return false;
        }
        else {
            user.setPassword(Password.genPassword(user.getPassword()));
            return create(user);
        }
    }
    public static boolean updateUser(User user) {
        if(getUser(user.getUsername()) == null){
            return false;
        }
        else {
            user.setPassword(Password.genPassword(user.getPassword()));
            return update(user);
        }
    }
    public static User login(String username, String password) {
        User user = getUser(username);
        if(user != null){
            boolean check = Password.checkPassword(password, user.getPassword());
            if(!check) user = null;
        }
        return user;
    }
}
