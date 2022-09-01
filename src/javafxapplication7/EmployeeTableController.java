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
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import oracle.jdbc.pool.OracleDataSource;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
/**
 * FXML Controller class
 *
 * @author danar
 */
public class EmployeeTableController implements Initializable {
      @FXML
    private TextField idtext;

    @FXML
    private TextField nametext;

    @FXML
    private TextField emailtext;

    @FXML
    private TextField gendertext;

    @FXML
    private DatePicker birthtext;

    @FXML
    private TextField salarytext;
    
    @FXML
    private TextField citytext;


    @FXML
    private Button logout;


    @FXML
    private TableView<Employee> employeeTable;
    @FXML
    private TableColumn<Employee, Integer>  idCol;
    @FXML
    private TableColumn<Employee, String> nameCol;
    @FXML
    private TableColumn<Employee, String>emailCol;
    @FXML
    private TableColumn<Employee, String>  genderCol;
    @FXML
    private TableColumn<Employee, String> CctyCol;
    @FXML
    private TableColumn<Employee, String> birtCol;
    @FXML
    private TableColumn<Employee, Integer>  salartCol;
   
  

     @FXML
    private Button save;
        @FXML
    private Button update;

   
    @FXML
    private Button delete;
     
     private PreparedStatement prs = null;
     private ResultSet rs = null;
     private  Connection   con  = null;
  private     ObservableList<Employee> EmployeeList;
  Employee employee = null;
  
   @FXML
    private void clean() {
        idtext.setText(null);
        nametext.setText(null);
        emailtext.setText(null);
        gendertext.setText(null);
         citytext.setText(null);
          birthtext.setValue(null);
           salarytext.setText(null);
    }
    private void refreshTable() {
        try {
            EmployeeList.clear();
             OracleDataSource ods = new OracleDataSource();
            ods.setUser("C##Dana");
            ods.setPassword("1992000");
      String      query = "SELECT * FROM employee";
            prs = con.prepareStatement(query);
            rs = prs.executeQuery();
            
             while(  rs.next()){
      EmployeeList.add(new Employee(
              rs.getInt(1),
              rs.getString(2),
              rs.getString(3),
              rs.getString(4),
              rs.getString(5),
              rs.getDate(6),
              rs.getInt(7)
           
      ));
       employeeTable.setItems(EmployeeList);
             }     
            
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeTableController.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
 @FXML    
 public void Delete() {
          try {
              OracleDataSource ods = new OracleDataSource();
            ods.setUser("C##Dana");
            ods.setPassword("1992000");
            ods.setURL("jdbc:oracle:thin:@localhost:1521:xe");
            employee = employeeTable.getSelectionModel().getSelectedItem();
        
              
		
               int id = Integer.valueOf(idtext.getText());
          

              String sql = "delete from employee where ide ="+employee.id;
               Connection con = ods.getConnection();
               prs = con.prepareStatement(sql);
             
           prs.executeUpdate();
     //    refreshTable();
             loadDataFromDB(); 
              
             
          } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
          }
    }
     private void setcallfromtable(){
      
       employeeTable.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
                    public void handle(MouseEvent event){
       Employee s1 = employeeTable.getItems().get(employeeTable.getSelectionModel().getSelectedIndex());
        
        idtext.setText(String.valueOf(s1.getId()));
        nametext.setText(s1.getName());
        salarytext.setText(String.valueOf(s1.getSalary()));
        
        emailtext.setText(s1.getEmail());
      
       gendertext.setText(s1.getGender());
     citytext.setText(s1.getCity());
     
                    }
        
        }
        );
  
  }

    @FXML
    void handlerButtonAction(ActionEvent event) throws IOException  {
        
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
            String email = emailtext.getText();
            String gender = gendertext.getText();
            String city = citytext.getText();
            String birth = String.valueOf(birthtext.getValue());
            int salary = Integer.valueOf(salarytext.getText());
            
                 OracleDataSource ods = new OracleDataSource();
                 ods.setUser("C##Dana");
                 ods.setPassword("1992000");
                 ods.setURL("jdbc:oracle:thin:@localhost:1521:xe");
                 String sql = "update employee set fname = ? , email=?,gender=?,  city=? , birthdate=?,salary=? where ide = ? ";
                 Connection con = ods.getConnection();
                 prs = con.prepareStatement(sql);
               
            prs.setString(1, name);
             prs.setString(2, email);
              prs.setString(3, gender);
               prs.setString(4, city);
                prs.setDate(5,java.sql.Date.valueOf(birth) );
                 prs.setInt(6, salary); 
                   prs.setInt(7, id);
                  prs.executeUpdate();
               //   refreshTable();
                 loadDataFromDB(); 
             } catch (SQLException ex) {
                 Logger.getLogger(EmployeeTableController.class.getName()).log(Level.SEVERE, null, ex);
             }
         }
        
     else   if (event.getSource() == save){
          String name = nametext.getText();
            String email = emailtext.getText();
            String gender = gendertext.getText();
            String city = citytext.getText();
            String birth = String.valueOf(birthtext.getValue());
           if ( name.isEmpty() || gender.isEmpty() || birth.isEmpty() || city.isEmpty() ||  email.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please Fill All DATA");
            alert.showAndWait();

        }else{
          try {
              EmployeeList.clear();
              DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
              String url = "jdbc:oracle:thin:@localhost:1521:xe";
              con = DriverManager.getConnection(url, "C##Dana", "1992000");
              int id = Integer.valueOf(idtext.getText());
         /*   String name = nametext.getText();
            String email = emailtext.getText();
            String gender = gendertext.getText();
            String city = citytext.getText();
            String birth = String.valueOf(birthtext.getValue());*/
            int salary = Integer.valueOf(salarytext.getText());
            
              String query = "insert into employee values (?,?,?,?,?,?,?)";
              
              
            prs = con.prepareStatement(query);
            prs.setInt(1, id);
            prs.setString(2, name);
             prs.setString(3, email);
              prs.setString(4, gender);
               prs.setString(5, city);
                prs.setDate(6,java.sql.Date.valueOf(birth) );
                 prs.setInt(7, salary); 
                 
                 prs.executeUpdate();
                 
                 
                setCellTable();
        loadDataFromDB();
                 
          } catch (SQLException ex) {
              JOptionPane.showMessageDialog(null, ex.toString());
          }
          
          
        }
     }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         EmployeeList = FXCollections.observableArrayList();
        setCellTable();
        loadDataFromDB();
        setcallfromtable();
    } 
    
     private void setCellTable() {
       
        
       idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
       nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
       emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
       genderCol.setCellValueFactory(new PropertyValueFactory<>("gender"));
       CctyCol.setCellValueFactory(new PropertyValueFactory<>("city"));
       birtCol.setCellValueFactory(new PropertyValueFactory<>("birth"));
       salartCol.setCellValueFactory(new PropertyValueFactory<>("salary"));
       
       
       
        
    }
     
     private void loadDataFromDB(){
          try {
               EmployeeList.clear();
               OracleDataSource ods = new OracleDataSource();
            ods.setUser("C##Dana");
            ods.setPassword("1992000");
            ods.setURL("jdbc:oracle:thin:@localhost:1521:xe");
              String sql = "select * from employee";
               Connection con = ods.getConnection();
              prs = con.prepareStatement(sql);
              rs = prs.executeQuery();
               
             while(  rs.next()){
      EmployeeList.add(new Employee(
              rs.getInt(1),
              rs.getString(2),
              rs.getString(3),
              rs.getString(4),
              rs.getString(5),
              rs.getDate(6),
              rs.getInt(7)
           
      ));
       employeeTable.setItems(EmployeeList);
             }
             con.close(); 
          } catch (SQLException ex) {
               JOptionPane.showMessageDialog(null, ex.toString());
          }
     }
    
}
