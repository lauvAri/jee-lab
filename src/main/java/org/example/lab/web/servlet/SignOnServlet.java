package org.example.lab.web.servlet;

import jakarta.servlet.ServletException;
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

public class SignOnServlet extends HttpServlet {

    private String username;
    private String password;

    private String signOnMsg;

    private static final String SIGN_ON_FORM = "WEB-INF/jsp/account/signon.jsp";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.username = req.getParameter("username");
        this.password = req.getParameter("password");
        //校验用户输入的正确性
        if (validate()) {
            AccountService accountService = new AccountService();
            Account loginAccount = accountService.getAccount(username, password);
            if (loginAccount != null) {
                loginAccount.setPassword(null);
                HttpSession session = req.getSession();
                session.setAttribute("loginAccount", loginAccount);

                if (loginAccount.isListOption()) {
                    CatalogService catalogService = new CatalogService();
                    List<Product> myList = catalogService.getProductListByCategory(loginAccount.getFavouriteCategoryId());
                    session.setAttribute("myList", myList);
                }

                resp.sendRedirect("mainForm");
            } else {
                this.signOnMsg = "用户名或者密码错误";
                req.getRequestDispatcher(SIGN_ON_FORM).forward(req, resp);
            }
        } else {
            req.setAttribute("signOnMsg", signOnMsg);
            req.getRequestDispatcher(SIGN_ON_FORM).forward(req, resp);
        }
    }

    private boolean validate() {
        if (username == null || username.trim().equals("")) {
            this.signOnMsg = "用户名不能为空";
            return false;
        }
        if (password == null || password.trim().equals("")) {
            this.signOnMsg = "密码不能为空";
            return false;
        }
        return true;
    }
}
