package com.microshop.demo;

import com.microshop.context.DBContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

@WebServlet("/demo/a05-sqli")
public class SQLInjection_A05 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        String username = req.getParameter("username");

        try (Connection conn = DBContext.getConnection();
             PrintWriter out = resp.getWriter();
             Statement st = conn.createStatement()) {

            String query = "SELECT MaNguoiDung, Email FROM NGUOIDUNG WHERE TenDangNhap = '" + username + "'";
            ResultSet rs = st.executeQuery(query);

            out.println("<h3>Kết quả tìm kiếm (A05)</h3>");
            while (rs.next()) {
                out.println("<p>ID: " + rs.getInt("MaNguoiDung") + " | Email: " + rs.getString("Email") + "</p>");
            }
        } catch (Exception e) {
            resp.getWriter().println("Lỗi truy vấn SQL: " + e.getMessage());
        }
    }
}