package supplier;

import connection.Connector;
import customer.customerEntity;
import java.awt.Color;
import java.sql.Date;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
import supplierOrder.SupplyOrder;

public class supplier extends javax.swing.JFrame {

    private int currentrowCount;
    private Date currentMaxDate;

    public supplier() {
        initComponents();
        userleft.setBackground(new Color(0, 0, 128, 80));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        initializeLabels();
        showSuppliers();
        syncTable();
    }

    private void initializeLabels() {
        starGen1.setVisible(false);
        starGen2.setVisible(false);
        starGen3.setVisible(false);
        starGen4.setVisible(false);
        starGen5.setVisible(false);
        starGen6.setVisible(false);
        sup_id.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addSup = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        sup_table = new javax.swing.JTable();
        searchField = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        title = new javax.swing.JLabel();
        userleft = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Name = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        sup_brno = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        sup_add = new javax.swing.JTextArea();
        sup_name = new javax.swing.JTextField();
        sup_etd = new org.jdesktop.swingx.JXDatePicker();
        sup_std = new org.jdesktop.swingx.JXDatePicker();
        sup_nature = new javax.swing.JComboBox<>();
        sup_type = new javax.swing.JComboBox<>();
        sup_mail = new javax.swing.JTextField();
        sup_id = new javax.swing.JTextField();
        starGen1 = new javax.swing.JLabel();
        starGen2 = new javax.swing.JLabel();
        starGen3 = new javax.swing.JLabel();
        starGen4 = new javax.swing.JLabel();
        starGen5 = new javax.swing.JLabel();
        starGen6 = new javax.swing.JLabel();
        printButton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        addSup1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        addSup.setBackground(new java.awt.Color(204, 0, 0));
        addSup.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        addSup.setForeground(new java.awt.Color(255, 255, 255));
        addSup.setText("Add");
        addSup.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        addSup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addSupActionPerformed(evt);
            }
        });
        getContentPane().add(addSup, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 350, 90, 30));

        jButton2.setBackground(new java.awt.Color(204, 0, 0));
        jButton2.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Update");
        jButton2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 350, 90, 30));

        jButton5.setBackground(new java.awt.Color(204, 0, 0));
        jButton5.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Remove");
        jButton5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 350, 90, 30));

        jButton6.setBackground(new java.awt.Color(204, 0, 0));
        jButton6.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Clear");
        jButton6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 350, 90, 30));

        sup_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Supplier ID", "Name", "Address", "Email", "Start Date", "End Date", "Type", "Nature", "BR No", "Added On"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        sup_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sup_tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(sup_table);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 110, 750, 210));

        searchField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        searchField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        getContentPane().add(searchField, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 60, 140, 30));

        searchButton.setBackground(new java.awt.Color(204, 0, 0));
        searchButton.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        searchButton.setForeground(new java.awt.Color(255, 255, 255));
        searchButton.setText("Search");
        searchButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });
        getContentPane().add(searchButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1260, 60, 80, 30));

        title.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        title.setForeground(new java.awt.Color(255, 255, 255));
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("Supplier Management");
        getContentPane().add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, 1070, 70));

        userleft.setBackground(new java.awt.Color(153, 0, 0));
        userleft.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        userleft.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 66, -1, 132));

        jLabel5.setFont(new java.awt.Font("Calibri", 1, 28)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Toothpaste");
        userleft.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(-7, 460, 310, 21));

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logof.png"))); // NOI18N
        userleft.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, 300, 90));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/supplier2.png"))); // NOI18N
        userleft.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 300, 110));

        getContentPane().add(userleft, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 720));

        Name.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        Name.setForeground(java.awt.Color.white);
        Name.setText("Name");
        getContentPane().add(Name, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 110, -1, -1));

        jLabel7.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel7.setForeground(java.awt.Color.white);
        jLabel7.setText("Address");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 320, -1, -1));

        jLabel9.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel9.setForeground(java.awt.Color.white);
        jLabel9.setText("Email");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 220, -1, -1));

        jLabel10.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel10.setForeground(java.awt.Color.white);
        jLabel10.setText("Contract Start Date");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 450, -1, -1));

        jLabel11.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel11.setForeground(java.awt.Color.white);
        jLabel11.setText("Contract End Date");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 450, -1, -1));

        jLabel12.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel12.setForeground(java.awt.Color.white);
        jLabel12.setText("Business Type");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 530, -1, -1));

        jLabel13.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel13.setForeground(java.awt.Color.white);
        jLabel13.setText("Business Registration Number");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 630, -1, -1));

        jLabel14.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel14.setForeground(java.awt.Color.white);
        jLabel14.setText("Nature of Business");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 530, -1, -1));

        sup_brno.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(106, 106, 0), 2));
        getContentPane().add(sup_brno, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 620, 240, 30));

        jScrollPane2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(83, 43, 11)));

        sup_add.setColumns(20);
        sup_add.setRows(5);
        sup_add.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(83, 43, 11), 2));
        jScrollPane2.setViewportView(sup_add);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 340, 360, 100));

        sup_name.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(106, 106, 0), 2));
        getContentPane().add(sup_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 130, 200, 30));

        sup_etd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(83, 43, 11), 2));
        sup_etd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sup_etdActionPerformed(evt);
            }
        });
        getContentPane().add(sup_etd, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 480, 210, -1));

        sup_std.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(83, 43, 11), 2));
        sup_std.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sup_stdActionPerformed(evt);
            }
        });
        getContentPane().add(sup_std, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 480, 230, -1));

        sup_nature.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Manufacturer", "Authorized Agent", "Trader", "Consulting Firm", "Other" }));
        getContentPane().add(sup_nature, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 570, 180, -1));

        sup_type.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cooperate", "Limited", "Partnership" }));
        sup_type.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sup_typeActionPerformed(evt);
            }
        });
        getContentPane().add(sup_type, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 570, 170, -1));

        sup_mail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(106, 106, 0), 2));
        getContentPane().add(sup_mail, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 240, 230, 30));
        getContentPane().add(sup_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 70, 100, -1));

        starGen1.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        starGen1.setForeground(java.awt.Color.red);
        starGen1.setText("*");
        getContentPane().add(starGen1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 120, -1, -1));

        starGen2.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        starGen2.setForeground(java.awt.Color.red);
        starGen2.setText("*");
        getContentPane().add(starGen2, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 340, -1, -1));

        starGen3.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        starGen3.setForeground(java.awt.Color.red);
        starGen3.setText("*");
        getContentPane().add(starGen3, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 230, -1, -1));

        starGen4.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        starGen4.setForeground(java.awt.Color.red);
        starGen4.setText("*");
        getContentPane().add(starGen4, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 610, -1, -1));

        starGen5.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        starGen5.setForeground(java.awt.Color.red);
        starGen5.setText("*");
        getContentPane().add(starGen5, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 460, -1, -1));

        starGen6.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        starGen6.setForeground(java.awt.Color.red);
        starGen6.setText("*");
        getContentPane().add(starGen6, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 460, -1, -1));

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
        getContentPane().add(printButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 60, 80, 30));

        jButton1.setText("DEMO");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 60, -1, -1));

        addSup1.setBackground(new java.awt.Color(204, 0, 0));
        addSup1.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        addSup1.setForeground(new java.awt.Color(255, 255, 255));
        addSup1.setText("Supplier Orders");
        addSup1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        addSup1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addSup1ActionPerformed(evt);
            }
        });
        getContentPane().add(addSup1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 10, 120, 30));

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel1.setForeground(java.awt.Color.white);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/gray2.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-1, 0, 1390, -1));

        setSize(new java.awt.Dimension(1382, 759));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void sup_etdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sup_etdActionPerformed

    }//GEN-LAST:event_sup_etdActionPerformed

    private void sup_stdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sup_stdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sup_stdActionPerformed

    private void addSupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addSupActionPerformed
        if (formValidate() != -1) {
            String Name = sup_name.getText();
            String Address = sup_add.getText();
            String Email = sup_mail.getText();
            String Type = sup_type.getSelectedItem().toString();
            String Nature = sup_nature.getSelectedItem().toString();
            String Br = sup_brno.getText();
            String stDate = getDate(sup_std);
            String endDate = getDate(sup_etd);

            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/orocare", "root", "");

                PreparedStatement stmt = myConn.prepareStatement("INSERT INTO supplier(Name, Address, Email, StartDate,EndDate, Businesstype, NatureofBusiness, BRNo, dateAdded) VALUES (?,?,?,?,?,?,?,?,NOW())");
                stmt.setString(1, Name);
                stmt.setString(2, Address);
                stmt.setString(3, Email);
                stmt.setString(4, stDate);
                stmt.setString(5, endDate);
                stmt.setString(6, Type);
                stmt.setString(7, Nature);
                stmt.setString(8, Br);
                int i = stmt.executeUpdate();
                refreshtable();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }//GEN-LAST:event_addSupActionPerformed

    private void refreshtable() {
        DefaultTableModel model = (DefaultTableModel) sup_table.getModel();
        model.setRowCount(0);
        showSuppliers();
    }

    private String getDate(JXDatePicker date1) {
        SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
        return formater.format(date1.getDate());
    }

    private void sup_typeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sup_typeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sup_typeActionPerformed

    private void sup_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sup_tableMouseClicked
        try {
            int i = sup_table.getSelectedRow();
            TableModel model = sup_table.getModel();

            sup_id.setText(model.getValueAt(i, 0).toString());
            sup_name.setText(model.getValueAt(i, 1).toString());
            sup_add.setText(model.getValueAt(i, 2).toString());
            sup_mail.setText(model.getValueAt(i, 3).toString());
            sup_std.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(model.getValueAt(i, 4).toString()));
            sup_etd.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(model.getValueAt(i, 5).toString()));
            sup_brno.setText(model.getValueAt(i, 8).toString());
        } catch (Exception e) {
            e.printStackTrace();;
        }
    }//GEN-LAST:event_sup_tableMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (!(sup_id.getText().equals("") || sup_id.getText().isEmpty() == true)) {
            if (formValidate() != -1) {
                String ID = sup_id.getText();
                String Name = sup_name.getText();
                String Address = sup_add.getText();
                String Email = sup_mail.getText();
                String Type = sup_type.getSelectedItem().toString();
                String Nature = sup_nature.getSelectedItem().toString();
                String Br = sup_brno.getText();
                String stDate = getDate(sup_std);
                String endDate = getDate(sup_etd);

                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/orocare", "root", "");

                    PreparedStatement stmt = myConn.prepareStatement("UPDATE supplier SET Name = ?, Address = ?, Email = ?, StartDate = ?, EndDate = ?,BusinessType = ?, Natureofbusiness = ?, BRNo = ?, DateAdded = NOW() WHERE SupplierID = ?");
                    stmt.setString(1, Name);
                    stmt.setString(2, Address);
                    stmt.setString(3, Email);
                    stmt.setString(4, stDate);
                    stmt.setString(5, endDate);
                    stmt.setString(6, Type);
                    stmt.setString(7, Nature);
                    stmt.setString(8, Br);
                    stmt.setString(9, ID);
                    int i = stmt.executeUpdate();
                    refreshtable();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else {
            message("Please Select a Supplier !");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        if (!(sup_id.getText().equals("") || sup_id.getText().isEmpty() == true)) {
            int ID = Integer.parseInt(sup_id.getText().toString());
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/orocare", "root", "");

                PreparedStatement stmt = myConn.prepareStatement("DELETE FROM supplier WHERE SupplierID = ?");
                stmt.setInt(1, ID);
                int i = stmt.executeUpdate();
                refreshtable();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            message("Please Select a Supplier !");
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed

        sup_id.setText("");
        sup_name.setText("");
        sup_add.setText("");
        sup_mail.setText("");
        sup_brno.setText("");
        sup_nature.setSelectedIndex(1);
        sup_type.setSelectedIndex(1);
        resetDate(sup_etd);
        resetDate(sup_std);

    }//GEN-LAST:event_jButton6ActionPerformed

    private void printButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printButtonActionPerformed
        new printer("Supplier", searchField.getText(), sup_table).print();
    }//GEN-LAST:event_printButtonActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        DefaultTableModel model = (DefaultTableModel) sup_table.getModel();
        model.setRowCount(0);
        this.showSupplierListFiltered();
    }//GEN-LAST:event_searchButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        sup_name.setText("Agro Chemicals");
        sup_mail.setText("agro@gmail.com");
        sup_add.setText("Colombo");

        String dateString = "2019-08-01";
        Date date = Date.valueOf(dateString);
        sup_std.setDate(date);

        dateString = "2020-08-01";
        date = Date.valueOf(dateString);
        sup_etd.setDate(date);
        sup_brno.setText("BR254812541");

    }//GEN-LAST:event_jButton1ActionPerformed

    private void addSup1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addSup1ActionPerformed
        new supplierOrder.supplierOrderInt().setVisible(true);
    }//GEN-LAST:event_addSup1ActionPerformed

    private ArrayList<supplierEntity> getSupplierListFiltered() {
        supplierEntity supplier;
        ArrayList<supplierEntity> supplierList = new ArrayList<supplierEntity>();
        Connector c1 = new Connector();
        String sql = "SELECT * FROM supplier WHERE CONCAT(SupplierID,Name,Address,Email,BRNo, BusinessType, NatureofBusiness) LIKE '%" + searchField.getText() + "%'";
        try {
            ResultSet rs = c1.myStmt.executeQuery(sql);

            while (rs.next()) {
                supplier = new supplierEntity(rs.getInt("SupplierID"), rs.getString("Name"), rs.getString("Address"), rs.getString("Email"), rs.getString("StartDate"), rs.getString("EndDate"), rs.getString("BusinessType"), rs.getString("NatureofBusiness"), rs.getString("BRNo"), String.valueOf(rs.getDate("DateAdded")));
                supplierList.add(supplier);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return supplierList;
    }

    private void showSupplierListFiltered() {
        ArrayList<supplierEntity> supplierList = this.getSupplierListFiltered();
        DefaultTableModel model = (DefaultTableModel) sup_table.getModel();
        Object[] row = new Object[10];

        for (int i = 0; i < supplierList.size(); ++i) {
            row[0] = supplierList.get(i).getSupplierID();
            row[1] = supplierList.get(i).getName();
            row[2] = supplierList.get(i).getAddress();
            row[3] = supplierList.get(i).getEmail();
            row[4] = supplierList.get(i).getStartDate();
            row[5] = supplierList.get(i).getEndDate();
            row[6] = supplierList.get(i).getBusinessType();
            row[7] = supplierList.get(i).getNatureofBusiness();
            row[8] = supplierList.get(i).getBRNo();
            row[9] = supplierList.get(i).getdateAdded();
            model.addRow(row);
        }
    }

    private void resetDate(JXDatePicker date1) {
        Calendar cals = Calendar.getInstance();
        date1.setDate(cals.getTime());
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
            java.util.logging.Logger.getLogger(supplier.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(supplier.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(supplier.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(supplier.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new supplier().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Name;
    private javax.swing.JButton addSup;
    private javax.swing.JButton addSup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton printButton;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchField;
    private javax.swing.JLabel starGen1;
    private javax.swing.JLabel starGen2;
    private javax.swing.JLabel starGen3;
    private javax.swing.JLabel starGen4;
    private javax.swing.JLabel starGen5;
    private javax.swing.JLabel starGen6;
    private javax.swing.JTextArea sup_add;
    private javax.swing.JTextField sup_brno;
    private org.jdesktop.swingx.JXDatePicker sup_etd;
    private javax.swing.JTextField sup_id;
    private javax.swing.JTextField sup_mail;
    private javax.swing.JTextField sup_name;
    private javax.swing.JComboBox<String> sup_nature;
    private org.jdesktop.swingx.JXDatePicker sup_std;
    private javax.swing.JTable sup_table;
    private javax.swing.JComboBox<String> sup_type;
    private javax.swing.JLabel title;
    private javax.swing.JPanel userleft;
    // End of variables declaration//GEN-END:variables

    private int formValidate() {
        if (strValidate(sup_name) == -1) {
            message("Name Field Empty !");
            starGenerator(true, starGen1);
            return -1;
        } else {
            starGenerator(false, starGen1);
        }

        String supName = sup_name.getText();

        if (!supName.matches("[a-zA-Z][a-zA-Z ]*")) {
            message("Name Field Contains Numbers");
            starGenerator(true, starGen1);
            return -1;
        } else {
            starGenerator(false, starGen1);
        }

        if (sup_add.getText().equals("") || sup_add.getText().equals(null) || sup_add.getText().isEmpty() == true) {
            message("Address Field Empty !");
            starGenerator(true, starGen2);
            return -1;
        } else {
            starGenerator(false, starGen2);
        }

        if (strValidate(sup_mail) == -1) {
            message("Email Field Empty !");
            starGenerator(true, starGen2);
            return -1;
        } else {
            starGenerator(false, starGen2);
        }

        String supMail = sup_mail.getText();

        if (!supMail.matches("^[A-Za-z0-9_.]+[@][A-Za-z.]+[.]+[a-z]+$")) {
            message("Email is Invalid");
            starGenerator(true, starGen3);
            return -1;
        } else {
            starGenerator(false, starGen3);
        }

        if (sup_std.getDate() == null) {
            message("Please Choose Start Date !");
            starGenerator(true, starGen5);
            return -1;
        } else {
            starGenerator(false, starGen5);
        }

        if (sup_etd.getDate() == null) {
            message("Please Choose End Date !");
            starGenerator(true, starGen6);
            return -1;
        } else {
            starGenerator(false, starGen6);
        }

        if (0 < (sup_std.getDate().compareTo(sup_etd.getDate()))) {
            message("Please Started Date is after End Date !");
            starGenerator(true, starGen5);
            starGenerator(true, starGen6);
            return -1;
        } else {
            starGenerator(false, starGen5);
            starGenerator(false, starGen6);
        }

        if (strValidate(sup_brno) == -1) {
            message("Bussiness Reg No Field Empty !");
            starGenerator(true, starGen4);
            return -1;
        } else {
            starGenerator(false, starGen4);
        }

        return 0;
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

    private ArrayList<supplierEntity> getSuppliersList() {

        supplierEntity sup;
        ArrayList<supplierEntity> supplierList = new ArrayList<supplierEntity>();
        Connector c1 = new Connector();
        ResultSet rs = c1.getResultSet();
        Statement st1 = c1.getStatement();
        String sql = "SELECT * from supplier";
        try {
            rs = st1.executeQuery(sql);
            while (rs.next()) {
                sup = new supplierEntity(rs.getInt("SupplierID"), rs.getString("Name"), rs.getString("Address"), rs.getString("Email"), rs.getString("StartDate"), rs.getString("EndDate"), rs.getString("BusinessType"), rs.getString("NatureofBusiness"), rs.getString("BRNo"), String.valueOf(rs.getDate("DateAdded")));
                supplierList.add(sup);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return supplierList;
    }

    private void showSuppliers() {
        ArrayList<supplierEntity> supplierList = this.getSuppliersList();
        DefaultTableModel model = (DefaultTableModel) sup_table.getModel();
        Object[] row = new Object[10];

        for (int i = 0; i < supplierList.size(); ++i) {
            row[0] = supplierList.get(i).getSupplierID();
            row[1] = supplierList.get(i).getName();
            row[2] = supplierList.get(i).getAddress();
            row[3] = supplierList.get(i).getEmail();
            row[4] = supplierList.get(i).getStartDate();
            row[5] = supplierList.get(i).getEndDate();
            row[6] = supplierList.get(i).getBusinessType();
            row[7] = supplierList.get(i).getNatureofBusiness();
            row[8] = supplierList.get(i).getBRNo();
            row[9] = supplierList.get(i).getdateAdded();
            model.addRow(row);
        }
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
        String sql = "SELECT MAX(DateAdded) FROM supplier";
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

    private int getRowCount(Connector connector) {
        int temprowCount = -1;
        ResultSet rs = connector.getResultSet();
        Statement st = connector.getStatement();
        String sql = "SELECT COUNT(*) FROM supplier";
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
