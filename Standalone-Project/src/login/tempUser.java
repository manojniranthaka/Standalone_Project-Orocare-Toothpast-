package login;
public class tempUser {
    
    private static int ID;
    private static String username = null;
    private static tempUser user;
    private static String type = null;
    private static int EmployeeID;
    
    private tempUser(){}
    
    public void setID(int ID){
        this.ID = ID;
    }
    
    public void setEmployeeID(int EMPID){
        this.EmployeeID = EMPID;
    }
    
    public int getEmployeeID(){
        return EmployeeID;
    }
    
    public int getID(){
        return ID;
    }
    
    public void setUsername(String username){
        tempUser.username = username;
    }
    
    public String getUsername(){
        return tempUser.username;
    }
    
    public String getType(){
        return type;
    }
    
    public  void setType(String type){
        this.type = type;
    }
    
    public static tempUser getTempUserInstance(){
        if (user == null)
            user = new tempUser();
        return user;
    }
}
