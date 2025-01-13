package com.jonathandiz.screen_match.ssl;

import javax.crypto.Cipher; 
import javax.crypto.KeyGenerator; 
import javax.crypto.SecretKey; 
import javax.crypto.spec.SecretKeySpec; 
import java.util.Base64;

public class EncryptionService {
    private static final String ALGORITHM = "AES";

    public String encrypt(String data, String secretKey) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        SecretKey key = new SecretKeySpec(secretKey.getBytes(), ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedData = cipher.doFinal(data.getBytes());
        return Base64.getEncoder().encodeToString(encryptedData);
    }

    public String decrypt(String encryptedData, String secretKey) throws Exception {
       Cipher cipher = Cipher.getInstance(ALGORITHM);
       SecretKey key = new SecretKeySpec(secretKey.getBytes(), ALGORITHM);
       cipher.init(Cipher.DECRYPT_MODE, key);
       byte[] decodedData = Base64.getDecoder().decode(encryptedData); 
       return new String(cipher.doFinal(decodedData));
    }
}