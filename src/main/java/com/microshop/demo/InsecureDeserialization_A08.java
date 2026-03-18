package com.microshop.demo;
import java.io.*;

public class InsecureDeserialization_A08 {
    // CWE-502: Deserialization of Untrusted Data.
    public Object deserializeUser(InputStream in) throws Exception {
        ObjectInputStream ois = new ObjectInputStream(in);
        return ois.readObject(); 
    }
}