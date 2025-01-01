package org.example.lab.web.servlet;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.lab.domain.Account;
import org.example.lab.service.LogService;

import java.io.IOException;

@WebFilter(urlPatterns = {"/productForm", "/categoryForm", "/itemForm", "/cartForm"})
public class MyFilter implements Filter {

    private String encoding;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.encoding = filterConfig.getInitParameter("encoding");
        if (this.encoding == null) {
            this.encoding = "UTF-8";
        }
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();
        Account account = (Account) session.getAttribute("loginAccount");
        if (account == null) {
            response.sendRedirect("/loginView");
        } else {

            String uri = request.getRequestURI();
            System.out.println("uri: " + uri);
            LogService logService = new LogService();
            if (uri.contains("categoryForm")) {
                String categoryId = request.getParameter("categoryId");
                logService.log(account.getUsername(), categoryId, LogService.CATEGORY);
            } else if (uri.contains("productForm")) {
                String productId = request.getParameter("productId");
                logService.log(account.getUsername(), productId, LogService.PRODUCT);
            } else if (uri.contains("itemForm")) {
                String itemId = request.getParameter("itemId");
                logService.log(account.getUsername(), itemId, LogService.ITEM);
            }
            filterChain.doFilter(request, response);
        }

    }
}