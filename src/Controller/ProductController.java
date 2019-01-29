package Controller;

import Models.Customer;
import Models.Product;
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
public class ProductController 
{
    private String brandName;
    private String color;
    private int size;
    private int price;
    private String stock;
   
    
    public ProductController(){}
    
    public List<Product> getProducts() throws SQLException
    {
        List<Product> products = new ArrayList<>();
        
        try (Connection con = Database.Database.getConnection()) 
        { 
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT product.id, product.brandId, product.color, product.size, product.price, product.stock, brand.name FROM Product inner join brand on brand.id = product.brandId");

            while (rs.next())
                products.add(new Product(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getInt(6), rs.getString(7)));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        
        return products;
    }
}
