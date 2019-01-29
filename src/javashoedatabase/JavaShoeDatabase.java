/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javashoedatabase;

import Controller.CustomerController;
import Database.Database;
import java.sql.Connection;
import java.sql.SQLException;

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
        CustomerController cc = new CustomerController();
        Connection con = Database.getConnection();
        con.close();
        
        System.out.println("Välj en användare genom att skriva in hens Namn och Efternamn");
        System.out.println("##");
        cc.printCustomers();
        System.out.println("##");
        
    }
}
