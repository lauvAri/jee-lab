package org.example.lab.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import jakarta.servlet.http.HttpSession;
import org.example.lab.domain.Account;
import org.example.lab.domain.Order;

public class CommitOrderServlet extends HttpServlet {
    private static final String CONFIRM_ORDER_FORM = "/WEB-INF/jsp/order/confirmOrder.jsp";

    private Order order;
    private String shipToFirstName;
    private String shipToLastName;
    private String shipAddress1;
    private String shipAddress2;
    private String shipCity;
    private String shipState;
    private String shipZip;
    private String shipCountry;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        shipToFirstName = req.getParameter("order.shipToFirstName");
        shipToLastName = req.getParameter("order.shipToLastName");
        shipAddress1 = req.getParameter("order.shipAddress1");
        shipAddress2 = req.getParameter("order.shipAddress2");
        shipCity = req.getParameter("order.shipCity");
        shipState = req.getParameter("order.shipState");
        shipZip = req.getParameter("order.shipZip");
        shipCountry = req.getParameter("order.shipCountry");

        HttpSession session = req.getSession();
        order = (Order)session.getAttribute("order");
        order.setShipToFirstName(shipToFirstName);
        order.setShipToLastName(shipToLastName);
        order.setShipAddress1(shipAddress1);
        order.setShipAddress2(shipAddress2);
        order.setShipCity(shipCity);
        order.setShipState(shipState);
        order.setShipZip(shipZip);
        order.setCourier(shipCountry);

        session.setAttribute("order", order);

        session.setAttribute("order.shipToFirstName", shipToFirstName);
        session.setAttribute("order.shipToLastName", shipToLastName);
        session.setAttribute("order.shipAddress1", shipAddress1);
        session.setAttribute("order.shipAddress2", shipAddress2);
        session.setAttribute("order.shipCity", shipCity);
        session.setAttribute("order.shipState", shipState);
        session.setAttribute("order.shipZip", shipZip);
        session.setAttribute("order.shipCountry", shipCountry);

//        System.out.println(order.toString());
//        System.out.println(order.getShipToFirstName());
//        System.out.println(order.getShipToLastName());
//        System.out.println(order.getShipAddress1());
//        System.out.println(order.getShipAddress2());
//        System.out.println(order.getShipCity());
//        System.out.println(order.getShipState());
//        System.out.println(order.getShipZip());
//        System.out.println(order.getShipCountry());

        req.getRequestDispatcher(CONFIRM_ORDER_FORM).forward(req, resp);
    }
}
