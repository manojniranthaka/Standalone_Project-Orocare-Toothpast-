/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import connection.Connector;
import java.sql.ResultSet;
import java.sql.Statement;
import dashboard.dashboard;
import java.awt.Color;
import java.security.MessageDigest;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import static jdk.nashorn.internal.objects.NativeError.printStackTrace;

/**
 *
 * @author it17052498
 */
public class userLogin extends javax.swing.JFrame {

    /**
     * Creates new form userLogin
     */
    public userLogin() {
        initComponents();
        SwingUtilities.getRootPane(jButton2).setDefaultButton(jButton2); 
    }

    public String generatePassword(String password) {
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        log_un = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        log_pw = new javax.swing.JPasswordField();

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("User Login");
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 102, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 66, -1, 132));

        jLabel5.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Toothpaste");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 250, -1, 21));

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo.png"))); // NOI18N
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 220, 90));

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/user1.png"))); // NOI18N
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 190, 130));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setBackground(new java.awt.Color(0, 102, 204));
        jLabel4.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 204));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("X");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, 35, 34));

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 204));
        jLabel1.setText("User Login");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(81, 40, -1, 56));

        jLabel6.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 102, 204));
        jLabel6.setText("Password");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 191, -1, -1));

        jLabel7.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 102, 204));
        jLabel7.setText("Username");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 135, -1, -1));

        log_un.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 204)));
        jPanel2.add(log_un, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, 173, 29));

        jButton1.setBackground(new java.awt.Color(0, 102, 204));
        jButton1.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Clear");
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(207, 244, 84, 31));

        jButton2.setBackground(new java.awt.Color(0, 102, 204));
        jButton2.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Login");
        jButton2.setBorder(null);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(117, 244, 84, 31));

        log_pw.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 255)));
        jPanel2.add(log_pw, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 190, 173, 29));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(620, 339));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        this.dispose();
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        if (formValidation() != -1) {
            String username = log_un.getText();
            String password = new String(log_pw.getPassword());
            String passwordEncrypted = this.generatePassword(password);

            String sqlQueryUserNew = "SELECT * from user WHERE Username = '" + username + "'";
            String sqlQueryExternalUser = "SELECT * from user_external WHERE uname = '" + username + "' AND password ='" + passwordEncrypted + "'";

            Connector cont1 = new Connector();
            Connector cont2 = new Connector();
            Connector cont3 = new Connector();

            Statement st1 = cont1.getStatement();
            Statement st2 = cont2.getStatement();
            Statement st3 = cont3.getStatement();

            ResultSet resultSetInternal = cont1.getResultSet();
            ResultSet resultSetExternal = cont2.getResultSet();
            ResultSet resultLogCount = cont3.getResultSet();

            int logCount = -1;
            String type = null;
            int userID = -1;
            int empID = -1;

            try {
                resultSetInternal = st1.executeQuery(sqlQueryUserNew);
                resultSetExternal = st2.executeQuery(sqlQueryExternalUser);

                if (resultSetInternal.next()) {
                    resultLogCount = st3.executeQuery("SELECT * FROM user u, employee e where u.empID = e.EmployeeID AND u.Username = '" + username + "'");
                    if (resultLogCount.next()) {
                        logCount = resultLogCount.getInt("logCount");
                    } else {
                        type = "Invalid";
                    }

                    if (logCount == 0) {
                        resultSetInternal = st3.executeQuery("SELECT * FROM user u, employee e where u.empID = e.EmployeeID AND u.Username = '" + username + "' and u.Password ='" + password + "'");
                        if (resultSetInternal.next()) {
                            type = "InternalNew";
                            userID = resultSetInternal.getInt("UserID");
                            empID = resultSetInternal.getInt("EmployeeID");
                        } else {
                            type = "Invalid";
                        }
                    } else if (logCount == 1) {
                        resultSetInternal = st3.executeQuery("SELECT * FROM user u, employee e where u.empID = e.EmployeeID AND u.Username = '" + username + "' and u.Password ='" + passwordEncrypted + "'");
                        if (resultSetInternal.next()) {
                            type = "InternalOld";
                            userID = resultSetInternal.getInt("UserID");
                            empID = resultSetInternal.getInt("EmployeeID");
                        } else {
                            type = "Invalid";
                        }
                    }
                } else if (resultSetExternal.next()) {
                    type = "External";
                    userID = resultSetExternal.getInt("extID");
                } else {
                    type = "Invalid";
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

            if (!type.equals("Invalid")) {
                tempUser tempus = tempUser.getTempUserInstance();
                tempus.setUsername(username);
                tempus.setID(userID);


                if (type.equals("InternalNew")) {
                    sucessMessage("Please Set New Password !");
                    tempus.setType("Internal");
                    tempus.setEmployeeID(empID);
                    new changePassword().setVisible(true);
                    this.dispose();
                } else if (type.equals("InternalOld")) {
                    sucessMessage("Login Sucessfull");
                    tempus.setType("Internal");
                    new dashboard().setVisible(true);
                    this.dispose();
                } else if (type.equals("External")) {
                    sucessMessage("Login Sucessfull");
                    tempus.setType("External");
                    new dashboard().setVisible(true);
                    this.dispose();
                }
            } else {
                errorMessage("Invalid Credentials");
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        log_un.setText("");
        log_pw.setText("");
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(userLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(userLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(userLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(userLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new userLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPasswordField log_pw;
    private javax.swing.JTextField log_un;
    // End of variables declaration//GEN-END:variables

    public int formValidation() {
        if (strValidate(log_un) == -1) {
            errorMessage("Username Field Empty !");
            return -1;
        }

        if (strValidate(log_pw) == -1) {
            errorMessage("Password Field Empty !");
            return -1;
        }

        return 0;

    }

    public int strValidate(JTextField textName) {
        if (textName.getText().equals(null) || textName.getText().equals("") || textName.getText().isEmpty() == true) {
            textName.setText("");
            return -1;
        } else {
            return 0;
        }
    }

    public void errorMessage(String message) {
        JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public void sucessMessage(String message) {
        JOptionPane.showMessageDialog(null, message, "Login", JOptionPane.INFORMATION_MESSAGE);
    }

//    resultSet3 = st3.executeQuery("SELECT * FROM user u, employee e where u.empID = e.EmployeeID AND u.Username = '" + username + "' AND u.Password ='" + password + "'");
//                    
//                    if (resultSet3.next()) {
//                        int logCount = resultSet3.getInt("logCount");
//                        if (logCount == 0) {
//                            new changePassword().setVisible(true);
//                            this.dispose();
//                            int ID = resultSet3.getInt("UserID");
//                            int EmpID = resultSet3.getInt("EmployeeID");
//                            tempus.setID(ID);
//                            tempus.setEmployeeID(EmpID);
//                            tempus.setUsername(username);
//                            sucessMessage("Please Set New Password !");
//                    } else {
//                            resultSet3 = st3.executeQuery("SELECT * FROM user where Username = '" + username + "' AND Password = '" + passwordEncrypted + "'");
//                            if (resultSet3.next()) {
//                                int ID = resultSet3.getInt("UserID");
//                                tempus.setUsername(username);
//                                tempus.setID(ID);
//                                new dashboard().setVisible(true);
//                                this.dispose();
//                                sucessMessage("Login Sucessfull");
//
//                            } else {
//                                errorMessage("Invalid User Credentials");
//                            }
//                        }
//                    }
//                try {
//                if (resultSetInternal.next()) {
//                    tempUser tempus = tempUser.getTempUserInstance();
//                    tempus.setUsername(username);
//                    tempus.setType("Internal");
//
//                    resultLogCount = st3.executeQuery("SELECT * FROM user u, employee e where u.empID = e.EmployeeID AND u.Username = '" + username + "' ");
//                    int logCount = resultLogCount.getInt(logCount);
//
//                    if (logCount == 0) {
//                        new changePassword().setVisible(true);
//                        this.dispose();
//                        int ID = resultLogCount.getInt("UserID");
//                        int EmpID = resultLogCount.getInt("EmployeeID");
//                        tempus.setID(ID);
//                        tempus.setEmployeeID(EmpID);
//                        tempus.setUsername(username);
//                        sucessMessage("Please Set New Password !");
//
//                    }else if(logCount == 1){
//                        resultSet3 = st3.executeQuery("SELECT * FROM user where Username = '" + username + "' AND Password = '" + passwordEncrypted + "'");
//                            if (resultSet3.next()) {
//                                int ID = resultSet3.getInt("UserID");
//                                tempus.setUsername(username);
//                                tempus.setID(ID);
//                                new dashboard().setVisible(true);
//                                this.dispose();
//                                sucessMessage("Login Sucessfull");
//                    }
//
//                } else if (resultSetExternal.next()) {
//                    tempUser tempus = tempUser.getTempUserInstance();
//                    tempus.setUsername(username);
//                    tempus.setType("External");
//                    dashboard dash = new dashboard();
//                    dash.setVisible(true);
//                    this.dispose();
//                    sucessMessage("Login Sucessfull");
//                } else {
//                    errorMessage("Invalid User Credentials");
//                }
//            } catch (Exception e) {
//                printStackTrace(e);
//            }
}
