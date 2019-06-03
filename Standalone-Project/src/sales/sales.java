package sales;

import connection.Connector;
import java.awt.Color;
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
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import org.jdesktop.swingx.JXDatePicker;


public class sales extends javax.swing.JFrame {

   
    public sales() {
        initComponents();
         userleft.setBackground(new Color(139,69,19,80));
         setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
         showSales();
         sales_id.setVisible(false);
         starGen1.setVisible(false);
        starGen2.setVisible(false);
        starGen3.setVisible(false);
        starGen4.setVisible(false);
        
    }
    
    
     public void clear() {
         
         
        sales_qty.setText("");
        sales_prof.setText("");
        sales_disc.setText("");
        sales_tot_earn.setText("");
        sales_prod_name.setText("");
        sales_cus_id.setText("");
        sales_pro_id.setText("");
        resetDate(sales_date);
        
        
        }
     
     public void resetDate(JXDatePicker date1) {
         Calendar cals = Calendar.getInstance();
         date1.setDate(cals.getTime());
    }
     
     public void refreshtable(){
        DefaultTableModel model= (DefaultTableModel) sales_table.getModel();
        model.setRowCount(0);
        showSales();
    }
     
     
     public void update() {
        
          if(!(sales_id.getText().equals("") || sales_id.getText().isEmpty() == true )){
              if(validateForm() != -1){
            
        int ID = Integer.parseInt(sales_id.getText().toString());
        String proName = sales_prod_name.getText().toString();
        String cusId = sales_cus_id.getText().toString();
        String proId = sales_pro_id.getText().toString();
        String quantity = sales_qty.getText().toString();
        String discount = sales_disc.getText().toString();
         String total = sales_tot_earn.getText().toString();
        String profit = sales_prof.getText().toString();
        String date = getDate(sales_date);
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/orocare", "root", "");
            
            PreparedStatement stmt = myConn.prepareStatement("UPDATE sales SET  proName = ?, prID = ?, cuID = ?, qty = ?, discount = ?, totEarn = ?, profit = ?, dateSold = ? WHERE salesID = ?");
            stmt.setString(1,proName);
            stmt.setString(2,proId);
            stmt.setString(3,cusId);
            stmt.setString(4,quantity);
            stmt.setString(5,discount);
            stmt.setString(6, total);
            stmt.setString(7,profit);
            stmt.setString(8,date);
            stmt.setInt(9, ID);
            int i = stmt.executeUpdate();
            if(i == 1){
            JOptionPane.showMessageDialog(null, "Record Updated Successfully", "Message!", JOptionPane.INFORMATION_MESSAGE);
            }
            refreshtable();
            clear();
        }catch(Exception e){
            System.out.println(e);
        }
              }
         }
      }
     
     
      public void remove(){
            if(!(sales_id.getText().equals("") || sales_id.getText().isEmpty() == true )){
        int ID = Integer.parseInt(sales_id.getText().toString());
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/orocare", "root", "");
            
            PreparedStatement stmt = myConn.prepareStatement("DELETE FROM sales WHERE salesID = ?");
            stmt.setInt(1, ID);
            int i = stmt.executeUpdate();
            if(i == 1){
            JOptionPane.showMessageDialog(null, "Record Removed Successfully", "Message!", JOptionPane.INFORMATION_MESSAGE);
            }
            refreshtable();
            clear();
        }catch(Exception e){
            printStackTrace(e);
        }}else
            message("Please Select a record !");
       }
      
      
       private void search() {                                             
        DefaultTableModel model = (DefaultTableModel) sales_table.getModel();
        model.setRowCount(0);
        this.showSalesListFiltered();
    }       
       
       
       
       public ArrayList<salesEntity> getSalesList(){
        
        salesEntity sal;
        ArrayList<salesEntity> salesList = new ArrayList<salesEntity>();
        Connector c1 = new Connector();
        ResultSet rs = c1.getResultSet();
        Statement st1= c1.getStatement();
        String sql = "SELECT * from sales";
        try{
        rs = st1.executeQuery(sql);
            while(rs.next()){
                sal = new salesEntity(rs.getInt("salesID"),rs.getString("proName"), rs.getInt("prID"), rs.getInt("cuID"),rs.getInt("qty"), rs.getDouble("discount"), rs.getDouble("totEarn"), rs.getDouble("profit"), String.valueOf(rs.getDate("dateSold")));
                salesList.add(sal);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return salesList;
    }
       
       
       public void showSales(){
        ArrayList<salesEntity>  saleslist = this.getSalesList();
        DefaultTableModel model = (DefaultTableModel) sales_table.getModel();
        Object[] row = new Object[9];
        
        for(int i = 0 ; i < saleslist.size(); ++i){
            row[0] = saleslist.get(i).getSalesID();
            row[1] = saleslist.get(i).getProName();
            row[2] = saleslist.get(i).getcusID();
            row[3] = saleslist.get(i).getproID();
            row[4] = saleslist.get(i).getQuantity();
            row[5] = saleslist.get(i).getDiscount();
            row[6] = saleslist.get(i).getTotal();
            row[7] = saleslist.get(i).getProfit();
            row[8] = saleslist.get(i).getDateSold();
            model.addRow(row);
        }
    }
       
       
       public ArrayList<salesEntity> getSalesListFiltered(){
        salesEntity sale;
        ArrayList<salesEntity> salesList = new ArrayList<salesEntity>();
        Connector c1 = new Connector();
         String sql = "SELECT * FROM sales WHERE CONCAT(salesID,proName, prID, cuID, qty, discount,totEarn, profit) LIKE '%" + searchField.getText() + "%'";
        //String sql = "SELECT * FROM customer WHERE CustomerID LIKE '%" +searchField.getText() + "%' OR Name LIKE '%" + searchField.getText() + "%'";
        try{
        ResultSet rs = c1.myStmt.executeQuery(sql);
        
            while(rs.next()){
                sale = new salesEntity(rs.getInt("salesID"),rs.getString("proName"), rs.getInt("prID"), rs.getInt("salesID"), rs.getInt("qty"), rs.getDouble("discount"), rs.getDouble("totEarn"),rs.getDouble("profit"), String.valueOf(rs.getDate("dateSold")));
                salesList.add(sale);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return salesList;
 }
    
    public void showSalesListFiltered(){
      ArrayList<salesEntity> saleslist = this.getSalesListFiltered();
        DefaultTableModel model = (DefaultTableModel) sales_table.getModel();
        Object[] row = new Object[9];
        
        for(int i = 0 ; i < saleslist.size(); ++i){
           row[0] = saleslist.get(i).getSalesID();
            row[1] = saleslist.get(i).getProName();
            row[2] = saleslist.get(i).getcusID();
            row[3] = saleslist.get(i).getproID();
            row[4] = saleslist.get(i).getQuantity();
            row[5] = saleslist.get(i).getDiscount();
            row[6] = saleslist.get(i).getTotal();
            row[7] = saleslist.get(i).getProfit();
            row[8] = saleslist.get(i).getDateSold();
            model.addRow(row);
        }
    }
    
    
    
     
     
     public String getDate(JXDatePicker date1) {
        SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
        return formater.format(date1.getDate());
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

        jLabel7 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        sales_table = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        sales_date = new org.jdesktop.swingx.JXDatePicker();
        jButton2 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        searchField = new javax.swing.JTextField();
        sales_id = new javax.swing.JTextField();
        title = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        sales_qty = new javax.swing.JTextField();
        sales_pro_id = new javax.swing.JTextField();
        sales_cus_id = new javax.swing.JTextField();
        sales_disc = new javax.swing.JTextField();
        sales_tot_earn = new javax.swing.JTextField();
        sales_prof = new javax.swing.JTextField();
        sales_prod_name = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        starGen1 = new javax.swing.JLabel();
        starGen2 = new javax.swing.JLabel();
        starGen3 = new javax.swing.JLabel();
        starGen4 = new javax.swing.JLabel();
        userleft = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        order_tot2 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel7.setForeground(java.awt.Color.white);
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Product Name");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 130, 160, -1));

        jLabel15.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel15.setForeground(java.awt.Color.white);
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Total Earning");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 320, 160, -1));

        jLabel9.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel9.setForeground(java.awt.Color.white);
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Customer ID");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 130, 160, -1));

        jLabel12.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel12.setForeground(java.awt.Color.white);
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Quantity");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 220, 160, -1));

        jLabel6.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel6.setForeground(java.awt.Color.white);
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Profit");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 420, 160, -1));

        sales_table.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(75, 0, 130), 2));
        sales_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sales ID", "Product Name", "Customer ID", "Product ID", "Quantity", "Discount", "Total Earning", "Profit", "Date Sold"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        sales_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sales_tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(sales_table);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 120, 470, 480));

        jLabel10.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel10.setForeground(java.awt.Color.white);
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Discount");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 320, 160, -1));

        jButton3.setBackground(new java.awt.Color(83, 41, 11));
        jButton3.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Search");
        jButton3.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.white, 2));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 60, 80, 30));

        sales_date.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(83, 41, 11), 2));
        sales_date.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sales_dateActionPerformed(evt);
            }
        });
        getContentPane().add(sales_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 440, 160, 30));

        jButton2.setBackground(new java.awt.Color(83, 41, 11));
        jButton2.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Update");
        jButton2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 540, 90, 30));

        jLabel16.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel16.setForeground(java.awt.Color.white);
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Date Added");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 420, 160, -1));

        jButton5.setBackground(new java.awt.Color(83, 41, 11));
        jButton5.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Remove");
        jButton5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 540, 90, 30));

        searchField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        searchField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        getContentPane().add(searchField, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 60, 140, 30));
        getContentPane().add(sales_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 80, 160, 20));

        title.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        title.setForeground(new java.awt.Color(255, 255, 255));
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("Sales Management");
        getContentPane().add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, 1070, 70));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(240, 240, 240));
        jLabel4.setText("Product ID");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 220, -1, -1));
        getContentPane().add(sales_qty, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 240, 160, 30));

        sales_pro_id.setEditable(false);
        getContentPane().add(sales_pro_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 240, 150, 30));

        sales_cus_id.setEditable(false);
        sales_cus_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sales_cus_idActionPerformed(evt);
            }
        });
        getContentPane().add(sales_cus_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 150, 160, 30));
        getContentPane().add(sales_disc, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 340, 160, 30));
        getContentPane().add(sales_tot_earn, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 340, 160, 30));
        getContentPane().add(sales_prof, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 440, 160, 30));

        sales_prod_name.setEditable(false);
        getContentPane().add(sales_prod_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 150, 160, 30));

        jButton6.setBackground(new java.awt.Color(83, 41, 11));
        jButton6.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("View All");
        jButton6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1219, 60, 90, 30));

        jButton4.setBackground(new java.awt.Color(83, 41, 11));
        jButton4.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Clear");
        jButton4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 540, 90, 30));

        starGen1.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        starGen1.setForeground(new java.awt.Color(204, 0, 0));
        starGen1.setText("*");
        getContentPane().add(starGen1, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 230, 30, 30));

        starGen2.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        starGen2.setForeground(new java.awt.Color(204, 0, 0));
        starGen2.setText("*");
        getContentPane().add(starGen2, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 330, 30, 30));

        starGen3.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        starGen3.setForeground(new java.awt.Color(204, 0, 0));
        starGen3.setText("*");
        getContentPane().add(starGen3, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 330, 30, 30));

        starGen4.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        starGen4.setForeground(new java.awt.Color(204, 0, 0));
        starGen4.setText("*");
        getContentPane().add(starGen4, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 430, 30, 30));

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
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/sales2.png"))); // NOI18N
        userleft.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 300, 110));

        getContentPane().add(userleft, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 720));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/gray2.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-1, 0, 1390, -1));

        order_tot2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(75, 0, 130), 2));
        getContentPane().add(order_tot2, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 340, 160, 30));

        jLabel11.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel11.setForeground(java.awt.Color.white);
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Total");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 320, 160, -1));

        setBounds(0, 0, 1382, 759);
    }// </editor-fold>//GEN-END:initComponents

    private void sales_dateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sales_dateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sales_dateActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        update();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
       remove();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        clear();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        search();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void sales_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sales_tableMouseClicked
try{        
        
        int i = sales_table.getSelectedRow();
        TableModel model = sales_table.getModel();
        
        
        sales_id.setText(model.getValueAt(i, 0).toString());
        sales_cus_id.setText(model.getValueAt(i, 2).toString());
        sales_pro_id.setText(model.getValueAt(i, 3).toString());
        sales_qty.setText(model.getValueAt(i, 4).toString());
        sales_disc.setText(model.getValueAt(i, 5).toString());
        sales_tot_earn.setText(model.getValueAt(i, 6).toString());
        sales_prof.setText(model.getValueAt(i, 7).toString());
        sales_prod_name.setText(model.getValueAt(i, 1).toString());
        
        try {
            sales_date.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(model.getValueAt(i, 8).toString()));
        } catch (ParseException ex) {
            Logger.getLogger(sales.class.getName()).log(Level.SEVERE, null, ex);
        }
}catch(Exception e){}
    }//GEN-LAST:event_sales_tableMouseClicked

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        refreshtable();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void sales_cus_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sales_cus_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sales_cus_idActionPerformed

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
            java.util.logging.Logger.getLogger(sales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(sales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(sales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(sales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new sales().setVisible(true);
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
        if (strValidate(sales_qty) == -1) {
            message("Quantity Field is Empty !");
            starGenerator(true, starGen1);
            return -1;
        } else {
            starGenerator(false, starGen1);
        }

        String Quantity = sales_qty.getText();

       if (!Quantity.matches("[0-9]+(\\.){0,1}[0-9]+")) {
            message("Quantity Contains Letters !");
            starGenerator(true, starGen1);
            return -1;
        } else {
            starGenerator(false, starGen1);
        }

        if (strValidate(sales_disc) == -1) {
            message("Discount Field is Empty !");
            starGenerator(true, starGen2);
            return -1;
        } else {
            starGenerator(false, starGen2);
        }
        
        String discount = sales_disc.getText();

         if (!discount.matches("[0-9]+(\\.){0,1}[0-9]+")) {
            message("Total Contains Letters !");
            starGenerator(true, starGen2);
            return -1;
        } else {
            starGenerator(false, starGen2);
        }
        
        if (strValidate(sales_tot_earn) == -1) {
            message("Total Earning Field is Empty !");
            starGenerator(true, starGen3);
            return -1;
        } else {
            starGenerator(false, starGen3);
        }

        String totEarn = sales_tot_earn.getText();

        if (!totEarn.matches("[0-9]+(\\.){0,1}[0-9]+")) {
            message("Total earning Contains Letters !");
            starGenerator(true, starGen3);
            return -1;
        } else {
            starGenerator(false, starGen3);
        }
        
        
         if (strValidate(sales_prof) == -1) {
            message("Profit Field is Empty !");
            starGenerator(true, starGen4);
            return -1;
        } else {
            starGenerator(false, starGen4);
        }

        String profit = sales_prof.getText();

        if (!profit.matches("[0-9]+(\\.){0,1}[0-9]+")) {
            message("Profit Contains Letters !");
            starGenerator(true, starGen4);
            return -1;
        } else {
            starGenerator(false, starGen4);
        }
        
        

        return 0;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField order_tot2;
    private javax.swing.JTextField sales_cus_id;
    private org.jdesktop.swingx.JXDatePicker sales_date;
    private javax.swing.JTextField sales_disc;
    private javax.swing.JTextField sales_id;
    private javax.swing.JTextField sales_pro_id;
    private javax.swing.JTextField sales_prod_name;
    private javax.swing.JTextField sales_prof;
    private javax.swing.JTextField sales_qty;
    private javax.swing.JTable sales_table;
    private javax.swing.JTextField sales_tot_earn;
    private javax.swing.JTextField searchField;
    private javax.swing.JLabel starGen1;
    private javax.swing.JLabel starGen2;
    private javax.swing.JLabel starGen3;
    private javax.swing.JLabel starGen4;
    private javax.swing.JLabel title;
    private javax.swing.JPanel userleft;
    // End of variables declaration//GEN-END:variables
}
