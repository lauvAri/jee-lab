package org.example.lab.web.servlet;

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

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "updateCartAJAX", value = "/updateCartAJAX")
public class UpdateCartAJAXServlet extends HttpServlet {
    CartService cartService = new CartService();
    private static final String SIGNONFORM = "/loginView";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doGet function");
        HttpSession session = req.getSession();
        Account account = (Account) session.getAttribute("loginAccount");
        System.out.println(account.getUsername());
        if (account == null) {
            req.getRequestDispatcher(SIGNONFORM).forward(req, resp);
        }
        Cart cart = cartService.getCart(account.getUsername());
        System.out.println(cart);

        String workingItemId = req.getParameter("workingItemId");
        System.out.println(workingItemId);
        //Item item = cart.removeItemById(workingItemId);
        //cartService.removeItemInCart(account.getUsername(),workingItemId);

        resp.setContentType("text/plain");
        PrintWriter out = resp.getWriter();
        String cartNumStr = req.getParameter("cartNum");
        int cartNum = Integer.parseInt(cartNumStr);
        System.out.println(cartNum);
        cart.setQuantityByItemId(workingItemId,cartNum);
        session.setAttribute("cart", cart);
        cartService.updateCart(account.getUsername(), workingItemId,cartNum);
        out.print("Success");
        out.flush();
        out.close();
    }
}
