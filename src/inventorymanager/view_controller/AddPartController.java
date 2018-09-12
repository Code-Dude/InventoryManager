/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorymanager.view_controller;

import inventorymanager.model.InhousePart;
import inventorymanager.model.OutsourcedPart;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author scott
 */
public class AddPartController implements Initializable {

    @FXML
    private Label InventoryLabel;

    @FXML
    private Label NameLabel;

    @FXML
    private RadioButton InHouseRadio;

    @FXML
    private TextField MinField;

    @FXML
    private TextField IDField;

    @FXML
    private Button SaveBtn;

    @FXML
    private TextField SpecialField;

    @FXML
    private TextField PriceField;

    @FXML
    private Label MaxLabel;

    @FXML
    private Label SpecialLabel;

    @FXML
    private Label PriceLabel;

    @FXML
    private RadioButton OutsourcedRadio;

    @FXML
    private Label ModifyPartLabel;

    @FXML
    private Label IDLabel;

    @FXML
    private ToggleGroup InHouseOutsourcedToggle;

    @FXML
    private TextField NameField;

    @FXML
    private Label MinLabel;

    @FXML
    private TextField InventoryField;

    @FXML
    private Button CancelBtn;

    @FXML
    private TextField MaxField;
    
    private Stage dialogStage;
    
    private boolean partToggle, saveClicked;
    
    private InhousePart inPart;
    
    private OutsourcedPart outPart;
    
    private ArrayList<Boolean> partConfig;
    
    public AddPartController() {
        partToggle = false;
        saveClicked = false;
        partConfig = new ArrayList<Boolean>();
        partConfig.add(partToggle);
        partConfig.add(saveClicked);
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
    
    public void setParts(InhousePart inPart, OutsourcedPart outPart) {
        this.inPart = inPart;
        this.outPart = outPart;
        
        IDField.setText("");
        NameField.setText("");
        InventoryField.setText("");
        PriceField.setText("");
        MaxField.setText("");
        MinField.setText("");
        SpecialLabel.setText("Select Part Type");
        SpecialField.setText("");
    }

    public boolean getPartToggle() {
        return partToggle;
    }
    
    public ArrayList<Boolean> getPartConfig() {
        return this.partConfig;
    }

    @FXML
    void cancel(ActionEvent event) {
        saveClicked = false;
        updatePartConfig();
        dialogStage.close();
    }

    @FXML
    void handleSave(ActionEvent event) {
        if(InHouseRadio.isSelected()) {
            partToggle = true;
            inPart.setPartID(Integer.parseInt(IDField.getText()));
            inPart.setName(NameField.getText());
            inPart.setInStock(Integer.parseInt(InventoryField.getText()));
            inPart.setPrice(Double.parseDouble(PriceField.getText()));
            inPart.setMax(Integer.parseInt(MaxField.getText()));
            inPart.setMin(Integer.parseInt (MinField.getText()));
            inPart.setMachineID(Integer.parseInt(SpecialField.getText()));         
        }
        else if(OutsourcedRadio.isSelected()) {
            partToggle = false;
            outPart.setPartID(Integer.parseInt(IDField.getText()));
            outPart.setName(NameField.getText());
            outPart.setInStock(Integer.parseInt(InventoryField.getText()));
            outPart.setPrice(Double.parseDouble(PriceField.getText()));
            outPart.setMax(Integer.parseInt(MaxField.getText()));
            outPart.setMin(Integer.parseInt (MinField.getText()));
            outPart.setCompanyName(SpecialField.getText());   
        }
        else {
            System.out.println("Please select a part type");
        }
        
        saveClicked = true;
        updatePartConfig();
        dialogStage.close();
    }
    
    public void setDialogStage(Stage stage) {
        this.dialogStage = stage;
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
    
    private void updatePartConfig() {
        partConfig.clear();
        partConfig.add(partToggle);
        partConfig.add(saveClicked);
    }
}

