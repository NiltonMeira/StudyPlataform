package interfaces;

import model.User;
import java.util.List;

public interface UserInterface {
    Boolean verifyUser(String username, String email);
    Boolean verifyPassword(User user);
    Boolean verifyEmail(User user);
    List<User> findByUsername(String username);
    List<User> findByEmail(String email);
}

