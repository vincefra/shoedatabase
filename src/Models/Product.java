package Models;

/**
 *
 * @author work
 */
public class Product 
{
    private int id;
    private int brandId;
    private String color;
    private int size;
    private int price;
    private String model;
    private int stock;
    private String brandName;
    
    public Product(){}
    
    public Product(int id, int brandId, String color, int size, int price, int stock, String brandName)
    {
        this.id = id;
        this.brandId = brandId;
        this.brandName = brandName;
        this.color = color;
        this.size = size;
        this.price = price;
        this.model = "";
        this.stock = stock;
    }
}
