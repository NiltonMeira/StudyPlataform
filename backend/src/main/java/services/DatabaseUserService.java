package services;

import dto.user.UserCreator;
import dto.user.UserPostReturn;
import exceptions.ConflictException;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositoriess.UserJPARepository;
import interfaces.UserInterface;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
@Service
public class DatabaseUserService implements UserInterface {

    @Autowired
    UserJPARepository repo;

    @Autowired
    UserInterface service;

    @Override
    public UserPostReturn newUser(UserCreator userCreator) {
        if (!verifyUser(userCreator.username(), userCreator.email()))
            throw new ConflictException();

        if (!verifyEmail(userCreator.email()))
            throw new ConflictException(); // create a wrong email exeption



        return service.checkUser(userCreator);
    }

    @Override
    public Boolean verifyUser(String username, String email) {
        var Test = repo.findBy(username);
    }

    @Override
    public Boolean verifyPassword(User user) {
        String password = user.getPassword();

        if (password.length() < 6)
            return false;

        Pattern specialCharsPattern = Pattern.compile("[^a-zA-Z0-9]");
        Matcher specialCharsMatcher = specialCharsPattern.matcher(password);

        if (specialCharsMatcher.find())
            return false;

        Pattern uppercasePattern = Pattern.compile("[A-Z]");
        Matcher uppercaseMatcher = uppercasePattern.matcher(password);

        if (!uppercaseMatcher.find()) {
            return false;
        }

        Pattern digitPattern = Pattern.compile("[0-9]");
        Matcher digitMatcher = digitPattern.matcher(password);

        if (!digitMatcher.find()) {
            return false;
        }

        return true;

    }

    @Override
    public Boolean verifyEmail(String email) {
        String email_regex = "^([\\w\\.-]+)@([\\w\\-]+)((\\.(\\w){2,3})+)$";

        Pattern pattern = Pattern.compile(email_regex);
        Matcher matcher = pattern.matcher(email);

        return matcher.matches();
    }

    @Override
    public List<User> findByUsername(String username) {
        return repo.findByUsername(username);
    }

    @Override
    public List<User> findByEmail(String email) {
        return repo.findByEmail(email);
    }


}
