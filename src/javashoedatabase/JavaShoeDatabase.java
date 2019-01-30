package javashoedatabase;

import Repository.CustomerRepository;
import Repository.ProductRepository;
import Models.Customer;
import Models.Order;
import Models.Product;
import Repository.OrderRepository;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author work
 */
public class JavaShoeDatabase 
{

    static Customer customer;
    static Product product;
    
    
    public static void main(String[] args) throws SQLException 
    {
        CustomerRepository cr = new CustomerRepository();
        ProductRepository pr = new ProductRepository();
        OrderRepository or = new OrderRepository();
        
        start(cr, pr, or);
    }
    
    public static void start(CustomerRepository cc, ProductRepository pc, OrderRepository or) throws SQLException
    {
        while (true)
        {
            customer = pickCustomer(cc);
            product = pickProduct(pc);
            pickOrder(or);

            System.out.println("All done");
        }
    }
    
    public static void pickOrder(OrderRepository or) throws SQLException
    {
        Order order;
        
        printOrders(or, customer.getId());
 
        int pick;

        pick = getInputInt("skriv 0 för ny order annars välj ordernummer ovanför!");
        
        or.AddToCart(pick, customer.getId(), product.getId());
        
        while(true){}
    }
    
    public static Customer pickCustomer(CustomerRepository cc) throws SQLException
    {
        Customer customer;
        
        while (true)
        {
            printCustomers(cc);
            customer = cc.getCustomer(getInputString(""));
            
            if (customer != null)
                break;

            System.out.println("Användaren kunde inte hittas, var vänlig och försök igen!");
        }
        
        return customer;
    }
    
    public static Product pickProduct(ProductRepository pc) throws SQLException
    {
        Product product;
        
        while (true)
        {
            product = new Product();
            
            printProducts(pc);
            product.setBrandName(getInputString("Skriv in märke"));
            product.setColor(getInputString("Skriv in färg"));
            product.setSize(getInputInt("Skriv in storlek"));
            
            product = pc.existProduct(product.getBrandName(), product.getColor(), product.getSize());
            
            if (product != null)
                break;
            
            System.out.println("Produkten kunde inte hittas, var vänlig och försök igen!"); 
        }
        
        return product;
    }
    
    public static String getInputString(String message)
    {
        System.out.println(message);
        Scanner scan = new Scanner(System.in);
        String name = scan.next();
        
        return name;
    }
    
    public static int getInputInt(String message)
    {
        System.out.println(message);
        Scanner scan = new Scanner(System.in);
        int value = scan.nextInt();
        
        return value;
    }
    
    public static void printCustomers(CustomerRepository cc) throws SQLException
    {
        System.out.println("- Kunder -");
        System.out.println("##");
        cc.printCustomers();
        System.out.println("##");
        System.out.println("Välj en kund genom att skriva in förnamn");
    }
    
    public static void printProducts(ProductRepository pc) throws SQLException
    {
        System.out.println("- Produkter -");
        System.out.println("##");
        pc.printProducts(true);
        System.out.println("##");
        System.out.println("Välj en product genom att skriva in märke");
    }
    
    public static void printOrders(OrderRepository or, int customerId) throws SQLException
    {
        System.out.println("- Ordrar -");
        System.out.println("##");
        or.printOrders(customerId);
        System.out.println("##");
    }
}
