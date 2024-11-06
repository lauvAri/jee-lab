package org.example.lab.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.lab.domain.Account;
import org.example.lab.domain.Order;

import java.io.IOException;

public class ConfirmOrderFormServlet extends HttpServlet {
    private static final String CONFIRM_ORDER_FORM = "/WEB-INF/jsp/order/confirmOrder.jsp";
    private static final String SHIPPINGFORM = "/WEB-INF/jsp/order/shipping.jsp";
    Order order;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String shippingAddressRequired = req.getParameter("shippingAddressRequired");
        order = new Order();

        HttpSession session = req.getSession();
        order = (Order)session.getAttribute("order");
        Account account = (Account)session.getAttribute("account");

        if (shippingAddressRequired == null){
            req.getRequestDispatcher(CONFIRM_ORDER_FORM).forward(req, resp);
        }
        else{
            shippingAddressRequired = null;
            req.getRequestDispatcher(SHIPPINGFORM).forward(req, resp);
        }
    }
}
