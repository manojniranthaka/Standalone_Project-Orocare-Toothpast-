package stock;

public class RawMaterialEntity {

    int rawID;
    String rawName;
    String rawDesc;
    String Date;

    public RawMaterialEntity(int rawID, String rawName, String rawDesc, String Date) {
        this.rawID = rawID;
        this.rawName = rawName;
        this.rawDesc = rawDesc;
        this.Date = Date;
    }

    public int getID() {
        return rawID;
    }
    
    public String getrawName(){
        return rawName;
    }
    
    public String getrawDesc(){
        return rawDesc;
    }
    
    public String getDate(){
        return Date;
    }
}
