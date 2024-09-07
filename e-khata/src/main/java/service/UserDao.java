package service;

import model.User;
import utils.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {

    // Connection to the database
    Connection con;

    // Constructor initializes the database connection
    public UserDao() {
        try{
            // Attempt to get a database connection using a custom DatabaseConnection class
            this.con = DatabaseConnection.getDatabaseConnection();
        }
        catch (SQLException | ClassNotFoundException e) {
            // Print stack trace if there's an exception while connecting to the database
            e.printStackTrace();
        }
    }

    // Method to check if a specific field value already exists in the database
    public boolean checkDuplicateFiled(String value, String columnName){
        try{
            // Construct the query dynamically with the column name and use a prepared statement
            String query = "SELECT * FROM User WHERE " + columnName + " = ?";
            PreparedStatement ps = con.prepareStatement(query);

            // Set the value for the placeholder in the prepared statement
            ps.setString(1, value);

            // Execute the query and check if any record exists
            ResultSet rs = ps.executeQuery();
            return rs.next();

        } catch (SQLException e) {
            // Print stack trace if there's an SQL exception
            e.printStackTrace();
        }
        // Return false if there's an exception or no record was found
        return false;
    }

    // Method to register a user in the database
    public int registerUser(User user){

        // Check for duplicate email address, phone number, and business name
        boolean isEmailAddressDuplicated = checkDuplicateFiled(user.getEmailAddress(), "EmailAddress");
        boolean isPhoneNumberDuplicated = checkDuplicateFiled(user.getPhoneNumber(), "PhoneNumber");
        boolean isBusinessNameDuplicated = checkDuplicateFiled(user.getBusinessName(), "BusinessName");

        // Return specific error codes if a duplicate is found
        if(isEmailAddressDuplicated){
            return -1; // Email address is already registered
        }
        else if(isPhoneNumberDuplicated){
            return -2; // Phone number is already registered
        }
        else if(isBusinessNameDuplicated){
            return -3; // Business name is already registered
        }
        else{
            try{
                // Insert the new user into the database if no duplicates are found
                String query = "INSERT INTO User (FirstName, LastName, EmailAddress, PhoneNumber, BusinessName, Address, Password) VALUES(?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement ps = con.prepareStatement(query);

                // Set the values for the prepared statement
                ps.setString(1, user.getFirstName());
                ps.setString(2, user.getLastName());
                ps.setString(3, user.getEmailAddress());
                ps.setString(4, user.getPhoneNumber());
                ps.setString(5, user.getBusinessName());
                ps.setString(6, user.getAddress());
                ps.setString(7, user.getPassword());

                // Execute the update and return the number of affected rows
                int result = ps.executeUpdate();
                return result; // Registration successful, return the number of rows affected
            }
            catch(SQLException e){
                // Print stack trace if there's an SQL exception during the insert operation
                e.printStackTrace();
                return -4; // Return a code indicating an SQL error during registration
            }
        }
    }

    public int getUserInfo(User user){
        try{
            String query = "SELECT Password FROM User WHERE EmailAddress = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, user.getEmailAddress());

            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                String dbPassword = rs.getString("Password");
                if(dbPassword.trim().equals(user.getPassword())){
                    return 1;
                }
                else{
                    return 0;
                }
            }
            else{
                return -1;
            }
        }
        catch(SQLException e){
            e.printStackTrace();
            return -2;
        }
    }
}

