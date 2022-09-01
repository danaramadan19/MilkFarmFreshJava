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
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author danar
 */
public class SignUpController implements Initializable {

    @FXML
    private TextField name;
    @FXML
    private Label emptyname;
    @FXML
    private TextField number;
    @FXML
    private Label emptynum;
    @FXML
    private TextField email;
    @FXML
    private Label emptyemail;
    @FXML
    private PasswordField password;
    @FXML
    private Label emptypass;
    @FXML
    private PasswordField replay;
    @FXML
    private Label emptyrebly;
   @FXML
    private Button sign;

    @FXML
    void handleButtonAction(ActionEvent event) throws IOException {
 if(event.getSource() == sign){
   //  Stage appStage = new Stage();
              Parent Home_page = FXMLLoader.load(getClass().getResource("customerHomepage.fxml"));
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
