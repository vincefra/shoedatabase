package Repository;

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

public class CustomerRepository 
{
    public CustomerRepository() throws SQLException
    {

    }
    
    public Customer getCustomer(String name) throws SQLException
    {
        for (Customer c : getCustomers()) 
            if (c.getname().equalsIgnoreCase(name))
                return c;
        
        return null;
    }
    
    public List<Customer> getCustomers() throws SQLException
    {
        List<Customer> customers = new ArrayList<>();
        
        try (Connection con = Database.Database.getConnection()) 
        { 
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Customer");

            while (rs.next())
                customers.add(
                        new Customer(rs.getInt("id"), rs.getString("name"), rs.getString("lastname")));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return customers;
    }
    
    public void printCustomers() throws SQLException
    {
        getCustomers().forEach(c -> new CustomerView().printCustomer(c.getname(), c.getLastname()));
    }
}
