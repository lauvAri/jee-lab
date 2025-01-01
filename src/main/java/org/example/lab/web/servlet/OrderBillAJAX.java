package org.example.lab.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.lab.domain.Order;

import java.io.IOException;

@WebServlet(name = "orderBillAJAX", value = "/orderBillAJAX")
public class OrderBillAJAX extends HttpServlet {
    private static final String CONFIRM_ORDER_FORM = "/WEB-INF/jsp/order/confirmOrder.jsp";
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("orderBillAJAX");
        resp.setContentType("text/html");
        // 从请求中获取参数
        String cardType = req.getParameter("order.cardType");
        String cardNum = req.getParameter("order.creditCard");
        String expireDate = req.getParameter("order.expiryDate");
        String firstName = req.getParameter("order.billToFirstName");
        String lastName = req.getParameter("order.billToLastName");
        String address1 = req.getParameter("order.billAddress1");
        String address2 = req.getParameter("order.billAddress2");
        String city = req.getParameter("order.billCity");
        String state = req.getParameter("order.billState");
        String zip = req.getParameter("order.billZip");
        String country = req.getParameter("order.billCountry");
        String shippingAddressRequired = req.getParameter("order.shippingAddressRequired");

        // 获取当前会话
        HttpSession session = req.getSession();

        // 从会话中获取 Order 对象
        Order order = (Order) session.getAttribute("order");

        // 如果 Order 对象不存在，创建一个新的
        if (order == null) {
            order = new Order();
        }

        // 更新 Order 对象的配送地址信息
        order.setCardType(cardType);
        order.setCreditCard(cardNum);
        order.setExpiryDate(expireDate);
        order.setBillToFirstName(firstName);
        order.setBillToLastName(lastName);
        order.setBillAddress1(address1);
        order.setBillAddress2(address2);
        order.setBillCity(city);
        order.setBillState(state);
        order.setBillZip(zip);
        order.setBillCountry(country);

        // 将更新后的 Order 对象存储到会话中
        session.setAttribute("order", order);

        // 将配送地址信息单独存储到会话中（可选）
        session.setAttribute("cardType", cardType);
        session.setAttribute("creditCard", cardNum);
        session.setAttribute("expiryDate", expireDate);
        session.setAttribute("order.billToFirstName", firstName);
        session.setAttribute("order.billToLastName", lastName);
        session.setAttribute("order.billAddress1", address1);
        session.setAttribute("order.billAddress2", address2);
        session.setAttribute("order.billCity", city);
        session.setAttribute("order.billState", state);
        session.setAttribute("order.billZip", zip);
        session.setAttribute("order.billCountry", country);

        System.out.println(shippingAddressRequired);

        if(shippingAddressRequired.equals("false")) {
            order.setShipToFirstName(firstName);
            order.setShipToLastName(lastName);
            order.setShipAddress1(address1);
            order.setShipAddress2(address2);
            order.setShipCity(city);
            order.setShipState(state);
            order.setShipZip(zip);
            order.setShipCountry(country);

            session.setAttribute("order", order);
            session.setAttribute("order.shipToFirstName", firstName);
            session.setAttribute("order.shipToLastName", lastName);
            session.setAttribute("order.shipAddress1", address1);
            session.setAttribute("order.shipAddress2", address2);
            session.setAttribute("order.shipCity", city);
            session.setAttribute("order.shipState", state);
            session.setAttribute("order.shipZip", zip);
            session.setAttribute("order.shipCountry", country);
        }else{
            order.setShipToFirstName("");
            order.setShipToLastName("");
            order.setShipAddress1("");
            order.setShipAddress2("");
            order.setShipCity("");
            order.setShipState("");
            order.setShipZip("");
            order.setShipCountry("");

            session.setAttribute("order", order);
            session.setAttribute("order.shipToFirstName", "");
            session.setAttribute("order.shipToLastName", "");
            session.setAttribute("order.shipAddress1", "");
            session.setAttribute("order.shipAddress2", "");
            session.setAttribute("order.shipCity", "");
            session.setAttribute("order.shipState", "");
            session.setAttribute("order.shipZip", "");
            session.setAttribute("order.shipCountry", "");
        }
        // 返回成功响应
        resp.setContentType("text/plain");
        resp.getWriter().write("Shipping information updated successfully!");
    }
}
