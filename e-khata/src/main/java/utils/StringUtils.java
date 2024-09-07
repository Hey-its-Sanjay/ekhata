package utils;

public class StringUtils {

    // Database Configuration
    public static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
    public static final String DB_URL = "jdbc:mysql://localhost:3306/e_khata_app";
    public static final String USER = "root";
    public static final String PASS = "Bishal@123";

    // Servlets Mapping
    public static final String SIGNUP_SERVLET = "/signup";
    public static final String LOGIN_SERVLET = "/login";
    public static final String LOGOUT_SERVLET = "/logout";
    public static final String DASHBOARD_SERVLET = "/dashboard";
    public static final String ADD_CUSTOMER_SERVLET = "/add-customer";
    public static final String CUSTOMER_LIST_SERVLET = "/customer-list";

    // JSP Route
    public static final String LOGIN_PAGE = "/WEB-INF/view/Login.jsp";
    public static final String SIGN_UP_PAGE = "/WEB-INF/view/SignUp.jsp";
    public static final String DASHBOARD_PAGE = "/WEB-INF/view/Dashboard.jsp";
    public static final String ADD_CUSTOMER_PAGE = "/WEB-INF/view/AddCustomer.jsp";
    public static final String VIEW_CUSTOMER_PAGE = "/WEB-INF/view/ViewCustomer.jsp";

    // Parameters
    public static final String FIRST_NAME = "firstName";
    public static final String LAST_NAME = "lastName";
    public static final String EMAIL_ADDRESS = "emailAddress";
    public static final String PHONE_NUMBER = "phoneNumber";
    public static final String BUSINESS_NAME = "businessName";
    public static final String ADDRESS = "address";
    public static final String PASSWORD = "password";
    public static final String CONFIRM_PASSWORD = "confirmPassword";
    public static final String USER_OBJECT = "userObject";
    public static final String CUSTOMER_OBJECT = "customerObject";

    // Error Message - Key
    public static final String ERROR_MESSAGE_KEY = "errorMessage";

    // Success Message - Key
    public static final String COMMON_SUCCESS_MESSAGE_KEY = "commonSuccessMessage";
    public static final String LOGIN_SUCCESS_MESSAGE_KEY = "loginSuccessMessage";

    // Error Message - Value
    public static final String SERVER_ERROR_MESSAGE = "Unexpected server error";
    public static final String EMPTY_FIELD_ERROR_MESSAGE = "Please fill all the field";
    public static final String FIRST_NAME_ERROR_MESSAGE = "Please enter valid first name";
    public static final String LAST_NAME_ERROR_MESSAGE = "Please enter valid last name";
    public static final String EMAIL_ADDRESS_ERROR_MESSAGE = "Please enter valid email address";
    public static final String PHONE_NUMBER_ERROR_MESSAGE = "Please enter valid phone number";
    public static final String PASSWORD_ERROR_MESSAGE = "Please enter strong password";
    public static final String CONFIRM_PASSWORD_ERROR_MESSAGE = "Password does not match";
    public static final String USER_REGISTERED_ERROR_MESSAGE = "Unable to register user";
    public static final String USER_LOGGED_IN_ERROR_MESSAGE = "Unable to log in";
    public static final String DUPLICATE_EMAIL_ERROR_MESSAGE = "Email address already in use";
    public static final String DUPLICATE_PHONE_NUMBER_ERROR_MESSAGE = "Phone number already in use";
    public static final String DUPLICATE_BUSINESS_NAME_ERROR_MESSAGE = "Business name already in use";
    public static final String INCORRECT_PASSWORD_ERROR_MESSAGE = "Incorrect password";
    public static final String ACCOUNT_DOES_NOT_EXISTS_ERROR_MESSAGE = "Account does not exist";


    // Success Message - Value
    public static final String USER_REGISTERED_SUCCESSFULLY_MESSAGE = "User registered successfully";
    public static final String USER_LOGGED_IN_SUCCESSFULLY_MESSAGE = "User logged in successfully";

}
