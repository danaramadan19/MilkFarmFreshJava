/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor. 
 */
package javafxapplication7;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * 
 * @author danar  
 */
public class Main extends Application {
    
    public static final String CURRENCY = "$";
    
     
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("gaza.fxml"));
        
        Scene scene = new Scene(root);
        //
       //scene.setFill(Color.TRANSPARENT);
        //
       
        stage.setScene(scene);
        //
      //stage.initStyle(StageStyle.TRANSPARENT);
        //
        stage.show();
        
    }
        
      
    
 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
