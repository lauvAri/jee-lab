package org.example.lab.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.lab.domain.Cart;
import org.example.lab.domain.Item;
import org.example.lab.service.CartService;

import java.io.IOException;

public class RemoveCartItemServlet extends HttpServlet {

    private static final String ERROR_FORM = "/WEB-INF/jsp/common/error.jsp";
    private static final String CART_FORM = "/WEB-INF/jsp/cart/cart.jsp";
    private static final CartService cartService = new CartService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        //Cart cart = (Cart) session.getAttribute("cart");
        Cart cart = cartService.getCart("ACID");

        String workingItemId = request.getParameter("workingItemId");
        Item item = cart.removeItemById(workingItemId);
        cartService.removeItemInCart("ACID",workingItemId);

        if (item == null) {
            session.setAttribute("errormsg", "Attempted to remove null CartItem from Cart.");
            request.getRequestDispatcher(ERROR_FORM).forward(request, response);
        } else {
            cart = cartService.getCart("ACID");
            request.getRequestDispatcher(CART_FORM).forward(request, response);
        }
    }
}
