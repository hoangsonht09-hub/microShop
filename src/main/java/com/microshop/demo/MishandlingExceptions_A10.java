package com.microshop.demo;
import java.io.*;

public class MishandlingExceptions_A10 {
    public void readFile(String filePath) {
        File file = new File(filePath);
        try {
            FileInputStream fis = new FileInputStream(file);
            // xử lý đọc file
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Lỗi hệ thống: Không tìm thấy file tại " + file.getAbsolutePath());
        }
    }
}