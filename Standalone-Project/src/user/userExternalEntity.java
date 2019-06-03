package user;

public class userExternalEntity {

    int extID;
    String fname;
    String lname;
    String uname;
    String password;
    String dateAdded;

    public userExternalEntity(int extID, String fname, String lname, String uname, String password, String dateAdded) {
        this.extID = extID;
        this.fname = fname;
        this.lname = lname;
        this.uname = uname;
        this.password = password;
        this.dateAdded = dateAdded;
    }

    public int getID() {
        return extID;
    }

    public String getfname() {
        return fname;
    }

    public String getlname() {
        return lname;
    }

    public String getUname() {
        return uname;
    }

    public String getPassword() {
        return password;
    }

    public String getDate() {
        return dateAdded;
    }
}
