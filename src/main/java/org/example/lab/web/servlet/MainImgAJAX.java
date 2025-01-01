package org.example.lab.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.lab.domain.Product;
import org.example.lab.service.CatalogService;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "mainImgAJAX", value = "/mainImgAJAX")
public class MainImgAJAX extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("type");
        System.out.println(type);
        CatalogService catalogService = new CatalogService();
        List<Product> productList = catalogService.getProductListByCategory(type);
        String resp = "Product ID      Name\n";
        int i = 0;
        while(i < productList.size()){
            Product product = productList.get(i);
            resp += product.getProductId() + "      " + product.getName() + "\n";
            i++;
        }

        response.setContentType("text/xml");
        PrintWriter out = response.getWriter();
        out.write(resp);
    }
}
