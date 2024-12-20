package org.example.lab.web.api;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.lab.domain.Account;
import org.example.lab.service.AccountService;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/api/getUserFromSession")
public class getUserFromSession extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain");
        String password = req.getParameter("password");
        HttpSession session = req.getSession();
        Account loginAccount = (Account) session.getAttribute("loginAccount");
        String name = loginAccount.getUsername();
        Account account = new AccountService().getAccount(name, password);
        PrintWriter out = resp.getWriter();
        if (account != null && account.getUsername().equals(name)) {
            out.write("true");
        } else {
            out.write("false");
        }
        out.close();
    }
}
