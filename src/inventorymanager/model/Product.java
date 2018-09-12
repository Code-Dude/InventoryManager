/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorymanager.model;

import java.util.ArrayList;

/**
 *
 * @author scott
 */
public class Product {
    
    private ArrayList<Part> associatedParts;
    private int productID;
    private String name;
    private double price;
    private int inStock;
    private int min;
    private int max;
    
    public Product() {
        
    }
    
    public void setName(String newName) {
        name = newName;
    }
    
    public String getName() {
        return name;
    }
    
    public void setPrice(double newPrice) {
        price = newPrice;
    }
    
    public double getPrice() {
        return price;
    }
    
    public void setInStock(int amountInStock) {
        inStock = amountInStock;
    }
    
    public int getInStock() {
        return inStock;
    }
    
    public void setMin(int newMin) {
        min = newMin;
    }
    
    public int getMin() {
        return min;
    }
    
    public void setMax(int newMax) {
        max = newMax;
    }
    
    public int getMax() {
        return max;
    }
    
    public void addAssociatedPart(Part newPart) {
        
    }
    
    public boolean removeAssociatedPart(int partIndex) {
        return false;
    }
    
//    public Part lookupAssociatedPart(int partIndex) {
//        Part newPart = new InhousePart();
//        
//        return newPart;
//    }
    
    public void setProductID(int newID) {
        productID = newID;
    }
    
    public int getProductID() {
        return productID;
    }
}
