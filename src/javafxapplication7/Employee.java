/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication7;
import java.sql.Date;

public class Employee {
    
    int id  ;
    String name ;
    Date birth ;
    String city ,email ;
    String gender;
    int salary;

    public Employee(int id, String name,String email ,   String city , String gender ,Date birth,  int salary) {
        this.id = id;
        this.name = name;
        this.birth = birth;
        this.city = city;
        this.email = email;
        this.gender = gender;
        this.salary = salary;
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

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String adress) {
        this.city = city;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    

    public void setGender(String gender) {
        this.gender = gender;
    }
    
     public String getGender() {
        return gender;
    }
 public void setSalary(int Salary) {
        this.salary = salary;
    }
    
     public int getSalary() {
        return salary;
    }
    
}
