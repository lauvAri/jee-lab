package org.example.lab.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.lab.domain.Account;

import java.io.IOException;

public class ShippingServlet extends HttpServlet {
    private static final String SHIPPINGFORM = "/WEB-INF/jsp/order/shipping.jsp";
    private static final String SIGNONFORM = "/WEB-INF/jsp/account/signon.jsp";

    Account account;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        account = (Account) session.getAttribute("loginAccount");
        if(account == null) {
            req.getRequestDispatcher(SIGNONFORM).forward(req, resp);
        }else {
            req.getRequestDispatcher(SHIPPINGFORM).forward(req, resp);
        }
    }
}
