package org.example.lab.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.lab.domain.Product;
import org.example.lab.service.CatalogService;

import java.io.IOException;
import java.util.List;

@WebServlet(name="search", urlPatterns = "/search")
public class SearchProductServlet extends HttpServlet {

    private static final String SEARCH_PRODUCTS = "WEB-INF/jsp/catalog/searchProducts.jsp";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String keyword = req.getParameter("keyword");
        CatalogService catalogService = new CatalogService();
        List<Product> productList = catalogService.searchProductList(keyword);
        for (Product product : productList) {
            System.out.println(product);
        }
        req.setAttribute("searchKeyword", keyword);
        req.setAttribute("productList", productList);
        req.getRequestDispatcher(SEARCH_PRODUCTS).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
