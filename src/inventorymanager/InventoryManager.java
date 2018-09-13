/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorymanager;

import inventorymanager.model.InhousePart;
import inventorymanager.model.Inventory;
import inventorymanager.model.OutsourcedPart;
import inventorymanager.model.Part;
import inventorymanager.model.Product;
import inventorymanager.view_controller.AddPartController;
import inventorymanager.view_controller.AddProductController;
import inventorymanager.view_controller.MainMenuController;
import inventorymanager.view_controller.ModifyPartController;
import java.io.IOException;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;


/**
 *
 * @author scott
 */
public class InventoryManager extends Application {
    
    private Stage primaryStage;
    public Inventory systemInventory;
    
    public InventoryManager() {
        systemInventory = new Inventory();
        for(int i = 0; i < 10; ++i) {
            String idNum = Integer.toString(i);
            Part newInHouse = new InhousePart(i, "part" + idNum, i + 43.46, 12, 10, 50, i + 1000);
            Part newOutsourced = new OutsourcedPart(i + 10, "part", i + 27.85, 40, 10, 100, "Company" + idNum);

            systemInventory.addPart(newInHouse);
            systemInventory.addPart(newOutsourced);
        }
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        this.primaryStage = stage;
        
        showMainMenu();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    public void showMainMenu() {
        try {
              FXMLLoader loader = new FXMLLoader();
              loader.setLocation(InventoryManager.class.getResource(Router.MainMenuURL));
              Parent mainMenu = loader.load();

              Scene scene = new Scene(mainMenu);
              Stage stage = new Stage();
              stage.setScene(scene);
              stage.show();
              
              // Give the controller access to the main app.
              MainMenuController controller = loader.getController();
              controller.setMainApp(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void showModifyPart(Part part) throws IOException {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(InventoryManager.class.getResource(Router.ModifyPartURL));
            Parent page = loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the parts in the controller.
            ModifyPartController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setPart(part);
            controller.updateForm();
            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();
    }
    
    public ArrayList<Boolean> showAddPart(InhousePart inPart, OutsourcedPart outPart) throws IOException {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(InventoryManager.class.getResource(Router.AddPartURL));
            Parent page = loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the part in the controller.
            AddPartController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setParts(inPart, outPart);
            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();
            
            return controller.getPartConfig();
    }
    
    public boolean showAddProduct(Product newProduct) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(InventoryManager.class.getResource(Router.AddProductURL));
        Parent page = loader.load();

        // Create the dialog Stage.
        Stage dialogStage = new Stage();
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage.initOwner(primaryStage);
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);

        // Set the product in the controller.
        AddProductController controller = loader.getController();
        controller.setMainApp(this);
        controller.setProduct(newProduct);
        controller.setDialogStage(dialogStage);
        // Show the dialog and wait until the user closes it
        dialogStage.showAndWait();
        return controller.getSaveClicked();
    }
    
    public boolean showModifyProduct(Product selectedProduct) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(InventoryManager.class.getResource(Router.AddProductURL));
        Parent page = loader.load();

        // Create the dialog Stage.
        Stage dialogStage = new Stage();
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage.initOwner(primaryStage);
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);

        // Set the product in the controller.
        AddProductController controller = loader.getController();
        controller.setMainApp(this);
        controller.setProduct(selectedProduct);
        controller.setDialogStage(dialogStage);
        // Show the dialog and wait until the user closes it
        dialogStage.showAndWait();
        return controller.getSaveClicked();
    }
    
    public Stage getPrimaryStage() {
        return this.primaryStage;
    }
    
    public ObservableList<Part> getPartsList() {
        return this.systemInventory.getParts();
    }
    
    public ObservableList<Product> getProductsList() {
        return this.systemInventory.getProducts();
    }
}
