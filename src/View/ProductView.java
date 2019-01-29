/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

/**
 *
 * @author work
 */
public class ProductView {
    
    public ProductView(){}
    
    public void printProduct(String brandName, String color, int size, int price, String stock)
    {
        System.out.println("Märke:" + brandName + " - Färg:" + color + " - Storlek:" + size + " - Pris:" + price + " - Status:" + stock);
    }
}
