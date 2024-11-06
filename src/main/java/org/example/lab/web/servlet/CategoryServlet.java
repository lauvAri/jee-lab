package org.example.lab.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.lab.domain.Account;
import org.example.lab.domain.Category;
import org.example.lab.domain.Product;
import org.example.lab.service.CatalogService;
import org.example.lab.service.LogService;

import java.io.IOException;
import java.util.List;

public class CategoryServlet extends HttpServlet {

    private CatalogService catalogService;

    private String CATEGORY_FORM = "/WEB-INF/jsp/catalog/category.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String categoryId = request.getParameter("categoryId");
        catalogService = new CatalogService();
        Category category =  catalogService.getCategory(categoryId);
        List<Product> productList = catalogService.getProductListByCategory(categoryId);
        HttpSession session = request.getSession();
        session.setAttribute("category", category);
        session.setAttribute("productList", productList);
        /*进行日志记录*/
//        Account account = (Account) session.getAttribute("loginAccount");
//        if (account != null) {
//            LogService logService = new LogService();
//            logService.log(account.getUsername(), categoryId, LogService.CATEGORY);
//        }
        request.getRequestDispatcher(CATEGORY_FORM).forward(request, response);
    }
}
