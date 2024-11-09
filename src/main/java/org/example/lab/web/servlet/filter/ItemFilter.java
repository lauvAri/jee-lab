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

@WebServlet(urlPatterns = "/itemFilter")
public class ItemFilter extends HttpServlet implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String itemId = request.getParameter("itemId");
        /*进行日志记录*/
        HttpSession session = request.getSession();
        Account account = (Account) session.getAttribute("loginAccount");
        if (account != null) {
            LogService logService = new LogService();
            logService.log(account.getUsername(), itemId, LogService.ITEM);
            request.getRequestDispatcher("ItemForm").forward(request, response);
        } else {
            response.sendRedirect("loginView");
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doFilter(req, resp, null);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
