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
public class producttable {
     int id  ;
    String name ;
   
    String category ;
    int price;
    int much;
    
    
     public producttable(int id, String name,int price, String category ,int much) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
        this.much = much;
     
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getMuch() {
        return much;
    }

    public void setMuch(int much) {
        this.much = much;
    }
    
}
