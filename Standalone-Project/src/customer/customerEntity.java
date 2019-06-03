/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customer;

/**
 *
 * @author Sathira Guruge
 */
public class customerEntity {

    int CustomerID;
    String Name;
    String Address;
    String Email;
    String Type;
    String DateAdded;
    String Phone;
    
    public customerEntity(int CustomerID, String Name, String Address, String Email, String Type,String Phone, String DateAdded){
        this.CustomerID = CustomerID;
        this.Name = Name;
        this.Address = Address;
        this.Email = Email;
        this.Type = Type;       
        this.DateAdded = DateAdded;
        this.Phone = Phone;
    }
    
    public String getPhone(){
        return Phone;
    }
    
    
    public int getCustomerID(){
        return CustomerID;
    }
    
    public String getName(){
        return Name;
    }
    
    public String getAddress(){
        return Address;
    }
    
    public String getEmail(){
        return Email;
    }
    
    public String getType(){
        return Type;
    }
    
    public String getDateAdded(){
        return DateAdded;
    }
    
}
