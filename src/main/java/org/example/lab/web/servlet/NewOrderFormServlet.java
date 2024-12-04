package org.example.lab.web.servlet;

import com.mysql.cj.x.protobuf.MysqlxCrud;
import com.oracle.wls.shaded.org.apache.xpath.operations.Or;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.lab.domain.Account;
import org.example.lab.domain.Cart;
import org.example.lab.domain.Order;
import org.example.lab.service.OrderService;

import java.io.IOException;
import java.util.List;

public class NewOrderFormServlet extends HttpServlet {

    private static final String NEW_ORDER_FORM = "/WEB-INF/jsp/order/newOrder.jsp";
    private final OrderService orderService = new OrderService();
    private Order order;
    private Account account;
    private Cart cart;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        account = (Account) session.getAttribute("loginAccount");
        cart = (Cart) session.getAttribute("cart");

        if (account == null) {
            resp.sendRedirect(req.getContextPath() + "loginView");
        } else {
            order = new Order();
            order.initOrder(account,cart);
            session.setAttribute("order", order);
            session.setAttribute("order.billToFirstName",account.getFirstName());
            session.setAttribute("order.billToLastName",account.getLastName());
            session.setAttribute("order.billAddress1",account.getAddress1());
            session.setAttribute("order.billAddress2",account.getAddress2());
            session.setAttribute("order.billCity",account.getCity());
            session.setAttribute("order.billState",account.getState());
            session.setAttribute("order.billZipCode",account.getZip());
            session.setAttribute("order.billCountry",account.getCountry());
            List<String> cardTypes = orderService.getCardType();
            session.setAttribute("cardTypes", cardTypes);
            req.getRequestDispatcher(NEW_ORDER_FORM).forward(req, resp);
        }
    }

}
