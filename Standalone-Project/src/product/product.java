package product;

import connection.Connector;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import printer.printer;

public class product extends javax.swing.JFrame {

    private int currentrowCount;
    private Date currentMaxDate;
    
    public product() {
        initComponents();
        userleft.setBackground(new Color(0, 0, 255, 80));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        showProducts();
        initializeLabels();
        syncTable();
    }
    
    private void initializeLabels(){
        prod_id.setVisible(false);
        starGen1.setVisible(false);
        starGen2.setVisible(false);
        starGen3.setVisible(false);
        starGen4.setVisible(false);
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        productTable = new javax.swing.JTable();
        searchField = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        prod_desc = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        prod_name = new javax.swing.JTextField();
        prod_size = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        prod_weight = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        prod_flavour = new javax.swing.JTextField();
        starGen1 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        addButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        printButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        title1 = new javax.swing.JLabel();
        userleft = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        title = new javax.swing.JLabel();
        prod_id = new javax.swing.JTextField();
        removeButton = new javax.swing.JButton();
        starGen2 = new javax.swing.JLabel();
        starGen3 = new javax.swing.JLabel();
        starGen4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        productTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(75, 0, 130), 2));
        productTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product ID", "Name", "Description", "Size", "Flavour", "Weight", "Date Added"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        productTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                productTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(productTable);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 120, 490, 480));

        searchField.setForeground(new java.awt.Color(75, 0, 130));
        searchField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        searchField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(83, 43, 11), 2));
        getContentPane().add(searchField, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 60, 140, 30));

        searchButton.setBackground(java.awt.Color.blue);
        searchButton.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        searchButton.setForeground(new java.awt.Color(255, 255, 255));
        searchButton.setText("Search");
        searchButton.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.white, 2));
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });
        getContentPane().add(searchButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1260, 60, 80, 30));

        prod_desc.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.blue, 2));
        getContentPane().add(prod_desc, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 170, 160, 30));

        jLabel9.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel9.setForeground(java.awt.Color.white);
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Description");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 140, 160, -1));

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel4.setForeground(java.awt.Color.white);
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Product Name");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 130, 160, -1));

        prod_name.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.blue, 2));
        getContentPane().add(prod_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 150, 160, 30));

        prod_size.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Small", "Medium", "Large" }));
        prod_size.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.blue, 2));
        getContentPane().add(prod_size, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 240, 160, 30));

        jLabel7.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel7.setForeground(java.awt.Color.white);
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Size");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 220, 160, -1));

        prod_weight.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.blue, 2));
        getContentPane().add(prod_weight, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 260, 160, 30));

        jLabel12.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel12.setForeground(java.awt.Color.white);
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Weight");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 230, 160, -1));

        prod_flavour.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.blue, 2));
        getContentPane().add(prod_flavour, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 340, 160, 30));

        starGen1.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        starGen1.setForeground(java.awt.Color.red);
        starGen1.setText("*");
        getContentPane().add(starGen1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 140, -1, -1));

        jLabel15.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel15.setForeground(java.awt.Color.white);
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Flavour");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 320, 160, -1));

        addButton.setBackground(java.awt.Color.blue);
        addButton.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        addButton.setForeground(new java.awt.Color(255, 255, 255));
        addButton.setText("Add");
        addButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });
        getContentPane().add(addButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 630, 90, 30));

        updateButton.setBackground(java.awt.Color.blue);
        updateButton.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        updateButton.setForeground(new java.awt.Color(255, 255, 255));
        updateButton.setText("Update");
        updateButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });
        getContentPane().add(updateButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 630, 90, 30));

        printButton.setBackground(java.awt.Color.blue);
        printButton.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        printButton.setForeground(new java.awt.Color(255, 255, 255));
        printButton.setText("Print");
        printButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        printButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printButtonActionPerformed(evt);
            }
        });
        getContentPane().add(printButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 60, 90, 30));

        clearButton.setBackground(java.awt.Color.blue);
        clearButton.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        clearButton.setForeground(new java.awt.Color(255, 255, 255));
        clearButton.setText("Clear");
        clearButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });
        getContentPane().add(clearButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 630, 90, 30));

        title1.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        title1.setForeground(new java.awt.Color(255, 255, 255));
        title1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title1.setText("Product Management");
        getContentPane().add(title1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, 1070, 70));

        userleft.setBackground(new java.awt.Color(153, 0, 0));
        userleft.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        userleft.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 66, -1, 132));

        jLabel5.setFont(new java.awt.Font("Calibri", 1, 28)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Toothpaste");
        userleft.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 450, 300, -1));

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logof.png"))); // NOI18N
        userleft.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, 300, 90));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/product2.png"))); // NOI18N
        userleft.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 300, 120));

        getContentPane().add(userleft, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 0, 300, 720));

        title.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        title.setForeground(new java.awt.Color(255, 255, 255));
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("Product Management");
        getContentPane().add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(301, 0, 1070, 70));
        getContentPane().add(prod_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 70, 150, 30));

        removeButton.setBackground(java.awt.Color.blue);
        removeButton.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        removeButton.setForeground(new java.awt.Color(255, 255, 255));
        removeButton.setText("Remove");
        removeButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });
        getContentPane().add(removeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 630, 90, 30));

        starGen2.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        starGen2.setForeground(java.awt.Color.red);
        starGen2.setText("*");
        getContentPane().add(starGen2, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 330, -1, -1));

        starGen3.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        starGen3.setForeground(java.awt.Color.red);
        starGen3.setText("*");
        getContentPane().add(starGen3, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 160, -1, -1));

        starGen4.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        starGen4.setForeground(java.awt.Color.red);
        starGen4.setText("*");
        getContentPane().add(starGen4, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 260, -1, -1));

        jButton1.setText("DEMO");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 80, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/gray2.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1390, -1));

        setSize(new java.awt.Dimension(1382, 759));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private ArrayList<productEntity> getProductList() {

        productEntity prod;
        ArrayList<productEntity> productList = new ArrayList<productEntity>();
        Connector c1 = new Connector();
        ResultSet rs = c1.getResultSet();
        Statement st1 = c1.getStatement();
        String sql = "SELECT * from product";
        try {
            rs = st1.executeQuery(sql);
            while (rs.next()) {
                prod = new productEntity(rs.getInt("ProductID"), rs.getString("Name"), rs.getString("Description"), rs.getString("Size"), rs.getString("Flavour"), rs.getDouble("Weight"), String.valueOf(rs.getDate("DateAdded")));
                productList.add(prod);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return productList;
    }

    private void showProducts() {
        ArrayList<productEntity> productList = this.getProductList();
        DefaultTableModel model = (DefaultTableModel) productTable.getModel();
        Object[] row = new Object[7];

        for (int i = 0; i < productList.size(); ++i) {
            row[0] = productList.get(i).getProdID();
            row[1] = productList.get(i).getName();
            row[2] = productList.get(i).getDescription();
            row[3] = productList.get(i).getSize();
            row[4] = productList.get(i).getFlavour();
            row[5] = productList.get(i).getWeight();
            row[6] = productList.get(i).getDate();
            model.addRow(row);
        }
    }

    private ArrayList<productEntity> getProductListFiltered() {
        productEntity product;
        ArrayList<productEntity> productList = new ArrayList<productEntity>();
        Connector c1 = new Connector();
        String sql = "SELECT * FROM product WHERE CONCAT(ProductID,Name,Description,Size,Flavour,Weight) LIKE '%" + searchField.getText() + "%'";
        try {
            ResultSet rs = c1.myStmt.executeQuery(sql);

            while (rs.next()) {
                product = new productEntity(rs.getInt("ProductID"), rs.getString("Name"), rs.getString("Description"), rs.getString("Size"), rs.getString("Flavour"), rs.getDouble("Weight"), String.valueOf(rs.getDate("DateAdded")));
                productList.add(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return productList;
    }

    private void showProductListFiltered() {
        ArrayList<productEntity> productList = this.getProductListFiltered();
        DefaultTableModel model = (DefaultTableModel) productTable.getModel();
        Object[] row = new Object[7];

        for (int i = 0; i < productList.size(); ++i) {
            row[0] = productList.get(i).getProdID();
            row[1] = productList.get(i).getName();
            row[2] = productList.get(i).getDescription();
            row[3] = productList.get(i).getSize();
            row[4] = productList.get(i).getFlavour();
            row[5] = productList.get(i).getWeight();
            row[6] = productList.get(i).getDate();
            model.addRow(row);
        }
    }

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed

        prod_name.setText("");
        prod_desc.setText("");
        prod_weight.setText("");
        prod_flavour.setText("");
        prod_size.setSelectedIndex(0);

    }//GEN-LAST:event_clearButtonActionPerformed

    private void productTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_productTableMouseClicked
        try{
        int i = productTable.getSelectedRow();
        TableModel model = productTable.getModel();

        prod_id.setText(model.getValueAt(i, 0).toString());
        prod_name.setText(model.getValueAt(i, 1).toString());
        prod_desc.setText(model.getValueAt(i, 2).toString());
        prod_flavour.setText(model.getValueAt(i, 4).toString());
        prod_weight.setText(model.getValueAt(i, 5).toString());
        }catch(Exception e){}
    }//GEN-LAST:event_productTableMouseClicked

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed

        if (validateForm() != -1) {
            String Name = prod_name.getText().toString();
            String Description = prod_desc.getText().toString();
            String Size = prod_size.getSelectedItem().toString();
            String Flavour = prod_flavour.getText().toString();
            String Weight = prod_weight.getText().toString();

            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/orocare", "root", "");

                PreparedStatement stmt = myConn.prepareStatement("INSERT INTO product(Name, Description, Size, Flavour,Weight, DateAdded) VALUES (?,?,?,?,?,NOW())");
                stmt.setString(1, Name);
                stmt.setString(2, Description);
                stmt.setString(3, Size);
                stmt.setString(4, Flavour);
                stmt.setString(5, Weight);
                int i = stmt.executeUpdate();
                refreshtable();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_addButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed

        if(strValidate(prod_id) != -1)
        {
        
        if (validateForm() != -1) {
            int ID = Integer.parseInt(prod_id.getText().toString());
            String Name = prod_name.getText().toString();
            String Description = prod_desc.getText().toString();
            String Size = prod_size.getSelectedItem().toString();
            String Flavour = prod_flavour.getText().toString();
            String Weight = prod_weight.getText().toString();

            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/orocare", "root", "");

                PreparedStatement stmt = myConn.prepareStatement("UPDATE product SET Name = ?, Description = ?, Size = ?, Flavour = ?, Weight = ?, dateAdded = NOW() WHERE ProductID = ?");
                stmt.setString(1, Name);
                stmt.setString(2, Description);
                stmt.setString(3, Size);
                stmt.setString(4, Flavour);
                stmt.setString(5, Weight);
                stmt.setInt(6, ID);
                int i = stmt.executeUpdate();
                refreshtable();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        }else{
            message("Please Select a Product !");
        }
    }//GEN-LAST:event_updateButtonActionPerformed

    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
        int ID = Integer.parseInt(prod_id.getText().toString());
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/orocare", "root", "");

            PreparedStatement stmt = myConn.prepareStatement("DELETE FROM product WHERE ProductID = ?");
            stmt.setInt(1, ID);
            int i = stmt.executeUpdate();
            refreshtable();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_removeButtonActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        DefaultTableModel model = (DefaultTableModel) productTable.getModel();
        model.setRowCount(0);
        this.showProductListFiltered();
    }//GEN-LAST:event_searchButtonActionPerformed

    private void printButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printButtonActionPerformed
        new printer("Product", searchField.getText(), productTable).print();
    }//GEN-LAST:event_printButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        prod_name.setText("OroMint");
        prod_desc.setText("Contains Mint Flavour");
        prod_size.setSelectedIndex(1);
        prod_weight.setText("10");
        prod_flavour.setText("Mint");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void refreshtable() {
        DefaultTableModel model = (DefaultTableModel) productTable.getModel();
        model.setRowCount(0);
        showProducts();
    }


    private static void main(String args[]) {

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
            java.util.logging.Logger.getLogger(product.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(product.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(product.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(product.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new product().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton clearButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton printButton;
    private javax.swing.JTextField prod_desc;
    private javax.swing.JTextField prod_flavour;
    private javax.swing.JTextField prod_id;
    private javax.swing.JTextField prod_name;
    private javax.swing.JComboBox<String> prod_size;
    private javax.swing.JTextField prod_weight;
    private javax.swing.JTable productTable;
    private javax.swing.JButton removeButton;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchField;
    private javax.swing.JLabel starGen1;
    private javax.swing.JLabel starGen2;
    private javax.swing.JLabel starGen3;
    private javax.swing.JLabel starGen4;
    private javax.swing.JLabel title;
    private javax.swing.JLabel title1;
    private javax.swing.JButton updateButton;
    private javax.swing.JPanel userleft;
    // End of variables declaration//GEN-END:variables

    private int validateForm() {
        if (strValidate(prod_name) == -1) {
            message("Product Name Field Empty !");
            starGenerator(true, starGen1);
            return -1;
        } else {
            starGenerator(false, starGen1);
        }

        String prodname = prod_name.getText();

        if (!prodname.matches("[a-zA-Z][a-zA-Z ]*")) {
            message("Product Name Field Contains Numbers");
            starGenerator(true, starGen1);
            return -1;
        } else {
            starGenerator(false, starGen1);
        }

        if (strValidate(prod_desc) == -1) {
            message("Description Field Empty !");
            starGenerator(true, starGen3);

            return -1;
        } else {
            starGenerator(false, starGen3);
        }

        String flavour = prod_flavour.getText();

        if (strValidate(prod_flavour) == -1) {
            message("Flavour Field Empty !");
            starGenerator(true, starGen2);

            return -1;
        } else {
            starGenerator(false, starGen2);
        }

        if (!flavour.matches("[a-zA-Z][a-zA-Z ]*")) {
            message("Flavour Field Contains Numbers");
            starGenerator(true, starGen2);
            return -1;
        } else {
            starGenerator(false, starGen2);
        }

        if (strValidate(prod_weight) == -1) {
            message("Weight Field Empty !");
            starGenerator(true, starGen4);
            return -1;
        } else {
            starGenerator(false, starGen4);
        }

        String number = prod_weight.getText();

        if (!number.matches("[0-9]+(\\.){0,1}[0-9]+")) {
            message("Weight Contains Letters !");
            starGenerator(true, starGen4);
            return -1;
        } else {
            starGenerator(false, starGen4);
        }

        return 0;
    }

    private int strValidate(JTextField textName) {
        if (textName.getText().equals(null) || textName.getText().equals("") || textName.getText().isEmpty() == true) {
            textName.setText("");
            return -1;
        } else {
            return 0;
        }
    }

    private void message(String message) {
        JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    private void starGenerator(boolean cond, JLabel jLabel) {
        jLabel.setVisible(cond);
    }
    
    private void syncTable() {
        Connector connector = new Connector();
        currentMaxDate = getMaxDate(connector);
        currentrowCount = getRowCount(connector);
        
        Timer t = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Date tempDate = getMaxDate(connector);
                int tempRowCount = getRowCount(connector);
                if (currentMaxDate.compareTo(tempDate) != 0 || currentrowCount != tempRowCount) {
                    refreshtable();
                    currentMaxDate = tempDate;
                    currentrowCount = tempRowCount;
                }
            }
        });
        t.start();
    }

    private Date getMaxDate(Connector connector) {

        Date date = null;
        Timestamp timestamp; 
        ResultSet rs = connector.getResultSet();
        Statement st = connector.getStatement();
        String sql = "SELECT MAX(DateAdded) FROM product";
        try {
            rs = st.executeQuery(sql);
            while (rs.next()) {
                //date = rs.getDate("MAX(DateAdded)");
                timestamp = rs.getTimestamp("MAX(DateAdded)");
                if (timestamp != null) {
                    date = new Date(timestamp.getTime());
                }   
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
        return date;
    }
    
    private int getRowCount(Connector connector){
        int temprowCount = -1;
        ResultSet rs = connector.getResultSet();
        Statement st = connector.getStatement();
        String sql = "SELECT COUNT(*) FROM product";
        try {
            rs = st.executeQuery(sql);
            while (rs.next()) {
                temprowCount = rs.getInt("COUNT(*)");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return -1;
        }
        return temprowCount;
    }
}
