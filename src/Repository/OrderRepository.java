package Repository;

import Models.Order;
import View.OrderView;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import static java.util.stream.Collectors.toList;

/**
 *
 * @author work
 */
public class OrderRepository 
{
    
    public OrderRepository(){}
    
    public List<Order> getOrders(int customerId) throws SQLException
    {
        List<Order> orders = new ArrayList<>();
        
        try (Connection con = Database.Database.getConnection()) 
        { 
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT order.id, order.customerId, order.created, order.lastupdate, order.delivered FROM Order where customerid = " + customerId + " ORDER by order.lastupdate ASC");

            while (rs.next())
                orders.add(new Order(rs.getInt(1), rs.getInt(2), rs.getTimestamp(3), rs.getTimestamp(4), rs.getInt(5)));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return orders;
    }
    
    public void printOrders(int customerId) throws SQLException
    {
        getOrders(customerId).forEach(o -> new OrderView().printOrder(o.getOrderId(), o.getCreated()));
    }
    
    public void printOrdersMap(int customerId) throws SQLException
    {
        getOrders(customerId).stream().map(Order::getOrderId).collect(toList());
    }
}
