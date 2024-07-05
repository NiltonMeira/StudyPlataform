package impl;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import repositorie.UserJPARepository;
import service.userService;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DatabaseUserService implements userService {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    UserJPARepository repo;

    @Override
    public Boolean verifyUser(User user) {
        String username = user.getUsername();
        String email = user.getEmail();

        if(email.contains("nilton")) {
            System.out.println("é gayddffd ");
        }

        return repo.findByUsername(username).isEmpty() && repo.findByEmail(email).isEmpty();
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
    public Boolean verifyEmail(User user) {
        String email = user.getEmail();
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
