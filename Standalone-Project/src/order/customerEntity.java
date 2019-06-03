
package order;


public class customerEntity {
    
    int customerId;
    String name;
    
    public customerEntity(String name,int customerId ){
        this.customerId = customerId;
        this.name = name;
    }
    
    public int getCustomerID(){
        return customerId;
    }
    
    public String getCustomerName(){
        return name;
    }
}
