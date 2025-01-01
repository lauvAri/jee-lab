package org.example.lab.web.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.lab.domain.Product;
import org.example.lab.service.CatalogService;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/filterDataByCategory")
public class filterDataByCategory extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String category = req.getParameter("category");
        List<Product> productList = new CatalogService().getProductListByCategory(category);

        resp.setContentType("application/json;charset=utf-8");
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(productList);

        PrintWriter out = resp.getWriter();
        out.write(json);
        out.flush();
        out.close();
    }
}
