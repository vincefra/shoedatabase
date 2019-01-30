package Repository;

import Models.Order;
import View.OrderView;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
        Map<Integer, Order> ordersMap = new HashMap();
        
        try (Connection con = Database.Database.getConnection()) 
        { 
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT order.id, order.customerId, order.created, order.lastupdate, order.delivered FROM `Order` where order.customerId = '" + customerId + "' ORDER by order.lastupdate ASC");

            while (rs.next())
            {
                orders.add(new Order(rs.getInt(1), rs.getInt(2), rs.getTimestamp(3), rs.getTimestamp(4), rs.getInt(5)));
                ordersMap.put(rs.getInt(1), new Order(rs.getInt(1), rs.getInt(2), rs.getTimestamp(3), rs.getTimestamp(4), rs.getInt(5)));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return orders;
    }
   
    public int getOrder(int orderId, int customerId) throws SQLException
    {
        for (Order o : getOrders(customerId)) 
            if (o.getOrderId() == orderId)
                return orderId;
        
        return getOrders(customerId).get(getOrders(customerId).size()-1).getOrderId();
    }
    
    public void AddToCart(int orderId, int customerId, int productId) throws SQLException
    {
        try (Connection con = Database.Database.getConnection()) 
        { 
            //customer, order, product
            String query = "call AddToCart(?, ?, ?)";
            
            CallableStatement stmt = con.prepareCall(query);
            {
                stmt.setInt(1, customerId);
                stmt.setInt(2, orderId);
                stmt.setInt(3, productId);
                stmt.executeQuery();
            }
            
            System.out.println("Allt gick utmärkt, ordern är lagd med Ordernummer: " + getOrder(orderId, customerId));
        }
        catch (Exception e)
        {
            System.out.println("Något gick tyvärr fel med att lägga ordern! :(");
        }
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
