/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

import connection.Connector;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import org.jdesktop.swingx.JXDatePicker;
import printer.printer;

public class utility extends javax.swing.JFrame {

    private int currentrowCount;
    private java.util.Date currentMaxDate;

    public utility() {
        initComponents();
        userleft.setBackground(new Color(96, 96, 96, 80));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ut_ID.setVisible(false);
        showUtilityList();
        initializeLabels();
        syncTable();
    }

    private void initializeLabels() {
        starGen1.setVisible(false);
        starGen2.setVisible(false);
        starGen3.setVisible(false);
        starGen4.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ut_price = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        ut_name = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ut_table = new javax.swing.JTable();
        searchField = new javax.swing.JTextField();
        ut_date = new org.jdesktop.swingx.JXDatePicker();
        searchButton = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        title = new javax.swing.JLabel();
        userleft = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ut_type = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        printButton = new javax.swing.JButton();
        ut_ID = new javax.swing.JTextField();
        starGen1 = new javax.swing.JLabel();
        starGen2 = new javax.swing.JLabel();
        starGen3 = new javax.swing.JLabel();
        starGen4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ut_price.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(42, 42, 42), 2));
        getContentPane().add(ut_price, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 240, 160, 30));

        jLabel9.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel9.setForeground(java.awt.Color.white);
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Price");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 220, 160, -1));

        ut_name.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(42, 42, 42), 2));
        ut_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ut_nameActionPerformed(evt);
            }
        });
        getContentPane().add(ut_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 150, 160, 30));

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel4.setForeground(java.awt.Color.white);
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Utility Name");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 130, 160, -1));

        jLabel15.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel15.setForeground(java.awt.Color.white);
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Date");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 220, 160, -1));

        ut_table.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(42, 42, 42), 2));
        ut_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Utility ID", "Type", "Name", "Amount", "Date", "Added Date"
            }
        ));
        ut_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ut_tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(ut_table);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 120, 470, 480));

        searchField.setForeground(new java.awt.Color(75, 0, 130));
        searchField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        searchField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(42, 42, 42), 2));
        getContentPane().add(searchField, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 60, 140, 30));

        ut_date.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(83, 43, 11), 2));
        getContentPane().add(ut_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 240, 160, 30));

        searchButton.setBackground(new java.awt.Color(42, 42, 42));
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

        jButton7.setBackground(new java.awt.Color(42, 42, 42));
        jButton7.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("Add");
        jButton7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 630, 90, 30));

        jButton2.setBackground(new java.awt.Color(42, 42, 42));
        jButton2.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Update");
        jButton2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 630, 90, 30));

        jButton5.setBackground(new java.awt.Color(42, 42, 42));
        jButton5.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Remove");
        jButton5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 630, 90, 30));

        jButton6.setBackground(new java.awt.Color(42, 42, 42));
        jButton6.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Clear");
        jButton6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 630, 90, 30));

        title.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        title.setForeground(new java.awt.Color(255, 255, 255));
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("Utility Management");
        getContentPane().add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, 1070, 70));

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
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/util3.png"))); // NOI18N
        userleft.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 300, 110));

        getContentPane().add(userleft, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 720));

        ut_type.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(42, 42, 42), 2));
        getContentPane().add(ut_type, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 150, 160, 30));

        jLabel10.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel10.setForeground(java.awt.Color.white);
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Utility Type");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 130, 160, -1));

        printButton.setBackground(new java.awt.Color(42, 42, 42));
        printButton.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        printButton.setForeground(new java.awt.Color(255, 255, 255));
        printButton.setText("Print");
        printButton.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.white, 2));
        printButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printButtonActionPerformed(evt);
            }
        });
        getContentPane().add(printButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 60, 80, 30));

        ut_ID.setEditable(false);
        getContentPane().add(ut_ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 80, 160, -1));

        starGen1.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        starGen1.setForeground(java.awt.Color.red);
        starGen1.setText("*");
        getContentPane().add(starGen1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 140, -1, -1));

        starGen2.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        starGen2.setForeground(java.awt.Color.red);
        starGen2.setText("*");
        getContentPane().add(starGen2, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 140, -1, -1));

        starGen3.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        starGen3.setForeground(java.awt.Color.red);
        starGen3.setText("*");
        getContentPane().add(starGen3, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 230, -1, -1));

        starGen4.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        starGen4.setForeground(java.awt.Color.red);
        starGen4.setText("*");
        getContentPane().add(starGen4, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 230, -1, -1));

        jButton1.setText("DEMO");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 80, -1, -1));

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel1.setForeground(java.awt.Color.white);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/gray2.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, -10, 1390, -1));

        setSize(new java.awt.Dimension(1382, 759));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ut_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ut_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ut_nameActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed

        ut_name.setText("");
        ut_price.setText("");
        ut_date.setDate(null);
        ut_type.setText("");

    }//GEN-LAST:event_jButton6ActionPerformed

    private void ut_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ut_tableMouseClicked
        try {
            int i = ut_table.getSelectedRow();
            TableModel model = ut_table.getModel();

            ut_ID.setText(model.getValueAt(i, 0).toString());
            ut_type.setText(model.getValueAt(i, 1).toString());
            ut_name.setText(model.getValueAt(i, 2).toString());
            ut_price.setText(model.getValueAt(i, 3).toString());
            String date = model.getValueAt(i, 4).toString();
            Date date1 = Date.valueOf(date);
            ut_date.setDate(date1);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_ut_tableMouseClicked

    private String getDate(JXDatePicker date1) {
        SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
        return formater.format(date1.getDate());
    }


    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        if (validateForm() != -1) {
            String Ut_name = ut_name.getText().toString();
            String Ut_type = ut_type.getText().toString();
            String Ut_price = ut_price.getText().toString();
            String date = getDate(ut_date);

            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/orocare", "root", "");

                PreparedStatement stmt = myConn.prepareStatement("INSERT INTO utility(type, name, Amount, date,added_dte) VALUES (?,?,?,?,NOW())");
                stmt.setString(1, Ut_type);
                stmt.setString(2, Ut_name);
                stmt.setString(3, Ut_price);
                stmt.setString(4, date);
                int i = stmt.executeUpdate();
                refreshtable();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (!(ut_ID.getText().equals("") || ut_ID.getText().isEmpty() == true)) {
            if (validateForm() != -1) {
                String ID = ut_ID.getText();
                String Ut_name = ut_name.getText().toString();
                String Ut_type = ut_type.getText().toString();
                String Ut_price = ut_price.getText().toString();
                String date = getDate(ut_date);

                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/orocare", "root", "");

                    PreparedStatement stmt = myConn.prepareStatement("UPDATE utility SET type = ?, name = ?, Amount = ?, date = ?, added_dte = NOW() WHERE UtilityID = ?");
                    stmt.setString(1, Ut_type);
                    stmt.setString(2, Ut_name);
                    stmt.setString(3, Ut_price);
                    stmt.setString(4, date);
                    stmt.setString(5, ID);
                    int i = stmt.executeUpdate();
                    refreshtable();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else {
            message("Please Select an Utility Item !");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        if (!(ut_ID.getText().equals("") || ut_ID.getText().isEmpty() == true)) {
            int ID = Integer.parseInt(ut_ID.getText().toString());
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/orocare", "root", "");

                PreparedStatement stmt = myConn.prepareStatement("DELETE FROM utility WHERE UtilityID = ?");
                stmt.setInt(1, ID);
                int i = stmt.executeUpdate();
                refreshtable();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            message("Please Select an Utilty Item !");
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        DefaultTableModel model = (DefaultTableModel) ut_table.getModel();
        model.setRowCount(0);
        this.showUtilityListFiltered();
    }//GEN-LAST:event_searchButtonActionPerformed

    private void printButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printButtonActionPerformed
        new printer("Utility", searchField.getText(), ut_table).print();
    }//GEN-LAST:event_printButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String dateString = "2018-08-01";
        Date date = Date.valueOf(dateString);
        ut_date.setDate(date);
        ut_type.setText("Electricity");
        ut_name.setText("LECO BILL");
        ut_price.setText("3000");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void refreshtable() {
        DefaultTableModel model = (DefaultTableModel) ut_table.getModel();
        model.setRowCount(0);
        showUtilityList();
    }

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
            java.util.logging.Logger.getLogger(utility.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(utility.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(utility.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(utility.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new utility().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton printButton;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchField;
    private javax.swing.JLabel starGen1;
    private javax.swing.JLabel starGen2;
    private javax.swing.JLabel starGen3;
    private javax.swing.JLabel starGen4;
    private javax.swing.JLabel title;
    private javax.swing.JPanel userleft;
    private javax.swing.JTextField ut_ID;
    private org.jdesktop.swingx.JXDatePicker ut_date;
    private javax.swing.JTextField ut_name;
    private javax.swing.JTextField ut_price;
    private javax.swing.JTable ut_table;
    private javax.swing.JTextField ut_type;
    // End of variables declaration//GEN-END:variables

    private ArrayList<utilityEntity> getUtilityList() {

        utilityEntity uEntity;
        ArrayList<utilityEntity> utilityList = new ArrayList<utilityEntity>();
        Connector c1 = new Connector();
        ResultSet rs = c1.getResultSet();
        Statement st1 = c1.getStatement();
        String sql = "SELECT * from utility";
        try {
            rs = st1.executeQuery(sql);
            while (rs.next()) {
                uEntity = new utilityEntity(rs.getInt("UtilityID"), rs.getString("type"), rs.getString("name"), rs.getDouble("Amount"), rs.getString("date"), rs.getString("added_dte"));
                utilityList.add(uEntity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return utilityList;
    }

    private void showUtilityList() {
        ArrayList<utilityEntity> utilityList = this.getUtilityList();
        DefaultTableModel model = (DefaultTableModel) ut_table.getModel();
        Object[] row = new Object[6];

        for (int i = 0; i < utilityList.size(); ++i) {
            row[0] = utilityList.get(i).getUtilityID();
            row[1] = utilityList.get(i).gettype();
            row[2] = utilityList.get(i).getname();
            row[3] = utilityList.get(i).getAmount();
            row[4] = utilityList.get(i).getdate();
            row[5] = utilityList.get(i).getadded_dte();

            model.addRow(row);
        }
    }

    private ArrayList<utilityEntity> getUtilityListFiltered() {
        utilityEntity uEntity;
        ArrayList<utilityEntity> utilityList = new ArrayList<utilityEntity>();
        Connector c1 = new Connector();
        String sql = "SELECT * FROM utility WHERE CONCAT(UtilityID,name,type,Amount) LIKE '%" + searchField.getText() + "%'";
        try {
            ResultSet rs = c1.myStmt.executeQuery(sql);

            while (rs.next()) {
                uEntity = new utilityEntity(rs.getInt("UtilityID"), rs.getString("type"), rs.getString("name"), rs.getDouble("Amount"), rs.getString("date"), rs.getString("added_dte"));
                utilityList.add(uEntity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return utilityList;
    }

    private void showUtilityListFiltered() {
        ArrayList<utilityEntity> utilityList = this.getUtilityListFiltered();
        DefaultTableModel model = (DefaultTableModel) ut_table.getModel();
        Object[] row = new Object[6];

        for (int i = 0; i < utilityList.size(); ++i) {
            row[0] = utilityList.get(i).getUtilityID();
            row[1] = utilityList.get(i).gettype();
            row[2] = utilityList.get(i).getname();
            row[3] = utilityList.get(i).getAmount();
            row[4] = utilityList.get(i).getdate();
            row[5] = utilityList.get(i).getadded_dte();

            model.addRow(row);
        }
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

    private int validateForm() {
        if (strValidate(ut_name) == -1) {
            message("Name Field Empty !");
            starGenerator(true, starGen1);
            return -1;
        } else {
            starGenerator(false, starGen1);
        }

        String Utname = ut_name.getText();

        if (!Utname.matches("[a-zA-Z][a-zA-Z ]*")) {
            message("Name Field Contains Numbers");
            starGenerator(true, starGen1);
            return -1;
        } else {
            starGenerator(false, starGen1);
        }

        if (strValidate(ut_type) == -1) {
            message("Type Field Empty !");
            starGenerator(true, starGen2);
            return -1;
        } else {
            starGenerator(false, starGen2);
        }

        String utType = ut_type.getText();

        if (!utType.matches("[a-zA-Z][a-zA-Z ]*")) {
            message("Type Field Contains Numbers");
            starGenerator(true, starGen2);
            return -1;
        } else {
            starGenerator(false, starGen2);
        }

        if (ut_date.getDate() == null) {
            message("Please Choose a Date !");
            starGenerator(true, starGen3);
            return -1;
        } else {
            starGenerator(false, starGen3);
        }

        if (strValidate(ut_price) == -1) {
            message("Amount Field Empty !");
            starGenerator(true, starGen4);
            return -1;
        } else {
            starGenerator(false, starGen4);
        }

        String number = ut_price.getText();

        if (!number.matches("[0-9]+(\\.){0,1}[0-9]+")) {
            message("Price Contains Letters !");
            starGenerator(true, starGen4);
            return -1;
        } else {
            starGenerator(false, starGen4);
        }

        return 0;
    }

    private void syncTable() {
        Connector connector = new Connector();
        currentMaxDate = getMaxDate(connector);
        currentrowCount = getRowCount(connector);

        Timer t = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                java.util.Date tempDate = getMaxDate(connector);
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

    private java.util.Date getMaxDate(Connector connector) {

        java.util.Date date = null;
        Timestamp timestamp;
        ResultSet rs = connector.getResultSet();
        Statement st = connector.getStatement();
        String sql = "SELECT MAX(added_dte) FROM utility";
        try {
            rs = st.executeQuery(sql);
            while (rs.next()) {
                //date = rs.getDate("MAX(added_dte)");
                timestamp = rs.getTimestamp("MAX(added_dte)");
                if (timestamp != null) {
                    date = new java.util.Date(timestamp.getTime());
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
        return date;
    }

    private int getRowCount(Connector connector) {
        int temprowCount = -1;
        ResultSet rs = connector.getResultSet();
        Statement st = connector.getStatement();
        String sql = "SELECT COUNT(*) FROM utility";
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
