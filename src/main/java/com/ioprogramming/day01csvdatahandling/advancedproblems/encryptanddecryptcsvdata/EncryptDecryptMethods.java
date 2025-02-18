package com.ioprogramming.day01csvdatahandling.advancedproblems.encryptanddecryptcsvdata;

import javax.crypto.*;
import javax.crypto.spec.*;
import java.util.Base64;

public class EncryptDecryptMethods {
    public static String encrypt(String data, String secretKey) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        SecretKeySpec key = new SecretKeySpec(secretKey.getBytes(), "AES");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedData = cipher.doFinal(data.getBytes());
        return Base64.getEncoder().encodeToString(encryptedData);
    }

    // AES decryption method
    public static String decrypt(String encryptedData, String secretKey) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        SecretKeySpec key = new SecretKeySpec(secretKey.getBytes(), "AES");
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decryptedData = cipher.doFinal(Base64.getDecoder().decode(encryptedData));
        return new String(decryptedData);
    }
}

