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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author scott
 */
public class Product {
    
    private ObservableList<Part> associatedParts;
    private IntegerProperty productID;
    private StringProperty name;
    private DoubleProperty price;
    private IntegerProperty inStock;
    private IntegerProperty min;
    private IntegerProperty max;
    
    public Product() {
        associatedParts = FXCollections.observableArrayList();
        productID = new SimpleIntegerProperty(0);
        name = new SimpleStringProperty("");
        price = new SimpleDoubleProperty(0.0);
        inStock = new SimpleIntegerProperty(0);
        min = new SimpleIntegerProperty(0);
        max = new SimpleIntegerProperty(0);
    }
    
    public void setName(String newName) {
        name = new SimpleStringProperty(newName);
    }
    
    public String getName() {
        return name.get();
    }
    
    public StringProperty getNameProperty() {
        return name;
    }
    
    public void setPrice(double newPrice) {
        price = new SimpleDoubleProperty(newPrice);
    }
    
    public double getPrice() {
        return price.get();
    }
    
    public DoubleProperty getPriceProperty() {
        return price;
    }
    
    public void setInStock(int amountInStock) {
        inStock = new SimpleIntegerProperty(amountInStock);
    }
    
    public int getInStock() {
        return inStock.get();
    }
    
    public IntegerProperty getInStockProperty() {
        return inStock;
    }
    
    public void setMin(int newMin) {
        min = new SimpleIntegerProperty(newMin);
    }
    
    public int getMin() {
        return min.get();
    }
    
    public IntegerProperty getMinProperty() {
        return min;
    }
    
    public void setMax(int newMax) {
        max = new SimpleIntegerProperty(newMax);
    }
    
    public int getMax() {
        return max.get();
    }
    
    public IntegerProperty getMaxProperty() {
        return max;
    }
    
    public void setProductID(int newID) {
        productID = new SimpleIntegerProperty(newID);
    }
    
    public int getProductID() {
        return productID.get();
    }
    
    public IntegerProperty getProductIDProperty() {
        return productID;
    }
    
    public void addAssociatedPart(Part newPart) {
        associatedParts.add(newPart);
    }
    
    public boolean removeAssociatedPart(int partIndex) {
        Part newPart = associatedParts.remove(partIndex);
        
        if(newPart != null) {
            return true;
        }
        else {
            return false;
        }
    }
    
    public void setAssociatedParts(ObservableList<Part> newPartList) {
        this.associatedParts = newPartList;
    }
    
    
    public Part lookupAssociatedPart(int partIndex) {     
        return associatedParts.get(partIndex);
    }
    
    public ObservableList<Part> getAssociatedParts() {
        return associatedParts;
    }
    
    public int getIndexOfPart(Part part) {
        return associatedParts.indexOf(part);
    }
    
    public static double sumPartPrices(ObservableList<Part> listToSum) {
        double sum = 0.0;
        
        for(int i = 0; i < listToSum.size(); ++i) {
            sum += listToSum.get(i).getPrice();
        }
        
        return sum;
    }
}
