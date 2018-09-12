/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorymanager.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author scott
 */
public class OutsourcedPart extends Part {
    private StringProperty companyName;
    
    public OutsourcedPart() {
        super();
        companyName = new SimpleStringProperty("");
    }
       
    public OutsourcedPart(int partID, String name, double price, int inStock,
                       int min, int max, String company) {
        super(partID, name, price, inStock, min, max);
        this.companyName = new SimpleStringProperty(company);
    }
    
    public void setCompanyName(String newName) {
        companyName.set(newName);
    }
    
    public String getCompanyName() {
        return companyName.get();
    }
}
