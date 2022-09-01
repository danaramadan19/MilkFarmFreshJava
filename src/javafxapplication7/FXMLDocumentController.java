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
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author danar
 */
public class FXMLDocumentController implements Initializable {
    
  /*  @FXML
    private Label label;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }*/
      @FXML
    private VBox chosenCard;

    @FXML
    private Label milkNameLable;

    @FXML
    private Label milkPriceLable;

    @FXML
    private ImageView milkImg;
    
     @FXML
    private ScrollPane scroll;

    @FXML
    private GridPane grid;
    
    @FXML
    private Button back;

   

    @FXML
    void handleButtonAction(ActionEvent event) throws IOException {
 if (event.getSource() == back){
     Parent Home_page = FXMLLoader.load(getClass().getResource("customerHomepage.fxml"));
           Scene Home_page_scene = new Scene(Home_page);
           Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
           appStage.hide();
           appStage.setScene(Home_page_scene);
           appStage.show();
         
       }
    }
    
    private List<Prodect> prodects = new ArrayList<>();
    private Image image;
    
    private MyListener myListener;
    private List<Prodect> getData(){
        List<Prodect> prodects = new ArrayList<>();
        Prodect prodect;
        
          prodect = new Prodect();
            prodect.setName("milk");
            prodect.setPrice(0.99);
            prodect.setImgSrc("Milk.jpg");
            prodect.setColor("99D3ED");
            prodects.add(prodect);
    
            prodect = new Prodect();
            prodect.setName("Labanh");
            prodect.setPrice(2.99);
            prodect.setImgSrc("labanh.jpg");
            prodect.setColor("BA6820");
            prodects.add(prodect);
            
             prodect = new Prodect();
            prodect.setName("Yougrt");
            prodect.setPrice(1.99);
            prodect.setImgSrc("youghrt.png");
            prodect.setColor("f4c2c2");
            prodects.add(prodect);
            
            prodect = new Prodect();
            prodect.setName("Mozarella");
            prodect.setPrice(5.99);
            prodect.setImgSrc("mozarella.jpg");
            prodect.setColor("53731C");
            prodects.add(prodect);
            
            
            
            prodect = new Prodect();
            prodect.setName("Cheese");
            prodect.setPrice(4.99);
            prodect.setImgSrc("nabolse.png");
            prodect.setColor("FCD50B");
            prodects.add(prodect);
            
              prodect = new Prodect();
            prodect.setName("Eggs");
            prodect.setPrice(3.99);
            prodect.setImgSrc("eags.jpg");
            prodect.setColor("C3A281");
            prodects.add(prodect);
            
              prodect = new Prodect();
            prodect.setName("Chicken");
            prodect.setPrice(7.99);
            prodect.setImgSrc("chicken.jpg");
            prodect.setColor("D3BBAF");
            prodects.add(prodect);
            
              prodect = new Prodect();
            prodect.setName("Beef");
            prodect.setPrice(10.99);
            prodect.setImgSrc("beef_PNG29.jpg");
            prodect.setColor("AC484A");
            prodects.add(prodect);
            
              prodect = new Prodect();
            prodect.setName("BeefGR");
            prodect.setPrice(9.99);
            prodect.setImgSrc("Ground+Beef.jpg");
            prodect.setColor("383E4B");
            prodects.add(prodect);
            
              prodect = new Prodect();
            prodect.setName("Ribs");
            prodect.setPrice(11.99);
            prodect.setImgSrc("ribs.jpg");
            prodect.setColor("CD9A6A");
            prodects.add(prodect);
            
            prodect = new Prodect();
            prodect.setName("Sausage");
            prodect.setPrice(12.99);
            prodect.setImgSrc("sausage.jpg");
            prodect.setColor("D65C1D");
            prodects.add(prodect);
            
            prodect = new Prodect();
            prodect.setName("Cheddar");
            prodect.setPrice(11.99);
            prodect.setImgSrc("marblechedder.jpg");
            prodect.setColor("F99D1A");
            prodects.add(prodect);
            
              prodect = new Prodect();
            prodect.setName("Smoothie");
            prodect.setPrice(4.99);
            prodect.setImgSrc("smoothie.png");
            prodect.setColor("CBC3E3");
            prodects.add(prodect);
        
        return prodects;
    }
private void setchosenCard(Prodect prodect){
    milkNameLable.setText(prodect.getName());
    milkPriceLable.setText(Main.CURRENCY + prodect.getPrice());
     image = new Image(getClass().getResourceAsStream(prodect.getImgSrc()));
     milkImg.setImage(image);
   chosenCard.setStyle(" -fx-background-color: #"+ prodect.getColor()+";\n" +
"    -fx-background-radius: 30;");
}
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        prodects.addAll(getData());
        if(prodects.size() > 0){
            setchosenCard(prodects.get(0));
            myListener = new MyListener() {
                @Override
                public void onClickListener(Prodect prodect) {
                setchosenCard(prodect);
                }
            };
        }
        int column = 0;
        int row = 1;
         try {
        for(int i = 0; i<prodects.size(); i++){
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("item.fxml"));
           
                AnchorPane anchorPane = fxmlLoader.load();
           
            ItemController itemController = fxmlLoader.getController();
            itemController.setData(prodects.get(i), myListener);
            
            if(column == 3){
                column = 0;
                row++;
            }
            grid.add(anchorPane, column++ ,row );
            //set item grid width
            
            grid.setMinWidth(Region.USE_COMPUTED_SIZE);
            grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
             grid.setMaxWidth(Region.USE_PREF_SIZE);
             
               //set item grid height
            
            grid.setMinHeight(Region.USE_COMPUTED_SIZE);
            grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
             grid.setMaxHeight(Region.USE_PREF_SIZE);
             
            GridPane.setMargin(anchorPane, new Insets(10));
        }
           } catch (IOException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }
    }    
    

