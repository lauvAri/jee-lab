package org.example.lab.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.lab.domain.Account;
import org.example.lab.service.AccountService;

import java.io.IOException;

@WebServlet(name = "profile", urlPatterns = "/profile")
public class ProfileServlet extends HttpServlet {

    private static final String MAIN = "/WEB-INF/jsp/catalog/main.jsp";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("first-name-input");
        String lastName = req.getParameter("last-name-input");
        String email = req.getParameter("email-input");
        String address1 = req.getParameter("address-1-input");
        String address2 = req.getParameter("address-2-input");
        String city = req.getParameter("city-input");
        String country = req.getParameter("country-input");
        String phone = req.getParameter("phone-input");

        Account account = (Account) req.getSession().getAttribute("loginAccount");
        account.setFirstName(firstName);
        account.setLastName(lastName);
        account.setEmail(email);
        account.setAddress1(address1);
        account.setAddress2(address2);
        account.setCity(city);
        account.setCountry(country);
        account.setPhone(phone);
        AccountService accountService = new AccountService();
        accountService.updateAccount(account);

        req.getRequestDispatcher(MAIN).forward(req, resp);
    }
}
