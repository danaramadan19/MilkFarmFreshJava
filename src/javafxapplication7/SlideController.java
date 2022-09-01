/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication7;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.util.Duration;
/**
 * FXML Controller class
 *
 * @author danar
 */
public class SlideController implements Initializable {

    @FXML
    private ImageView imageView;
    int count;
    public void slideshow(){
        ArrayList<Image> images = new ArrayList<Image>();
        images.add(new Image("/p2.jpg"));
         images.add(new Image("/p3.jpg"));
          images.add(new Image("/p4.jpg"));
           images.add(new Image("/p5.jpg"));
            images.add(new Image("/p1.jpg"));
         
            Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(5), event -> {
                imageView.setImage(images.get(count));
                count++;
                if(count==5)
                    count=0;
            }));
            timeline.setCycleCount(Timeline.INDEFINITE);
            timeline.play();
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        slideshow();
    }    
    
}
