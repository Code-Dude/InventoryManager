/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorymanager.view_controller;

import inventorymanager.model.InhousePart;
import inventorymanager.model.OutsourcedPart;
import inventorymanager.model.Part;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author scott
 */
public class ModifyPartController implements Initializable {
    
    @FXML
    private Label ModifyPartLabel, IDLabel, NameLabel, InventoryLabel,
            PriceLabel, MaxLabel, MinLabel, SpecialLabel;
    
    @FXML
    private Button SaveBtn, CancelBtn;
    
    @FXML
    private RadioButton InHouseRadio; 
    
    @FXML
    private RadioButton OutsourcedRadio;
    
    @FXML
    private TextField IDField, NameField, InventoryField, PriceField,
            MaxField, MinField, SpecialField;
    
    private Stage dialogStage;
    private Part part;
    
    private InhousePart inPart;
    private OutsourcedPart outPart;
    
    /**
     * Initializes the controller class.
     */
    public ModifyPartController() {
        inPart = new InhousePart();
        outPart = new OutsourcedPart();
    }    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
    
    @FXML
    public void cancel(ActionEvent event) {
        dialogStage.close();
    }
    
    public void setDialogStage(Stage stage) {
        this.dialogStage = stage;
    }
    
    public void setPart(Part newPart) {
        part = newPart;
        
        IDField.setText(Integer.toString(part.getPartID()));
        NameField.setText(part.getName());
        InventoryField.setText(Integer.toString(part.getInStock()));
        PriceField.setText(Double.toString(part.getPrice()));
        MaxField.setText(Integer.toString(part.getMax()));
        MinField.setText(Integer.toString(part.getMin()));
       
        if(part.getClass() == inPart.getClass()) {
            SpecialField.setText(Integer.toString(((InhousePart) part).getMachineID()));
        }
        else if(part.getClass() == outPart.getClass()) {
            SpecialField.setText(((OutsourcedPart) part).getCompanyName());
        }
    }
    
    @FXML
    public void handleSave() {       
        part.setPartID(Integer.parseInt(IDField.getText()));
        part.setName(NameField.getText());
        part.setInStock(Integer.parseInt(InventoryField.getText()));
        part.setPrice(Double.parseDouble(PriceField.getText()));
        part.setMax(Integer.parseInt(MaxField.getText()));
        part.setMin(Integer.parseInt(MinField.getText()));
        if(part.getClass() == inPart.getClass()) {
            ((InhousePart) part).setMachineID(Integer.parseInt(SpecialField.getText()));
        }
        else if(part.getClass() == outPart.getClass()) {
            ((OutsourcedPart) part).setCompanyName(SpecialField.getText());
        }
        
        dialogStage.close();
    }
    
    public void updateForm() {
        if(part != null) {
            if(part.getClass() == inPart.getClass()) {
                InHouseRadio.setSelected(true);
                SpecialLabel.setText("Machine ID");
                SpecialField.setText((Integer.toString(((InhousePart) part).getMachineID())));
            }
            else if(part.getClass() == outPart.getClass()) {
                OutsourcedRadio.setSelected(true);
                SpecialLabel.setText("Company Name");
                SpecialField.setText(((OutsourcedPart) part).getCompanyName());
            }
        }
    }
    
    @FXML
    public void toggleButton() {
        if(InHouseRadio.isSelected()) {
            SpecialLabel.setText("Machine ID");
        }
        else if(OutsourcedRadio.isSelected()) {
            SpecialLabel.setText("Company Name");
        }
    }
}
