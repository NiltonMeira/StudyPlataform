package com.example.backend.services;

import com.example.backend.dto.user.UpdatePasswordDto;
import com.example.backend.dto.user.UserCreatorDto;
import com.example.backend.exceptions.ConflictException;
import com.example.backend.exceptions.InvalidEmailException;
import com.example.backend.exceptions.InvalidPasswordException;
import com.example.backend.exceptions.ObjectNotFindException;
import com.example.backend.interfaces.UserInterface;
import com.example.backend.model.User;
import com.example.backend.repositories.UserJPARepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.beans.Encoder;
import java.util.Base64;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class DatabaseUserService implements UserInterface {

    @Autowired
    UserJPARepository repo;

    @Qualifier("userBean")
    @Lazy
    @Autowired
    UserInterface service;

    @Override
    public User newUser(UserCreatorDto userCreator) {
        if (!verifyUser(userCreator.username(), userCreator.email())){
            throw new ConflictException();
        }

        if (!verifyEmail(userCreator.email()))
            throw new InvalidEmailException(); // create a wrong email exeption

        String password = createPassword(userCreator.username(),userCreator.role().name(),userCreator.cpf());
        User user = new User(userCreator.username(),userCreator.email(), password,userCreator.role(),userCreator.cpf(),userCreator.cep(),userCreator.street(),userCreator.neighborhood(),userCreator.housenumber());
        repo.save(user);
        return user;
    }

    @Override
    public String changePassword(UpdatePasswordDto updatePasswordDto, String token) {
        var user = repo.findByEmail(updatePasswordDto.email());
        if (user.isEmpty())
            throw new ObjectNotFindException();
        if (!verifyPassword(updatePasswordDto.newPassword()))
            throw new InvalidPasswordException();

        String[] chunks = token.split("\\.");
        Base64.Decoder decoder = Base64.getDecoder();
        String payload = new String(decoder.decode(chunks[1]));
        System.out.println(payload);

        user.getFirst().setPassword(PasswordEncoder.encode(updatePasswordDto.newPassword()));
        repo.save(user.getFirst());
        return PasswordEncoder.encode(updatePasswordDto.newPassword());
    }

    public String createPassword(String username, String role, String cpf) {
//        var rawPassword = username + role + cpf;
//        System.out.println(rawPassword);
//        return encode(rawPassword);
        return "123456";
    }

    @Override
    public Boolean verifyUser(String username, String email) {
        return findByUsername(username).isEmpty() && findByEmail(email).isEmpty();
    }

    @Override
    public Boolean verifyPassword(String password) {

        if (password.length() < 6)
            return false;

        Pattern specialCharsPattern = Pattern.compile("[^a-zA-Z0-9]");
        Matcher specialCharsMatcher = specialCharsPattern.matcher(password);

        if (!specialCharsMatcher.find())
            return false;

        Pattern uppercasePattern = Pattern.compile("[A-Z]");
        Matcher uppercaseMatcher = uppercasePattern.matcher(password);

        if (!uppercaseMatcher.find()) {
            return false;
        }

        Pattern digitPattern = Pattern.compile("[0-9]");
        Matcher digitMatcher = digitPattern.matcher(password);

        return digitMatcher.find();

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

    public Boolean validatePassword(String newPassword, String oldPassword) {
        return PasswordEncoder.matches(newPassword, oldPassword);
    }

}
