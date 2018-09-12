/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorymanager.view_controller;

import inventorymanager.InventoryManager;
import inventorymanager.model.InhousePart;
import inventorymanager.model.OutsourcedPart;
import inventorymanager.model.Part;
import inventorymanager.model.Product;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;


public class MainMenuController implements Initializable {

    @FXML
    private Button DeleteProductBtn;

    @FXML
    private Button AddProductBtn;

    @FXML
    private Button AddPartBtn;

    @FXML
    private Button ModifyPartBtn;

    @FXML
    private TableColumn<Part, Integer> PartIDColumn;

    @FXML
    private TableColumn<Part, Integer> ProductInventoryColumn;

    @FXML
    private TableView<Part> PartsTableView;

    @FXML
    private TableColumn<Part, String> PartNameColumn;

    @FXML
    private TextField PartSearchField;

    @FXML
    private Button PartSearchBtn;

    @FXML
    private Button ExitBtn;

    @FXML
    private TableColumn<Part, Integer> PartInventoryColumn;

    @FXML
    private Label IMSLabel;

    @FXML
    private TableColumn<Part, Double> PartPriceColumn;

    @FXML
    private TableColumn<Product, Double> ProductPriceColumn;

    @FXML
    private Button ModifyProductBtn;

    @FXML
    private Button DeletePartBtn;

    @FXML
    private TableColumn<Product, Integer> ProductIDColumn;

    @FXML
    private TextField ProductSearchField;

    @FXML
    private TableColumn<Product, String> ProductNameColumn;

    @FXML
    private Button ProductSearchBtn;

    @FXML
    private TableView<Product> ProductsTableView;
    
    private InventoryManager mainApp;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        PartIDColumn.setCellValueFactory(cellData -> cellData.getValue().getPartIDProperty().asObject());
        PartNameColumn.setCellValueFactory(cellData -> cellData.getValue().getNameProperty());
        PartInventoryColumn.setCellValueFactory(cellData -> cellData.getValue().getInStockProperty().asObject());
        PartPriceColumn.setCellValueFactory(cellData -> cellData.getValue().getPriceProperty().asObject());
    }   
    
    @FXML
    void exit(ActionEvent event) {

    }

    @FXML
    void handleLoadAddProduct(ActionEvent event) {

    }

    @FXML
    void handleLoadModifyProduct(ActionEvent event) {

    }

    @FXML
    void handleAddPart(ActionEvent event) throws IOException {
        InhousePart newInPart = new InhousePart();
        OutsourcedPart newOutPart = new OutsourcedPart();
        ArrayList<Boolean> partConfig = mainApp.showAddPart(newInPart, newOutPart);
        boolean partToggle = partConfig.get(0);
        boolean saveClicked = partConfig.get(1);
        if(saveClicked) {
            if(partToggle) {
                mainApp.getPartsList().add(newInPart);
            }
            else {
                mainApp.getPartsList().add(newOutPart);
            }

            PartsTableView.refresh();
        }
    }

    @FXML
    public void handleModifyPart(ActionEvent event) throws IOException {
        Part selectedPart = PartsTableView.getSelectionModel().getSelectedItem();
        if (selectedPart != null) {
            mainApp.showModifyPart(selectedPart);
            PartsTableView.refresh();
        }
    }

    @FXML
    void handleDeletePart(ActionEvent event) {
        Part selectedPart = PartsTableView.getSelectionModel().getSelectedItem();
        if (selectedPart != null) {
            mainApp.getPartsList().remove(selectedPart);
            PartsTableView.refresh();
        }
    }
    
    public void setMainApp(InventoryManager mainApp) {
        this.mainApp = mainApp;
        
        this.PartsTableView.setItems(mainApp.getPartsList());
    }
}

