/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author work
 */
public class Order 
{
    private int id;
    private int customerId;
    private long created;
    private long lastupdate;
    private int delivered;
    
    public Order(){}
    
    public Order(int id,long created, long lastupdate, int customerId, int delivered)
    {
        this.id = id;
        this.customerId = customerId;
        this.created = created;
        this.lastupdate = lastupdate;
        this.delivered = delivered;
    }
}
