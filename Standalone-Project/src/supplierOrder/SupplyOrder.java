package supplierOrder;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class SupplyOrder {
    int sup_order_id;
    String material_name;
    int quantity;
    double total_price;
    String order_date;

    public SupplyOrder(int sup_order_id, String material_name, int quantity, double total_price, String order_date) {
        this.sup_order_id = sup_order_id;
        this.material_name = material_name;
        this.quantity = quantity;
        this.total_price = total_price;
        this.order_date = order_date;
    }


    public int getSup_order_id() {
        return sup_order_id;
    }

    public void setSup_order_id(int sup_order_id) {
        this.sup_order_id = sup_order_id;
    }

    public String getMaterial_name() {
        return material_name;
    }

    public void setMaterial_name(String material_name) {
        this.material_name = material_name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(double total_price) {
        this.total_price = total_price;
    }

    public String getOrder_date() {
        return order_date;
    }

    public void setOrder_date(String order_date) {
        this.order_date = order_date;
    }
}
