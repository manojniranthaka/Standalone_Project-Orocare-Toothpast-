package customer;

import connection.Connector;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import digitalClock.digitalClock;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.util.Date;
import javax.swing.Timer;
import org.joda.time.DateTime;
import printer.printer;

public class customer extends javax.swing.JFrame {

    private int currentrowCount;
    private Date currentMaxDate;

    public customer() {
        initComponents();
        userleft.setBackground(new Color(255, 255, 0, 80));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        showCustomers();
        initializeLabels();
        syncTable();
    }

    private void initializeLabels() {
        cus_id.setVisible(false);
        starGen1.setVisible(false);
        starGen2.setVisible(false);
        starGen3.setVisible(false);
        starGen4.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        title = new javax.swing.JLabel();
        cus_id = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        customerTable = new javax.swing.JTable();
        searchField = new javax.swing.JTextField();
        printButton = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        cus_addr = new javax.swing.JTextArea();
        Type = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        cus_email = new javax.swing.JTextField();
        cus_type = new javax.swing.JComboBox<>();
        addCus = new javax.swing.JButton();
        editCus = new javax.swing.JButton();
        removeCus = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        userleft = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        cus_name1 = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        cus_phone = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        starGen1 = new javax.swing.JLabel();
        starGen2 = new javax.swing.JLabel();
        starGen3 = new javax.swing.JLabel();
        starGen4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        title.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        title.setForeground(new java.awt.Color(255, 255, 255));
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("Customer Management");
        getContentPane().add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, 1070, 70));

        cus_id.setEditable(false);
        cus_id.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(106, 106, 0), 2));
        getContentPane().add(cus_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 170, 160, 30));

        customerTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(83, 43, 11), 2));
        customerTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Customer ID", "Name", "Address", "Email", "Type", "Phone", "Date Added"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        customerTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                customerTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(customerTable);
        if (customerTable.getColumnModel().getColumnCount() > 0) {
            customerTable.getColumnModel().getColumn(0).setResizable(false);
            customerTable.getColumnModel().getColumn(1).setResizable(false);
            customerTable.getColumnModel().getColumn(2).setResizable(false);
            customerTable.getColumnModel().getColumn(3).setResizable(false);
            customerTable.getColumnModel().getColumn(4).setResizable(false);
            customerTable.getColumnModel().getColumn(5).setResizable(false);
            customerTable.getColumnModel().getColumn(6).setResizable(false);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 120, 550, 480));

        searchField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        searchField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(83, 43, 11), 2));
        getContentPane().add(searchField, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 60, 140, 30));

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
        getContentPane().add(printButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 60, 80, 30));

        jLabel10.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel10.setForeground(java.awt.Color.white);
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Address");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 320, 260, -1));

        jScrollPane2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(83, 43, 11)));

        cus_addr.setColumns(20);
        cus_addr.setRows(5);
        cus_addr.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(106, 106, 0), 2));
        jScrollPane2.setViewportView(cus_addr);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 340, 260, 100));

        Type.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        Type.setForeground(java.awt.Color.white);
        Type.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Type.setText("Type");
        getContentPane().add(Type, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 470, 160, -1));

        jLabel12.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel12.setForeground(java.awt.Color.white);
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Email");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 240, 160, -1));

        cus_email.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(106, 106, 0), 2));
        cus_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cus_emailActionPerformed(evt);
            }
        });
        getContentPane().add(cus_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 260, 160, 30));

        cus_type.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "One Time", "Long Term" }));
        cus_type.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(106, 106, 0), 2));
        cus_type.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cus_typeActionPerformed(evt);
            }
        });
        getContentPane().add(cus_type, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 500, 160, 30));

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
        getContentPane().add(addCus, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 630, 90, 30));

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
        getContentPane().add(editCus, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 630, 90, 30));

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
        getContentPane().add(removeCus, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 630, 90, 30));

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
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 630, 90, 30));

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
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cus2.png"))); // NOI18N
        userleft.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 300, 110));

        getContentPane().add(userleft, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 720));

        jLabel11.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel11.setForeground(java.awt.Color.white);
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Name");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 240, 160, -1));

        cus_name1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(106, 106, 0), 2));
        getContentPane().add(cus_name1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 260, 160, 30));

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
        getContentPane().add(searchButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1260, 60, 80, 30));
        getContentPane().add(cus_phone, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 500, 190, 30));

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel4.setForeground(java.awt.Color.white);
        jLabel4.setText("Phone");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 470, -1, -1));

        starGen1.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        starGen1.setForeground(java.awt.Color.red);
        starGen1.setText("*");
        getContentPane().add(starGen1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 250, -1, -1));

        starGen2.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        starGen2.setForeground(java.awt.Color.red);
        starGen2.setText("*");
        getContentPane().add(starGen2, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 250, -1, -1));

        starGen3.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        starGen3.setForeground(java.awt.Color.red);
        starGen3.setText("*");
        getContentPane().add(starGen3, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 330, -1, -1));

        starGen4.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        starGen4.setForeground(java.awt.Color.red);
        starGen4.setText("*");
        getContentPane().add(starGen4, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 490, -1, -1));

        jButton1.setText("DEMO");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 120, 100, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/gray2.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-1, 0, 1390, -1));

        setSize(new java.awt.Dimension(1382, 759));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed

        cus_id.setText("");
        cus_addr.setText("");
        cus_email.setText("");
        cus_name1.setText("");
        cus_phone.setText("");
        cus_type.setSelectedIndex(0);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void cus_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cus_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cus_emailActionPerformed

    private void cus_typeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cus_typeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cus_typeActionPerformed

    private void addCusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCusActionPerformed
        if (validateForm() != -1) {
            String Name = cus_name1.getText().toString();
            String Address = cus_addr.getText().toString();
            String Email = cus_email.getText().toString();
            String Type = cus_type.getSelectedItem().toString();
            String Phone = cus_phone.getText().toString();

            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/orocare", "root", "");

                PreparedStatement stmt = myConn.prepareStatement("INSERT INTO CUSTOMER(Name, Address, Email, Type,Phone, DateAdded) VALUES (?,?,?,?,?,NOW())");
                stmt.setString(1, Name);
                stmt.setString(2, Address);
                stmt.setString(3, Email);
                stmt.setString(4, Type);
                stmt.setString(5, Phone);
                int i = stmt.executeUpdate();
                refreshtable();
            } catch (Exception e) {
                printStackTrace(e);
            }
        }
    }//GEN-LAST:event_addCusActionPerformed

    private void refreshtable() {
        DefaultTableModel model = (DefaultTableModel) customerTable.getModel();
        model.setRowCount(0);
        showCustomers();
    }

    private void customerTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_customerTableMouseClicked
        try {
            int i = customerTable.getSelectedRow();
            TableModel model = customerTable.getModel();

            cus_id.setText(model.getValueAt(i, 0).toString());
            cus_name1.setText(model.getValueAt(i, 1).toString());
            cus_addr.setText(model.getValueAt(i, 2).toString());
            cus_email.setText(model.getValueAt(i, 3).toString());
            cus_phone.setText(model.getValueAt(i, 5).toString());
        } catch (Exception e) {
        }
    }//GEN-LAST:event_customerTableMouseClicked

    private void editCusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editCusActionPerformed

        if (!(cus_id.getText().equals("") || cus_id.getText().isEmpty() == true)) {
            if (validateForm() != -1) {
                int ID = Integer.parseInt(cus_id.getText().toString());
                String Name = cus_name1.getText().toString();
                String Address = cus_addr.getText().toString();
                String Email = cus_email.getText().toString();
                String Type = cus_type.getSelectedItem().toString();
                String Phone = cus_phone.getText().toString();

                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/orocare", "root", "");

                    PreparedStatement stmt = myConn.prepareStatement("UPDATE customer SET Name = ?, Address = ?, Email = ?, Type = ?, Phone = ?, DateAdded = NOW() WHERE CustomerID = ?");
                    stmt.setString(1, Name);
                    stmt.setString(2, Address);
                    stmt.setString(3, Email);
                    stmt.setString(4, Type);
                    stmt.setString(5, Phone);
                    stmt.setInt(6, ID);
                    int i = stmt.executeUpdate();
                    refreshtable();
                } catch (Exception e) {
                    printStackTrace(e);
                }
            }
        } else {
            message("Please Select a Customer !");
        }
    }//GEN-LAST:event_editCusActionPerformed

    private void removeCusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeCusActionPerformed
        if (!(cus_id.getText().equals("") || cus_id.getText().isEmpty() == true)) {
            int ID = Integer.parseInt(cus_id.getText().toString());
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/orocare", "root", "");

                PreparedStatement stmt = myConn.prepareStatement("DELETE FROM customer WHERE CustomerID = ?");
                stmt.setInt(1, ID);
                int i = stmt.executeUpdate();
                refreshtable();
            } catch (Exception e) {
                printStackTrace(e);
            }
        } else {
            message("Please Select a Customer !");
        }
    }//GEN-LAST:event_removeCusActionPerformed

    private void printButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printButtonActionPerformed
        new printer("Customer", searchField.getText(), customerTable).print();
    }//GEN-LAST:event_printButtonActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        DefaultTableModel model = (DefaultTableModel) customerTable.getModel();
        model.setRowCount(0);
        this.showCustomerListFiltered();
    }//GEN-LAST:event_searchButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        cus_name1.setText("Alex Davis");
        cus_email.setText("alexdavis@gmail.com");
        cus_addr.setText("Colombo");
        cus_phone.setText("0774587458");
        cus_type.setSelectedIndex(1);
    }//GEN-LAST:event_jButton1ActionPerformed

    private ArrayList<customerEntity> getCustomersList() {

        customerEntity cus;
        ArrayList<customerEntity> customerList = new ArrayList<customerEntity>();
        Connector c1 = new Connector();
        ResultSet rs = c1.getResultSet();
        Statement st1 = c1.getStatement();
        String sql = "SELECT * from customer";
        try {
            rs = st1.executeQuery(sql);
            while (rs.next()) {
                cus = new customerEntity(rs.getInt("CustomerID"), rs.getString("Name"), rs.getString("Address"), rs.getString("Email"), rs.getString("Type"), rs.getString("Phone"), String.valueOf(rs.getDate("DateAdded")));
                customerList.add(cus);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return customerList;
    }

    private void showCustomers() {
        ArrayList<customerEntity> customerslist = this.getCustomersList();
        DefaultTableModel model = (DefaultTableModel) customerTable.getModel();
        Object[] row = new Object[7];

        for (int i = 0; i < customerslist.size(); ++i) {
            row[0] = customerslist.get(i).getCustomerID();
            row[1] = customerslist.get(i).getName();
            row[2] = customerslist.get(i).getAddress();
            row[3] = customerslist.get(i).getEmail();
            row[4] = customerslist.get(i).getType();
            row[5] = customerslist.get(i).getPhone();
            row[6] = customerslist.get(i).getDateAdded();
            model.addRow(row);
        }
    }

    private ArrayList<customerEntity> getCustomerListFiltered() {
        customerEntity customer;
        ArrayList<customerEntity> customerList = new ArrayList<customerEntity>();
        Connector c1 = new Connector();
        String sql = "SELECT * FROM customer WHERE CONCAT(CustomerID,Name,Address,Email,Phone) LIKE '%" + searchField.getText() + "%'";
        //String sql = "SELECT * FROM customer WHERE CustomerID LIKE '%" +searchField.getText() + "%' OR Name LIKE '%" + searchField.getText() + "%'";
        try {
            ResultSet rs = c1.myStmt.executeQuery(sql);

            while (rs.next()) {
                customer = new customerEntity(rs.getInt("CustomerID"), rs.getString("Name"), rs.getString("Address"), rs.getString("Email"), rs.getString("Type"), rs.getString("Phone"), String.valueOf(rs.getDate("DateAdded")));
                customerList.add(customer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return customerList;
    }

    private void showCustomerListFiltered() {
        ArrayList<customerEntity> customerslist = this.getCustomerListFiltered();
        DefaultTableModel model = (DefaultTableModel) customerTable.getModel();
        Object[] row = new Object[7];

        for (int i = 0; i < customerslist.size(); ++i) {
            row[0] = customerslist.get(i).getCustomerID();
            row[1] = customerslist.get(i).getName();
            row[2] = customerslist.get(i).getAddress();
            row[3] = customerslist.get(i).getEmail();
            row[4] = customerslist.get(i).getType();
            row[5] = customerslist.get(i).getPhone();
            row[6] = customerslist.get(i).getDateAdded();
            model.addRow(row);
        }
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
            java.util.logging.Logger.getLogger(customer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(customer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(customer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(customer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new customer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Type;
    private javax.swing.JButton addCus;
    private javax.swing.JTextArea cus_addr;
    private javax.swing.JTextField cus_email;
    private javax.swing.JTextField cus_id;
    private javax.swing.JTextField cus_name1;
    private javax.swing.JTextField cus_phone;
    private javax.swing.JComboBox<String> cus_type;
    private javax.swing.JTable customerTable;
    private javax.swing.JButton editCus;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton printButton;
    private javax.swing.JButton removeCus;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchField;
    private javax.swing.JLabel starGen1;
    private javax.swing.JLabel starGen2;
    private javax.swing.JLabel starGen3;
    private javax.swing.JLabel starGen4;
    private javax.swing.JLabel title;
    private javax.swing.JPanel userleft;
    // End of variables declaration//GEN-END:variables

    private void printStackTrace(Exception e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        if (strValidate(cus_name1) == -1) {
            message("Customer Name Field Empty !");
            starGenerator(true, starGen1);
            return -1;
        } else {
            starGenerator(false, starGen1);
        }

        String cusname = cus_name1.getText();

        if (!cusname.matches("[a-zA-Z][a-zA-Z ]*")) {
            message("Customer Name Field Contains Numbers");
            starGenerator(true, starGen1);
            return -1;
        } else {
            starGenerator(false, starGen1);
        }

        if (strValidate(cus_email) == -1) {
            message("Email Field Empty !");
            starGenerator(true, starGen2);
            return -1;
        } else {
            starGenerator(false, starGen2);
        }

        String cusEmail = cus_email.getText();

        if (!cusEmail.matches("^[A-Za-z0-9_.]+[@][A-Za-z.]+[.]+[a-z]+$")) {
            message("Customer Email is Invalid");
            starGenerator(true, starGen2);
            return -1;
        } else {
            starGenerator(false, starGen2);
        }

        if (cus_addr.getText().equals("") || cus_addr.getText().equals(null) || cus_addr.getText().isEmpty() == true) {
            message("Address Field Empty !");
            starGenerator(true, starGen3);
            return -1;
        } else {
            starGenerator(false, starGen3);
        }

        if (strValidate(cus_phone) == -1) {
            message("Phone Field Empty !");
            starGenerator(true, starGen4);
            return -1;
        } else {
            starGenerator(false, starGen4);
        }

        String number = cus_phone.getText();

        if (!number.matches("[0-9]+(\\.){0,1}[0-9]+")) {
            message("Phone Contains Letters !");
            starGenerator(true, starGen4);
            return -1;
        } else {
            starGenerator(false, starGen4);
        }

        if (number.length() != 10) {
            message("Invalid Phone Number !");
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
        Timestamp timestamp = null;
        ResultSet rs = connector.getResultSet();
        Statement st = connector.getStatement();
        String sql = "SELECT MAX(DateAdded) FROM customer";
        try {
            rs = st.executeQuery(sql);
            while (rs.next()) {
                //date = rs.getTime("MAX(DateAdded)");
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
        String sql = "SELECT COUNT(*) FROM customer";
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
