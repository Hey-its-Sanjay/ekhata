package controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Customer;
import service.CustomerDao;
import service.UserDao;
import utils.StringUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(asyncSupported = true, urlPatterns = StringUtils.CUSTOMER_LIST_SERVLET)
public class ViewCustomer extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private CustomerDao customerDao;
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        this.customerDao = new CustomerDao();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String searchQuery = req.getParameter("search");  // Get the search query from the request
        System.out.println(searchQuery);
        List<Customer> customers;

        if(searchQuery != null && !searchQuery.trim().isEmpty()) {
            customers = customerDao.searchCustomersByName(searchQuery);
        }
        else{
            customers = customerDao.getAllCustomer();
        }
        req.setAttribute(StringUtils.CUSTOMER_OBJECT, customers);
        req.getRequestDispatcher(StringUtils.VIEW_CUSTOMER_PAGE).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}

