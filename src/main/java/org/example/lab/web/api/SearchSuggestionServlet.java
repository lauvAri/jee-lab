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

@WebServlet("/searchSuggestion")
public class SearchSuggestionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String keyword = req.getParameter("keyword");
        List<Product> suggestions = null;
        suggestions = new CatalogService().searchProductList(keyword);

        resp.setContentType("application/json;charset=utf-8");


        /*jackson*/
        // 使用ObjectMapper将对象转换为JSON字符串
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(suggestions);

        // 将JSON字符串写入响应输出流，发送给前端
        PrintWriter out = resp.getWriter();
        out.write(json);
        out.flush();
        out.close();
    }
}
