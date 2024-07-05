package service;

import model.User;
import java.util.List;

public interface userService{
    Boolean verifyUser(User user);
    Boolean verifyPassword(User user);
    Boolean verifyEmail(User user);
    List<User> findByUsername(String username);
    List<User> findByEmail(String email);
}

