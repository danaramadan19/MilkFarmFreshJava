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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import oracle.jdbc.pool.OracleDataSource;
/**
 * FXML Controller class
 *
 * @author danar
 */
public class SellsController implements Initializable {
    @FXML
    private TextField idtext;

    @FXML
    private TextField nametext;

    @FXML
    private TextField cattext;

    @FXML
    private DatePicker selltext;

    @FXML
    private TextField employeetext;

    @FXML
    private TextField addresstext;

    @FXML
    private TextField emailtext;

    @FXML
    private Button logout;

    @FXML
    private Button clean;

    @FXML
    private TableView<sellTable> sell;

    @FXML
    private TableColumn<sellTable, Integer> idCol;

    @FXML
    private TableColumn<sellTable, String> nameCol;

    @FXML
    private TableColumn<sellTable, String> catCol;

    @FXML
    private TableColumn<sellTable, String> dateCol;

    @FXML
    private TableColumn<sellTable, String> employeeCol;

    @FXML
    private TableColumn<sellTable, String> addressCol;

    @FXML
    private TableColumn<sellTable, String>emailCol;

    @FXML
    private Button save;

    @FXML
    private Button update;

    @FXML
    private Button Delete;
    
    
     private PreparedStatement prs = null;
     private ResultSet rs = null;
     private  Connection   con  = null;
  private     ObservableList<sellTable> sellList;
  
  sellTable sells = null;
  

    @FXML
    void clean() {
idtext.setText(null);
        nametext.setText(null);
        emailtext.setText(null);
        cattext.setText(null);
         selltext.setValue(null);
         employeetext.setText(null);
        addresstext.setText(null);
    }
 private void refreshTable() {
        try {
            sellList.clear();
             OracleDataSource ods = new OracleDataSource();
            ods.setUser("C##Dana");
            ods.setPassword("1992000");
      String   query = "SELECT * FROM sell";
            prs = con.prepareStatement(query);
            rs = prs.executeQuery();
            
              while(  rs.next()){
      sellList.add(new sellTable(
              rs.getInt(1),
              rs.getString(2),
              rs.getString(3),
              rs.getDate(4),
              rs.getString(5),
              rs.getString(6),
              rs.getString(7)
           
      ));
       sell.setItems(sellList);
       
       
             }
            
        } catch (SQLException ex) {
            Logger.getLogger(SellsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
 @FXML    
 public void Delete() {
          try {
              OracleDataSource ods = new OracleDataSource();
            ods.setUser("C##Dana");
            ods.setPassword("1992000");
            ods.setURL("jdbc:oracle:thin:@localhost:1521:xe");
            sells = sell.getSelectionModel().getSelectedItem();
        
              
		
               int id = Integer.valueOf(idtext.getText());
          

              String sql = "delete from sell where ID_PRODECT="+sells.id;
               Connection con = ods.getConnection();
               prs = con.prepareStatement(sql);
             
           prs.executeUpdate();
        // refreshTable();
           setCellTable();
       //  loadDataFromDB(); 
              
             
          } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
          }
    }
 
  private void setcallfromtable(){
      
        sell.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
                    public void handle(MouseEvent event){
        sellTable s1 = sell.getItems().get(sell.getSelectionModel().getSelectedIndex());
        
        idtext.setText(String.valueOf(s1.getId()));
        nametext.setText(s1.getName());
        cattext.setText(s1.getCategory());
       
        employeetext.setText(s1.getEmployee());
        addresstext.setText(s1.getAddress());
        emailtext.setText(s1.getEmail());
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
            String category = cattext.getText();
             String selldate = String.valueOf(selltext.getValue());
            String employee = employeetext.getText();
            String address = addresstext.getText();
          String email = emailtext.getText();
                 OracleDataSource ods = new OracleDataSource();
                 ods.setUser("C##Dana");
                 ods.setPassword("1992000");
                 ods.setURL("jdbc:oracle:thin:@localhost:1521:xe");
                 String sql = "update sell set pname = ? ,categorym=?, DATEOFSALLING =? ,ATTENDBY=? , ADDRESS=?, GMAIL=?  where ID_PRODECT= ? ";
                 Connection con = ods.getConnection();
                 prs = con.prepareStatement(sql);
               
             prs = con.prepareStatement(sql);
         
            prs.setString(1, name);
             prs.setString(2, category);
              prs.setDate(3,java.sql.Date.valueOf(selldate) );
              prs.setString(4, employee);
               prs.setString(5, address);
               
                 prs.setString(6, email); 
                   prs.setInt(7, id);
                  
                  prs.executeUpdate();
            //    refreshTable();
                 setCellTable(); 
             } catch (SQLException ex) {
                 Logger.getLogger(EmployeeTableController.class.getName()).log(Level.SEVERE, null, ex);
             }
         }
         
          else   if (event.getSource() == save){
               int id = Integer.valueOf(idtext.getText());
               
                String name = nametext.getText();
            String category = cattext.getText();
             String selldate = String.valueOf(selltext.getValue());
            String employee = employeetext.getText();
            String address = addresstext.getText();
          String email = emailtext.getText();
                if ( name.isEmpty() || category.isEmpty() || selldate.isEmpty() || employee.isEmpty() || address.isEmpty() || email.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please Fill All DATA");
            alert.showAndWait();

        }else{
          try {
              sellList.clear();
              DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
              String url = "jdbc:oracle:thin:@localhost:1521:xe";
              con = DriverManager.getConnection(url, "C##Dana", "1992000");
         /*     int id = Integer.valueOf(idtext.getText());
            String name = nametext.getText();
            String category = cattext.getText();
             String selldate = String.valueOf(selltext.getValue());
            String employee = employeetext.getText();
            String address = addresstext.getText();
          String email = emailtext.getText();*/
            
              String query = "insert into sell values (?,?,?,?,?,?,?)";
              
              
            prs = con.prepareStatement(query);
            prs.setInt(1, id);
            prs.setString(2, name);
             prs.setString(3, category);
              prs.setDate(4,java.sql.Date.valueOf(selldate) );
              prs.setString(5, employee);
               prs.setString(6, address);
               
                 prs.setString(7, email); 
                 
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
        sellList = FXCollections.observableArrayList();
        setCellTable();
        loadDataFromDB();
       setcallfromtable();
    }    

    private void loadDataFromDB() {
       idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
       nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
      catCol.setCellValueFactory(new PropertyValueFactory<>("category"));
       dateCol.setCellValueFactory(new PropertyValueFactory<>("selldate"));
       employeeCol.setCellValueFactory(new PropertyValueFactory<>("employee"));
       addressCol.setCellValueFactory(new PropertyValueFactory<>("address"));
       emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
       
    }

    private void setCellTable() {
         sellList.clear();
        try {
               OracleDataSource ods = new OracleDataSource();
            ods.setUser("C##Dana");
            ods.setPassword("1992000");
            ods.setURL("jdbc:oracle:thin:@localhost:1521:xe");
              String sql = "select * from sell";
               Connection con = ods.getConnection();
              prs = con.prepareStatement(sql);
              rs = prs.executeQuery();
               
             while(  rs.next()){
      sellList.add(new sellTable(
              rs.getInt(1),
              rs.getString(2),
              rs.getString(3),
              rs.getDate(4),
              rs.getString(5),
              rs.getString(6),
              rs.getString(7)
           
      ));
       sell.setItems(sellList);
       
       
             }
             con.close(); 
          } catch (SQLException ex) {
               JOptionPane.showMessageDialog(null, ex.toString());
          
     }
    }
    
}
