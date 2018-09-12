/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorymanager.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 *
 * @author scott
 */
public class InhousePart extends Part {
    private IntegerProperty machineID;
    
    public InhousePart() {
        super();
        machineID = new SimpleIntegerProperty(0);
    }
    
    public InhousePart(int partID, String name, double price, int inStock,
                       int min, int max, int machineID) {
        
        super(partID, name, price, inStock, min, max);
        this.machineID = new SimpleIntegerProperty(machineID);
    }
    
    public void setMachineID(int newID) {
        this.machineID.set(newID);
    }
    
    public int getMachineID() {
        return machineID.get();
    }
}
