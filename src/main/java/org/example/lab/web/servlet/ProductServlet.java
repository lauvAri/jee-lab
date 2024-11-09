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
import java.util.ArrayList;
import java.util.List;


public class ProductServlet extends HttpServlet {

    private static final String PRODUCT_FORM = "/WEB-INF/jsp/catalog/product.jsp";

    private CatalogService catalogService = new CatalogService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productId = request.getParameter("productId");
        Product product =  catalogService.getProduct(productId);
        List<Item> itemList = catalogService.getItemListByProduct(productId);
        HttpSession session = request.getSession();
        session.setAttribute("product", product);
        session.setAttribute("itemList", itemList);
//        /*进行日志记录*/
//        Account account = (Account) session.getAttribute("loginAccount");
//        if (account != null) {
//            LogService logService = new LogService();
//            logService.log(account.getUsername(), productId, LogService.PRODUCT);
//        }
        request.getRequestDispatcher(PRODUCT_FORM).forward(request, response);
    }
}
