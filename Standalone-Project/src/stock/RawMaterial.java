/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stock;

import connection.Connector;
import customer.customerEntity;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import printer.printer;

/**
 *
 * @author Sathira Guruge
 */
public class RawMaterial extends javax.swing.JFrame {

    private int currentrowCount;
    private Date currentMaxDate;

    public RawMaterial() {
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        showRawsList();
        initializeLabels();
        syncTable();
    }

    private void initializeLabels() {
        rawID.setVisible(false);
        starGen1.setVisible(false);
        starGen2.setVisible(false);

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
        ResultSet rs = connector.getResultSet();
        Statement st = connector.getStatement();
        String sql = "SELECT MAX(DateAdded) FROM raw_mat";
        try {
            rs = st.executeQuery(sql);
            while (rs.next()) {
                date = rs.getDate("MAX(DateAdded)");
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
        String sql = "SELECT COUNT(*) FROM raw_mat";
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        userleft = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        title = new javax.swing.JLabel();
        raw_name = new javax.swing.JTextField();
        Name = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        rawTable = new javax.swing.JTable();
        searchButton = new javax.swing.JButton();
        searchField = new javax.swing.JTextField();
        printButton = new javax.swing.JButton();
        starGen1 = new javax.swing.JLabel();
        starGen2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        raw_desc = new javax.swing.JTextArea();
        addCus = new javax.swing.JButton();
        editCus = new javax.swing.JButton();
        removeCus = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        rawID = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/stock2.png"))); // NOI18N
        userleft.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 300, 110));

        getContentPane().add(userleft, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 720));

        title.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        title.setForeground(new java.awt.Color(255, 255, 255));
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("Raw Material Management");
        getContentPane().add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, 1070, 70));

        raw_name.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.blue, 2));
        raw_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                raw_nameActionPerformed(evt);
            }
        });
        getContentPane().add(raw_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 160, 270, 30));

        Name.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        Name.setForeground(java.awt.Color.white);
        Name.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Name.setText("Name");
        getContentPane().add(Name, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 130, 160, -1));

        jLabel14.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel14.setForeground(java.awt.Color.white);
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Description");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 260, 160, -1));

        rawTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Raw ID", "Name", "Description", "Added Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        rawTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rawTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(rawTable);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 140, 680, -1));

        searchButton.setBackground(new java.awt.Color(106, 106, 0));
        searchButton.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        searchButton.setForeground(new java.awt.Color(255, 255, 255));
        searchButton.setText("Search");
        searchButton.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.white, 2));
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });
        getContentPane().add(searchButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1270, 80, 80, 30));

        searchField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        searchField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(83, 43, 11), 2));
        getContentPane().add(searchField, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 80, 230, 30));

        printButton.setBackground(new java.awt.Color(106, 106, 0));
        printButton.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        printButton.setForeground(new java.awt.Color(255, 255, 255));
        printButton.setText("Print");
        printButton.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.white, 2));
        printButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printButtonActionPerformed(evt);
            }
        });
        getContentPane().add(printButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 80, 80, 30));

        starGen1.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        starGen1.setForeground(java.awt.Color.red);
        starGen1.setText("*");
        getContentPane().add(starGen1, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 160, -1, -1));

        starGen2.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        starGen2.setForeground(java.awt.Color.red);
        starGen2.setText("*");
        getContentPane().add(starGen2, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 290, -1, -1));

        raw_desc.setColumns(20);
        raw_desc.setRows(5);
        jScrollPane2.setViewportView(raw_desc);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 290, 270, 170));

        addCus.setBackground(new java.awt.Color(106, 106, 0));
        addCus.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        addCus.setForeground(new java.awt.Color(255, 255, 255));
        addCus.setText("Add");
        addCus.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        addCus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCusActionPerformed(evt);
            }
        });
        getContentPane().add(addCus, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 600, 90, 30));

        editCus.setBackground(new java.awt.Color(106, 106, 0));
        editCus.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        editCus.setForeground(new java.awt.Color(255, 255, 255));
        editCus.setText("Update");
        editCus.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        editCus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editCusActionPerformed(evt);
            }
        });
        getContentPane().add(editCus, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 600, 90, 30));

        removeCus.setBackground(new java.awt.Color(106, 106, 0));
        removeCus.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        removeCus.setForeground(new java.awt.Color(255, 255, 255));
        removeCus.setText("Remove");
        removeCus.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        removeCus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeCusActionPerformed(evt);
            }
        });
        getContentPane().add(removeCus, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 600, 90, 30));

        jButton6.setBackground(new java.awt.Color(106, 106, 0));
        jButton6.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Clear");
        jButton6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 600, 90, 30));

        rawID.setEditable(false);
        getContentPane().add(rawID, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 70, 140, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/gray2.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-1, 0, 1390, 720));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void raw_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_raw_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_raw_nameActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        DefaultTableModel model = (DefaultTableModel) rawTable.getModel();
        model.setRowCount(0);
        this.showRawListFiltered();
    }//GEN-LAST:event_searchButtonActionPerformed

    private ArrayList<RawMaterialEntity> getRawListFiltered() {
        RawMaterialEntity materialEntity;
        ArrayList<RawMaterialEntity> matList = new ArrayList<RawMaterialEntity>();
        Connector c1 = new Connector();
        String sql = "SELECT * FROM raw_mat WHERE CONCAT(rawID,rawName,raw_Desc) LIKE '%" + searchField.getText() + "%'";
        try {
            ResultSet rs = c1.myStmt.executeQuery(sql);

            while (rs.next()) {
                materialEntity = new RawMaterialEntity(rs.getInt("rawID"), rs.getString("rawName"), rs.getString("raw_Desc"), String.valueOf(rs.getDate("dateAdded")));
                matList.add(materialEntity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return matList;
    }

    private void showRawListFiltered() {

        ArrayList<RawMaterialEntity> rawList = this.getRawListFiltered();
        DefaultTableModel model = (DefaultTableModel) rawTable.getModel();
        Object[] row = new Object[4];

        for (int i = 0; i < rawList.size(); ++i) {
            row[0] = rawList.get(i).getID();
            row[1] = rawList.get(i).getrawName();
            row[2] = rawList.get(i).getrawDesc();
            row[3] = rawList.get(i).getDate();
            model.addRow(row);
        }
    }


    private void printButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printButtonActionPerformed
        new printer("Raw Material", searchField.getText(), rawTable).print();
    }//GEN-LAST:event_printButtonActionPerformed

    private void addCusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCusActionPerformed
        if (validateForm() != -1) {
            String Name = raw_name.getText().toString();
            String Address = raw_desc.getText().toString();

            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/orocare", "root", "");

                PreparedStatement stmt = myConn.prepareStatement("INSERT INTO raw_mat(rawName, raw_Desc,  dateAdded) VALUES (?,?,NOW())");
                stmt.setString(1, Name);
                stmt.setString(2, Address);
                int i = stmt.executeUpdate();
                refreshtable();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_addCusActionPerformed

    private void refreshtable() {
        DefaultTableModel model = (DefaultTableModel) rawTable.getModel();
        model.setRowCount(0);
        showRawsList();
    }


    private void editCusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editCusActionPerformed

        if (!(rawID.getText().equals("") || rawID.getText().isEmpty() == true)) {
            if (validateForm() != -1) {
                int ID = Integer.parseInt(rawID.getText().toString());
                String Name = raw_name.getText().toString();
                String Address = raw_desc.getText().toString();

                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/orocare", "root", "");

                    PreparedStatement stmt = myConn.prepareStatement("UPDATE raw_mat SET rawName = ?, raw_Desc = ?, dateAdded =  NOW() WHERE rawID = ?");
                    stmt.setString(1, Name);
                    stmt.setString(2, Address);
                    stmt.setInt(3, ID);
                    int i = stmt.executeUpdate();
                    refreshtable();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else {
            message("Please Select a Raw Item !");
        }
    }//GEN-LAST:event_editCusActionPerformed

    private void removeCusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeCusActionPerformed
        if (!(rawID.getText().equals("") || rawID.getText().isEmpty() == true)) {
            int ID = Integer.parseInt(rawID.getText().toString());
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/orocare", "root", "");

                PreparedStatement stmt = myConn.prepareStatement("DELETE FROM raw_mat WHERE rawID = ?");
                stmt.setInt(1, ID);
                int i = stmt.executeUpdate();
                refreshtable();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            message("Please Select a Customer !");
        }
    }//GEN-LAST:event_removeCusActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed

        rawID.setText("");
        raw_desc.setText("");
        raw_name.setText("");
    }//GEN-LAST:event_jButton6ActionPerformed

    private void rawTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rawTableMouseClicked
        try {
            int i = rawTable.getSelectedRow();
            TableModel model = rawTable.getModel();

            rawID.setText(model.getValueAt(i, 0).toString());
            raw_name.setText(model.getValueAt(i, 1).toString());
            raw_desc.setText(model.getValueAt(i, 2).toString());
        } catch (Exception e) {
        }
    }//GEN-LAST:event_rawTableMouseClicked

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
            java.util.logging.Logger.getLogger(RawMaterial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RawMaterial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RawMaterial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RawMaterial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RawMaterial().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Name;
    private javax.swing.JButton addCus;
    private javax.swing.JButton editCus;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton printButton;
    private javax.swing.JTextField rawID;
    private javax.swing.JTable rawTable;
    private javax.swing.JTextArea raw_desc;
    private javax.swing.JTextField raw_name;
    private javax.swing.JButton removeCus;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchField;
    private javax.swing.JLabel starGen1;
    private javax.swing.JLabel starGen2;
    private javax.swing.JLabel title;
    private javax.swing.JPanel userleft;
    // End of variables declaration//GEN-END:variables

    private ArrayList<RawMaterialEntity> getRawsList() {

        RawMaterialEntity materialEntity;
        ArrayList<RawMaterialEntity> rawList = new ArrayList<RawMaterialEntity>();
        Connector c1 = new Connector();
        ResultSet rs = c1.getResultSet();
        Statement st1 = c1.getStatement();
        String sql = "SELECT * from raw_mat";
        try {
            rs = st1.executeQuery(sql);
            while (rs.next()) {
                materialEntity = new RawMaterialEntity(rs.getInt("rawID"), rs.getString("rawName"), rs.getString("raw_Desc"), String.valueOf(rs.getDate("dateAdded")));
                rawList.add(materialEntity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rawList;
    }

    private void showRawsList() {
        ArrayList<RawMaterialEntity> rawList = this.getRawsList();
        DefaultTableModel model = (DefaultTableModel) rawTable.getModel();
        Object[] row = new Object[4];

        for (int i = 0; i < rawList.size(); ++i) {
            row[0] = rawList.get(i).getID();
            row[1] = rawList.get(i).getrawName();
            row[2] = rawList.get(i).getrawDesc();
            row[3] = rawList.get(i).getDate();
            model.addRow(row);
        }
    }

    private void message(String message) {
        JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    private void starGenerator(boolean cond, JLabel jLabel) {
        jLabel.setVisible(cond);
    }

    private int strValidate(JTextField textName) {
        if (textName.getText().equals(null) || textName.getText().equals("") || textName.getText().isEmpty() == true) {
            textName.setText("");
            return -1;
        } else {
            return 0;
        }
    }

    private int validateForm() {
        if (strValidate(raw_name) == -1) {
            message("Name Field Empty !");
            starGenerator(true, starGen1);
            return -1;
        } else {
            starGenerator(false, starGen1);
        }

        if (raw_desc.getText().equals("") || raw_desc.getText().equals(null) || raw_desc.getText().isEmpty() == true) {
            message("Description Field Empty !");
            starGenerator(true, starGen2);
            return -1;
        } else {
            starGenerator(false, starGen2);
        }

        return 0;
    }
}
