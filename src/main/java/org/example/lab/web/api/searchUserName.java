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

@WebServlet("/searchUserName")
public class searchUserName extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        Account account = new AccountService().getAccount(username);
        resp.setContentType(("text/plain"));
        System.out.println(account.getUsername());

        PrintWriter out = resp.getWriter();
        if (account != null && account.getUsername().equals(username)) {
            out.write("true");
        } else {
            out.write("false");
        }
        out.flush();
        out.close();
    }
}
