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
public class OwnerlogController implements Initializable {

    @FXML
    private TextField emailtext;

    @FXML
    private Label rongemail;

    @FXML
    private PasswordField passwordtext;

    @FXML
    private Label rongpass;

    @FXML
    private Button logbtn;
    
       @FXML
    private Label alllable;

    @FXML
    void handleButtonAction(ActionEvent event) throws IOException {
     if(event.getSource() == logbtn){
         String usertext = emailtext.getText();
         String passtext = passwordtext.getText();
         
         if(usertext.equalsIgnoreCase("dana@gmail.com") && passtext.equalsIgnoreCase("admin")){
           Parent Home_page = FXMLLoader.load(getClass().getResource("ownerHomepage.fxml"));
           Scene Home_page_scene = new Scene(Home_page);
           Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
           appStage.hide();
           appStage.setScene(Home_page_scene);
           appStage.show();
             
             
           
         }
         
      else   if(passtext.isEmpty() && usertext.isEmpty() ){
              rongemail.setText("email is empty");
             rongpass.setText("Password is empty");
             alllable.setText(" ");
         } 
         
         
         
         else if(usertext.isEmpty()){
             rongemail.setText("email is empty");
               rongpass.setText(" ");
              alllable.setText(" ");
         }
         
          else if(passtext.isEmpty()){
               rongemail.setText(" ");
             rongpass.setText("Password is empty");
              alllable.setText(" ");
         }
          
         
         else{
             rongemail.setText(" ");
             rongpass.setText(" ");
              alllable.setText("wrong email or password");
         }
     }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
