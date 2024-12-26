package org.example.lab.web.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.lab.domain.Cart;

import java.io.IOException;
@WebServlet("/getCartData")
public class getCartData extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(cart);
        resp.setContentType("application/json");
        resp.getWriter().write(json);
    }
}
