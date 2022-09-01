/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication7;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import oracle.jdbc.pool.OracleDataSource;

/**
 * FXML Controller class
 *
 * @author danar
 */
public class ProdectTableController implements Initializable {
   @FXML
    private TableView<producttable> productTable;

    @FXML
    private TableColumn<producttable, Integer> idCol;

    @FXML
    private TableColumn<producttable, String> nameCol;

    @FXML
    private TableColumn<producttable, Integer> priceCol;

    @FXML
    private TableColumn<producttable, String> catCol;

    @FXML
    private TableColumn<producttable, Integer> boughtCol;

    @FXML
    private TextField idtext;

    @FXML
    private TextField nametext;

    @FXML
    private TextField pricetext;

    @FXML
    private TextField categorytext;

    @FXML
    private TextField boughttext;

    @FXML
    private Button logout;

    @FXML
    private Button logout1;

    @FXML
    private Button save;

    @FXML
    private Button update;

    @FXML
    private Button save111;
    
       private PreparedStatement prs = null;
     private ResultSet rs = null;
     private  Connection   con  = null;
     private  ObservableList<producttable> productList;
producttable product = null;
     
      @FXML
    private void clean() {
        idtext.setText(null);
        nametext.setText(null);
        pricetext.setText(null);
        categorytext.setText(null);
         boughttext.setText(null);
    }
private void refreshTable() {
        try {
         //   productList.clear();
             OracleDataSource ods = new OracleDataSource();
            ods.setUser("C##Dana");
            ods.setPassword("1992000");
            String query = "select * from prodect";
            prs = con.prepareStatement(query);
            rs = prs.executeQuery();
            
                 
             while(  rs.next()){
      productList.add(new producttable(
              rs.getInt(1),
              rs.getString(2),
              rs.getInt(3),
              rs.getString(4),
              rs.getInt(5)
           
      ));
       productTable.setItems(productList);
             }
            
        } catch (SQLException ex) {
            Logger.getLogger(ProdectTableController.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
 @FXML    
 public void Delete() {
          try {
              OracleDataSource ods = new OracleDataSource();
            ods.setUser("C##Dana");
            ods.setPassword("1992000");
            ods.setURL("jdbc:oracle:thin:@localhost:1521:xe");
            product  = productTable.getSelectionModel().getSelectedItem();
        
              
		
               int id = Integer.valueOf(idtext.getText());
          

              String sql = "delete from prodect where ID_PRODECT="+product .id;
               Connection con = ods.getConnection();
               prs = con.prepareStatement(sql);
             
           prs.executeUpdate();
       //  refreshTable();
         //  setCellTable();
         loadDataFromDB(); 
              
             
          } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
          }
    }
  private void setcallfromtable(){
      
       productTable.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
                    public void handle(MouseEvent event){
        producttable s1 = productTable.getItems().get(productTable.getSelectionModel().getSelectedIndex());
        
        idtext.setText(String.valueOf(s1.getId()));
        nametext.setText(s1.getName());
        pricetext.setText(String.valueOf(s1.getPrice()));
        
        categorytext.setText(s1.getCategory());
       boughttext.setText(String.valueOf(s1.getMuch()));
      
     
                    }
        
        }
        );
  
  }
    @FXML
    void handlerButtonAction(ActionEvent event) throws IOException {
        
        if (event.getSource() == logout){
            
              Parent Home_page = FXMLLoader.load(getClass().getResource("ownerHomepage.fxml"));
           Scene Home_page_scene = new Scene(Home_page);
           Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
           appStage.hide();
           appStage.setScene(Home_page_scene);
           appStage.show();
         
        
         }
        
        else if(event.getSource() == update){
             try {
                int id = Integer.valueOf(idtext.getText());
            String name = nametext.getText();
             int price = Integer.valueOf(pricetext.getText());
            String category = categorytext.getText();
             int much = Integer.valueOf(boughttext.getText());
             
                 OracleDataSource ods = new OracleDataSource();
                 ods.setUser("C##Dana");
                 ods.setPassword("1992000");
                 ods.setURL("jdbc:oracle:thin:@localhost:1521:xe");
                 String sql = "update prodect set pname = ? , price=?,categorym=?, HOW_MANY_PRODECT_BOUGHT=?  where ID_PRODECT= ? ";
                 Connection con = ods.getConnection();
                 prs = con.prepareStatement(sql);
               
             prs = con.prepareStatement(sql);
          
            prs.setString(1, name);
            prs.setInt(2, price);
            prs.setString(3, category);
            prs.setInt(4, much); 
               prs.setInt(5, id);    
                  prs.executeUpdate();
               //   refreshTable();
                 loadDataFromDB(); 
             } catch (SQLException ex) {
                 Logger.getLogger(EmployeeTableController.class.getName()).log(Level.SEVERE, null, ex);
             }
         }
        else if (event.getSource() == save){
               int id = Integer.valueOf(idtext.getText());
            String name = nametext.getText();
             int price = Integer.valueOf(pricetext.getText());
            String category = categorytext.getText();
             int much = Integer.valueOf(boughttext.getText());
             
              if ( name.isEmpty() ||  category.isEmpty() ) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please Fill All DATA");
            alert.showAndWait();

        }else{
          try {
              productList.clear();
              DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
              String url = "jdbc:oracle:thin:@localhost:1521:xe";
              con = DriverManager.getConnection(url, "C##Dana", "1992000");
             /* int id = Integer.valueOf(idtext.getText());
            String name = nametext.getText();
             int price = Integer.valueOf(pricetext.getText());
            String category = categorytext.getText();
             int much = Integer.valueOf(boughttext.getText());*/
              String query = "insert into prodect values (?,?,?,?,?)";
              
              
            prs = con.prepareStatement(query);
            prs.setInt(1, id);
            prs.setString(2, name);
            prs.setInt(3, price);
            prs.setString(4, category);
            prs.setInt(5, much); 
                 
            prs.executeUpdate();
                 
                 
                setCellTable();
        loadDataFromDB();
                 
          } catch (SQLException ex) {
              JOptionPane.showMessageDialog(null, ex.toString());
          }
          
          
        }
    }
    
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        productList = FXCollections.observableArrayList();
        setCellTable();
        loadDataFromDB();
        setcallfromtable();
    }    

    private void setCellTable() {
          idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
       nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
       priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
       catCol.setCellValueFactory(new PropertyValueFactory<>("category"));
       boughtCol.setCellValueFactory(new PropertyValueFactory<>("much"));
     
       
    }

    private void loadDataFromDB() {
         try {
               productList.clear();
               OracleDataSource ods = new OracleDataSource();
            ods.setUser("C##Dana");
            ods.setPassword("1992000");
            ods.setURL("jdbc:oracle:thin:@localhost:1521:xe");
              String sql = "select * from prodect";
               Connection con = ods.getConnection();
              prs = con.prepareStatement(sql);
              rs = prs.executeQuery();
               
             while(  rs.next()){
      productList.add(new producttable(
              rs.getInt(1),
              rs.getString(2),
              rs.getInt(3),
              rs.getString(4),
              rs.getInt(5)
           
      ));
       productTable.setItems(productList);
             }
             con.close(); 
          } catch (SQLException ex) {
               JOptionPane.showMessageDialog(null, ex.toString());
          }
     }
    }
    

