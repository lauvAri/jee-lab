package org.example.lab.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.lab.domain.Account;
import org.example.lab.domain.Item;
import org.example.lab.domain.Product;
import org.example.lab.service.CatalogService;
import org.example.lab.service.LogService;

import java.io.IOException;

public class ItemServlet extends HttpServlet {

    private static final String ITEM_FORM = "WEB-INF/jsp/catalog/item.jsp";
    private CatalogService catalogService;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String itemId = request.getParameter("itemId");
        catalogService = new CatalogService();
        Item item = catalogService.getItem(itemId);
        Product product = item.getProduct();
        HttpSession session = request.getSession();
        session.setAttribute("item", item);
        session.setAttribute("product", product);
//        /*进行日志记录*/
//        Account account = (Account) session.getAttribute("loginAccount");
//        if (account != null) {
//            LogService logService = new LogService();
//            logService.log(account.getUsername(), itemId, LogService.ITEM);
//        }
        request.getRequestDispatcher(ITEM_FORM).forward(request, response);
    }
}
