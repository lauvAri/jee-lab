package org.example.lab.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.lab.domain.Account;
import org.example.lab.domain.Product;
import org.example.lab.service.AccountService;
import org.example.lab.service.CatalogService;

import java.io.IOException;
import java.util.List;


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
        String zip = req.getParameter("zip-input");
        String favouriteCategoryId = req.getParameter("favourite-category-id-input");
        System.out.println("favouriteCategoryId: " + favouriteCategoryId);

        Account account = (Account) req.getSession().getAttribute("loginAccount");
        account.setFirstName(firstName);
        account.setLastName(lastName);
        account.setEmail(email);
        account.setAddress1(address1);
        account.setAddress2(address2);
        account.setCity(city);
        account.setCountry(country);
        account.setPhone(phone);
        account.setZip(zip);
        account.setFavouriteCategoryId(favouriteCategoryId);

        AccountService accountService = new AccountService();
        //req.getSession().setAttribute("loginAccount", account);
        accountService.updateAccount(account);
        account = accountService.getAccount(account.getUsername());
        List<Product> myList = new CatalogService().getProductListByCategory(favouriteCategoryId);
        req.getSession().setAttribute("myList", myList);
        req.getSession().setAttribute("loginAccount", account);

        req.getRequestDispatcher(MAIN).forward(req, resp);
    }
}
