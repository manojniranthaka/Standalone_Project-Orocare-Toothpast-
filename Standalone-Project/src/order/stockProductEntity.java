
package order;


public class stockProductEntity {
    
     int productId,quantity;
String location,Name,Size;
double unitPrice,sellPrice;


public stockProductEntity(int productId,String Name,String Size,String location,int quantity,double unitPrice,double sellPrice){
     this.productId = productId;
     this.location = location;
     this.unitPrice = unitPrice;
     this.sellPrice = sellPrice;
     this.Name = Name;
     this.Size = Size;
     this.quantity = quantity;
 }
 
 public int getProductId(){
     return productId;
 }
 
 public String getLocation(){
         return location;
}
 
 public int getQuantity(){
     return quantity;
 }
 
public double getUnitPrice(){
    return unitPrice;
}

public double getSellPrice(){
    return sellPrice;
}

public String getName(){
    return Name;
}

public String getSize(){
    return Size;
}

}
