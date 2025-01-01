package org.example.lab.web.api;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.lab.domain.Account;
import org.example.lab.service.AccountService;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/searchUserNameAndPassword")
public class searchUserNameAndPassword extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        Account account = new AccountService().getAccount(username, password);

        PrintWriter out = resp.getWriter();
        if (account != null) {
            out.write("true");
        } else {
            out.write("false");
        }
        out.close();
    }
}
