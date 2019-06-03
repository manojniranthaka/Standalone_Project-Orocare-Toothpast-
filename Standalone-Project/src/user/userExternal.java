/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import connection.Connector;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import printer.printer;

public class userExternal extends javax.swing.JFrame {

    private int currentrowCount;
    private Date currentMaxDate;

    public userExternal() {
        initComponents();
        showUsers();
        IDField.setVisible(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        initializeLabels();
        syncTable();
    }

    private void initializeLabels() {
        starGen1.setVisible(false);
        starGen2.setVisible(false);
        starGen3.setVisible(false);
        starGen4.setVisible(false);
    }

    private ArrayList<userExternalEntity> getUsersExternalList() {

        userExternalEntity user;
        ArrayList<userExternalEntity> userExtList = new ArrayList<userExternalEntity>();
        Connector c1 = new Connector();
        ResultSet rs = c1.getResultSet();
        Statement st1 = c1.getStatement();
        String sql = "SELECT * from user_external";
        try {
            rs = st1.executeQuery(sql);
            while (rs.next()) {
                user = new userExternalEntity(rs.getInt("extID"), rs.getString("fname"), rs.getString("lname"), rs.getString("uname"), rs.getString("password"), rs.getString("dateAdded"));
                userExtList.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userExtList;
    }

    private void showUsers() {
        ArrayList<userExternalEntity> userIntList = this.getUsersExternalList();
        DefaultTableModel model = (DefaultTableModel) extUserTable.getModel();
        Object[] row = new Object[5];

        for (int i = 0; i < userIntList.size(); ++i) {
            row[0] = userIntList.get(i).getID();
            row[1] = userIntList.get(i).getfname();
            row[2] = userIntList.get(i).getlname();
            row[3] = userIntList.get(i).getUname();
            row[4] = userIntList.get(i).getDate();
            model.addRow(row);
        }
    }

    private ArrayList<userExternalEntity> getUserListFiltered() {
        userExternalEntity user;
        ArrayList<userExternalEntity> userList = new ArrayList<userExternalEntity>();
        Connector c1 = new Connector();
        String sql = "SELECT * FROM user_external WHERE CONCAT(extID,fname,lname,uname) LIKE '%" + searchField.getText() + "%'";
        //String sql = "SELECT * FROM customer WHERE CustomerID LIKE '%" +searchField.getText() + "%' OR Name LIKE '%" + searchField.getText() + "%'";
        try {
            ResultSet rs = c1.myStmt.executeQuery(sql);

            while (rs.next()) {
                user = new userExternalEntity(rs.getInt("extID"), rs.getString("fname"), rs.getString("lname"), rs.getString("uname"), rs.getString("password"), rs.getString("dateAdded"));
                userList.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userList;
    }

    private void showUserListFiltered() {
        ArrayList<userExternalEntity> userlist = this.getUserListFiltered();
        DefaultTableModel model = (DefaultTableModel) extUserTable.getModel();
        Object[] row = new Object[5];

        for (int i = 0; i < userlist.size(); ++i) {
            row[0] = userlist.get(i).getID();
            row[1] = userlist.get(i).getfname();
            row[2] = userlist.get(i).getlname();
            row[3] = userlist.get(i).getUname();
            row[4] = userlist.get(i).getDate();
            model.addRow(row);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        starGen = new javax.swing.JLabel();
        firstnameField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        PasswordField = new javax.swing.JPasswordField();
        userleft = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        extUserTable = new javax.swing.JTable();
        lastnameField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        usernameField = new javax.swing.JTextField();
        addButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        removeButton = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        IDField = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        searchField = new javax.swing.JTextField();
        printButton = new javax.swing.JButton();
        starGen1 = new javax.swing.JLabel();
        starGen2 = new javax.swing.JLabel();
        starGen3 = new javax.swing.JLabel();
        starGen4 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();

        starGen.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        starGen.setForeground(java.awt.Color.red);
        starGen.setText("*");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(java.awt.Color.black);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        firstnameField.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.red, 2));
        firstnameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstnameFieldActionPerformed(evt);
            }
        });
        getContentPane().add(firstnameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(379, 213, 205, 30));

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        jLabel1.setForeground(java.awt.Color.white);
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("User Management (External)");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(602, 30, 477, 39));

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel4.setForeground(java.awt.Color.white);
        jLabel4.setText("Username");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(378, 340, 96, -1));

        jLabel6.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel6.setForeground(java.awt.Color.white);
        jLabel6.setText("Password");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(378, 428, 96, -1));
        getContentPane().add(PasswordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(378, 463, 205, 30));

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

        extUserTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "extID", "fname", "lname", "uname", "Date Added"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        extUserTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                extUserTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(extUserTable);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(786, 109, -1, -1));

        lastnameField.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.red, 2));
        lastnameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastnameFieldActionPerformed(evt);
            }
        });
        getContentPane().add(lastnameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(378, 292, 206, 30));

        jLabel7.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel7.setForeground(java.awt.Color.white);
        jLabel7.setText("First Name");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(379, 171, 88, 30));

        jLabel9.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel9.setForeground(java.awt.Color.white);
        jLabel9.setText("Last Name");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(378, 261, -1, -1));

        usernameField.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.red, 2));
        usernameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameFieldActionPerformed(evt);
            }
        });
        getContentPane().add(usernameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(378, 380, 206, 30));

        addButton.setBackground(java.awt.Color.red);
        addButton.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        addButton.setForeground(new java.awt.Color(255, 255, 255));
        addButton.setText("ADD");
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
        getContentPane().add(IDField, new org.netbeans.lib.awtextra.AbsoluteConstraints(379, 133, 160, -1));

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

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/gray2.png"))); // NOI18N
        jLabel22.setIconTextGap(100);
        getContentPane().add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 1390, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lastnameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastnameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lastnameFieldActionPerformed

    private void usernameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameFieldActionPerformed

    private void firstnameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstnameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_firstnameFieldActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed

        if (validateForm() != -1) {
            String Fname = firstnameField.getText().toString();
            String Lname = lastnameField.getText().toString();
            String Username = usernameField.getText().toString();
            String Password = new String(PasswordField.getPassword());
            String generatedPassword = generatePassword(Password);
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/orocare", "root", "");

                PreparedStatement stmt = myConn.prepareStatement("INSERT INTO user_external(fname, lname, uname, password, DateAdded) VALUES (?,?,?,?,NOW())");
                stmt.setString(1, Fname);
                stmt.setString(2, Lname);
                stmt.setString(3, Username);
                stmt.setString(4, generatedPassword);
                int i = stmt.executeUpdate();
                refreshtable();
            } catch (SQLIntegrityConstraintViolationException ex) {
                JOptionPane.showMessageDialog(null, "Username Already Exits !", "Login Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_addButtonActionPerformed

    private String generatePassword(String password) {
        String passwordToHash = password;
        String generatedPassword = null;
        try {
            // Create MessageDigest instance for MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
            // Add password bytes to digest
            md.update(passwordToHash.getBytes());
            // Get the hash's bytes
            byte[] bytes = md.digest();
            // This bytes[] has bytes in decimal format;
            // Convert it to hexadecimal format
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            // Get complete hashed password in hex format
            generatedPassword = sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return generatedPassword;
    }

    private void refreshtable() {
        DefaultTableModel model = (DefaultTableModel) extUserTable.getModel();
        model.setRowCount(0);
        showUsers();
    }

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed

        if (validateFormUpdate() != -1) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/orocare", "root", "");

                PreparedStatement stmt = myConn.prepareStatement("UPDATE user_external SET fname = ?, lname = ? , uname = ?, dateAdded = NOW() WHERE extID = ?");
                stmt.setString(1, firstnameField.getText());
                stmt.setString(2, lastnameField.getText());
                stmt.setString(3, usernameField.getText());
                stmt.setInt(4, Integer.parseInt(IDField.getText()));
                int i = stmt.executeUpdate();
                refreshtable();

            } catch (SQLIntegrityConstraintViolationException ex) {
                JOptionPane.showMessageDialog(null, "Username Already Exits !", "Login Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }//GEN-LAST:event_updateButtonActionPerformed

    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
        int ID = Integer.parseInt(IDField.getText().toString());
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/orocare", "root", "");

            PreparedStatement stmt = myConn.prepareStatement("DELETE FROM user_external WHERE extID = ?");
            stmt.setInt(1, ID);
            int i = stmt.executeUpdate();
            refreshtable();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_removeButtonActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        firstnameField.setText("");
        lastnameField.setText("");
        PasswordField.setText("");
        usernameField.setText("");

    }//GEN-LAST:event_jButton11ActionPerformed

    private void extUserTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_extUserTableMouseClicked
        try {
            int i = extUserTable.getSelectedRow();
            TableModel model = extUserTable.getModel();

            IDField.setText(model.getValueAt(i, 0).toString());
            firstnameField.setText(model.getValueAt(i, 1).toString());
            lastnameField.setText(model.getValueAt(i, 2).toString());
            usernameField.setText(model.getValueAt(i, 3).toString());
        } catch (Exception e) {
        }
    }//GEN-LAST:event_extUserTableMouseClicked

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        DefaultTableModel model = (DefaultTableModel) extUserTable.getModel();
        model.setRowCount(0);
        this.showUserListFiltered();
    }//GEN-LAST:event_searchButtonActionPerformed

    private void searchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchFieldActionPerformed

    private void printButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printButtonActionPerformed
        new printer("External User", searchField.getText(), extUserTable).print();
    }//GEN-LAST:event_printButtonActionPerformed

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
            java.util.logging.Logger.getLogger(userExternal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(userExternal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(userExternal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(userExternal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new userExternal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField IDField;
    private javax.swing.JPasswordField PasswordField;
    private javax.swing.JButton addButton;
    private javax.swing.JTable extUserTable;
    private javax.swing.JTextField firstnameField;
    private javax.swing.JButton jButton11;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField lastnameField;
    private javax.swing.JButton printButton;
    private javax.swing.JButton removeButton;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchField;
    private javax.swing.JLabel starGen;
    private javax.swing.JLabel starGen1;
    private javax.swing.JLabel starGen2;
    private javax.swing.JLabel starGen3;
    private javax.swing.JLabel starGen4;
    private javax.swing.JButton updateButton;
    private javax.swing.JPanel userleft;
    private javax.swing.JTextField usernameField;
    // End of variables declaration//GEN-END:variables

    private int strValidate(JTextField textName) {
        if (textName.getText().equals(null) || textName.getText().equals("") || textName.getText().isEmpty() == true) {
            textName.setText("");
            return -1;
        } else {
            return 0;
        }
    }

    private int validateFormUpdate() {
        starGeneratorUpdate();
        if (strValidate(firstnameField) == -1) {
            message("First Name Field Empty !");
            return -1;
        }

        String firstname = firstnameField.getText();
        String lastname = lastnameField.getText();

        if (!firstname.matches("[a-zA-Z]+")) {
            message("First Name Field Contains Numbers");
            return -1;
        }

        if (strValidate(lastnameField) == -1) {
            message("Last Name Field Empty !");
            return -1;
        }

        if (!lastname.matches("[a-zA-Z]+")) {
            message("Last Name Field Contains Numbers !");
            return -1;
        }

        if (strValidate(usernameField) == -1) {
            message("UserName Field Empty !");
            return -1;
        }

        return 0;

    }

    private void starGeneratorUpdate() {
        if (strValidate(firstnameField) == -1) {
            starGen1.setVisible(true);
        } else {
            starGen1.setVisible(false);
        }

        if (strValidate(lastnameField) == -1) {
            starGen2.setVisible(true);
        } else {
            starGen2.setVisible(false);
        }

        if (strValidate(usernameField) == -1) {
            starGen3.setVisible(true);
        } else {
            starGen3.setVisible(false);
        }
    }

    private int validateForm() {
        starGenerator();
        if (strValidate(firstnameField) == -1) {
            message("First Name Field Empty !");
            return -1;
        }

        String firstname = firstnameField.getText();
        String lastname = lastnameField.getText();

        if (!firstname.matches("[a-zA-Z]+")) {
            message("First Name Field Contains Numbers");
            return -1;
        }

        if (strValidate(lastnameField) == -1) {
            message("Last Name Field Empty !");
            return -1;
        }

        if (!lastname.matches("[a-zA-Z]+")) {
            message("Last Name Field Contains Numbers !");
            return -1;
        }

        if (strValidate(usernameField) == -1) {
            message("UserName Field Empty !");
            return -1;
        }
        if (strValidate(PasswordField) == -1) {
            message("Password Field Empty !");
            return -1;
        }

        String pass1 = new String(PasswordField.getPassword());

        boolean hasUppercase = !pass1.equals(pass1.toLowerCase());
        boolean hasLowercase = !pass1.equals(pass1.toUpperCase());
        boolean hasNumber = pass1.matches(".*\\d.*");
        boolean noSpecialChar = pass1.matches("[a-zA-Z0-9 ]*");

        if (pass1.length() < 5) {
            message("Password too Short !");
            return -1;
        }

        if (!hasUppercase) {
            message("Password should contain a UpperCase !");
            return -1;
        }

        if (!hasLowercase) {
            message("Password should contain a LowerCase !");
            return -1;
        }

        if (!hasNumber) {
            message("Password should contain a Number !");
            return -1;
        }

        if (noSpecialChar) {
            message("Password should contain a Special Character !");
            return -1;
        }

        return 0;
    }

    private void starGenerator() {
        if (strValidate(firstnameField) == -1) {
            starGen1.setVisible(true);
        } else {
            starGen1.setVisible(false);
        }

        if (strValidate(lastnameField) == -1) {
            starGen2.setVisible(true);
        } else {
            starGen2.setVisible(false);
        }

        if (strValidate(usernameField) == -1) {
            starGen3.setVisible(true);
        } else {
            starGen3.setVisible(false);
        }

        if (strValidate(PasswordField) == -1) {
            starGen4.setVisible(true);
        } else {
            starGen4.setVisible(false);
        }
    }

    private void message(String message) {
        JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
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
        String sql = "SELECT MAX(DateAdded) FROM user_external";
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
        String sql = "SELECT COUNT(*) FROM user_external";
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
