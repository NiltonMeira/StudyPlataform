package com.example.backend.services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.example.backend.dto.UserLoginDto;
import com.example.backend.exceptions.InvalidtokenException;
import com.example.backend.exceptions.ObjectNotFindException;
import com.example.backend.interfaces.LoginInterface;
import com.example.backend.repositories.UserJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

@Service
public class LoginService  implements LoginInterface {

    @Autowired
    UserJPARepository repo;

    KeyPairManager keyPairManager = new KeyPairManager();

    PublicKey publicKey = keyPairManager.getPublicKey();
    PrivateKey privateKey = keyPairManager.getPrivateKey();


    @Override
    public Boolean checkLogin(String email, String password) {

        if (repo.findByEmail(email) == null)
            throw new ObjectNotFindException();

        return null;
    }

    @Override
    public String doLogin(UserLoginDto userLoginDto) {
        var users = repo.findByEmail(userLoginDto.email());
        var oldPassword = users.getFirst().getPassword();
        var isValidLogin = validateLogin(userLoginDto.password(), oldPassword);

        if (isValidLogin)
            return createToken(publicKey,privateKey,userLoginDto.email());

        throw new InvalidtokenException();
    }

    public String createToken(PublicKey publicKey, PrivateKey privateKey, String email) {
        try {
            Algorithm algorithm = Algorithm.RSA256((RSAPublicKey) publicKey, (RSAPrivateKey) privateKey);

            return JWT.create()
                    .withIssuer("studyPlatform")
                    .withSubject(Long.toString(repo.findByEmail(email).getFirst().getId()))
                    .withClaim("Roles", repo.findByEmail(email).getFirst().getRole().name())
                    .sign(algorithm);

        } catch (JWTCreationException exception) {
            throw new InvalidtokenException();
        }
    }

    public Boolean validateLogin (String loginPassword, String SavedPassword) {
        PasswordEncoder encoder = new PasswordEncoder();
        return encoder.matches(loginPassword, SavedPassword);
    }
}
