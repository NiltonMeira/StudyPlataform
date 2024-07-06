package interfaces;

import dto.user.UserCreator;
import model.User;
import java.util.List;

public interface UserInterface {
    Boolean verifyUser(String username, String email);
    Boolean verifyPassword(String password);
    Boolean verifyEmail(String email);
    List<User> findByUsername(String username);
    List<User> findByEmail(String email);
    User newUser(UserCreator userCreator);
}

