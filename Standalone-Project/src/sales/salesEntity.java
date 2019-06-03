package sales;


public class salesEntity {
    
    String dateSold,proName;
    int salesID,cusID,proID,quantity;
    double  discount,total,profit;
    
    public salesEntity(int salesID,String proName,int proID,int cusID,int quantity,double discount,double total,double profit,String dateSold){
        this.salesID = salesID;
        this.proName = proName;
        this.cusID = cusID;
        this.proID = proID;
        this.quantity = quantity;
        this.discount = discount;
        this.total = total;
        this.profit = profit;
        this.dateSold = dateSold;
    }
    
    
    public int getSalesID(){
        return salesID;
    }
    
    public String getProName(){
        return proName;
    }
    
    public int getcusID(){
        return cusID;
    }
    
    public int getproID(){
        return proID;
    }
    
    
    public double getDiscount(){
        return discount;
    }
    
    public double getProfit(){
    return profit;
}
    
    public double getTotal(){
        return total;
    }
    
    public int getQuantity(){
        return quantity;
    }
    
    
     public String getDateSold(){
        return dateSold;
    }
}
