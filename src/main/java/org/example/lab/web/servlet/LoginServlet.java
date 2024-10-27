package org.example.lab.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.lab.domain.Account;
import org.example.lab.domain.Product;
import org.example.lab.service.AccountService;
import org.example.lab.service.CatalogService;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "login" , urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    private String username;
    private String password;
    private String loginMsg;
    private String status;
    private static final String LOGIN_VIEW = "/WEB-INF/jsp/account/login.jsp";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        username = (String) req.getParameter("username");
        password = (String) req.getParameter("password");
        HttpSession session = req.getSession();
        //校验用户输入的正确性
        if (validate()) {
            AccountService accountService = new AccountService();
            Account loginAccount = accountService.getAccount(username, password);
            if (loginAccount != null) {
                loginAccount.setPassword(null);
                session.setAttribute("loginAccount", loginAccount);

                if (loginAccount.isListOption()) {
                    CatalogService catalogService = new CatalogService();
                    List<Product> myList = catalogService.getProductListByCategory(loginAccount.getFavouriteCategoryId());
                    session.setAttribute("myList", myList);
                }

                resp.sendRedirect("mainForm");
            } else {
                this.loginMsg = "用户名或者密码错误";
                this.status = "failed";
                req.setAttribute("loginMsg", loginMsg);
                req.setAttribute("status", status);
                req.getRequestDispatcher(LOGIN_VIEW).forward(req, resp);
            }
        } else {
            req.setAttribute("loginMsg", loginMsg);
            req.setAttribute("status", status);
            req.getRequestDispatcher(LOGIN_VIEW).forward(req, resp);
        }
    }

    private boolean validate() {
        if (username == null || username.trim().equals("")) {
            this.loginMsg = "用户名不能为空";
            this.status = "failed";
            return false;
        }
        if (password == null || password.trim().equals("")) {
            this.loginMsg = "密码不能为空";
            this.status = "failed";
            return false;
        }
        return true;
    }
}