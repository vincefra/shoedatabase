/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.sql.Timestamp;

/**
 *
 * @author work
 */
public class Order 
{
    private int id;
    private int customerId;
    private Timestamp created;
    private Timestamp lastupdate;
    private int delivered;
    
    public Order(){}
    
    public Order(int id, int customerId,Timestamp created, Timestamp lastupdate, int delivered)
    {
        this.id = id;
        this.customerId = customerId;
        this.created = created;
        this.lastupdate = lastupdate;
        this.delivered = delivered;
    }
    
    public int getOrderId()
    {
        return id;
    }
    
    public Timestamp getCreated()
    {
        return created;
    }
    
    
}
