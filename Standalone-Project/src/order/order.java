package order;

import connection.Connector;
import java.awt.Color;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import org.jdesktop.swingx.JXDatePicker;
import printer.printer;



public class order extends javax.swing.JFrame {
   
    
   
    public order() {
        initComponents();
         userleft.setBackground(new Color(75,0,130,80));
         showOrders();
         showStocksProducts();
         showCustomers();
         setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
         order_text.setVisible(false);
         starGen1.setVisible(false);
         starGen2.setVisible(false);
        starGen3.setVisible(false);
        starGen4.setVisible(false);
        starGen6.setVisible(false);
        starGen7.setVisible(false);
        starGen8.setVisible(false);
        starGen9.setVisible(false);
        confirm_order.setEnabled(false);
        check_avb.setEnabled(false);
        add_butt.setEnabled(false);
        order_profit.setVisible(false);
        prod_name.setVisible(false);
        qty_left.setVisible(false);
        resetDate(date_picker);
        
    
        
       
 }
    
    
    
    
    public void clear() {
         
         order_text.setText("");
        order_cus_name.setText("");
        tot_text.setText("");
        order_qty.setText("");
        order_disc.setText("");
        cus_id.setText("");
        pro_id.setText("");
        order_loc.setText("");
        resetDate(date_picker);
        type_combo.setSelectedIndex(0);
        add_butt.setEnabled(false);
        check_avb.setEnabled(false);
        
     }
    
    public void add(){
        if (validateForm() != -1) {   
            
            
        String cusName = order_cus_name.getText().toString();
        String cusId = cus_id.getText().toString();
        String proId = pro_id.getText().toString();
        String quantity = order_qty.getText().toString();
        String discount = order_disc.getText().toString();
         String total = tot_text.getText().toString();
        String type = type_combo.getSelectedItem().toString();
        String date = getDate(date_picker);
        String profit = order_profit.getText().toString();
        String name = prod_name.getText().toString();
        String location = order_loc.getText().toString();
        String qtyLeft = qty_left.getText().toString();
        String status = "confirmed";
        
        if(type.contains("Internal")){
        
        
            
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/orocare", "root", "");
            
            PreparedStatement stmt = myConn.prepareStatement("INSERT INTO CUSORDER(cusName, cusID, productID, qty, discount,total,location,type,status,dateAdded) VALUES (?,?,?,?,?,?,?,?,?,?)");
            stmt.setString(1,cusName);
            stmt.setString(2,cusId);
            stmt.setString(3,proId);
            stmt.setString(4,quantity);
            stmt.setString(5,discount);
            stmt.setString(6,total);
            stmt.setString(7,location);
            stmt.setString(8,type);
            stmt.setString(9,status);
            stmt.setString(10,date);
            int i = stmt.executeUpdate();
            if(i == 1){
            JOptionPane.showMessageDialog(null, "Record Added Successfully", "Message!", JOptionPane.INFORMATION_MESSAGE);
            }
            refreshtable();
            
            
        
            
            
           PreparedStatement stmt2 = myConn.prepareStatement("INSERT INTO SALES(proName, prID, cuID, qty, discount, totEarn, profit, dateSold) VALUES (?,?,?,?,?,?,?,?)");
            stmt2.setString(1,name);
            stmt2.setString(2,proId);
            stmt2.setString(3,cusId);
            stmt2.setString(4,quantity);
            stmt2.setString(5,discount);
            stmt2.setString(6,total);
            stmt2.setString(7,profit);
            stmt2.setString(8,date);
            int j = stmt2.executeUpdate();
             if(j == 1){
            JOptionPane.showMessageDialog(null, "Sales updated Successfully", "Message!", JOptionPane.INFORMATION_MESSAGE);
            }
            PreparedStatement stmt3 = myConn.prepareStatement("UPDATE stockproduct SET avl_qty = ?  WHERE prodID = ? AND location = ?");
            stmt3.setString(1,qtyLeft);
            stmt3.setString(2,proId);
            stmt3.setString(3,location);
            int k = stmt3.executeUpdate();
             if(k == 1){
            JOptionPane.showMessageDialog(null, "Stocks has been updated!", "Message!", JOptionPane.INFORMATION_MESSAGE);
            }
            
            refreshtableStockProduct();
            add_butt.setEnabled(false);
            check_avb.setEnabled(false);
            clear();
            
            
          }catch(Exception e){
            System.out.println(e);
        }
        
        }else{
            
             try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/orocare", "root", "");
            
            PreparedStatement stmt = myConn.prepareStatement("INSERT INTO CUSORDER(cusName, cusID, productID, qty, discount,total,location,type,status,dateAdded) VALUES (?,?,?,?,?,?,?,?,?,?)");
            stmt.setString(1,cusName);
            stmt.setString(2,cusId);
            stmt.setString(3,proId);
            stmt.setString(4,quantity);
            stmt.setString(5,discount);
            stmt.setString(6,total);
            stmt.setString(7,location);
            stmt.setString(8,type);
            stmt.setString(9,"pending");
            stmt.setString(10,date);
            int i = stmt.executeUpdate();
            if(i == 1){
            JOptionPane.showMessageDialog(null, "Record Added Successfully", "Message!", JOptionPane.INFORMATION_MESSAGE);
            }
            refreshtable();
            add_butt.setEnabled(false);
            check_avb.setEnabled(false);
            clear();
            
            }catch(Exception e){
                 System.out.println(e);
        }
            
        }
        
       }
    }
    
     public String getDate(JXDatePicker date1) {
        SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
        return formater.format(date1.getDate());
    }
     
     public void resetDate(JXDatePicker date1) {
         Calendar cals = Calendar.getInstance();
         date1.setDate(cals.getTime());
    }
    
 
      
      public void refreshtable(){
        DefaultTableModel model= (DefaultTableModel) tableOrder.getModel();
        model.setRowCount(0);
        showOrders();
    }
      
      public void refreshtableStockProduct(){
        DefaultTableModel model= (DefaultTableModel) stock_prod_table.getModel();
        model.setRowCount(0);
        showStocksProducts();
    }
      
      
       public void refreshCustomerTable(){
        DefaultTableModel model= (DefaultTableModel) cus_table.getModel();
        model.setRowCount(0);
        showCustomers();
    }
      
    
      
      
       
       
       public void update() {
        
          if(!(order_text.getText().equals("") || order_text.getText().isEmpty() == true )){
              if(validateForm() != -1){
            
        int ID = Integer.parseInt(order_text.getText().toString());
        String cusName = order_cus_name.getText().toString();
        String cusId = cus_id.getText().toString();
        String proId = pro_id.getText().toString();
        String quantity = order_qty.getText().toString();
        String discount = order_disc.getText().toString();
         String total = tot_text.getText().toString();
         String type = type_combo.getSelectedItem().toString();
         String date = getDate(date_picker);
         String location = order_loc.getText().toString();
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/orocare", "root", "");
            
            PreparedStatement stmt = myConn.prepareStatement("UPDATE cusorder SET cusName = ?, cusID = ?, productID = ?, qty = ?, discount = ?, total = ?, location = ?, type = ?, dateAdded = ? WHERE orderID = ?");
            stmt.setString(1,cusName);
            stmt.setString(2,cusId);
            stmt.setString(3,proId);
            stmt.setString(4,quantity);
            stmt.setString(5, discount);
            stmt.setString(6,total);
            stmt.setString(7,location);
            stmt.setString(8, type);
            stmt.setString(9, date);
            stmt.setInt(10, ID);
            int i = stmt.executeUpdate();
            if(i == 1){
            JOptionPane.showMessageDialog(null, "Record Updated Successfully", "Message!", JOptionPane.INFORMATION_MESSAGE);
            }
            refreshtable();
        }catch(Exception e){
            printStackTrace(e);
        }
              }
         
         }
      }
       
       public void remove(){
            if(!(order_text.getText().equals("") || order_text.getText().isEmpty() == true )){
        int ID = Integer.parseInt(order_text.getText().toString());
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/orocare", "root", "");
            
            PreparedStatement stmt = myConn.prepareStatement("DELETE FROM cusorder WHERE orderID = ?");
            stmt.setInt(1, ID);
            int i = stmt.executeUpdate();
            if(i == 1){
            JOptionPane.showMessageDialog(null, "Record Deleted Successfully", "Message!", JOptionPane.INFORMATION_MESSAGE);
            }
            refreshtable();
            confirm_order.setEnabled(false);
            clear();
        }catch(Exception e){
            printStackTrace(e);
        }}else
            message("Please Select an Order !");
       }
       
       
        private void search() {                                             
        DefaultTableModel model = (DefaultTableModel) tableOrder.getModel();
        model.setRowCount(0);
        this.showOrderListFiltered();
    }       
        
        private void searchStockProduct() {                                             
        DefaultTableModel model = (DefaultTableModel) stock_prod_table.getModel();
        model.setRowCount(0);
        this.showStockProductListFiltered();
    }
        
         private void searchCustomer() {                                             
        DefaultTableModel model = (DefaultTableModel) cus_table.getModel();
        model.setRowCount(0);
        this.showCustomerListFiltered();
    }       
        
        
         public ArrayList<orderEntity> getOrdersList(){
        
        orderEntity odr;
        ArrayList<orderEntity> orderList = new ArrayList<orderEntity>();
        Connector c1 = new Connector();
        ResultSet rs = c1.getResultSet();
        Statement st1= c1.getStatement();
        String sql = "SELECT * from cusorder";
        try{
        rs = st1.executeQuery(sql);
            while(rs.next()){
                odr = new orderEntity(rs.getInt("orderID"), rs.getString("cusName"), rs.getInt("cusID"), rs.getInt("productID"),rs.getInt("qty"), rs.getDouble("discount"), rs.getDouble("total"),rs.getString("location"), rs.getString("type"), rs.getString("status"), String.valueOf(rs.getDate("dateAdded")));
                orderList.add(odr);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return orderList;
    }
         
         
         
         public ArrayList<stockProductEntity> getStocksProductsList(){
        
        stockProductEntity stoPro;
        ArrayList<stockProductEntity> stockProductList = new ArrayList<stockProductEntity>();
        Connector c1 = new Connector();
        ResultSet rs = c1.getResultSet();
        Statement st1= c1.getStatement();
        String sql = "SELECT ProductID,Name,Size,location,avl_qty,unitCost,sellPrice FROM product P,stockproduct s WHERE p.ProductID = s.prodID";
        try{
        rs = st1.executeQuery(sql);
            while(rs.next()){
                stoPro = new stockProductEntity(rs.getInt("productID"),rs.getString("Name"),rs.getString("Size"), rs.getString("location"), rs.getInt("avl_qty"), rs.getDouble("unitCost"), rs.getDouble("sellPrice"));
                stockProductList.add(stoPro);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return stockProductList;
    }
         
         
         public ArrayList<customerEntity> getCustomersList(){
        
        customerEntity cus;
        ArrayList<customerEntity> customerList = new ArrayList<customerEntity>();
        Connector c1 = new Connector();
        ResultSet rs = c1.getResultSet();
        Statement st1= c1.getStatement();
        String sql = "SELECT Name,CustomerID from customer";
        try{
        rs = st1.executeQuery(sql);
            while(rs.next()){
                cus = new customerEntity(rs.getString("Name"), rs.getInt("CustomerID"));
                customerList.add(cus);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return customerList;
    }
         
         
         
      
       public void showOrders(){
        ArrayList<orderEntity> orderslist = this.getOrdersList();
        DefaultTableModel model = (DefaultTableModel) tableOrder.getModel();
        Object[] row = new Object[11];
        
        for(int i = 0 ; i < orderslist.size(); ++i){
            row[0] = orderslist.get(i).getOrderID();
            row[1] = orderslist.get(i).getCusName();
            row[2] = orderslist.get(i).getcusID();
            row[3] = orderslist.get(i).getproID();
            row[4] = orderslist.get(i).getQuantity();
            row[5] = orderslist.get(i).getDiscount();
            row[6] = orderslist.get(i).getTotal();
            row[7] = orderslist.get(i).getLocation();
            row[8] = orderslist.get(i).getType();
            row[9] = orderslist.get(i).getStatus();
            row[10] = orderslist.get(i).getDateAdded();
            model.addRow(row);
        }
    }
       
       
       public void showStocksProducts(){
        ArrayList<stockProductEntity> stockProductList = this.getStocksProductsList();
        DefaultTableModel model = (DefaultTableModel) stock_prod_table.getModel();
        Object[] row = new Object[7];
        
        for(int i = 0 ; i < stockProductList.size(); ++i){
            row[0] = stockProductList.get(i).getProductId();
            row[1] = stockProductList.get(i).getName();
            row[2] = stockProductList.get(i).getSize();
            row[3] = stockProductList.get(i).getLocation(); 
            row[4] = stockProductList.get(i).getQuantity(); 
            row[5] = stockProductList.get(i).getUnitPrice();
            row[6] = stockProductList.get(i).getSellPrice(); 
            model.addRow(row);
        }
    }
       
       
       public void showCustomers(){
        ArrayList<customerEntity> customerslist = this.getCustomersList();
        DefaultTableModel model = (DefaultTableModel) cus_table.getModel();
        Object[] row = new Object[2];
        
        for(int i = 0 ; i < customerslist.size(); ++i){
            row[0] = customerslist.get(i).getCustomerName();
            row[1] = customerslist.get(i).getCustomerID();
            model.addRow(row);
        }
    }
       
       
       
        public ArrayList<orderEntity> getOrderListFiltered(){
        orderEntity order;
        ArrayList<orderEntity> orderList = new ArrayList<orderEntity>();
        Connector c1 = new Connector();
         String sql = "SELECT * FROM cusorder WHERE CONCAT(orderID,cusName, cusID, productID, qty, discount,total) LIKE '%" + searchField.getText() + "%'";
        //String sql = "SELECT * FROM customer WHERE CustomerID LIKE '%" +searchField.getText() + "%' OR Name LIKE '%" + searchField.getText() + "%'";
        try{
        ResultSet rs = c1.myStmt.executeQuery(sql);
        
            while(rs.next()){
                order = new orderEntity(rs.getInt("orderID"), rs.getString("cusName"), rs.getInt("cusID"), rs.getInt("productID"), rs.getInt("qty"), rs.getDouble("discount"), rs.getDouble("total"),rs.getString("location"), rs.getString("type"), rs.getString("status"), String.valueOf(rs.getDate("dateAdded")));
                orderList.add(order);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return orderList;
 }
        
        
        public ArrayList<stockProductEntity> getStockProductListFiltered(){
        stockProductEntity stockProd;
        ArrayList<stockProductEntity> stockProdList = new ArrayList<stockProductEntity>();
        Connector c1 = new Connector();
         String sql = "SELECT ProductID,Name,Size,location,avl_qty,unitCost,sellPrice FROM product P,stockproduct s WHERE p.ProductID = s.prodID AND CONCAT(ProductID,Name,Size,location,unitCost,sellPrice) LIKE '%" + search_prod.getText() + "%'";
        
        try{
        ResultSet rs = c1.myStmt.executeQuery(sql);
        
            while(rs.next()){
                stockProd = new stockProductEntity(rs.getInt("productID"),rs.getString("Name"),rs.getString("Size"), rs.getString("location"), rs.getInt("avl_qty"), rs.getDouble("unitCost"), rs.getDouble("sellPrice"));
                stockProdList.add(stockProd);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return stockProdList;
 }
        
        
        public ArrayList<customerEntity> getCustomerListFiltered(){
        customerEntity customer;
        ArrayList<customerEntity> customerList = new ArrayList<customerEntity>();
        Connector c1 = new Connector();
         String sql = "SELECT Name,CustomerID from customer WHERE CONCAT(Name,CustomerID) LIKE '%" + search_cus.getText() + "%'";
        
        try{
        ResultSet rs = c1.myStmt.executeQuery(sql);
        
            while(rs.next()){
                customer = new customerEntity(rs.getString("Name"), rs.getInt("CustomerID"));
                customerList.add(customer);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return customerList;
 }
    
    public void showOrderListFiltered(){
      ArrayList<orderEntity> orderslist = this.getOrderListFiltered();
        DefaultTableModel model = (DefaultTableModel) tableOrder.getModel();
        Object[] row = new Object[11];
        
        for(int i = 0 ; i < orderslist.size(); ++i){
           row[0] = orderslist.get(i).getOrderID();
            row[1] = orderslist.get(i).getCusName();
            row[2] = orderslist.get(i).getcusID();
            row[3] = orderslist.get(i).getproID();
            row[4] = orderslist.get(i).getQuantity();
            row[5] = orderslist.get(i).getDiscount();
            row[6] = orderslist.get(i).getTotal();
            row[7] = orderslist.get(i).getLocation();
            row[8] = orderslist.get(i).getType();
            row[9] = orderslist.get(i).getStatus();
            row[10] = orderslist.get(i).getDateAdded();
            model.addRow(row);
        }
    }
    
    
    public void showStockProductListFiltered(){
      ArrayList<stockProductEntity> stockProductList = this.getStockProductListFiltered();
        DefaultTableModel model = (DefaultTableModel) stock_prod_table.getModel();
        Object[] row = new Object[7];
        
        for(int i = 0 ; i < stockProductList.size(); ++i){
           row[0] = stockProductList.get(i).getProductId();
            row[1] = stockProductList.get(i).getName();
            row[2] = stockProductList.get(i).getSize();
            row[3] = stockProductList.get(i).getLocation(); 
            row[4] = stockProductList.get(i).getQuantity(); 
            row[5] = stockProductList.get(i).getUnitPrice();
            row[6] = stockProductList.get(i).getSellPrice(); 
            model.addRow(row);
        }
    }
    
    
    public void showCustomerListFiltered(){
      ArrayList<customerEntity> customerslist = this.getCustomerListFiltered();
        DefaultTableModel model = (DefaultTableModel) cus_table.getModel();
        Object[] row = new Object[2];
        
        for(int i = 0 ; i < customerslist.size(); ++i){
           row[0] = customerslist.get(i).getCustomerName();
            row[1] = customerslist.get(i).getCustomerID();
            
            model.addRow(row);
        }
    }
    
    
    
    
    public void message(String message) {
        JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
    }
    
     private void printStackTrace(Exception e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
      
      
      
      
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        order_text = new javax.swing.JTextField();
        order_cus_name = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        searchField = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        confirm_order = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        date_picker = new org.jdesktop.swingx.JXDatePicker();
        type_combo = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        sales_view = new javax.swing.JButton();
        tot_text = new javax.swing.JTextField();
        starGen1 = new javax.swing.JLabel();
        starGen3 = new javax.swing.JLabel();
        starGen4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableOrder = new javax.swing.JTable();
        cus_id = new javax.swing.JTextField();
        pro_id = new javax.swing.JTextField();
        check_avb = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        search_cus = new javax.swing.JTextField();
        search_cus_but = new javax.swing.JButton();
        search_cus_view = new javax.swing.JButton();
        search_pro_view = new javax.swing.JButton();
        search_prod = new javax.swing.JTextField();
        search_prod_but = new javax.swing.JButton();
        order_profit = new javax.swing.JTextField();
        prod_name = new javax.swing.JTextField();
        order_loc = new javax.swing.JTextField();
        starGen2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        starGen6 = new javax.swing.JLabel();
        starGen8 = new javax.swing.JLabel();
        starGen7 = new javax.swing.JLabel();
        qty_left = new javax.swing.JTextField();
        printer = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        cus_table = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        stock_prod_table = new javax.swing.JTable();
        starGen9 = new javax.swing.JLabel();
        userleft = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        order_qty = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        order_disc = new javax.swing.JTextField();
        add_butt = new javax.swing.JButton();
        title = new javax.swing.JLabel();
        starGen5 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        order_text.setEditable(false);
        order_text.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(75, 0, 130), 2));
        order_text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                order_textActionPerformed(evt);
            }
        });
        getContentPane().add(order_text, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 90, 160, 30));

        order_cus_name.setEditable(false);
        order_cus_name.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(75, 0, 130), 2));
        getContentPane().add(order_cus_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 150, 160, 30));

        jLabel9.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel9.setForeground(java.awt.Color.white);
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Customer Name");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 130, 160, -1));

        jLabel6.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel6.setForeground(java.awt.Color.white);
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Total");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 280, 160, -1));

        jButton1.setBackground(new java.awt.Color(75, 0, 130));
        jButton1.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Search");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.white, 2));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 80, 80, 30));

        searchField.setForeground(new java.awt.Color(75, 0, 130));
        searchField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        searchField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(83, 43, 11), 2));
        searchField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchFieldActionPerformed(evt);
            }
        });
        getContentPane().add(searchField, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 80, 140, 30));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(240, 240, 240));
        jLabel11.setText("Date");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 430, 50, -1));

        confirm_order.setBackground(java.awt.Color.green);
        confirm_order.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        confirm_order.setForeground(new java.awt.Color(255, 255, 255));
        confirm_order.setText("Confirm Order");
        confirm_order.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        confirm_order.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                confirm_orderMouseClicked(evt);
            }
        });
        confirm_order.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirm_orderActionPerformed(evt);
            }
        });
        getContentPane().add(confirm_order, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 520, 160, 50));

        jButton2.setBackground(new java.awt.Color(75, 0, 130));
        jButton2.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Update");
        jButton2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 590, 90, 30));

        jButton5.setBackground(new java.awt.Color(75, 0, 130));
        jButton5.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Remove");
        jButton5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 590, 90, 30));

        jButton6.setBackground(new java.awt.Color(75, 0, 130));
        jButton6.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Clear");
        jButton6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 590, 90, 30));

        jLabel15.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel15.setForeground(java.awt.Color.white);
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Discount");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 200, 160, -1));

        date_picker.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(75, 0, 130), 2));
        getContentPane().add(date_picker, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 450, 160, 30));

        type_combo.setEditable(true);
        type_combo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        type_combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "none", "Internal", "External" }));
        type_combo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(75, 0, 130), 2));
        getContentPane().add(type_combo, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 150, 160, 30));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(240, 240, 240));
        jLabel10.setText("Customer ID");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 360, -1, -1));

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(240, 240, 240));
        jLabel17.setText("Product ID");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 360, -1, -1));

        sales_view.setBackground(new java.awt.Color(75, 0, 130));
        sales_view.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        sales_view.setForeground(new java.awt.Color(255, 255, 255));
        sales_view.setText("View All");
        sales_view.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        sales_view.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sales_viewActionPerformed(evt);
            }
        });
        getContentPane().add(sales_view, new org.netbeans.lib.awtextra.AbsoluteConstraints(1260, 80, 80, 30));

        tot_text.setEditable(false);
        tot_text.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(75, 0, 130), 2));
        tot_text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tot_textActionPerformed(evt);
            }
        });
        getContentPane().add(tot_text, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 300, 160, 30));

        starGen1.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        starGen1.setForeground(new java.awt.Color(204, 0, 0));
        starGen1.setText("*");
        getContentPane().add(starGen1, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 140, 20, 30));

        starGen3.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        starGen3.setForeground(new java.awt.Color(204, 0, 0));
        starGen3.setText("*");
        getContentPane().add(starGen3, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 220, 20, 30));

        starGen4.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        starGen4.setForeground(new java.awt.Color(204, 0, 0));
        starGen4.setText("*");
        getContentPane().add(starGen4, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 220, 20, 30));

        jScrollPane1.setPreferredSize(new java.awt.Dimension(469, 419));

        tableOrder.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(75, 0, 130), 2));
        tableOrder.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Order ID", "Customer Name", "Customer ID", "Product ID", "Quantity", "Discount", "Total", "Location", "Type", "Status", "Date Added"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Double.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tableOrder.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tableOrder.setPreferredSize(new java.awt.Dimension(1000, 1000));
        tableOrder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableOrderMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableOrder);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 130, 590, 270));

        cus_id.setEditable(false);
        getContentPane().add(cus_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 380, 160, 30));

        pro_id.setEditable(false);
        getContentPane().add(pro_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 380, 160, 30));

        check_avb.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        check_avb.setText("Check Total");
        check_avb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                check_avbMouseClicked(evt);
            }
        });
        check_avb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check_avbActionPerformed(evt);
            }
        });
        getContentPane().add(check_avb, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 300, 160, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Type");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 130, -1, -1));
        getContentPane().add(search_cus, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 610, 100, 30));

        search_cus_but.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-search-16.png"))); // NOI18N
        search_cus_but.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_cus_butActionPerformed(evt);
            }
        });
        getContentPane().add(search_cus_but, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 610, 30, 30));

        search_cus_view.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-eye-16.png"))); // NOI18N
        search_cus_view.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_cus_viewActionPerformed(evt);
            }
        });
        getContentPane().add(search_cus_view, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 610, 30, 30));

        search_pro_view.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-eye-16.png"))); // NOI18N
        search_pro_view.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_pro_viewActionPerformed(evt);
            }
        });
        getContentPane().add(search_pro_view, new org.netbeans.lib.awtextra.AbsoluteConstraints(1310, 610, 30, 30));
        getContentPane().add(search_prod, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 610, 150, 30));

        search_prod_but.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-search-16.png"))); // NOI18N
        search_prod_but.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_prod_butActionPerformed(evt);
            }
        });
        getContentPane().add(search_prod_but, new org.netbeans.lib.awtextra.AbsoluteConstraints(1270, 610, 40, 30));
        getContentPane().add(order_profit, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 90, 80, -1));
        getContentPane().add(prod_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 90, 80, -1));
        getContentPane().add(order_loc, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 450, 160, 30));

        starGen2.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        starGen2.setForeground(new java.awt.Color(204, 0, 0));
        starGen2.setText("*");
        getContentPane().add(starGen2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 140, 20, 30));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Location");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 430, -1, -1));

        starGen6.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        starGen6.setForeground(new java.awt.Color(255, 0, 0));
        starGen6.setText("*");
        getContentPane().add(starGen6, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 290, 20, 30));

        starGen8.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        starGen8.setForeground(new java.awt.Color(255, 0, 0));
        starGen8.setText("*");
        getContentPane().add(starGen8, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 360, 20, 40));

        starGen7.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        starGen7.setForeground(new java.awt.Color(255, 0, 0));
        starGen7.setText("*");
        getContentPane().add(starGen7, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 370, 20, 30));
        getContentPane().add(qty_left, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 90, 80, -1));

        printer.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        printer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-send-to-printer-30.png"))); // NOI18N
        printer.setText("Print");
        printer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                printerMouseClicked(evt);
            }
        });
        getContentPane().add(printer, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 70, 100, 50));

        cus_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Customer Name", "Customer ID"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        cus_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cus_tableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(cus_table);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(752, 407, 160, 190));

        stock_prod_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product ID", "Name", "Size", "Location", "Quantity", "Unit Cost", "Sell Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        stock_prod_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                stock_prod_tableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(stock_prod_table);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(922, 410, 420, 190));

        starGen9.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        starGen9.setForeground(new java.awt.Color(204, 0, 0));
        starGen9.setText("*");
        getContentPane().add(starGen9, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 440, 20, 30));

        userleft.setBackground(new java.awt.Color(153, 0, 0));
        userleft.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        userleft.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 66, -1, 132));

        jLabel5.setFont(new java.awt.Font("Calibri", 1, 28)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Toothpaste");
        userleft.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 460, 300, 40));

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logof.png"))); // NOI18N
        userleft.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, 300, 90));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/order2.png"))); // NOI18N
        userleft.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 300, 110));

        getContentPane().add(userleft, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 290, 720));

        order_qty.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(75, 0, 130), 2));
        order_qty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                order_qtyActionPerformed(evt);
            }
        });
        getContentPane().add(order_qty, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 230, 160, 30));

        jLabel12.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel12.setForeground(java.awt.Color.white);
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Quantity");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 200, 160, -1));

        order_disc.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(75, 0, 130), 2));
        order_disc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                order_discActionPerformed(evt);
            }
        });
        getContentPane().add(order_disc, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 230, 160, 30));

        add_butt.setBackground(new java.awt.Color(75, 0, 130));
        add_butt.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        add_butt.setForeground(new java.awt.Color(255, 255, 255));
        add_butt.setText("Add");
        add_butt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        add_butt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_buttActionPerformed(evt);
            }
        });
        getContentPane().add(add_butt, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 590, 90, 30));

        title.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        title.setForeground(java.awt.Color.white);
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("Order Management");
        getContentPane().add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, 1070, 70));

        starGen5.setBackground(new java.awt.Color(255, 51, 255));
        starGen5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/gray2.png"))); // NOI18N
        getContentPane().add(starGen5, new org.netbeans.lib.awtextra.AbsoluteConstraints(-1, 0, 1390, -1));

        jLabel13.setText("jLabel13");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 474, 20, 30));

        setSize(new java.awt.Dimension(1382, 759));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void order_textActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_order_textActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_order_textActionPerformed

    private void order_qtyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_order_qtyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_order_qtyActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed

        clear();

    }//GEN-LAST:event_jButton6ActionPerformed

    private void add_buttActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_buttActionPerformed
              add();        
         
    
    }//GEN-LAST:event_add_buttActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        update();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tableOrderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableOrderMouseClicked

        try{
        
        int i = tableOrder.getSelectedRow();
        TableModel model = tableOrder.getModel();
        
        
        order_text.setText(model.getValueAt(i, 0).toString());
        order_cus_name.setText(model.getValueAt(i, 1).toString());
        order_qty.setText(model.getValueAt(i, 4).toString());
        order_disc.setText(model.getValueAt(i, 5).toString());
        tot_text.setText(model.getValueAt(i, 6).toString());
        cus_id.setText(model.getValueAt(i, 2).toString());
        pro_id.setText(model.getValueAt(i, 3).toString());
        type_combo.getEditor().setItem(model.getValueAt(i, 8).toString());
        order_loc.setText(model.getValueAt(i, 7).toString());
        
        try {
            date_picker.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(model.getValueAt(i, 10).toString()));
        } catch (ParseException ex) {
            Logger.getLogger(order.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        int row = tableOrder.getSelectedRow();
        String type = tableOrder.getValueAt(row, 8).toString();
        String status = tableOrder.getValueAt(row, 9).toString();
        
        if(type.contains("External")){
            if(status.contains("pending"))
            confirm_order.setEnabled(true);
        }
        else
            confirm_order.setEnabled(false);
            
        }catch(Exception e){
        }
       
    }//GEN-LAST:event_tableOrderMouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        remove();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void searchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchFieldActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        search();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void sales_viewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sales_viewActionPerformed
        refreshtable();
    }//GEN-LAST:event_sales_viewActionPerformed

    private void confirm_orderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirm_orderActionPerformed
        
    }//GEN-LAST:event_confirm_orderActionPerformed

    private void order_discActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_order_discActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_order_discActionPerformed

    private void search_prod_butActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_prod_butActionPerformed
        searchStockProduct();
    }//GEN-LAST:event_search_prod_butActionPerformed

    private void search_pro_viewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_pro_viewActionPerformed
        refreshtableStockProduct();
    }//GEN-LAST:event_search_pro_viewActionPerformed

    private void search_cus_butActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_cus_butActionPerformed
        searchCustomer();
    }//GEN-LAST:event_search_cus_butActionPerformed

    private void search_cus_viewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_cus_viewActionPerformed
        refreshCustomerTable();
    }//GEN-LAST:event_search_cus_viewActionPerformed

    private void tot_textActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tot_textActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tot_textActionPerformed

    private void stock_prod_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stock_prod_tableMouseClicked
        try{
        int i = stock_prod_table.getSelectedRow();
        TableModel model = stock_prod_table.getModel();
        
        
        pro_id.setText(model.getValueAt(i, 0).toString());
        order_loc.setText(model.getValueAt(i,3).toString());
        
        
        check_avb.setEnabled(true);
        }catch(Exception e){}
    }//GEN-LAST:event_stock_prod_tableMouseClicked

    private void cus_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cus_tableMouseClicked
        try{
        int i = cus_table.getSelectedRow();
        TableModel model = cus_table.getModel();
        
        
        cus_id.setText(model.getValueAt(i, 1).toString());
        order_cus_name.setText(model.getValueAt(i, 0).toString());
        }catch(Exception e){}
    }//GEN-LAST:event_cus_tableMouseClicked

    private void check_avbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_check_avbMouseClicked
        if (validateTotal() != -1) {
        int i = stock_prod_table.getSelectedRow();
        TableModel model = stock_prod_table.getModel();
        
        double unitCost = Double.parseDouble(model.getValueAt(i, 5).toString());
        double sellPrice = Double.parseDouble(model.getValueAt(i, 6).toString());
        double avlQty = Double.parseDouble(model.getValueAt(i, 4).toString());
        double quantity = Double.parseDouble(order_qty.getText().toString());
        double discount = Double.parseDouble(order_disc.getText().toString());
        
        double total = (quantity*sellPrice) - discount;
        double profit = (sellPrice - unitCost)*quantity - discount;
        double qtyLeft = avlQty - quantity;
        
        if(qtyLeft > 0){
        
        tot_text.setText(String.valueOf(total));
        order_profit.setText(String.valueOf(profit));
        qty_left.setText(String.valueOf(qtyLeft));
        
        prod_name.setText(model.getValueAt(i,1).toString());
        
        add_butt.setEnabled(true);
        }else{
             JOptionPane.showMessageDialog(null,"Stock too low for this order!" , "Error", JOptionPane.ERROR_MESSAGE);
             add_butt.setEnabled(false);
        }
        
        }
    }//GEN-LAST:event_check_avbMouseClicked

    private void check_avbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check_avbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_check_avbActionPerformed

    private void confirm_orderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_confirm_orderMouseClicked
      try{
        int i = tableOrder.getSelectedRow();
        TableModel model = tableOrder.getModel();
        
        
        
        String proId = model.getValueAt(i, 3).toString();
        String cusId = model.getValueAt(i, 2).toString();
        String quantity = model.getValueAt(i, 4).toString();
        String discount = model.getValueAt(i, 5).toString();
        String total = model.getValueAt(i, 6).toString();
        String date = model.getValueAt(i,10).toString();
        String location = model.getValueAt(i, 7).toString();
        String orderId = model.getValueAt(i,0).toString();
        
        Connector c1 = new Connector();
        ResultSet rs = c1.getResultSet();
        Statement st1= c1.getStatement();
        String sql = "SELECT Name FROM product WHERE ProductID ="+proId;
        
        ResultSet rs2 = c1.getResultSet();
        Statement st2 = c1.getStatement();
        
        String sql2 = "SELECT avl_qty,unitCost,sellPrice FROM stockproduct WHERE prodID ="+proId +" AND location ='"+location+"'";
        
        try{
            String name = null;
            rs = st1.executeQuery(sql);
            while(rs.next()){
              name = rs.getString("Name");
                
            }
            System.out.println(name);

                 rs2 = st2.executeQuery(sql2);
            
                 String unitCost = null;
                 String sellPrice = null;
                 String avlQty = null;
            while(rs2.next()){
             unitCost = rs2.getString("unitCost");
             sellPrice = rs2.getString("sellPrice");
             avlQty = rs2.getString("avl_qty");
                
            }
            
            System.out.println(unitCost);
                System.out.println(sellPrice);
             
                double unitCostDb = Double.parseDouble(unitCost);
        double sellPriceDb = Double.parseDouble(sellPrice);
        double quantityDb = Double.parseDouble(quantity);
        double discountDb = Double.parseDouble(discount);
        double avlQtyDb = Double.parseDouble(avlQty);

double profitDb = (sellPriceDb - unitCostDb)*quantityDb - discountDb;
        String profit = String.valueOf(profitDb);
        
        double qtyLeftDb = avlQtyDb - quantityDb;
        String qtyLeft = String.valueOf(qtyLeftDb);

        
        Class.forName("com.mysql.jdbc.Driver");
            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/orocare", "root", "");
         PreparedStatement stmt2 = myConn.prepareStatement("INSERT INTO SALES(proName, prID, cuID, qty, discount, totEarn, profit, dateSold) VALUES (?,?,?,?,?,?,?,?)");
            
            stmt2.setString(1,name);
            stmt2.setString(2,proId);
            stmt2.setString(3,cusId);
            stmt2.setString(4,quantity);
            stmt2.setString(5,discount);
            stmt2.setString(6,total);
            stmt2.setString(7,profit);
            stmt2.setString(8,date);
            int j = stmt2.executeUpdate();
            if(j == 1){
            JOptionPane.showMessageDialog(null, "Order Confirmed Successfully", "Message!", JOptionPane.INFORMATION_MESSAGE);
            }
            
            PreparedStatement stmt3 = myConn.prepareStatement("UPDATE stockproduct SET avl_qty = ?  WHERE prodID = ? AND location = ?");
            stmt3.setString(1,qtyLeft);
            stmt3.setString(2,proId);
            stmt3.setString(3,location);
            int k = stmt3.executeUpdate();
            if(k == 1){
            JOptionPane.showMessageDialog(null, "Stock has been updated!", "Message!", JOptionPane.INFORMATION_MESSAGE);
            }
            
            refreshtableStockProduct();
            confirm_order.setEnabled(false);
            
            PreparedStatement stmt4 = myConn.prepareStatement("UPDATE cusorder SET status = ? WHERE orderID = ?");
            stmt4.setString(1,"confirmed");
            stmt4.setString(2,orderId);
            stmt4.executeUpdate();
            refreshtable();
            
            
        }catch(Exception e){
            System.out.println(e);
        }
      }catch(Exception e){
      }
    }//GEN-LAST:event_confirm_orderMouseClicked

    private void printerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_printerMouseClicked
        String search = searchField.getText().toString();
        
        printer pNew = new printer("Order Details",search,tableOrder);
        
        pNew.print();
    }//GEN-LAST:event_printerMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new order().setVisible(true);
            }
        });
    }
    
    
    public int strValidate(JTextField textName) {
        if (textName.getText().equals(null) || textName.getText().equals("") || textName.getText().isEmpty() == true) {
            textName.setText("");
            return -1;
        } else {
            return 0;
        }
    }
    
    
    public void starGenerator(boolean cond, JLabel jLabel) {
        jLabel.setVisible(cond);
    }
    
    int validateForm() {
        
        String type = type_combo.getSelectedItem().toString();
        
        if(type.contains("none")){
            message("Select Type!");
            starGenerator(true,starGen2);
            return -1;
        }
        else{
            
          starGenerator(false,starGen2);
        }
        
        if (strValidate(order_cus_name) == -1) {
            message("Customer Name Field Empty !");
            starGenerator(true, starGen1);
            return -1;
        } else {
            starGenerator(false, starGen1);
        }

        String cusname = order_cus_name.getText();

        if (!cusname.matches("[a-zA-Z]+")) {
            message("Customer Name Field Contains Numbers");
            starGenerator(true, starGen1);
            return -1;
        } else {
            starGenerator(false, starGen1);
        }

        
      
        
        if (strValidate(order_qty) == -1) {
            message("Quantity Field Empty !");
            starGenerator(true, starGen3);
            return -1;
        } else {
            starGenerator(false, starGen3);
        }

        

        if (floatValidate(order_qty) == -1) {
            message("Quantity Contains Letters !");
            starGenerator(true, starGen3);
            return -1;
        } else {
            starGenerator(false, starGen3);
        }
        
        
         if (strValidate(order_disc) == -1) {
            message("Discount Field Empty !");
            starGenerator(true, starGen4);
            return -1;
        } else {
            starGenerator(false, starGen4);
        }

        

        if (floatValidate(order_disc) == -1) {
            message("Discount Contains Letters !");
            starGenerator(true, starGen4);
            return -1;
        } else {
            starGenerator(false, starGen4);
        }
        
         if (strValidate(tot_text) == -1) {
            message("Total Field Empty !");
            starGenerator(true, starGen6);
            return -1;
        } else {
            starGenerator(false, starGen6);
        }
         
         if (strValidate(cus_id) == -1) {
            message("Customer ID Field Empty !");
            starGenerator(true, starGen7);
            return -1;
        } else {
            starGenerator(false, starGen7);
        }
         
         if (strValidate(pro_id) == -1) {
            message("Product ID Field Empty !");
            starGenerator(true, starGen8);
            return -1;
        } else {
            starGenerator(false, starGen8);
        }
         
         if (strValidate(order_loc) == -1) {
            message("Location Field Empty !");
            starGenerator(true, starGen9);
            return -1;
        } else {
            starGenerator(false, starGen9);
        }
         
         String location = order_loc.getText().toString();
         
         if (!location.matches("[a-zA-Z]+")) {
            message("Location Field Contains Numbers");
            starGenerator(true, starGen9);
            return -1;
        } else {
            starGenerator(false, starGen9);
        }
        
        
        return 0;
    }
    
    public int floatValidate(JTextField num) {
        try{
            Double.parseDouble(num.getText());
            if(Double.valueOf(num.getText()) > 0) {
                 return 0;
            }
         
            else {
                 return -1;
            }
   
        }
        
        catch(NumberFormatException e) {
            return -1;
        }
    }
    
    int validateTotal(){
        
        if (strValidate(order_qty) == -1) {
            message("Quantity Field Empty !");
            starGenerator(true, starGen3);
            return -1;
        } else {
            starGenerator(false, starGen3);
        }

       

         if (floatValidate(order_qty) == -1) {
            message("Quantity Contains Letters !");
            starGenerator(true, starGen3);
            return -1;
        } else {
            starGenerator(false, starGen3);
        }
        
         if (strValidate(order_disc) == -1) {
            message("Discount Field Empty !");
            starGenerator(true, starGen4);
            return -1;
        } else {
            starGenerator(false, starGen4);
        }

        

        if (floatValidate(order_disc) == -1) {
            message("Discount Contains Letters !");
            starGenerator(true, starGen4);
            return -1;
        } else {
            starGenerator(false, starGen4);
        }
        
        return 0;
        
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add_butt;
    private javax.swing.JButton check_avb;
    private javax.swing.JButton confirm_order;
    private javax.swing.JTextField cus_id;
    private javax.swing.JTable cus_table;
    private org.jdesktop.swingx.JXDatePicker date_picker;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField order_cus_name;
    private javax.swing.JTextField order_disc;
    private javax.swing.JTextField order_loc;
    private javax.swing.JTextField order_profit;
    private javax.swing.JTextField order_qty;
    private javax.swing.JTextField order_text;
    private javax.swing.JButton printer;
    private javax.swing.JTextField pro_id;
    private javax.swing.JTextField prod_name;
    private javax.swing.JTextField qty_left;
    private javax.swing.JButton sales_view;
    private javax.swing.JTextField searchField;
    private javax.swing.JTextField search_cus;
    private javax.swing.JButton search_cus_but;
    private javax.swing.JButton search_cus_view;
    private javax.swing.JButton search_pro_view;
    private javax.swing.JTextField search_prod;
    private javax.swing.JButton search_prod_but;
    private javax.swing.JLabel starGen1;
    private javax.swing.JLabel starGen2;
    private javax.swing.JLabel starGen3;
    private javax.swing.JLabel starGen4;
    private javax.swing.JLabel starGen5;
    private javax.swing.JLabel starGen6;
    private javax.swing.JLabel starGen7;
    private javax.swing.JLabel starGen8;
    private javax.swing.JLabel starGen9;
    private javax.swing.JTable stock_prod_table;
    private javax.swing.JTable tableOrder;
    private javax.swing.JLabel title;
    private javax.swing.JTextField tot_text;
    private javax.swing.JComboBox<String> type_combo;
    private javax.swing.JPanel userleft;
    // End of variables declaration//GEN-END:variables
}
