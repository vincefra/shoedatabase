package Controller;

import Models.Customer;
import View.CustomerView;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author work
 */

public class CustomerController 
{
    public CustomerController() throws SQLException
    {

    }
    
    public List<Customer> getCustomers() throws SQLException
    {
        List<Customer> customers = new ArrayList<>();
        
        try (Connection con = Database.Database.getConnection()) 
        { 
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Customer");

            while (rs.next())
            {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String lastname = rs.getString("lastname");
                customers.add(new Customer(id, name, lastname));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        
        return customers;
    }
    
    public void printCustomers() throws SQLException
    {
        for (Customer temp : getCustomers()) 
            new CustomerView().printCustomer(temp.getname(), temp.getLastname());
    }
}
