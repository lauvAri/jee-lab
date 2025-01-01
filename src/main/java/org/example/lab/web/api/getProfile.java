package org.example.lab.web.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.lab.domain.Account;

import java.io.IOException;

@WebServlet("/getProfile")
public class getProfile extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Account loginAccount = (Account) req.getSession().getAttribute("loginAccount");
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(loginAccount);
        resp.setContentType("application/json");
        resp.getWriter().write(json);
    }
}
