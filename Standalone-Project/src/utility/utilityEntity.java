/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

/**
 *
 * @author Sathira Guruge
 */
public class utilityEntity {

    int UtilityID;
    String type;
    String name;
    Double Amount;
    String date;
    String added_dte;

    public utilityEntity(int UtilityID, String type, String name, Double Amount, String date, String added_dte) {
        this.UtilityID = UtilityID;
        this.type = type;
        this.name = name;
        this.Amount = Amount;
        this.date = date;
        this.added_dte = added_dte;
    }

    public int getUtilityID(){
        return UtilityID;
    }
    
    public Double getAmount(){
        return Amount;
    }
    
    public String gettype() {
        return type; 
    }

    public String getname() {
        return name;
    }

    public String getdate() {
        return date;
    }

    public String getadded_dte() {
        return added_dte;
    }
}
