/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supplier;

/**
 *
 * @author Sathira Guruge
 */
public class supplierEntity {

    int SupplierID;
    String Name;
    String Address;
    String Email;
    String StartDate;
    String EndDate;
    String BusinessType;
    String NatureofBusiness;
    String BRNo;
    String dateAdded;

    public supplierEntity(int SupplierID, String Name, String Address, String Email, String StartDate, String EndDate, String BusinessType, String NatureofBusiness, String BRNo, String dateAdded) {
        this.SupplierID = SupplierID;
        this.Name = Name;
        this.Address = Address;
        this.Email = Email;
        this.StartDate = StartDate;
        this.EndDate = EndDate;
        this.BusinessType = BusinessType;
        this.NatureofBusiness = NatureofBusiness;
        this.BRNo = BRNo;
        this.dateAdded = dateAdded;    
    }
    
    public int getSupplierID(){
        return SupplierID;
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
    public String getStartDate(){
        return StartDate;
    }
    public String getEndDate(){
        return EndDate;
    }
    public String getBusinessType(){
        return BusinessType;
    }
    public String getNatureofBusiness(){
        return NatureofBusiness;
    }
    public String getBRNo(){
        return BRNo;
    }
    public String getdateAdded(){
        return dateAdded;
    }

}
