
package order;


public class orderEntity {
    
    String cusName,type,dateAdded,location,status;
    int orderID,cusID,proID,quantity;
    double  discount,total;
    
    public orderEntity(int orderID,String cusName,int cusID,int proID,int quantity,double discount,double total,String location,String type,String status,String dateAdded){
        this.orderID = orderID;
        this.cusName = cusName;
        this.cusID = cusID;
        this.proID = proID;
        this.quantity = quantity;
        this.discount = discount;
        this.total = total;
        this.location = location;
        this.type = type;
        this.status = status;
        this.dateAdded = dateAdded;
    }
    
    
    public int getOrderID(){
        return orderID;
    }
    
    public int getcusID(){
        return cusID;
    }
    
    public int getproID(){
        return proID;
    }
    
    public String getCusName(){
        return cusName;
    }
    
    public double getDiscount(){
        return discount;
    }
    
    public double getTotal(){
        return total;
    }
    
    public int getQuantity(){
        return quantity;
    }
    
    public String getLocation(){
        return location;
    }
    
    public String getType(){
        return type;
    }
    
    public String getStatus(){
        return status;
    }
    
     public String getDateAdded(){
        return dateAdded;
    }
    
}  