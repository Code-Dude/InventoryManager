/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorymanager.model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author scott
 */
public abstract class Part {
    private IntegerProperty partID;
    private StringProperty name;
    private DoubleProperty price;
    private IntegerProperty inStock;
    private IntegerProperty min;
    private IntegerProperty max;
    
    public Part() {
        this.partID = new SimpleIntegerProperty(0);
        this.name = new SimpleStringProperty("");
        this.price = new SimpleDoubleProperty(0.0);
        this.inStock = new SimpleIntegerProperty(0);
        this.min = new SimpleIntegerProperty(0);
        this.max = new SimpleIntegerProperty(0);
    }   
    
    public Part(int partID, String name, double price, int inStock, int min,
                int max) {
        this.partID = new SimpleIntegerProperty(partID);
        this.name = new SimpleStringProperty(name);
        this.price = new SimpleDoubleProperty(price);
        this.inStock = new SimpleIntegerProperty(inStock);
        this.min = new SimpleIntegerProperty(min);
        this.max = new SimpleIntegerProperty(max);
    }
    
    public void setName(String newName) {
        this.name.set(newName);
    }
    
    public String getName() {
        return this.name.get();
    }
    
    public StringProperty getNameProperty() {
        return this.name;
    }
    
    public void setPrice(double newPrice) {
        this.price.set(newPrice);
    }
    
    public double getPrice() {
        return price.get();
    }
    
    public DoubleProperty getPriceProperty() {
        return this.price;
    }
    
    public void setInStock(int numInStock) {
        this.inStock.set(numInStock);
    }
    
    public int getInStock() {
        return inStock.get();
    }
    
    public IntegerProperty getInStockProperty() {
        return this.inStock;
    }
    
    public void setMin(int newMin) {
        this.min.set(newMin);
    }
    
    public int getMin() {
        return min.get();
    }
    
    public void setMax(int newMax) {
        this.max.set(newMax);
    }
    
    public int getMax() {
        return max.get();
    }
    
    public void setPartID(int newPartID) {
        this.partID.set(newPartID);
    }
    
    public int getPartID() {
        return partID.get();
    }
    
    public IntegerProperty getPartIDProperty() {
        return this.partID;
    }
}
