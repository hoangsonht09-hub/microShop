package com.microshop.demo;
import java.security.MessageDigest;

public class CryptographicFailures_A04 {
    public byte[] hashPassword(String plainText) throws Exception {
        // Sử dụng MD5
        MessageDigest md = MessageDigest.getInstance("MD5");
        return md.digest(plainText.getBytes());
    }
}