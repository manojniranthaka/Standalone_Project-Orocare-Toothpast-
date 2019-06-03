package finance;

public class incomeEntity {

    int ID;
    String name;
    String type;
    Double amount;
    String DateAdded;
    String Date;

    public incomeEntity(int ID, String name, String type, Double amount, String DateAdded, String Date) {
        this.ID = ID;
        this.name = name;
        this.type = type;
        this.amount = amount;
        this.DateAdded = DateAdded;
        this.Date = Date;
    }

    public int getID() {
        return ID;
    }

    public double getAmount() {
        return amount;
    }

    public String getname() {
        return name;
    }

    public String gettype() {
        return type;
    }

    public String getDateAdded() {
        return DateAdded;
    }

    public String getDate() {
        return Date;
    }
}
