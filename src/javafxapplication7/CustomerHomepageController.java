/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication7;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class CustomerHomepageController implements Initializable {
 
    @FXML
    private Button prodect;
    
     @FXML
    private Button cart;

    @FXML
    private Button help;

    @FXML
    private Button logout;
    @FXML
    private Button  deelss;
@FXML
    private Button adv;



  @FXML
    void handleButtonAction(ActionEvent event) throws IOException {
 if(event.getSource() == prodect){
     
              Parent Home_page = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
           Scene Home_page_scene = new Scene(Home_page);
           Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
           appStage.hide();
           appStage.setScene(Home_page_scene);
           appStage.show();
             
           
 /*    Stage praimarystage = new Stage();
     Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        praimarystage.setTitle("Milk Farm..Fresh Prodects");
        Scene scene = new Scene(root);
        
        praimarystage.setScene(scene);
        praimarystage.show();*/
 }
 
 else  if(event.getSource() == cart){
     
         Parent Home_page = FXMLLoader.load(getClass().getResource("cart.fxml"));
           Scene Home_page_scene = new Scene(Home_page);
           Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
           appStage.hide();
           appStage.setScene(Home_page_scene);
           appStage.show();
             
    }
 
 else if(event.getSource() == help){
     
        Parent Home_page = FXMLLoader.load(getClass().getResource("Help.fxml"));
           Scene Home_page_scene = new Scene(Home_page);
           Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
           appStage.hide();
           appStage.setScene(Home_page_scene);
           appStage.show();
             
    }
 else if(event.getSource() == logout){
     
        Parent Home_page = FXMLLoader.load(getClass().getResource("s"
                + "creen2.fxml"));
           Scene Home_page_scene = new Scene(Home_page);
           Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
           appStage.hide();
           appStage.setScene(Home_page_scene);
           appStage.show();
             
    }
 
 else if(event.getSource() ==  deelss){
     
        Stage praimarystage = new Stage();
     Parent root = FXMLLoader.load(getClass().getResource("deals.fxml"));
        praimarystage.setTitle("Milk Farm..Fresh Prodects");
        Scene scene = new Scene(root);
        
        praimarystage.setScene(scene);
        praimarystage.show();
             
    }
 
  else if(event.getSource() == adv){
     
        Stage praimarystage = new Stage();
     Parent root = FXMLLoader.load(getClass().getResource("advice.fxml"));
        praimarystage.setTitle("Milk Farm..Fresh Prodects");
        Scene scene = new Scene(root);
        
        praimarystage.setScene(scene);
        praimarystage.show();
             
    }
    }
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     
    }
    

    

    }
