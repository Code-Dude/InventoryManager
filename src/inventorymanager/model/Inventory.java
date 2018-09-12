/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorymanager.model;

import javafx.collections.FXCollections;
import static javafx.collections.FXCollections.observableArrayList;
import javafx.collections.ObservableList;

/**
 *
 * @author scott
 */
public class Inventory {
    private ObservableList<Product> allProducts;
    private ObservableList<Part> allParts;
    
    public Inventory() {
        allProducts = FXCollections.observableArrayList();
        allParts = FXCollections.observableArrayList();
    }
    
    public void addProduct(Product product) {
        
    }
    
    public boolean removeProduct(int productIndex) {
        return false;
    }
    
    public Product lookupProduct(int productIndex) {
        Product newProduct = new Product();
        
        return newProduct;
    }
    
    public void updateProduct(int productIndex, Product product) {
        
    }
    
    public void addPart(Part part) {
        allParts.add(part);
    }
    
    public boolean deletePart(Part part) {
        return false;
    }
    
//    public Part lookupPart(int partIndex) {
//        Part newPart = new InhousePart();
//        
//        return newPart;
//    }
    
    public void updatePart(int partIndex, Part part) {
        
    }
    
    public ObservableList<Part> getParts() {
        return this.allParts;
    }
    
    public ObservableList<Product> getProducts() {
        return this.allProducts;
    }
}