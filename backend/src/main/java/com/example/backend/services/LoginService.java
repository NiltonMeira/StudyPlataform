package com.example.backend.services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.example.backend.enums.Roles;
import com.example.backend.exceptions.InvalidtokenException;
import com.example.backend.exceptions.ObjectNotFindException;
import com.example.backend.interfaces.LoginInterface;
import com.example.backend.repositories.UserJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.AlgorithmConstraints;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

@Service
public class LoginService  implements LoginInterface {

    @Autowired
    UserJPARepository repo;

    @Override
    public Boolean checkLogin(String email, String password) {

        if (repo.findByEmail(email) == null)
            throw new ObjectNotFindException();

        return null;
    }

    public String createToken(PublicKey publicKey, PrivateKey privateKey, String email) {
        try {
            Algorithm algorithm = Algorithm.RSA256((RSAPublicKey) publicKey, (RSAPrivateKey) privateKey);
            String token = JWT.create()
                    .withIssuer("studyPlatform")
                    .withSubject(Long.toString(repo.findByEmail(email).getFirst().getId()))
                    .withClaim("Roles", repo.findByEmail(email).getFirst().getRole().name())
                    .sign(algorithm);
            return token;
        } catch (JWTCreationException exception) {
            throw new InvalidtokenException();
        }

    }
}
