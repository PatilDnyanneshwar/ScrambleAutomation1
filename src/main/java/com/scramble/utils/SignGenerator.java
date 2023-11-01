package com.scramble.utils;

import java.security.KeyFactory;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;

public class SignGenerator {

    public static String generateSignature(String input, String privateKey) {

        System.out.println("input =" + input);
        String strPk = privateKey;

        try {
            // Remove markers and new line characters in private key
            String realPK = privateKey.replaceAll("-----END PRIVATE KEY-----", "")
                    .replaceAll("-----BEGIN PRIVATE KEY-----", "")
                    .replaceAll("\n", "");

            byte[] b1 = Base64.getDecoder().decode(realPK);
            PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(b1);
            KeyFactory kf = KeyFactory.getInstance("RSA");
            Signature privateSignature = Signature.getInstance("SHA256withRSA");
            privateSignature.initSign(kf.generatePrivate(spec));
            privateSignature.update(input.getBytes("UTF-8"));
            byte[] s = privateSignature.sign();
            String base64Signature = Base64.getEncoder().encodeToString(s);

            return base64Signature;
        } catch (Exception e) {
            System.err.println("Error generating RSA signature: " + e.getMessage());
            return null;
        }
    }
}
