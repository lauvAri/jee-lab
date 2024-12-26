package org.example.lab.web.api;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
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
import java.io.PrintWriter;

@WebServlet("/api/addItemToCart")
public class addItemToCart extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String workingItemId = req.getParameter("workingItemId");
        resp.setContentType("text/plain");
        PrintWriter out = resp.getWriter();

        HttpSession session = req.getSession();
        Account account = (Account) session.getAttribute("loginAccount");
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (account == null || workingItemId == null || cart == null) {
            out.write("false");
            return;
        }
        CartService cartService = new CartService();
        CatalogService catalogService = new CatalogService();

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

        out.write("true");
    }
}
