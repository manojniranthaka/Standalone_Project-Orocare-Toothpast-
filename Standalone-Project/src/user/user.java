/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

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


public class user extends javax.swing.JFrame {
    
    private int currentrowCount;

    public user() {
        initComponents();
        userleft.setBackground(new Color(255, 0, 0, 80));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        showUsers();
        syncTable();
    }

    private ArrayList<userInternalEntity> getUsersInternalList() {

        userInternalEntity user;
        ArrayList<userInternalEntity> userIntList = new ArrayList<userInternalEntity>();
        Connector c1 = new Connector();
        ResultSet rs = c1.getResultSet();
        Statement st1 = c1.getStatement();
        String sql = "SELECT * from user";
        try {
            rs = st1.executeQuery(sql);
            while (rs.next()) {
                user = new userInternalEntity(rs.getInt("UserID"), rs.getInt("empID"), rs.getString("Username"), rs.getString("Password"), rs.getInt("EmployeePriviledge"), rs.getInt("CustomerPriviledge"), rs.getInt("SupplierPriviledge"), rs.getInt("ProductPriviledge"), rs.getInt("StockPriviledge"), rs.getInt("OrderPriviledge"), rs.getInt("SalesPriviledge"), rs.getInt("SalaryPriviledge"), rs.getInt("UtilityPriviledge"), rs.getInt("FinancePriviledge"), rs.getInt("UserPriviledge"), rs.getInt("NotificationPriviledge"));
                userIntList.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userIntList;
    }

    private void showUsers() {
        ArrayList<userInternalEntity> userIntList = this.getUsersInternalList();
        DefaultTableModel model = (DefaultTableModel) intUserTable.getModel();
        Object[] row = new Object[16];

        for (int i = 0; i < userIntList.size(); ++i) {
            row[0] = userIntList.get(i).getUserID();
            row[1] = userIntList.get(i).getEmpID();
            row[2] = userIntList.get(i).getUsername();
            row[3] = userIntList.get(i).getEmployeePriviledge();
            row[4] = userIntList.get(i).getCustomerPriviledge();
            row[5] = userIntList.get(i).getSupplierPriviledge();
            row[6] = userIntList.get(i).getProductPriviledge();
            row[7] = userIntList.get(i).getStockPriviledge();
            row[8] = userIntList.get(i).getOrderPriviledge();
            row[9] = userIntList.get(i).getSalesPriviledge();
            row[10] = userIntList.get(i).getSalaryPriviledge();
            row[11] = userIntList.get(i).getUtilityPriviledge();
            row[12] = userIntList.get(i).getFinancePriviledge();
            row[13] = userIntList.get(i).getUserPriviledge();
            row[14] = userIntList.get(i).getNotificationPriviledge();

            model.addRow(row);
        }
    }

    private ArrayList<userInternalEntity> getUserListFiltered() {
        userInternalEntity user;
        ArrayList<userInternalEntity> userList = new ArrayList<userInternalEntity>();
        Connector c1 = new Connector();
        String sql = "SELECT * FROM user WHERE CONCAT(UserID,empID,Username) LIKE '%" + searchField.getText() + "%'";

        try {
            ResultSet rs = c1.myStmt.executeQuery(sql);

            while (rs.next()) {
                user = new userInternalEntity(rs.getInt("UserID"), rs.getInt("empID"), rs.getString("Username"), rs.getString("Password"), rs.getInt("EmployeePriviledge"), rs.getInt("CustomerPriviledge"), rs.getInt("SupplierPriviledge"), rs.getInt("ProductPriviledge"), rs.getInt("StockPriviledge"), rs.getInt("OrderPriviledge"), rs.getInt("SalesPriviledge"), rs.getInt("SalaryPriviledge"), rs.getInt("UtilityPriviledge"), rs.getInt("FinancePriviledge"), rs.getInt("UserPriviledge"), rs.getInt("NotificationPriviledge"));
                userList.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userList;
    }

    private void showUserListFiltered() {
        ArrayList<userInternalEntity> userList = this.getUserListFiltered();
        DefaultTableModel model = (DefaultTableModel) intUserTable.getModel();
        Object[] row = new Object[16];

        for (int i = 0; i < userList.size(); ++i) {
            row[0] = userList.get(i).getUserID();
            row[1] = userList.get(i).getEmpID();
            row[2] = userList.get(i).getUsername();
            row[3] = userList.get(i).getEmployeePriviledge();
            row[4] = userList.get(i).getCustomerPriviledge();
            row[5] = userList.get(i).getSupplierPriviledge();
            row[6] = userList.get(i).getProductPriviledge();
            row[7] = userList.get(i).getStockPriviledge();
            row[8] = userList.get(i).getOrderPriviledge();
            row[9] = userList.get(i).getSalesPriviledge();
            row[10] = userList.get(i).getSalaryPriviledge();
            row[11] = userList.get(i).getUtilityPriviledge();
            row[12] = userList.get(i).getFinancePriviledge();
            row[13] = userList.get(i).getUserPriviledge();
            row[14] = userList.get(i).getNotificationPriviledge();

            model.addRow(row);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        user_uname = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        intUserTable = new javax.swing.JTable();
        searchField = new javax.swing.JTextField();
        NIC1 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        user_id = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        searchButton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        title = new javax.swing.JLabel();
        userleft = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        user_add1 = new javax.swing.JButton();
        printButton = new javax.swing.JButton();
        btn_sales = new javax.swing.JCheckBox();
        btn_sal = new javax.swing.JCheckBox();
        btn_stock = new javax.swing.JCheckBox();
        btn_util = new javax.swing.JCheckBox();
        btn_finance = new javax.swing.JCheckBox();
        btn_order = new javax.swing.JCheckBox();
        btn_notif = new javax.swing.JCheckBox();
        btn_emp = new javax.swing.JCheckBox();
        btn_cus = new javax.swing.JCheckBox();
        btn_user = new javax.swing.JCheckBox();
        btn_supp = new javax.swing.JCheckBox();
        btn_prod = new javax.swing.JCheckBox();
        jLabel22 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        user_uname.setEditable(false);
        user_uname.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.red, 2));
        user_uname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                user_unameActionPerformed(evt);
            }
        });
        getContentPane().add(user_uname, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 300, 160, 30));

        jLabel19.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel19.setForeground(java.awt.Color.white);
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Username");
        getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 270, 160, -1));

        intUserTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(83, 43, 11), 2));
        intUserTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "User ID", "Emp ID", "Username", "Emp", "Cust", "Sup", "Prod", "Stock", "Order", "Sales", "Salary", "Utility", "Finance", "User", "Notify"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        intUserTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                intUserTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(intUserTable);
        if (intUserTable.getColumnModel().getColumnCount() > 0) {
            intUserTable.getColumnModel().getColumn(0).setPreferredWidth(60);
            intUserTable.getColumnModel().getColumn(1).setPreferredWidth(60);
            intUserTable.getColumnModel().getColumn(2).setPreferredWidth(90);
            intUserTable.getColumnModel().getColumn(3).setPreferredWidth(25);
            intUserTable.getColumnModel().getColumn(4).setPreferredWidth(25);
            intUserTable.getColumnModel().getColumn(5).setPreferredWidth(25);
            intUserTable.getColumnModel().getColumn(6).setPreferredWidth(25);
            intUserTable.getColumnModel().getColumn(7).setPreferredWidth(25);
            intUserTable.getColumnModel().getColumn(8).setPreferredWidth(25);
            intUserTable.getColumnModel().getColumn(9).setPreferredWidth(25);
            intUserTable.getColumnModel().getColumn(10).setPreferredWidth(25);
            intUserTable.getColumnModel().getColumn(11).setPreferredWidth(25);
            intUserTable.getColumnModel().getColumn(12).setPreferredWidth(25);
            intUserTable.getColumnModel().getColumn(13).setPreferredWidth(25);
            intUserTable.getColumnModel().getColumn(14).setPreferredWidth(25);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 100, 1030, 130));

        searchField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        searchField.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.red, 2));
        getContentPane().add(searchField, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 60, 140, 30));

        NIC1.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        NIC1.setForeground(java.awt.Color.white);
        NIC1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NIC1.setText("User Priviledges");
        getContentPane().add(NIC1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 390, 290, -1));

        jButton7.setBackground(java.awt.Color.green);
        jButton7.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("External User");
        jButton7.setBorder(new javax.swing.border.LineBorder(java.awt.Color.white, 2, true));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 60, 130, 30));

        jButton8.setBackground(java.awt.Color.red);
        jButton8.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setText("Update");
        jButton8.setBorder(new javax.swing.border.LineBorder(java.awt.Color.white, 2, true));
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 630, 90, 30));

        jButton9.setBackground(java.awt.Color.red);
        jButton9.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jButton9.setForeground(new java.awt.Color(255, 255, 255));
        jButton9.setText("Remove");
        jButton9.setBorder(new javax.swing.border.LineBorder(java.awt.Color.white, 2, true));
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 630, 90, 30));

        user_id.setEditable(false);
        user_id.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.red, 2));
        user_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                user_idActionPerformed(evt);
            }
        });
        getContentPane().add(user_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 300, 160, 30));

        jLabel20.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel20.setForeground(java.awt.Color.white);
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("ID");
        getContentPane().add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 270, 160, -1));

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
        getContentPane().add(searchButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1260, 60, 80, 30));

        jButton1.setBackground(new java.awt.Color(83, 43, 11));
        jButton1.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Search");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(83, 43, 11), 2));
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1260, -210, 80, 30));

        title.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        title.setForeground(new java.awt.Color(255, 255, 255));
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("User Management");
        getContentPane().add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, 1070, 70));

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

        getContentPane().add(userleft, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 720));

        user_add1.setBackground(java.awt.Color.red);
        user_add1.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        user_add1.setForeground(new java.awt.Color(255, 255, 255));
        user_add1.setText("Reset User");
        user_add1.setBorder(new javax.swing.border.LineBorder(java.awt.Color.white, 2, true));
        user_add1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                user_add1ActionPerformed(evt);
            }
        });
        getContentPane().add(user_add1, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 280, 110, 40));

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
        getContentPane().add(printButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 50, 80, 30));

        btn_sales.setBackground(new java.awt.Color(0, 0, 0));
        btn_sales.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        btn_sales.setForeground(java.awt.Color.white);
        btn_sales.setText("Sales");
        btn_sales.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btn_sales.setIconTextGap(142);
        btn_sales.setOpaque(false);
        getContentPane().add(btn_sales, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 500, 210, 30));

        btn_sal.setBackground(new java.awt.Color(0, 0, 0));
        btn_sal.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        btn_sal.setForeground(java.awt.Color.white);
        btn_sal.setText("Salary");
        btn_sal.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btn_sal.setIconTextGap(134);
        btn_sal.setOpaque(false);
        getContentPane().add(btn_sal, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 540, 210, 30));

        btn_stock.setBackground(new java.awt.Color(0, 0, 0));
        btn_stock.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        btn_stock.setForeground(java.awt.Color.white);
        btn_stock.setText("Stock");
        btn_stock.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btn_stock.setIconTextGap(135);
        btn_stock.setOpaque(false);
        btn_stock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_stockActionPerformed(evt);
            }
        });
        getContentPane().add(btn_stock, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 660, 210, 30));

        btn_util.setBackground(new java.awt.Color(0, 0, 0));
        btn_util.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        btn_util.setForeground(java.awt.Color.white);
        btn_util.setText("Utility");
        btn_util.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btn_util.setIconTextGap(133);
        btn_util.setOpaque(false);
        getContentPane().add(btn_util, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 580, 210, 30));

        btn_finance.setBackground(new java.awt.Color(0, 0, 0));
        btn_finance.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        btn_finance.setForeground(java.awt.Color.white);
        btn_finance.setText("Finance");
        btn_finance.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btn_finance.setIconTextGap(121);
        btn_finance.setOpaque(false);
        getContentPane().add(btn_finance, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 620, 220, 30));

        btn_order.setBackground(new java.awt.Color(0, 0, 0));
        btn_order.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        btn_order.setForeground(java.awt.Color.white);
        btn_order.setText("Order");
        btn_order.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btn_order.setIconTextGap(135);
        btn_order.setOpaque(false);
        getContentPane().add(btn_order, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 460, 210, 30));

        btn_notif.setBackground(new java.awt.Color(0, 0, 0));
        btn_notif.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        btn_notif.setForeground(java.awt.Color.white);
        btn_notif.setText("Notification");
        btn_notif.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btn_notif.setIconTextGap(87);
        btn_notif.setOpaque(false);
        getContentPane().add(btn_notif, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 660, 220, 30));

        btn_emp.setBackground(new java.awt.Color(0, 0, 0));
        btn_emp.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        btn_emp.setForeground(java.awt.Color.white);
        btn_emp.setText("Employee");
        btn_emp.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btn_emp.setIconTextGap(100);
        btn_emp.setOpaque(false);
        btn_emp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_empActionPerformed(evt);
            }
        });
        getContentPane().add(btn_emp, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 460, 210, 30));

        btn_cus.setBackground(new java.awt.Color(0, 0, 0));
        btn_cus.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        btn_cus.setForeground(java.awt.Color.white);
        btn_cus.setText("Customer");
        btn_cus.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btn_cus.setIconTextGap(100);
        btn_cus.setOpaque(false);
        btn_cus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cusActionPerformed(evt);
            }
        });
        getContentPane().add(btn_cus, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 500, 210, 30));

        btn_user.setBackground(new java.awt.Color(0, 0, 0));
        btn_user.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        btn_user.setForeground(java.awt.Color.white);
        btn_user.setText("User         ");
        btn_user.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btn_user.setIconTextGap(98);
        btn_user.setOpaque(false);
        btn_user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_userActionPerformed(evt);
            }
        });
        getContentPane().add(btn_user, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 540, 210, 30));

        btn_supp.setBackground(new java.awt.Color(0, 0, 0));
        btn_supp.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        btn_supp.setForeground(java.awt.Color.white);
        btn_supp.setText("Supplier    ");
        btn_supp.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btn_supp.setIconTextGap(92);
        btn_supp.setOpaque(false);
        btn_supp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_suppActionPerformed(evt);
            }
        });
        getContentPane().add(btn_supp, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 580, 210, 30));

        btn_prod.setBackground(new java.awt.Color(0, 0, 0));
        btn_prod.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        btn_prod.setForeground(java.awt.Color.white);
        btn_prod.setText("Product    ");
        btn_prod.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btn_prod.setIconTextGap(94);
        btn_prod.setOpaque(false);
        btn_prod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_prodActionPerformed(evt);
            }
        });
        getContentPane().add(btn_prod, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 620, 210, 30));

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/gray2.png"))); // NOI18N
        jLabel22.setIconTextGap(100);
        getContentPane().add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 1390, -1));

        setSize(new java.awt.Dimension(1382, 759));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void user_unameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_user_unameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_user_unameActionPerformed

    private void user_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_user_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_user_idActionPerformed

    private void intUserTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_intUserTableMouseClicked
        try {
            int i = intUserTable.getSelectedRow();
            TableModel model = intUserTable.getModel();

            user_id.setText(model.getValueAt(i, 0).toString());
            user_uname.setText(model.getValueAt(i, 2).toString());

            int eVal = Integer.parseInt(model.getValueAt(i, 3).toString());
            int cVal = Integer.parseInt(model.getValueAt(i, 4).toString());
            int supVal = Integer.parseInt(model.getValueAt(i, 5).toString());
            int prodVal = Integer.parseInt(model.getValueAt(i, 6).toString());
            int stockVal = Integer.parseInt(model.getValueAt(i, 7).toString());
            int orderVal = Integer.parseInt(model.getValueAt(i, 8).toString());
            int salesVal = Integer.parseInt(model.getValueAt(i, 9).toString());
            int salaryVal = Integer.parseInt(model.getValueAt(i, 10).toString());
            int utilVal = Integer.parseInt(model.getValueAt(i, 11).toString());
            int financeVal = Integer.parseInt(model.getValueAt(i, 12).toString());
            int userVal = Integer.parseInt(model.getValueAt(i, 13).toString());
            int notifyVal = Integer.parseInt(model.getValueAt(i, 14).toString());

            if (eVal == 1) {
                btn_emp.getModel().setSelected(true);
            } else {
                btn_emp.getModel().setSelected(false);
            }
            if (cVal == 1) {
                btn_cus.getModel().setSelected(true);
            } else {
                btn_cus.getModel().setSelected(false);
            }
            if (supVal == 1) {
                btn_supp.getModel().setSelected(true);
            } else {
                btn_supp.getModel().setSelected(false);
            }
            if (prodVal == 1) {
                btn_prod.getModel().setSelected(true);
            } else {
                btn_prod.getModel().setSelected(false);
            }
            if (stockVal == 1) {
                btn_stock.getModel().setSelected(true);
            } else {
                btn_stock.getModel().setSelected(false);
            }
            if (orderVal == 1) {
                btn_order.getModel().setSelected(true);
            } else {
                btn_order.getModel().setSelected(false);
            }
            if (salesVal == 1) {
                btn_sales.getModel().setSelected(true);
            } else {
                btn_sales.getModel().setSelected(false);
            }
            if (salaryVal == 1) {
                btn_sal.getModel().setSelected(true);
            } else {
                btn_sal.getModel().setSelected(false);
            }
            if (utilVal == 1) {
                btn_util.getModel().setSelected(true);
            } else {
                btn_util.getModel().setSelected(false);
            }
            if (financeVal == 1) {
                btn_finance.getModel().setSelected(true);
            } else {
                btn_finance.getModel().setSelected(false);
            }
            if (userVal == 1) {
                btn_user.getModel().setSelected(true);
            } else {
                btn_user.getModel().setSelected(false);
            }
            if (notifyVal == 1) {
                btn_notif.getModel().setSelected(true);
            } else {
                btn_notif.getModel().setSelected(false);
            }
        } catch (Exception e) {
        }


    }//GEN-LAST:event_intUserTableMouseClicked


    private void user_add1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_user_add1ActionPerformed
        String ID = user_id.getText();
        String query = "SELECT EmployeeID, nic from employee e, user u WHERE e.EmployeeID = u.empID AND u.UserID = '" + ID + "'";
        int employeeID = 0;
        String nic = null;

        connection.Connector connector = new Connector();
        Statement statement = connector.getStatement();
        ResultSet resultSet = connector.getResultSet();

        try {
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                employeeID = resultSet.getInt("EmployeeID");
                nic = resultSet.getString("nic");
            }
            String updateQuery = "UPDATE user SET Username ='OC" + employeeID + "', Password = '" + nic + "' WHERE UserID ='" + ID + "'";
            String updateQuery2 = "UPDATE employee SET logCount = '0' WHERE EmployeeID = '" + employeeID + "'";

            int i = statement.executeUpdate(updateQuery);
            int j = statement.executeUpdate(updateQuery2);

            if ((i > 0) || (j > 0)) {
                JOptionPane.showMessageDialog(null, "Reset Successful", "Login", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Error", "Login Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }//GEN-LAST:event_user_add1ActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        DefaultTableModel model = (DefaultTableModel) intUserTable.getModel();
        model.setRowCount(0);
        this.showUserListFiltered();
    }//GEN-LAST:event_searchButtonActionPerformed

    private void printButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printButtonActionPerformed
        new printer("User", searchField.getText(), intUserTable).print();
    }//GEN-LAST:event_printButtonActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed

        if (validateForm() != -1) {
            boolean empValue = btn_emp.isSelected();
            boolean custValue = btn_cus.isSelected();
            boolean supplyValue = btn_supp.isSelected();
            boolean prodValue = btn_prod.isSelected();
            boolean stockValue = btn_stock.isSelected();
            boolean orderValue = btn_order.isSelected();
            boolean salesValue = btn_sales.isSelected();
            boolean salaryValue = btn_sal.isSelected();
            boolean utilValue = btn_util.isSelected();
            boolean financeValue = btn_finance.isSelected();
            boolean userValue = btn_user.isSelected();
            boolean notifyValue = btn_notif.isSelected();

            int eVal;
            int cVal;
            int supVal;
            int prodVal;
            int stockVal;
            int orderVal;
            int salesVal;
            int salaryVal;
            int utilVal;
            int financeVal;
            int userVal;
            int notifyVal;

            if (empValue == true) {
                eVal = 1;
            } else {
                eVal = 0;
            }
            if (custValue == true) {
                cVal = 1;
            } else {
                cVal = 0;
            }
            if (supplyValue == true) {
                supVal = 1;
            } else {
                supVal = 0;
            }
            if (prodValue == true) {
                prodVal = 1;
            } else {
                prodVal = 0;
            }
            if (stockValue == true) {
                stockVal = 1;
            } else {
                stockVal = 0;
            }
            if (orderValue == true) {
                orderVal = 1;
            } else {
                orderVal = 0;
            }
            if (salesValue == true) {
                salesVal = 1;
            } else {
                salesVal = 0;
            }
            if (salaryValue == true) {
                salaryVal = 1;
            } else {
                salaryVal = 0;
            }
            if (utilValue == true) {
                utilVal = 1;
            } else {
                utilVal = 0;
            }
            if (financeValue == true) {
                financeVal = 1;
            } else {
                financeVal = 0;
            }
            if (userValue == true) {
                userVal = 1;
            } else {
                userVal = 0;
            }
            if (notifyValue == true) {
                notifyVal = 1;
            } else {
                notifyVal = 0;
            }

            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/orocare", "root", "");

                PreparedStatement stmt = myConn.prepareStatement("UPDATE user SET EmployeePriviledge = ?, CustomerPriviledge = ? , SupplierPriviledge = ?, ProductPriviledge = ?, StockPriviledge = ?, OrderPriviledge = ?, SalesPriviledge = ?, SalaryPriviledge = ?, UtilityPriviledge = ?, FinancePriviledge = ?, UserPriviledge = ?, NotificationPriviledge = ? WHERE UserID = ?");
                stmt.setInt(1, eVal);
                stmt.setInt(2, cVal);
                stmt.setInt(3, supVal);
                stmt.setInt(4, prodVal);
                stmt.setInt(5, stockVal);
                stmt.setInt(6, orderVal);
                stmt.setInt(7, salesVal);
                stmt.setInt(8, salaryVal);
                stmt.setInt(9, utilVal);
                stmt.setInt(10, financeVal);
                stmt.setInt(11, userVal);
                stmt.setInt(12, notifyVal);
                stmt.setInt(13, Integer.parseInt(user_id.getText()));
                int i = stmt.executeUpdate();
                refreshtable();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private int validateForm() {
        if (user_id.getText().equals(null) || user_id.getText().equals("") || user_id.getText().isEmpty() == true) {
            JOptionPane.showMessageDialog(null, "Please Select a User !", "Error", JOptionPane.ERROR_MESSAGE);
            return -1;
        } else {
            return 0;
        }
    }


    private void btn_stockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_stockActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_stockActionPerformed

    private void btn_empActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_empActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_empActionPerformed

    private void btn_cusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_cusActionPerformed

    private void btn_userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_userActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_userActionPerformed

    private void btn_suppActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suppActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_suppActionPerformed

    private void btn_prodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_prodActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_prodActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        new userExternal().setVisible(true);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed

        if (!(user_id.getText().equals("") || user_id.getText().isEmpty() == true)) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/orocare", "root", "");

                PreparedStatement stmt = myConn.prepareStatement("UPDATE user SET Password = '' WHERE user.UserID = ? ");
                stmt.setInt(1, Integer.parseInt(user_id.getText()));
                int i = stmt.executeUpdate();

                int EMPID = 0;
                Connector cont = new Connector();
                Statement st1 = cont.getStatement();
                ResultSet resultSet = cont.getResultSet();
                String sqlQueryUser = "SELECT * from user WHERE UserID = '" + user_id.getText() + "'";
                resultSet = st1.executeQuery(sqlQueryUser);
                while (resultSet.next()) {
                    EMPID = resultSet.getInt("empID");
                }

                stmt = myConn.prepareStatement("UPDATE employee SET Status = 'Inactive' WHERE EmployeeID = ? ");
                stmt.setInt(1, EMPID);
                int j = stmt.executeUpdate();

                JOptionPane.showMessageDialog(null, "User Removed Succesfully!", "Error", JOptionPane.INFORMATION_MESSAGE);

                refreshtable();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please Select a User !", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    public void refreshtable() {
        DefaultTableModel model = (DefaultTableModel) intUserTable.getModel();
        model.setRowCount(0);
        showUsers();
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
            java.util.logging.Logger.getLogger(user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new user().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel NIC1;
    private javax.swing.JCheckBox btn_cus;
    private javax.swing.JCheckBox btn_emp;
    private javax.swing.JCheckBox btn_finance;
    private javax.swing.JCheckBox btn_notif;
    private javax.swing.JCheckBox btn_order;
    private javax.swing.JCheckBox btn_prod;
    private javax.swing.JCheckBox btn_sal;
    private javax.swing.JCheckBox btn_sales;
    private javax.swing.JCheckBox btn_stock;
    private javax.swing.JCheckBox btn_supp;
    private javax.swing.JCheckBox btn_user;
    private javax.swing.JCheckBox btn_util;
    private javax.swing.JTable intUserTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton printButton;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchField;
    private javax.swing.JLabel title;
    private javax.swing.JButton user_add1;
    private javax.swing.JTextField user_id;
    private javax.swing.JTextField user_uname;
    private javax.swing.JPanel userleft;
    // End of variables declaration//GEN-END:variables
    private void syncTable() {
        Connector connector = new Connector();
        currentrowCount = getRowCount(connector);

        Timer t = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int tempRowCount = getRowCount(connector);
                if (currentrowCount != tempRowCount) {
                    refreshtable();
                    currentrowCount = tempRowCount;
                }
            }
        });
        t.start();
    }


    private int getRowCount(Connector connector) {
        int temprowCount = -1;
        ResultSet rs = connector.getResultSet();
        Statement st = connector.getStatement();
        String sql = "SELECT COUNT(*) FROM user";
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
