package org.example.lab.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.lab.domain.Account;
import org.example.lab.persistence.DBUtil;
import org.example.lab.service.AccountService;

import java.io.IOException;
import java.sql.*;

@WebServlet(name = "registration", urlPatterns = "/registration")
public class RegistrationServlet extends HttpServlet {

    private static final String REGISTER_VIEW = "/WEB-INF/jsp/account/registration.jsp";
    private static final String LOGIN_URL = "loginView";
    private String username;
    private String password;
    private String email;
    private String favouriteCategoryId;
    private String registrationMsg;
    private String registrationStatus;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        username = req.getParameter("name");
        password = req.getParameter("pass");
        email = req.getParameter("email");
        favouriteCategoryId = req.getParameter("favcategory");

        if (!registered()) {
            Account account = new Account();
            account.setUsername(username);
            account.setPassword(password);
            account.setEmail(email);
            account.setFavouriteCategoryId(favouriteCategoryId);
            account.setListOption(true);
            account.setBannerOption(true);

            AccountService accountService = new AccountService();
            accountService.insertAccount(account);
            resp.sendRedirect(req.getContextPath() + LOGIN_URL);
        } else {
            this.registrationMsg = "you have registered this website";
            this.registrationStatus = "failed";
            req.setAttribute("registrationMsg", this.registrationMsg);
            req.setAttribute("registrationStatus", this.registrationStatus);
            req.getRequestDispatcher(REGISTER_VIEW).forward(req, resp);
        }
    }

    boolean registered () {
        try {
            Connection conn = DBUtil.getConnection();
            String selectQuery = "select * from account where userid='" + username + "'";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(selectQuery);
            if (resultSet.next()) {
                return true;
            } return false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
