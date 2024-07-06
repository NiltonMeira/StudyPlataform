package interfaces;

import dto.user.UserCreator;
import dto.user.UserPostReturn;
import model.User;
import java.util.List;

public interface UserInterface {
    Boolean verifyUser(String username, String email);
    Boolean verifyPassword(User user);
    Boolean verifyEmail(String email);
    List<User> findByUsername(String username);
    List<User> findByEmail(String email);
    UserPostReturn checkUser(UserCreator userCreator);
}

