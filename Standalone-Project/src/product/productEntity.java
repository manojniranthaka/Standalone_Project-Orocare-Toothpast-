package product;


public class productEntity {

    int ProductID;
    String Name;
    String Description;
    String Size;
    String Flavour;
    Double Weight;
    String dateAdded;
    
    public productEntity( int ProductID, String Name,String Description, String Size, String Flavour, Double Weight, String dateAdded){
        this.ProductID = ProductID;
        this.Name = Name;
        this.Description = Description;
        this.Size = Size;
        this.Flavour = Flavour;
        this.Weight = Weight;
        this.dateAdded = dateAdded;
    }
    
    public String getDate(){
        return dateAdded;
    }
    
    
    public int getProdID(){
        return ProductID;
    }
    
    public String getName(){
        return Name;
    }
    public String getDescription(){
        return Description;
    }
    public String getSize(){
        return Size;
    }
    public String getFlavour(){
        return Flavour;
    }
    public Double getWeight(){
        return Weight;
    }
}
