package Controller;

import Models.Product;
import View.ProductView;
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
    public ProductController(){}
    
    public Product existProduct(String brand, String color, int size) throws SQLException
    {
        for (Product p : getProducts()) 
            if (p.getBrandName().equalsIgnoreCase(brand))
                if (p.getColor().equalsIgnoreCase(color))
                    if (p.getSize() == size)
                        return p;
        
        return null;
    }
    
    
    public List<Product> getProducts() throws SQLException
    {
        List<Product> products = new ArrayList<>();
        
        try (Connection con = Database.Database.getConnection()) 
        { 
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT product.id, product.brandId, product.color, product.size, product.price, product.stock, brand.name FROM Product inner join brand on brand.id = product.brandId ORDER by brand.name ASC");

            while (rs.next())
                products.add(new Product(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getInt(6), rs.getString(7)));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return products;
    }

    public void printProducts() throws SQLException
    {
        getProducts().forEach(p -> new ProductView().printProduct(p.getBrandName(), p.getColor(), p.getSize(), p.getPrice(), p.getStock() > 0 ? "I lager" : "Slut"));
    }
}
