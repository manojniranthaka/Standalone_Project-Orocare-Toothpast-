/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supplierOrder;

import connection.Connector;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import org.jdesktop.swingx.JXDatePicker;
import printer.printer;

/**
 *
 * @author Isuru Gunatileka
 */
public class supplierOrderInt extends javax.swing.JFrame {

    /**
     * Creates new form userExternal
     */
    public supplierOrderInt() {
        initComponents();
        showSupplyOrder();
        supOrderIDField.setVisible(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        starGen1.setVisible(false);
        starGen2.setVisible(false);
        starGen3.setVisible(false);
        starGen4.setVisible(false);
        syncTable();
    }

    public void syncTable() {

        Connector connector = new Connector();
        Timer t = new Timer(5000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel model = (DefaultTableModel) supply_order.getModel();
                model.setRowCount(0);
                showUsersSync(connector);
            }
        });
        t.start();

    }

    public ArrayList<SupplyOrder> getSupplyOrderListSync(Connector connector) {

        SupplyOrder supOrder;
        ArrayList<SupplyOrder> supOrderList = new ArrayList<SupplyOrder>();
        ResultSet rs = connector.getResultSet();
        Statement st1 = connector.getStatement();
        String sql = "SELECT * FROM supply_order";
        try {
            rs = st1.executeQuery(sql);
            while (rs.next()) {
                supOrder = new SupplyOrder(rs.getInt("sup_order_id"), rs.getString("material_name"), rs.getInt("quantity"), rs.getDouble("total_price"), rs.getString("order_date"));
                supOrderList.add(supOrder);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return supOrderList;
    }

    public void showUsersSync(Connector connector) {
        ArrayList<SupplyOrder> supOrderIntList = this.getSupplyOrderListSync(connector);
        DefaultTableModel model = (DefaultTableModel) supply_order.getModel();
        Object[] row = new Object[5];

        for (int i = 0; i < supOrderIntList.size(); ++i) {
            row[0] = supOrderIntList.get(i).getSup_order_id();
            row[1] = supOrderIntList.get(i).getMaterial_name();
            row[2] = supOrderIntList.get(i).getQuantity();
            row[3] = supOrderIntList.get(i).getTotal_price();
            row[4] = supOrderIntList.get(i).getOrder_date();
            model.addRow(row);
        }
    }

    public ArrayList<SupplyOrder> getSupplyOrderList() {

        SupplyOrder supOrder;
        ArrayList<SupplyOrder> supOrderList = new ArrayList<SupplyOrder>();
        Connector c1 = new Connector();
        ResultSet rs = c1.getResultSet();
        Statement st1 = c1.getStatement();
        String sql = "SELECT * from supply_order";
        try {
            rs = st1.executeQuery(sql);
            while (rs.next()) {
                supOrder = new SupplyOrder(rs.getInt("sup_order_id"), rs.getString("material_name"), rs.getInt("quantity"), rs.getDouble("total_price"), rs.getString("order_date"));
                supOrderList.add(supOrder);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return supOrderList;
    }

    public void showSupplyOrder() {
        ArrayList<SupplyOrder> supOrderIntList = this.getSupplyOrderList();
        DefaultTableModel model = (DefaultTableModel) supply_order.getModel();
        Object[] row = new Object[5];

        for (int i = 0; i < supOrderIntList.size(); ++i) {
            row[0] = supOrderIntList.get(i).getSup_order_id();
            row[1] = supOrderIntList.get(i).getMaterial_name();
            row[2] = supOrderIntList.get(i).getQuantity();
            row[3] = supOrderIntList.get(i).getTotal_price();
            row[4] = supOrderIntList.get(i).getOrder_date();
            model.addRow(row);
        }
    }

    public ArrayList<SupplyOrder> getSupplyOrderListFiltered() {
        SupplyOrder supOrder;
        ArrayList<SupplyOrder> supOrderList = new ArrayList<SupplyOrder>();
        Connector c1 = new Connector();
        String sql = "SELECT * FROM supply_order WHERE CONCAT(sup_order_id,material_name,quantity,total_price) LIKE '%" + searchField.getText() + "%'";
        //String sql = "SELECT * FROM customer WHERE CustomerID LIKE '%" +searchField.getText() + "%' OR Name LIKE '%" + searchField.getText() + "%'";
        try {
            ResultSet rs = c1.myStmt.executeQuery(sql);

            while (rs.next()) {
                supOrder = new SupplyOrder(rs.getInt("sup_order_id"), rs.getString("material_name"), rs.getInt("quantity"), rs.getDouble("total_price"), rs.getString("order_date"));
                supOrderList.add(supOrder);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return supOrderList;
    }

    public void showSupplyOrderListFiltered() {
        ArrayList<SupplyOrder> supOrderList = this.getSupplyOrderListFiltered();
        DefaultTableModel model = (DefaultTableModel) supply_order.getModel();
        Object[] row = new Object[5];

        for (int i = 0; i < supOrderList.size(); ++i) {
            row[0] = supOrderList.get(i).getSup_order_id();
            row[1] = supOrderList.get(i).getMaterial_name();
            row[2] = supOrderList.get(i).getQuantity();
            row[3] = supOrderList.get(i).getTotal_price();
            row[4] = supOrderList.get(i).getOrder_date();
            model.addRow(row);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        starGen = new javax.swing.JLabel();
        materialNameField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        userleft = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        supply_order = new javax.swing.JTable();
        quantityField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        unitPriceField = new javax.swing.JTextField();
        addButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        removeButton = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        supOrderIDField = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        searchField = new javax.swing.JTextField();
        printButton = new javax.swing.JButton();
        starGen1 = new javax.swing.JLabel();
        starGen2 = new javax.swing.JLabel();
        starGen3 = new javax.swing.JLabel();
        starGen4 = new javax.swing.JLabel();
        supOrderDatePicker = new org.jdesktop.swingx.JXDatePicker();
        jLabel11 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();

        starGen.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        starGen.setForeground(java.awt.Color.red);
        starGen.setText("*");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(java.awt.Color.black);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        materialNameField.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.red, 2));
        materialNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                materialNameFieldActionPerformed(evt);
            }
        });
        getContentPane().add(materialNameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(379, 213, 205, 30));

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        jLabel1.setForeground(java.awt.Color.white);
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Supplier Order Management");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(549, 30, 530, 39));

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel4.setForeground(java.awt.Color.white);
        jLabel4.setText("Total Price");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(378, 340, 96, -1));

        jLabel6.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel6.setForeground(java.awt.Color.white);
        jLabel6.setText("Ordered Date");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(378, 430, 130, 20));

        userleft.setBackground(new java.awt.Color(153, 0, 0));
        userleft.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        userleft.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 66, -1, 132));

        jLabel5.setFont(new java.awt.Font("Calibri", 1, 28)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Toothpaste");
        userleft.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 450, 300, 50));

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logof.png"))); // NOI18N
        userleft.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, 300, 90));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/user3.png"))); // NOI18N
        userleft.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 300, 110));

        getContentPane().add(userleft, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 740));

        supply_order.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sup_Order ID", "Material Name", "Quantity", "Unit Price", "Ordered Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        supply_order.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                supply_orderMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(supply_order);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(786, 109, -1, -1));

        quantityField.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.red, 2));
        quantityField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quantityFieldActionPerformed(evt);
            }
        });
        getContentPane().add(quantityField, new org.netbeans.lib.awtextra.AbsoluteConstraints(378, 292, 206, 30));

        jLabel9.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel9.setForeground(java.awt.Color.white);
        jLabel9.setText("Quantity");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(378, 261, -1, -1));

        unitPriceField.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.red, 2));
        unitPriceField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unitPriceFieldActionPerformed(evt);
            }
        });
        getContentPane().add(unitPriceField, new org.netbeans.lib.awtextra.AbsoluteConstraints(378, 380, 206, 30));

        addButton.setBackground(java.awt.Color.red);
        addButton.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        addButton.setForeground(new java.awt.Color(255, 255, 255));
        addButton.setText("Add");
        addButton.setBorder(new javax.swing.border.LineBorder(java.awt.Color.white, 2, true));
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });
        getContentPane().add(addButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(786, 574, 90, 30));

        updateButton.setBackground(java.awt.Color.red);
        updateButton.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        updateButton.setForeground(new java.awt.Color(255, 255, 255));
        updateButton.setText("Update");
        updateButton.setBorder(new javax.swing.border.LineBorder(java.awt.Color.white, 2, true));
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });
        getContentPane().add(updateButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(894, 574, 90, 30));

        removeButton.setBackground(java.awt.Color.red);
        removeButton.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        removeButton.setForeground(new java.awt.Color(255, 255, 255));
        removeButton.setText("Remove");
        removeButton.setBorder(new javax.swing.border.LineBorder(java.awt.Color.white, 2, true));
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });
        getContentPane().add(removeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1002, 574, 90, 30));

        jButton11.setBackground(java.awt.Color.red);
        jButton11.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jButton11.setForeground(new java.awt.Color(255, 255, 255));
        jButton11.setText("Clear");
        jButton11.setBorder(new javax.swing.border.LineBorder(java.awt.Color.white, 2, true));
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(1102, 574, 90, 30));

        supOrderIDField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supOrderIDFieldActionPerformed(evt);
            }
        });
        getContentPane().add(supOrderIDField, new org.netbeans.lib.awtextra.AbsoluteConstraints(379, 133, 160, -1));

        searchButton.setBackground(java.awt.Color.red);
        searchButton.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        searchButton.setForeground(new java.awt.Color(255, 255, 255));
        searchButton.setText("Search");
        searchButton.setBorder(new javax.swing.border.LineBorder(java.awt.Color.white, 2, true));
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });
        getContentPane().add(searchButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1137, 73, 90, 30));

        searchField.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.red, 2));
        searchField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchFieldActionPerformed(evt);
            }
        });
        getContentPane().add(searchField, new org.netbeans.lib.awtextra.AbsoluteConstraints(926, 73, 205, 30));

        printButton.setBackground(java.awt.Color.red);
        printButton.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        printButton.setForeground(new java.awt.Color(255, 255, 255));
        printButton.setText("Print");
        printButton.setBorder(new javax.swing.border.LineBorder(java.awt.Color.white, 2, true));
        printButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printButtonActionPerformed(evt);
            }
        });
        getContentPane().add(printButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(786, 73, 90, 30));

        starGen1.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        starGen1.setForeground(java.awt.Color.red);
        starGen1.setText("*");
        getContentPane().add(starGen1, new org.netbeans.lib.awtextra.AbsoluteConstraints(602, 207, -1, 33));

        starGen2.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        starGen2.setForeground(java.awt.Color.red);
        starGen2.setText("*");
        getContentPane().add(starGen2, new org.netbeans.lib.awtextra.AbsoluteConstraints(602, 286, -1, 33));

        starGen3.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        starGen3.setForeground(java.awt.Color.red);
        starGen3.setText("*");
        getContentPane().add(starGen3, new org.netbeans.lib.awtextra.AbsoluteConstraints(602, 374, -1, 33));

        starGen4.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        starGen4.setForeground(java.awt.Color.red);
        starGen4.setText("*");
        getContentPane().add(starGen4, new org.netbeans.lib.awtextra.AbsoluteConstraints(602, 457, -1, 33));

        supOrderDatePicker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supOrderDatePickerActionPerformed(evt);
            }
        });
        getContentPane().add(supOrderDatePicker, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 470, 200, -1));

        jLabel11.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel11.setForeground(java.awt.Color.white);
        jLabel11.setText("Material Name");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(379, 171, 140, 30));

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/gray2.png"))); // NOI18N
        jLabel22.setIconTextGap(100);
        getContentPane().add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, 1390, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void quantityFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quantityFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_quantityFieldActionPerformed

    private void unitPriceFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unitPriceFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_unitPriceFieldActionPerformed

    private void materialNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_materialNameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_materialNameFieldActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed

        if (validateForm() != -1) {
            String materialName = materialNameField.getText().toString();
            String quantity = quantityField.getText().toString();
            String unitPrice = unitPriceField.getText().toString();
            String orderDate = getDate(supOrderDatePicker);

            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/orocare", "root", "");

                PreparedStatement stmt = myConn.prepareStatement("INSERT INTO supply_order(material_name,quantity,total_price, order_date) VALUES (?,?,?,NOW())");
                stmt.setString(1, materialName);
                stmt.setString(2, quantity);
                stmt.setString(3, unitPrice);
                int i = stmt.executeUpdate();
                refreshtable();
            } catch (SQLIntegrityConstraintViolationException ex) {
                JOptionPane.showMessageDialog(null, "Material Already Exits !", "Login Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_addButtonActionPerformed

    public String getDate(JXDatePicker orderDate) {
        SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
        return formater.format(orderDate.getDate());
    }

    public void refreshtable() {
        DefaultTableModel model = (DefaultTableModel) supply_order.getModel();
        model.setRowCount(0);
        showSupplyOrder();
    }

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed

        if (validateFormUpdate() != -1) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/orocare", "root", "");

                PreparedStatement stmt = myConn.prepareStatement("UPDATE supply_order SET material_name = ?, quantity = ? , total_price = ?, order_date = NOW() WHERE sup_order_id = ?");
                stmt.setString(1, materialNameField.getText());
                stmt.setString(2, quantityField.getText());
                stmt.setString(3, unitPriceField.getText());
                stmt.setInt(4, Integer.parseInt(supOrderIDField.getText()));
                int i = stmt.executeUpdate();
                refreshtable();

            } catch (SQLIntegrityConstraintViolationException ex) {
                JOptionPane.showMessageDialog(null, "Material Already Exits !", "Login Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }//GEN-LAST:event_updateButtonActionPerformed

    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
        int ID = Integer.parseInt(supOrderIDField.getText().toString());
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/orocare", "root", "");

            PreparedStatement stmt = myConn.prepareStatement("DELETE FROM supply_order WHERE sup_order_id = ?");
            stmt.setInt(1, ID);
            int i = stmt.executeUpdate();
            refreshtable();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_removeButtonActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        materialNameField.setText("");
        quantityField.setText("");
        unitPriceField.setText("");
        supOrderDatePicker.setDate(null);

    }//GEN-LAST:event_jButton11ActionPerformed

    private void supply_orderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_supply_orderMouseClicked
        try {
            int i = supply_order.getSelectedRow();
            TableModel model = supply_order.getModel();

            supOrderIDField.setText(model.getValueAt(i, 0).toString());
            materialNameField.setText(model.getValueAt(i, 1).toString());
            quantityField.setText(model.getValueAt(i, 2).toString());
            unitPriceField.setText(model.getValueAt(i, 3).toString());
            String date = model.getValueAt(i, 4).toString();
            Date date1 = Date.valueOf(date);
            supOrderDatePicker.setDate(date1);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_supply_orderMouseClicked

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        DefaultTableModel model = (DefaultTableModel) supply_order.getModel();
        model.setRowCount(0);
        this.showSupplyOrderListFiltered();
    }//GEN-LAST:event_searchButtonActionPerformed

    private void searchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchFieldActionPerformed

    private void printButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printButtonActionPerformed
        new printer("Supply Order", searchField.getText(), supply_order).print();
    }//GEN-LAST:event_printButtonActionPerformed

    private void supOrderIDFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supOrderIDFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_supOrderIDFieldActionPerformed

    private void supOrderDatePickerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supOrderDatePickerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_supOrderDatePickerActionPerformed

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
            java.util.logging.Logger.getLogger(supplierOrderInt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(supplierOrderInt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(supplierOrderInt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(supplierOrderInt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new supplierOrderInt().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton jButton11;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField materialNameField;
    private javax.swing.JButton printButton;
    private javax.swing.JTextField quantityField;
    private javax.swing.JButton removeButton;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchField;
    private javax.swing.JLabel starGen;
    private javax.swing.JLabel starGen1;
    private javax.swing.JLabel starGen2;
    private javax.swing.JLabel starGen3;
    private javax.swing.JLabel starGen4;
    private org.jdesktop.swingx.JXDatePicker supOrderDatePicker;
    private javax.swing.JTextField supOrderIDField;
    private javax.swing.JTable supply_order;
    private javax.swing.JTextField unitPriceField;
    private javax.swing.JButton updateButton;
    private javax.swing.JPanel userleft;
    // End of variables declaration//GEN-END:variables

    public int strValidate(JTextField textName) {
        if (textName.getText().equals(null) || textName.getText().equals("") || textName.getText().isEmpty() == true) {
            textName.setText("");
            return -1;
        } else {
            return 0;
        }
    }

    public int validateFormUpdate() {
        starGeneratorUpdate();
        if (strValidate(materialNameField) == -1) {
            message("Material Name Field Empty !");
            return -1;
        }

        if (strValidate(quantityField) == -1) {
            message("Material Name Field Empty !");
            return -1;
        }

        if (strValidate(unitPriceField) == -1) {
            message("UserName Field Empty !");
            return -1;
        }

        return 0;

    }

    public void starGeneratorUpdate() {
        if (strValidate(supOrderIDField) == -1) {
            starGen1.setVisible(true);
        } else {
            starGen1.setVisible(false);
        }

        if (strValidate(materialNameField) == -1) {
            starGen2.setVisible(true);
        } else {
            starGen2.setVisible(false);
        }

        if (strValidate(quantityField) == -1) {
            starGen3.setVisible(true);
        } else {
            starGen3.setVisible(false);
        }

        if (strValidate(unitPriceField) == -1) {
            starGen4.setVisible(true);
        } else {
            starGen4.setVisible(false);
        }
    }

    public boolean integerValidate(String text) {
        try {
            Integer.parseInt(text);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public int floatValidate(JTextField num) {
        try {
            Double.parseDouble(num.getText());
            if (Double.valueOf(num.getText()) > 0) {
                return 0;
            } else {
                return -1;
            }

        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public int validateForm() {
        starGenerator();
        if (strValidate(materialNameField) == -1) {
            message("Material Name Field Empty !");
            return -1;
        }

        if (strValidate(quantityField) == -1) {
            message("Quantity Field Empty !");
            return -1;
        }

        if (integerValidate(quantityField.getText().toString()) == false) {
            message("Invalid Quantity !");
            return -1;
        }

        if (strValidate(unitPriceField) == -1) {
            message("Total Price Field Empty !");
            return -1;
        }
        
        if (floatValidate(unitPriceField) == -1) {
            message("Invalid Total Price !");
            return -1;
        }

        if (supOrderDatePicker.getDate() == null) {
            message("Please Choose a Date !");
///           starGenerator(true, starGen6);
            return -1;
        }

        return 0;
    }

    public void starGenerator() {
        if (strValidate(supOrderIDField) == -1) {
            starGen1.setVisible(true);
        } else {
            starGen1.setVisible(false);
        }

        if (strValidate(materialNameField) == -1) {
            starGen2.setVisible(true);
        } else {
            starGen2.setVisible(false);
        }

        if (strValidate(quantityField) == -1) {
            starGen3.setVisible(true);
        } else {
            starGen3.setVisible(false);
        }

        if (strValidate(unitPriceField) == -1) {
            starGen4.setVisible(true);
        } else {
            starGen4.setVisible(false);
        }

    }

    public void message(String message) {
        JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
    }
}
