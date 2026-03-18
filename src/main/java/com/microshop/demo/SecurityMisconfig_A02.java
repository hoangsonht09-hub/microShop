package com.microshop.demo;
import jakarta.servlet.http.*;
import java.io.IOException;

public class SecurityMisconfig_A02 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            int error = 1 / 0;
        } catch (Exception e) {
            e.printStackTrace(resp.getWriter());
        }
    }
}