/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javashoedatabase;

import Repository.CustomerRepository;
import Repository.ProductRepository;
import Models.Customer;
import Models.Product;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author work
 */
public class JavaShoeDatabase {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException 
    {
        CustomerRepository cc = new CustomerRepository();
        ProductRepository pc = new ProductRepository();
        
        List<Customer> customers = cc.getCustomers();
        List<Product> products = pc.getProducts(true);
        List<Order> products 

        start(cc, pc);
        
        /*
        System.out.println("Välj en Produkt att beställa");
        System.out.println("##");
        pc.printProducts();
        System.out.println("##");*/
        
    }
    
    public static void start(CustomerRepository cc, ProductRepository pc) throws SQLException
    {
        while (true)
        {
            Customer customer = pickCustomer(cc);
            Product product = pickProduct(pc);

            System.out.println("All done");
        }
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
}
