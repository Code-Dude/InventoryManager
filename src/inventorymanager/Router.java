/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorymanager;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author scott
 */
public class Router {
    public static String MainMenuURL = "view_controller/MainMenu.fxml";
    public static String AddPartURL = "view_controller/AddPart.fxml";
    public static String ModifyPartURL = "view_controller/ModifyPart.fxml";
    public static String AddProductURL = "view_controller/AddProduct.fxml";
    public static String ModifyProductURL = "view_controller/ModifyProduct.fxml";
}
