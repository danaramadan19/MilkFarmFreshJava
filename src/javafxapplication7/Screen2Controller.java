/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication7;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author danar
 */
public class Screen2Controller implements Initializable {

     @FXML
    private Button owner;

    @FXML
    private Button customer;

    @FXML
    void handlerButtonAction(ActionEvent event) throws IOException {
        if (event.getSource() == owner){
           Parent Home_page = FXMLLoader.load(getClass().getResource("ownerlog.fxml"));
           Scene Home_page_scene = new Scene(Home_page);
           Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
           appStage.hide();
           appStage.setScene(Home_page_scene);
           appStage.show();
            
            
            /*
           Stage praimarystage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("ownerlog.fxml"));
        praimarystage.setTitle("Milk Farm..Fresh Prodects");
        Scene scene = new Scene(root);
        
        praimarystage.setScene(scene);
        praimarystage.show();*/
       }
        
       if(event.getSource() == customer){
         //  Stage appStage = new Stage();
            Parent Home_page = FXMLLoader.load(getClass().getResource("customerlog.fxml"));
           Scene Home_page_scene = new Scene(Home_page);
          Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
           appStage.hide();
           appStage.setScene(Home_page_scene);
           appStage.show();
          
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
