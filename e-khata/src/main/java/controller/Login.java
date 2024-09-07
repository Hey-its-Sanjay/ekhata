package controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.User;
import service.UserDao;
import utils.StringUtils;

import java.io.IOException;

@WebServlet(asyncSupported = true, urlPatterns = StringUtils.LOGIN_SERVLET)
public class Login extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private UserDao userDao;
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        this.userDao = new UserDao();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(StringUtils.LOGIN_PAGE).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String emailAddress = req.getParameter(StringUtils.EMAIL_ADDRESS);
        String password = req.getParameter(StringUtils.PASSWORD);

        // Check for empty fields and return an error message if any field is empty
        if (emailAddress == null || emailAddress.trim().isEmpty() || password == null || password.trim().isEmpty()) {
            req.setAttribute(StringUtils.ERROR_MESSAGE_KEY, StringUtils.EMPTY_FIELD_ERROR_MESSAGE);
            req.getRequestDispatcher(StringUtils.LOGIN_PAGE).forward(req, resp);
            return;
        }

        User user = new User(emailAddress, password);
        int result = userDao.getUserInfo(user);

        switch (result){
            case 1:
                HttpSession session = req.getSession();
                session.setAttribute(StringUtils.USER_OBJECT, user);
                session.setAttribute(StringUtils.LOGIN_SUCCESS_MESSAGE_KEY, StringUtils.USER_LOGGED_IN_SUCCESSFULLY_MESSAGE);
                session.setMaxInactiveInterval(300);
                resp.sendRedirect(req.getContextPath() + StringUtils.DASHBOARD_SERVLET);
                break;

            case 0:
                req.setAttribute(StringUtils.ERROR_MESSAGE_KEY, StringUtils.INCORRECT_PASSWORD_ERROR_MESSAGE);
                req.getRequestDispatcher(StringUtils.LOGIN_PAGE).forward(req, resp);
                break;

            case -1:
                req.setAttribute(StringUtils.ERROR_MESSAGE_KEY, StringUtils.ACCOUNT_DOES_NOT_EXISTS_ERROR_MESSAGE);
                req.getRequestDispatcher(StringUtils.LOGIN_PAGE).forward(req, resp);
                break;

            case -2:
                req.setAttribute(StringUtils.ERROR_MESSAGE_KEY, StringUtils.USER_LOGGED_IN_ERROR_MESSAGE);
                req.getRequestDispatcher(StringUtils.LOGIN_PAGE).forward(req, resp);
                break;
        }

    }
}
