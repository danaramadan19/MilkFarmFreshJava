/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication7;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.sql.Connection;
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
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.swing.JRViewer;
import oracle.jdbc.pool.OracleDataSource;

/**
 * FXML Controller class
 *
 * @author danar
 */

public class OwnerHomepageController implements Initializable {
 @FXML
    private Button add;
 
   @FXML
    private Button product;
 @FXML
    private Button sells;
 
  @FXML
    private Button jasper;

    @FXML
    void handleButtonAction(ActionEvent event) throws IOException {
 if (event.getSource() == add){
     Parent Home_page = FXMLLoader.load(getClass().getResource("employeeTable.fxml"));
           Scene Home_page_scene = new Scene(Home_page);
           Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
           appStage.hide();
           appStage.setScene(Home_page_scene);
           appStage.show();
             
         
       }
 
 else if (event.getSource() == product){
     
     Parent Home_page = FXMLLoader.load(getClass().getResource("prodectTable.fxml"));
           Scene Home_page_scene = new Scene(Home_page);
           Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
           appStage.hide();
           appStage.setScene(Home_page_scene);
           appStage.show();
     
 }
 
  else if (event.getSource() == sells){

      Parent Home_page = FXMLLoader.load(getClass().getResource("sells.fxml"));
           Scene Home_page_scene = new Scene(Home_page);
           Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
           appStage.hide();
           appStage.setScene(Home_page_scene);
           appStage.show();
    
 }
 
 
  else if (event.getSource() == jasper){
      try{
           OracleDataSource ods = new OracleDataSource();
           ods.setURL("jdbc:oracle:thin:@localhost:1521:xe");
            ods.setUser("C##Dana");
            ods.setPassword("1992000");
             Connection con = ods.getConnection();
      InputStream input = new FileInputStream(new File("milkfarm.jrxml"));
      
     JasperDesign jd = JRXmlLoader.load(input);
     JasperReport jr = JasperCompileManager.compileReport(jd);
     JasperPrint jp = JasperFillManager.fillReport(jr, null, con);
    // OutputStream output = new FileOutputStream(new File("ProductSamary.pdf"));
    // JasperExportManager.exportReportToPdfStream(jp, output);
     
    // output.close();
    JFrame prFrame = new JFrame("Product Report");
    prFrame.getContentPane().add(new JRViewer(jp));
    prFrame.pack();
    prFrame.setVisible(true);
     input.close();
     con.close();
      
      }catch(Exception ex){
           JOptionPane.showMessageDialog(null, ex.toString());
          
      }   
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
