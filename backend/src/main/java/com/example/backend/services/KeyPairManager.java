package com.example.backend.services;

import lombok.Getter;

import java.security.*;

public class KeyPairManager {

    @Getter
    private PublicKey publicKey;

    @Getter
    private PrivateKey privateKey;

    public KeyPairManager() {
        KeyPairGenerator keyPairGenerator;
        try{
            keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(2048);
            KeyPair keyPair = keyPairGenerator.generateKeyPair();
            publicKey = keyPair.getPublic();
            privateKey = keyPair.getPrivate();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
