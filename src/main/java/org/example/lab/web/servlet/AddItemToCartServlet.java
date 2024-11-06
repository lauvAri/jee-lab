package org.example.lab.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.lab.domain.Account;
import org.example.lab.domain.Cart;
import org.example.lab.domain.Item;
import org.example.lab.service.CartService;
import org.example.lab.service.CatalogService;

import java.io.IOException;

public class AddItemToCartServlet extends HttpServlet {

    //private static final String CART_FORM = "/WEB-INF/jsp/cart/cart.jsp";
    private static final String CART_URL = "/cartForm";
    private static final String SIGNONFORM = "/loginView";
    private static final CartService cartService = new CartService();
    private static final CatalogService catalogService = new CatalogService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String workingItemId = request.getParameter("workingItemId");
        HttpSession session = request.getSession();
        //Cart cart = (Cart) session.getAttribute("cart");
        Account account = (Account) session.getAttribute("loginAccount");
        //Cart cart1 = new Cart();

        if (account == null){
            request.getRequestDispatcher(SIGNONFORM).forward(request, response);
        }

        Cart cart = cartService.getCart(account.getUsername());

        if (cart == null) {
            cart = new Cart();
        }

        if (cart.containsItemId(workingItemId)) {
            cart.incrementQuantityByItemId(workingItemId);
            cartService.addItemQuantity(account.getUsername(), workingItemId);
        } else {
            boolean isInStock = catalogService.isItemInStock(workingItemId);
            Item item = catalogService.getItem(workingItemId);
            item.setQuantity(1);
            item.setProductId(item.getProduct().getProductId());
            cart.addItem(item, isInStock);
            System.out.println("try add");
            cartService.insertCart(account.getUsername(),isInStock,item);
        }
        session.setAttribute("cart", cart);
        //request.getRequestDispatcher(CART_FORM).forward(request, response);
        response.sendRedirect(request.getContextPath() + CART_URL);
    }
}
