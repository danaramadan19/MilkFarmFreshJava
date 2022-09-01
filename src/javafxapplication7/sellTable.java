/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication7;

import java.sql.Date;

/**
 *
 * @author danar
 */
public class sellTable {
     int id  ;
    String name ;
    Date selldate ;
    String address ,email ;
    String employee;
   String category;
    
    
     public sellTable(int id, String name,String category ,   Date selldate , String employee ,String address,  String email) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.selldate = selldate;
        this.employee = employee;
      this.address = address;
       this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getSelldate() {
        return selldate;
    }

    public void setSelldate(Date selldate) {
        this.selldate = selldate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
  

}
