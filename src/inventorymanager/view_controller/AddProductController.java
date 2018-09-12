/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorymanager.view_controller;

import inventorymanager.InventoryManager;
import inventorymanager.model.Part;
import inventorymanager.model.Product;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author scott
 */
public class AddProductController implements Initializable {
    
    @FXML
    private Label AddProductLabel, IDLabel, NameLabel, InventoryLabel,
            PriceLabel, MaxLabel, MinLabel, AllPartsLabel, ProductPartsLabel;
    
    @FXML
    private TextField IDField, NameField, InventoryField, PriceField,
            MaxField, MinField, SearchField;
    
    @FXML
    private Button SearchBtn, AddBtn, DeleteBtn, SaveBtn, CancelBtn;
    
    @FXML
    private TableView AllPartsTable, ProductPartsTable;
    
    @FXML
    private TableColumn<Part, Integer> AllPartIDColumn;
    
    @FXML
    private TableColumn<Part, String> AllPartNameColumn;
    
    @FXML
    private TableColumn<Part, Integer> AllPartInventoryColumn;
    
    @FXML
    private TableColumn<Part, Double> AllPartPriceColumn;
    
    @FXML
    private TableColumn<Part, Integer> ProductPartIDColumn;
    
    @FXML
    private TableColumn<Part, String> ProductPartNameColumn;
    
    @FXML
    private TableColumn<Part, Integer> ProductPartInventoryColumn;
    
    @FXML
    private TableColumn<Part, Double> ProductPartPriceColumn;
    
    private Stage dialogStage;
    private Product product;
    private InventoryManager mainApp;
    private boolean saveClicked;
    private boolean modifyingPart;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        AllPartIDColumn.setCellValueFactory(cellData -> cellData.getValue().getPartIDProperty().asObject());
        AllPartNameColumn.setCellValueFactory(cellData -> cellData.getValue().getNameProperty());
        AllPartInventoryColumn.setCellValueFactory(cellData -> cellData.getValue().getInStockProperty().asObject());
        AllPartPriceColumn.setCellValueFactory(cellData -> cellData.getValue().getPriceProperty().asObject());
        
        ProductPartIDColumn.setCellValueFactory(cellData -> cellData.getValue().getPartIDProperty().asObject());
        ProductPartNameColumn.setCellValueFactory(cellData -> cellData.getValue().getNameProperty());
        ProductPartInventoryColumn.setCellValueFactory(cellData -> cellData.getValue().getInStockProperty().asObject());
        ProductPartPriceColumn.setCellValueFactory(cellData -> cellData.getValue().getPriceProperty().asObject());
        
        saveClicked = false;
    }
    
    @FXML
    private void cancel(ActionEvent event) {
        saveClicked = false;
        dialogStage.close();
    }
    
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
    
    public void setProduct(Product newProduct) {
        this.product = newProduct;
        
        IDField.setText(Integer.toString(product.getProductID()));
        NameField.setText(product.getName());
        InventoryField.setText(Integer.toString(product.getInStock()));
        PriceField.setText(Double.toString(product.getPrice()));
        MaxField.setText(Integer.toString(product.getMax()));
        MinField.setText(Integer.toString(product.getMin()));
        
        AllPartsTable.setItems(mainApp.getPartsList());
        ProductPartsTable.setItems(product.getAssociatedParts());
    }
    
    public void setMainApp(InventoryManager mainApp) {
        this.mainApp = mainApp;
    }
    
    @FXML
    public void handleAddPart() {
        Part selectedPart = (Part) AllPartsTable.getSelectionModel().getSelectedItem();
        if(selectedPart != null) {
            product.addAssociatedPart(selectedPart);
            refreshTables();
        }
    }
    
    @FXML
    public void handleRemoveAssociatedPart() {
        Part selectedPart = (Part) ProductPartsTable.getSelectionModel().getSelectedItem();
        
        if(selectedPart != null) {
            product.removeAssociatedPart(product.getIndexOfPart(selectedPart));
        }
    }
    
    private void refreshTables() {
        AllPartsTable.refresh();
        ProductPartsTable.setItems(product.getAssociatedParts());
        ProductPartsTable.refresh();
    }
    
    public void handleSave() {
        product.setProductID(Integer.parseInt(IDField.getText()));
        product.setName(NameField.getText());
        product.setInStock(Integer.parseInt(InventoryField.getText()));
        product.setPrice(Double.parseDouble(PriceField.getText()));
        product.setMax(Integer.parseInt(MaxField.getText()));
        product.setMin(Integer.parseInt(MinField.getText()));
        
        saveClicked = true;
        dialogStage.close();
    }
    
    
    public boolean getSaveClicked() {
        return saveClicked;
    }
    
    @FXML
    public void handleSearchPart() {
        ObservableList<Part> searchResults = FXCollections.observableArrayList();
        String query = SearchField.getText();
        
        if(query != null) {
            for(Part currentPart : mainApp.getPartsList()) {
                if((currentPart.getName()).equalsIgnoreCase(query)) {
                    searchResults.add(currentPart);
                }
            }
        }
        
        AllPartsTable.setItems(searchResults);
        AllPartsTable.refresh();
    }
    
    @FXML
    public void handleCancelPartSeach() {
        AllPartsTable.setItems(mainApp.getPartsList());
        SearchField.clear();
        AllPartsTable.refresh();
    }
}

