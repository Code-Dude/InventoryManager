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
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author scott
 */
public class AddProductController implements Initializable {
    private Router addProductRouter;
    
    @FXML
    private Label AddProductLabel, IDLabel, NameLabel, InventoryLabel,
            PriceLabel, MaxLabel, MinLabel;
    
    @FXML
    private TextField IDField, NameField, InventoryField, PriceField,
            MaxField, MinField, SearchField;
    
    @FXML
    private Button SearchBtn, AddBtn, DeleteBtn, SaveBtn, CancelBtn;
    
    @FXML
    private TableView AddTable, DeleteTable;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        addProductRouter = new Router();
    }
    
    @FXML
    private void cancel(ActionEvent event) {
    }
    
}
