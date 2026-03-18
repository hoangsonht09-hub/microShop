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
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet("/demo/a01-idor")
public class BrokenAccessControl_A01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        String targetUserId = req.getParameter("id"); 

        try (Connection conn = DBContext.getConnection();
             PrintWriter out = resp.getWriter()) {

            String sql = "SELECT TenDangNhap, Email, SoDienThoai, VaiTro FROM NGUOIDUNG WHERE MaNguoiDung = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, targetUserId);
            ResultSet rs = ps.executeQuery();

            out.println("<h3>Kết quả IDOR (A01)</h3>");
            if (rs.next()) {
                out.println("<p>Tài khoản: " + rs.getString("TenDangNhap") + "</p>");
                out.println("<p>Email: " + rs.getString("Email") + "</p>");
                out.println("<p>SĐT: " + rs.getString("SoDienThoai") + "</p>");
            } else {
                out.println("<p>Không tìm thấy user.</p>");
            }
        } catch (Exception e) {
            resp.setStatus(500);
            resp.getWriter().println("Lỗi Server: " + e.getMessage());
        }
    }
}