package org.example.lab.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.lab.domain.Cart;
import org.example.lab.domain.Item;
import org.example.lab.service.CatalogService;

import java.io.IOException;

public class AddItemToCartServlet extends HttpServlet {

    //private static final String CART_FORM = "/WEB-INF/jsp/cart/cart.jsp";
    private static final String CART_URL = "/cartForm";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String workingItemId = request.getParameter("workingItemId");
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");


        if (cart == null) {
            cart = new Cart();
        }

        if (cart.containsItemId(workingItemId)) {
            cart.incrementQuantityByItemId(workingItemId);
        } else {
            CatalogService catalogService = new CatalogService();
            boolean isInStock = catalogService.isItemInStock(workingItemId);
            Item item = catalogService.getItem(workingItemId);
            cart.addItem(item, isInStock);
        }
        session.setAttribute("cart", cart);
        //request.getRequestDispatcher(CART_FORM).forward(request, response);
        response.sendRedirect(request.getContextPath() + CART_URL);
    }
}
