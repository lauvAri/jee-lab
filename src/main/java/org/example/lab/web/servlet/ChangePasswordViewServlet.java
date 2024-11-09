package org.example.lab.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/changePasswordView")
public class ChangePasswordViewServlet extends HttpServlet {

    private static final String CHANGE_PASSWORD= "/WEB-INF/jsp/account/changePassword.jsp";
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher(CHANGE_PASSWORD).forward(request, response);
    }
}
