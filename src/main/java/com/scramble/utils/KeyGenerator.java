package com.scramble.utils;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;

import java.security.NoSuchAlgorithmException;

public class KeyGenerator {

    public static String generatePublicKey() {
        try {
            // Generate Key Pair
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(2048);
            KeyPair keyPair = keyPairGenerator.generateKeyPair();

            // Get Public Key
            PublicKey publicKey = keyPair.getPublic();
            String publicKeyBase64 = Base64.getEncoder().encodeToString(publicKey.getEncoded());

            // Add header to the public key
            String publicKeyWithHeader = "-----BEGIN PUBLIC KEY-----\n" + publicKeyBase64 + "\n-----END PUBLIC KEY-----";

            return publicKeyWithHeader;
        } catch (NoSuchAlgorithmException e) {
            System.err.println("Error generating RSA keys: " + e.getMessage());
            return null;
        }
    }

    public static String generatePrivateKey() {
        try {
            // Generate Key Pair
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(2048);
            KeyPair keyPair = keyPairGenerator.generateKeyPair();

            // Get Private Key
            PrivateKey privateKey = keyPair.getPrivate();
            String privateKeyBase64 = Base64.getEncoder().encodeToString(privateKey.getEncoded());

            // Add header to the private key
            String privateKeyWithHeader = "-----BEGIN PRIVATE KEY-----\n" + privateKeyBase64 + "\n-----END PRIVATE KEY-----";

            return privateKeyWithHeader;
        } catch (NoSuchAlgorithmException e) {
            System.err.println("Error generating RSA keys: " + e.getMessage());
            return null;
        }
    }
}
