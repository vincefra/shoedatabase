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
public class OrderInfo 
{
    private int id;
    private int orderId;
    private int productId;
    
    public OrderInfo(){}
    
    public OrderInfo(int id, int orderId, int productId)
    {
        this.id = id;
        this.orderId = orderId;
        this.productId = productId;
    }
}
