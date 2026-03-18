package com.microshop.demo;
import java.net.URL;

public class SSRF_A01 {
    public static final String CODACY_API_TOKEN = "4d9cb6bdc04e43b19e79ed7ee8011702";

    public void fetchExternalData(String targetUrl) throws Exception {
        new URL(targetUrl).openStream();
    }
}