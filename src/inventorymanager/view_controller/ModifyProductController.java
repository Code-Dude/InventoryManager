/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorymanager.view_controller;

import inventorymanager.Router;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author scott
 */
public class ModifyProductController implements Initializable {
    
    private Router modifyProductRouter;
    
    @FXML
    private Label ModifyPartLabel, PartIDLabel, PartNameLabel, InventoryLabel,
            PriceLabel, MaxStoreLabel, MinStoreLabel, CompanyNameLabel;
    
    @FXML
    private RadioButton InHouseRadio, OutsourcedRadio;
    
    @FXML
    private Button SaveBtn, CancelBtn;
    
    @FXML
    private TextField IDfield, PartNameField, InventoryField, PriceField,
            MaxField, MinField, CompanyNameField;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        modifyProductRouter = new Router();
    }    
    
    @FXML
    private void cancel(ActionEvent event) {
    }
}
