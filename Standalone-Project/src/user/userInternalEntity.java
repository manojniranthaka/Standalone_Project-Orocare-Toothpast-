/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

/**
 *
 * @author Sathira Guruge
 */
public class userInternalEntity {
    
    int UserID;
    int empID;
    String Username;
    String Password;
    int EmployeePriviledge;
    int CustomerPriviledge;
    int SupplierPriviledge;
    int ProductPriviledge;
    int StockPriviledge;
    int OrderPriviledge;
    int SalesPriviledge;
    int SalaryPriviledge;
    int UtilityPriviledge;
    int FinancePriviledge;
    int UserPriviledge;
    int NotificationPriviledge;
    
    public userInternalEntity(int UserID, int empID, String Username,String Password, int EmployeePriviledge, int CustomerPriviledge, int SupplierPriviledge, int ProductPriviledge, int StockPriviledge, int OrderPriviledge, int SalesPriviledge, int SalaryPriviledge, int UtilityPriviledge, int FinancePriviledge, int UserPriviledge, int NotificationPriviledge){
        this.UserID = UserID;
        this.empID = empID;
        this.Username = Username;
        this.Password = Password;
        this.EmployeePriviledge = EmployeePriviledge;
    this.CustomerPriviledge = CustomerPriviledge;
    this.SupplierPriviledge = SupplierPriviledge;
    this.ProductPriviledge = ProductPriviledge;
    this.StockPriviledge = StockPriviledge;
    this.OrderPriviledge = OrderPriviledge;
    this.SalesPriviledge = SalesPriviledge;
    this.SalaryPriviledge = SalaryPriviledge;
    this.UtilityPriviledge = UtilityPriviledge;
    this.FinancePriviledge = FinancePriviledge;
    this.UserPriviledge = UserPriviledge;
    this.NotificationPriviledge = NotificationPriviledge;
    }
    
    public int getUserID(){
        return UserID;
    }
    
    public int getEmpID(){
        return empID;
    }
    
    public String getUsername(){
        return Username;
    }
    
    public String getPassword(){
        return Password;
    }
    
     public int getEmployeePriviledge(){
        return EmployeePriviledge;
    }

     public int getCustomerPriviledge(){
        return CustomerPriviledge;
    }
     
     public int getSupplierPriviledge(){
        return SupplierPriviledge;
    }
     
      public int getProductPriviledge(){
        return ProductPriviledge;
    }
      
       public int getStockPriviledge(){
        return StockPriviledge;
    }
       
        public int getOrderPriviledge(){
        return OrderPriviledge;
    }
        
         public int getSalesPriviledge(){
        return SalesPriviledge;
    }
         
    public int getSalaryPriviledge(){
        return SalaryPriviledge;
    }
         
          public int getUtilityPriviledge(){
        return UtilityPriviledge;
    }
          
           public int getFinancePriviledge(){
        return FinancePriviledge;
    }
           
            public int getUserPriviledge(){
        return UserPriviledge;
    }
            
             public int getNotificationPriviledge(){
        return NotificationPriviledge;
    }
             
            
}
