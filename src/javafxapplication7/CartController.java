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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author danar
 */
public class CartController implements Initializable {
@FXML
    private Button home;

    @FXML
    private Button prodect;

    @FXML
    private Button help;

    @FXML
    private Button out;

    @FXML
    void handleButtonAction(ActionEvent event) throws IOException {
if(event.getSource() == home){
     
     Parent Home_page = FXMLLoader.load(getClass().getResource("customerHomepage.fxml"));
           Scene Home_page_scene = new Scene(Home_page);
           Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
           appStage.hide();
           appStage.setScene(Home_page_scene);
           appStage.show();
             
    
    }

else  if(event.getSource() == prodect){
     Parent Home_page = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
           Scene Home_page_scene = new Scene(Home_page);
           Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
           appStage.hide();
           appStage.setScene(Home_page_scene);
           appStage.show();
             
     
 
    }
 
 else if(event.getSource() == help){
     
      Parent Home_page = FXMLLoader.load(getClass().getResource("Help"
              + ".fxml"));
           Scene Home_page_scene = new Scene(Home_page);
           Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
           appStage.hide();
           appStage.setScene(Home_page_scene);
           appStage.show();
             
    }
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
