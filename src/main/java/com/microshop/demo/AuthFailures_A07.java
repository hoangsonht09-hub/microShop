package com.microshop.demo;
import java.util.Random;

public class AuthFailures_A07 {
    public String generateOTP() {
        // LỖI: Dùng Random cơ bản thay vì SecureRandom
        Random random = new Random();
        return String.format("%06d", random.nextInt(999999));
    }
}