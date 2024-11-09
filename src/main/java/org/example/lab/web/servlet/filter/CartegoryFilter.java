package org.example.lab.web.servlet.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.lab.domain.Account;
import org.example.lab.service.LogService;

import java.io.IOException;

@WebServlet(urlPatterns = "/categoryFilter")
public class CartegoryFilter extends HttpServlet implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
        HttpSession session = httpRequest.getSession(false); // 不创建新的 session
        String categoryId = httpRequest.getParameter("categoryId");
        Account account = (Account) session.getAttribute("loginAccount");
        if (account == null) {
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/loginView");
        } else {
            LogService logService = new LogService();
            logService.log(account.getUsername(), categoryId, LogService.CATEGORY);
            filterChain.doFilter(servletRequest, servletResponse);
            httpRequest.getRequestDispatcher("categoryForm").forward(httpRequest, httpResponse);
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doFilter(req, resp, new FilterChain() {
            public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse) throws IOException, ServletException {}
        });
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //this.doGet(req, resp);
    }
}
