/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.sql.Timestamp;

/**
 *
 * @author work
 */
public class OrderView {
    
    public OrderView(){}
    
    public void printOrder(int orderId, Timestamp created)
    {
        System.out.println("- Ordernummer:" + orderId + " - Skapad:" + created);
    }
    
}
