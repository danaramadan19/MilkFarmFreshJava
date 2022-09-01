/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication7;

import javafx.scene.input.MouseEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author danar
 */
public class ItemController implements Initializable {

  @FXML
    private Label nameLabel;

    @FXML
    private Label priceLabel;

    @FXML
    private ImageView img;
    
    @FXML
    private void click(MouseEvent event) {
        myListener.onClickListener(prodect);
    }

    
    private Prodect prodect;
    
    private MyListener myListener;

    public void setData(Prodect prodect, MyListener myListener){
        this.prodect = prodect;
        this.myListener = myListener;
        nameLabel.setText(prodect.getName());
        priceLabel.setText(Main.CURRENCY + prodect.getPrice());
        Image image = new Image(getClass().getResourceAsStream(prodect.getImgSrc()));
        img.setImage(image);
        
    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
