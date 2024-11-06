package org.example.lab.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.lab.domain.Account;
import org.example.lab.persistence.DBUtil;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet(name= "changePassword" , urlPatterns = "/changePassword")
public class ChangePasswordServlet extends HttpServlet {

    private static final String UPDATE_SIGNON = "UPDATE SIGNON SET\n" +
            "PASSWORD = ?\n"+
            "WHERE USERNAME = ? AND PASSWORD = ?";

    private static final String MAIN_URL = "/mainForm";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Account account = (Account) req.getSession().getAttribute("loginAccount");
        String username = account.getUsername();
        String newPassword = req.getParameter("newPassword");
        String oldPassword = req.getParameter("originalPassword");
        System.out.println(username);
        System.out.println(newPassword);
        System.out.println(oldPassword);

        int row = -1;
        try {
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(UPDATE_SIGNON);
            ps.setString(1, newPassword);
            ps.setString(2, username);
            ps.setString(3, oldPassword);
            row = ps.executeUpdate();
            DBUtil.closePreparedStatement(ps);
            DBUtil.closeConnection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (row == 1) {
            resp.sendRedirect(req.getContextPath() + MAIN_URL);
        } else {
            HttpSession session = req.getSession();
            session.setAttribute("changePasswordInfo", "origin password is wrong");
            resp.sendRedirect(req.getContextPath() + "/changePasswordView");
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
