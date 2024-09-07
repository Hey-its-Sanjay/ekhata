package service;

import model.Customer;
import utils.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDao {

    Connection con;

    public CustomerDao() {
        try{
            this.con = DatabaseConnection.getDatabaseConnection();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public List<Customer> getAllCustomer(){
        try{
            String query = "SELECT * FROM Customer ORDER BY FirstName ";
            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();
            List<Customer> customers = new ArrayList<>();
            while(rs.next()){
                Customer customer = new Customer();
                customer.setFirstName(rs.getString("FirstName"));
                customer.setLastName(rs.getString("LastName"));
                customer.setPhone(rs.getString("PhoneNumber"));
                customers.add(customer);
            }
            return customers;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Customer> searchCustomersByName(String name) {
        try {
            String query;
            PreparedStatement ps;

            // Check if the input contains a space (indicating a full name)
            if (name.contains(" ")) {
                // Split the full name into first and last name
                String[] parts = name.split(" ");
                String firstName = parts[0];
                String lastName = parts.length > 1 ? parts[1] : "";

                query = "SELECT * FROM Customer WHERE (FirstName LIKE ? AND LastName LIKE ?) OR (FirstName LIKE ? OR LastName LIKE ?) ORDER BY FirstName";
                ps = con.prepareStatement(query);
                ps.setString(1, "%" + firstName + "%");
                ps.setString(2, "%" + lastName + "%");
                ps.setString(3, "%" + name + "%"); // For matching the whole name in either field
                ps.setString(4, "%" + name + "%"); // For matching the whole name in either field
            } else {
                // Single name search
                query = "SELECT * FROM Customer WHERE FirstName LIKE ? OR LastName LIKE ? ORDER BY FirstName";
                ps = con.prepareStatement(query);
                ps.setString(1, "%" + name + "%");
                ps.setString(2, "%" + name + "%");
            }

            ResultSet rs = ps.executeQuery();
            List<Customer> customers = new ArrayList<>();
            while (rs.next()) {
                Customer customer = new Customer();
                customer.setFirstName(rs.getString("FirstName"));
                customer.setLastName(rs.getString("LastName"));
                customer.setPhone(rs.getString("PhoneNumber"));
                customers.add(customer);
            }
            return customers;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


}
