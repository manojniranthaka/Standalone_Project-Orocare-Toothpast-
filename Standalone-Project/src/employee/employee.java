/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employee;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
import java.awt.Color;
import java.awt.Font;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.ButtonGroup;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import org.jdesktop.swingx.JXDatePicker;
import connection.ConnectorNew;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import connection.Connector;
import java.sql.Connection;
import java.text.ParseException;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Sahan Jayawardena
 */
public class employee extends javax.swing.JFrame {

    String fname, mname, lname, gender, email, address, dob, mobile, position, nic, uname, pw, status, strtDte;
    int cust, emp, supp, prod, stock, ord, sale, sal, util, fin, user, notif;
    //int emp1, cust1, supp1, prod1, stock1, ord1, sale1, sal1, util1, fin1, user1, notif1;
    int sum = 0;
    int ID, recID, logCount;
    String cnfrmUn, cnfrmNIC, srch, empID;

    //del table
    String fname1, lname1, gender1, position1, nic1, strtDte1;
    int ID1, rec1, tempID;

    Connection conn = new ConnectorNew().ConnectorNew();
    String query;
    Statement stmt;
    ResultSet rs;

    public employee() {

        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        userleft.setBackground(new Color(255, 140, 0, 80));
        ButtonGroup gender = new ButtonGroup();
        gender.add(male_radio);
        gender.add(female_radio);
        male_radio.setSelected(true);
        tableEmp.setAutoCreateColumnsFromModel(true);
        emp_ID.setVisible(false);
        emp_status.setVisible(false);

        resetDate(emp_dob);
        setStars();

        showTable();
        showDelTable();

    }

    public employee(int ID, String fname, String mname, String lname, int logCount, String mobile, String address, String nic, String status, String gender, String dob, String position, String strtDte, String email) {

        this.ID = ID;
        this.fname = fname;
        this.lname = lname;
        this.logCount = logCount;
        this.mname = mname;
        this.gender = gender;
        this.email = email;
        this.strtDte = strtDte;
        this.address = address;
        this.dob = dob;
        this.mobile = mobile;
        this.position = position;
        this.nic = nic;
        this.status = status;

        /*if(emp == true){this.emp = 1;} else {this.emp = 0;}
        if(cust == true){this.cust = 1;} else {this.cust = 0;}
        if(supp == true){this.supp = 1;} else {this.supp = 0;}
        if(prod == true){this.prod = 1;} else {this.prod = 0;}
        if(stock == true){this.emp = 1;} else {this.emp = 0;}
        if(ord == true){this.ord = 1;} else {this.ord = 0;}
        if(sale == true){this.sale = 1;} else {this.sale = 0;}
        if(sal == true){this.sal = 1;} else {this.sal = 0;}
        if(util == true){this.util = 1;} else {this.util = 0;}
        if(fin == true){this.fin = 1;} else {this.fin = 0;}
        if(user == true){this.user = 1;} else {this.user = 0;}
        if(notif == true){this.notif = 1;} else {this.notif = 0;}*/
    }

    //Del Table initialize
    public employee(int recID, int ID, String fname, String lname, String gender, String position, String NIC, String strtDate) {

        this.recID = recID;
        this.ID1 = ID;
        this.fname1 = fname;
        this.lname1 = lname;
        this.gender1 = gender;
        this.position1 = position;
        this.nic1 = NIC;
        this.strtDte1 = strtDate;

        /*if(emp == true){this.emp = 1;} else {this.emp = 0;}
        if(cust == true){this.cust = 1;} else {this.cust = 0;}
        if(supp == true){this.supp = 1;} else {this.supp = 0;}
        if(prod == true){this.prod = 1;} else {this.prod = 0;}
        if(stock == true){this.emp = 1;} else {this.emp = 0;}
        if(ord == true){this.ord = 1;} else {this.ord = 0;}
        if(sale == true){this.sale = 1;} else {this.sale = 0;}
        if(sal == true){this.sal = 1;} else {this.sal = 0;}
        if(util == true){this.util = 1;} else {this.util = 0;}
        if(fin == true){this.fin = 1;} else {this.fin = 0;}
        if(user == true){this.user = 1;} else {this.user = 0;}
        if(notif == true){this.notif = 1;} else {this.notif = 0;}*/
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton4 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        emp_lname = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        emp_addr = new javax.swing.JTextArea();
        emp_ID = new javax.swing.JTextField();
        emp_email = new javax.swing.JTextField();
        female_radio = new javax.swing.JRadioButton();
        male_radio = new javax.swing.JRadioButton();
        emp_mname = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btn_update = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        emp_srch = new javax.swing.JTextField();
        btn_all = new javax.swing.JButton();
        emp_mobile = new javax.swing.JTextField();
        emp_position = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        emp_dob = new org.jdesktop.swingx.JXDatePicker();
        emp_nic = new javax.swing.JTextField();
        NIC1 = new javax.swing.JLabel();
        btn_cus = new javax.swing.JToggleButton();
        btn_emp = new javax.swing.JToggleButton();
        btn_supp = new javax.swing.JToggleButton();
        btn_prod = new javax.swing.JToggleButton();
        btn_stock = new javax.swing.JToggleButton();
        btn_order = new javax.swing.JToggleButton();
        btn_sales = new javax.swing.JToggleButton();
        btn_sal = new javax.swing.JToggleButton();
        btn_util = new javax.swing.JToggleButton();
        btn_finance = new javax.swing.JToggleButton();
        btn_user = new javax.swing.JToggleButton();
        btn_notif = new javax.swing.JToggleButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableEmp = new javax.swing.JTable();
        starUserPriv = new javax.swing.JLabel();
        starLname = new javax.swing.JLabel();
        starMname = new javax.swing.JLabel();
        starFname = new javax.swing.JLabel();
        starPos = new javax.swing.JLabel();
        starAddress = new javax.swing.JLabel();
        starNIC = new javax.swing.JLabel();
        starMail = new javax.swing.JLabel();
        starPass = new javax.swing.JLabel();
        emp_fname = new javax.swing.JTextField();
        emp_status = new javax.swing.JTextField();
        NIC = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        title = new javax.swing.JLabel();
        starGen = new javax.swing.JLabel();
        btn_srch = new javax.swing.JButton();
        starMob = new javax.swing.JLabel();
        empScroll = new javax.swing.JScrollPane();
        empFired = new javax.swing.JTable();
        jButton7 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableFired = new javax.swing.JTable();
        userleft = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        title1 = new javax.swing.JLabel();
        privHide = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton4.setBackground(new java.awt.Color(83, 43, 11));
        jButton4.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Add");
        jButton4.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.white, 2));
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 630, 90, 30));

        jLabel6.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel6.setForeground(java.awt.Color.white);
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Last Name");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 130, 160, -1));

        emp_lname.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(83, 43, 11), 2));
        getContentPane().add(emp_lname, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 150, 160, 30));

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel2.setForeground(java.awt.Color.white);
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("First Name");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 130, 160, -1));

        jLabel7.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel7.setForeground(java.awt.Color.white);
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Email");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 430, 160, -1));

        jScrollPane2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(83, 43, 11)));

        emp_addr.setColumns(20);
        emp_addr.setRows(5);
        emp_addr.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(83, 43, 11), 2));
        jScrollPane2.setViewportView(emp_addr);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 220, 360, 100));

        emp_ID.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(83, 43, 11), 2));
        emp_ID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emp_IDActionPerformed(evt);
            }
        });
        getContentPane().add(emp_ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 70, 160, 30));

        emp_email.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(83, 43, 11), 2));
        getContentPane().add(emp_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 450, 160, 30));

        female_radio.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        female_radio.setForeground(java.awt.Color.white);
        female_radio.setText("Female");
        female_radio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                female_radioActionPerformed(evt);
            }
        });
        getContentPane().add(female_radio, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 260, -1, -1));

        male_radio.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        male_radio.setForeground(java.awt.Color.white);
        male_radio.setText("Male");
        getContentPane().add(male_radio, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 260, -1, -1));

        emp_mname.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(83, 43, 11), 2));
        getContentPane().add(emp_mname, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 150, 160, 30));

        jLabel10.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel10.setForeground(java.awt.Color.white);
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Address");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 200, 360, -1));

        jLabel9.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel9.setForeground(java.awt.Color.white);
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Middle Name");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 130, 160, -1));

        jLabel11.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel11.setForeground(java.awt.Color.white);
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Gender");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 200, 160, -1));

        btn_update.setBackground(new java.awt.Color(83, 43, 11));
        btn_update.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btn_update.setForeground(new java.awt.Color(255, 255, 255));
        btn_update.setText("Update");
        btn_update.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.white, 2));
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });
        getContentPane().add(btn_update, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 630, 90, 30));

        jButton5.setBackground(new java.awt.Color(83, 43, 11));
        jButton5.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Remove");
        jButton5.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.white, 2));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 630, 90, 30));

        jButton6.setBackground(new java.awt.Color(83, 43, 11));
        jButton6.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Clear");
        jButton6.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.white, 2));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 630, 90, 30));

        emp_srch.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        emp_srch.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(83, 43, 11), 2));
        getContentPane().add(emp_srch, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 70, 140, 30));

        btn_all.setBackground(new java.awt.Color(83, 43, 11));
        btn_all.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btn_all.setForeground(new java.awt.Color(255, 255, 255));
        btn_all.setText("Show All");
        btn_all.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.white, 2));
        btn_all.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_allActionPerformed(evt);
            }
        });
        getContentPane().add(btn_all, new org.netbeans.lib.awtextra.AbsoluteConstraints(1260, 70, 80, 30));

        emp_mobile.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(83, 43, 11), 2));
        emp_mobile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emp_mobileActionPerformed(evt);
            }
        });
        getContentPane().add(emp_mobile, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 370, 160, 30));

        emp_position.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(83, 41, 11), 2));
        getContentPane().add(emp_position, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 370, 160, 30));

        jLabel15.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel15.setForeground(java.awt.Color.white);
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Date of Birth");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 350, 160, -1));

        emp_dob.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(83, 43, 11), 2));
        emp_dob.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emp_dobActionPerformed(evt);
            }
        });
        getContentPane().add(emp_dob, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 370, 160, -1));

        emp_nic.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(83, 43, 11), 2));
        emp_nic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emp_nicActionPerformed(evt);
            }
        });
        getContentPane().add(emp_nic, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 450, 160, 30));

        NIC1.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        NIC1.setForeground(java.awt.Color.white);
        NIC1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NIC1.setText("User Priviledges");
        getContentPane().add(NIC1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 510, 160, -1));

        btn_cus.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btn_cus.setText("Cust");
        btn_cus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cusActionPerformed(evt);
            }
        });
        getContentPane().add(btn_cus, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 550, 80, 30));

        btn_emp.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btn_emp.setText("Emp");
        btn_emp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_empActionPerformed(evt);
            }
        });
        getContentPane().add(btn_emp, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 550, 80, 30));

        btn_supp.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btn_supp.setText("Supply");
        btn_supp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_suppActionPerformed(evt);
            }
        });
        getContentPane().add(btn_supp, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 550, 80, 30));

        btn_prod.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btn_prod.setText("Prod");
        btn_prod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_prodActionPerformed(evt);
            }
        });
        getContentPane().add(btn_prod, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 550, 80, 30));

        btn_stock.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btn_stock.setText("Stock");
        btn_stock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_stockActionPerformed(evt);
            }
        });
        getContentPane().add(btn_stock, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 550, 80, 30));

        btn_order.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btn_order.setText("Order");
        btn_order.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_orderActionPerformed(evt);
            }
        });
        getContentPane().add(btn_order, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 550, 80, 30));

        btn_sales.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btn_sales.setText("Sales");
        btn_sales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salesActionPerformed(evt);
            }
        });
        getContentPane().add(btn_sales, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 590, 80, 30));

        btn_sal.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btn_sal.setText("Salary");
        btn_sal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salActionPerformed(evt);
            }
        });
        getContentPane().add(btn_sal, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 590, 80, 30));

        btn_util.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btn_util.setText("Utility");
        btn_util.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_utilActionPerformed(evt);
            }
        });
        getContentPane().add(btn_util, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 590, 80, 30));

        btn_finance.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btn_finance.setText("Finance");
        btn_finance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_financeActionPerformed(evt);
            }
        });
        getContentPane().add(btn_finance, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 590, 80, 30));

        btn_user.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btn_user.setText("User");
        btn_user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_userActionPerformed(evt);
            }
        });
        getContentPane().add(btn_user, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 590, 80, 30));

        btn_notif.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btn_notif.setText("Notify");
        btn_notif.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_notifActionPerformed(evt);
            }
        });
        getContentPane().add(btn_notif, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 590, 80, 30));

        tableEmp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "fname", "mname", "lname", "logCnt", "mobile", "address", "nic", "status", "gender", "dob", "position", "uname", "stDate", "mail"
            }
        ));
        tableEmp.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tableEmp.setAutoscrolls(false);
        tableEmp.setEditingColumn(0);
        tableEmp.setEditingRow(0);
        tableEmp.setPreferredSize(new java.awt.Dimension(1366, 1366));
        tableEmp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableEmpMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableEmp);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(922, 120, 420, 280));

        starUserPriv.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        starUserPriv.setForeground(java.awt.Color.red);
        starUserPriv.setText("*");
        getContentPane().add(starUserPriv, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 510, 20, 70));

        starLname.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        starLname.setForeground(java.awt.Color.red);
        starLname.setText("*");
        getContentPane().add(starLname, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 120, 20, 60));

        starMname.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        starMname.setForeground(java.awt.Color.red);
        starMname.setText("*");
        getContentPane().add(starMname, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 120, 20, 60));

        starFname.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        starFname.setForeground(java.awt.Color.red);
        starFname.setText("*");
        getContentPane().add(starFname, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 120, 20, 60));

        starPos.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        starPos.setForeground(java.awt.Color.red);
        starPos.setText("*");
        getContentPane().add(starPos, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 340, 20, 60));

        starAddress.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        starAddress.setForeground(java.awt.Color.red);
        starAddress.setText("*");
        getContentPane().add(starAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 200, 20, 60));

        starNIC.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        starNIC.setForeground(java.awt.Color.red);
        starNIC.setText("*");
        getContentPane().add(starNIC, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 420, 20, 60));

        starMail.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        starMail.setForeground(java.awt.Color.red);
        starMail.setText("*");
        getContentPane().add(starMail, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 420, 20, 60));

        starPass.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        starPass.setForeground(java.awt.Color.red);
        getContentPane().add(starPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 420, 20, 60));

        emp_fname.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(83, 43, 11), 2));
        emp_fname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emp_fnameActionPerformed(evt);
            }
        });
        getContentPane().add(emp_fname, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 150, 160, 30));

        emp_status.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(83, 43, 11), 2));
        emp_status.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emp_statusActionPerformed(evt);
            }
        });
        getContentPane().add(emp_status, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 70, 160, 30));

        NIC.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        NIC.setForeground(java.awt.Color.white);
        NIC.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NIC.setText("NIC");
        getContentPane().add(NIC, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 430, 160, -1));

        jLabel12.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel12.setForeground(java.awt.Color.white);
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Mobile");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 350, 160, -1));

        jLabel13.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel13.setForeground(java.awt.Color.white);
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Position");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 350, 160, -1));

        title.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        title.setForeground(new java.awt.Color(255, 255, 255));
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("Employee Management");
        getContentPane().add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, 1070, 70));

        starGen.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        starGen.setForeground(java.awt.Color.red);
        starGen.setText("*");
        getContentPane().add(starGen, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 220, 20, 60));

        btn_srch.setBackground(new java.awt.Color(83, 43, 11));
        btn_srch.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btn_srch.setForeground(new java.awt.Color(255, 255, 255));
        btn_srch.setText("Search");
        btn_srch.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.white, 2));
        btn_srch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_srchActionPerformed(evt);
            }
        });
        getContentPane().add(btn_srch, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 70, 80, 30));

        starMob.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        starMob.setForeground(java.awt.Color.red);
        starMob.setText("*");
        getContentPane().add(starMob, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 340, 20, 60));

        empFired.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "empID", "Fname", "Lname", "NIC", "gender", "Position", "remDate"
            }
        ));
        empFired.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        empFired.setEditingColumn(0);
        empFired.setEditingRow(0);
        empFired.setPreferredSize(new java.awt.Dimension(600, 800));
        empScroll.setViewportView(empFired);

        getContentPane().add(empScroll, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 430, 420, 170));

        jButton7.setBackground(java.awt.Color.green);
        jButton7.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("Activate User");
        jButton7.setBorder(new javax.swing.border.LineBorder(java.awt.Color.white, 2, true));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 450, 110, 30));

        tableFired.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "fname", "mname", "lname", "logCnt", "mobile", "address", "nic", "status", "gender", "dob", "position", "uname", "stDate", "mail"
            }
        ));
        tableFired.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tableFired.setAutoscrolls(false);
        tableFired.setEditingColumn(0);
        tableFired.setEditingRow(0);
        tableFired.setPreferredSize(new java.awt.Dimension(1366, 1366));
        tableFired.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableFiredMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tableFired);
        if (tableFired.getColumnModel().getColumnCount() > 0) {
            tableFired.getColumnModel().getColumn(1).setHeaderValue("fname");
            tableFired.getColumnModel().getColumn(2).setHeaderValue("mname");
            tableFired.getColumnModel().getColumn(3).setHeaderValue("lname");
            tableFired.getColumnModel().getColumn(4).setHeaderValue("logCnt");
            tableFired.getColumnModel().getColumn(5).setHeaderValue("mobile");
            tableFired.getColumnModel().getColumn(6).setHeaderValue("address");
            tableFired.getColumnModel().getColumn(7).setHeaderValue("nic");
            tableFired.getColumnModel().getColumn(8).setHeaderValue("status");
            tableFired.getColumnModel().getColumn(9).setHeaderValue("gender");
            tableFired.getColumnModel().getColumn(10).setHeaderValue("dob");
            tableFired.getColumnModel().getColumn(11).setHeaderValue("position");
            tableFired.getColumnModel().getColumn(12).setHeaderValue("uname");
            tableFired.getColumnModel().getColumn(13).setHeaderValue("stDate");
            tableFired.getColumnModel().getColumn(14).setHeaderValue("mail");
        }

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(922, 120, 420, 280));

        userleft.setBackground(new java.awt.Color(153, 0, 0));
        userleft.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        userleft.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 66, -1, 132));

        jLabel5.setFont(new java.awt.Font("Calibri", 1, 28)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Toothpaste");
        userleft.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(-7, 451, 310, 30));

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logof.png"))); // NOI18N
        userleft.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, 300, 90));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/employee2.png"))); // NOI18N
        userleft.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 300, 150));

        title1.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        title1.setForeground(new java.awt.Color(255, 255, 255));
        title1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title1.setText("User Management");
        userleft.add(title1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, 1070, 70));

        getContentPane().add(userleft, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 720));

        privHide.setText("jLabel14");
        getContentPane().add(privHide, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 640, -1, -1));

        jButton1.setText("DEMO");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 90, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/gray2.png"))); // NOI18N
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(242, 6, 23)));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -20, 1390, -1));

        setSize(new java.awt.Dimension(1382, 759));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void emp_IDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emp_IDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emp_IDActionPerformed

    private void emp_mobileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emp_mobileActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emp_mobileActionPerformed

    public void insert() {

        query = "INSERT INTO employee (Firstname, Middlename, Lastname, logCount, Mobile, Address, nic, Status, Gender, DateOfBirth, Position, StartDate, Email) VALUES ('" + fname + "' , '" + mname + "' , '" + lname + "' , '0' , '" + mobile + "' , '" + address + "' , '" + nic + "' , 'Inactive', '" + gender + "' , '" + dob + "' , '" + position + "' , NOW() , '" + email + "')";
        String query1 = " select * from employee where nic = '" + nic + "' ";

        try {

            stmt = conn.createStatement();

            if (stmt.executeUpdate(query) == 1) {
                DefaultTableModel model = (DefaultTableModel) tableEmp.getModel();
                model.setRowCount(0);
                showTable();
                clear();
                JOptionPane.showMessageDialog(null, "Record Added Successfully", "Error", JOptionPane.INFORMATION_MESSAGE);

                Statement stmt1 = conn.createStatement();
                ResultSet res1 = stmt1.executeQuery(query1);
                while (res1.next()) {
                    tempID = res1.getInt("EmployeeID");
                }

                addUserDetails();

            }

        } catch (SQLIntegrityConstraintViolationException ex) {
            JOptionPane.showMessageDialog(null, "Employee : " + emp_fname.getText() + " " + emp_lname.getText() + " ( NIC - " + emp_nic.getText() + " ) is already added", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void update() {

        query = "UPDATE employee set Firstname = '" + fname + "', Middlename = '" + mname + "', Lastname = '" + lname + "', Mobile = '" + mobile + "', Address = '" + address + "', nic = '" + nic + "',  Gender = '" + gender + "', DateOfBirth = '" + dob + "', Position = '" + position + "', Email = '" + email + "' where EmployeeID = '" + empID + "' ";

        try {

            stmt = conn.createStatement();
            if (stmt.executeUpdate(query) == 1) {
                DefaultTableModel model = (DefaultTableModel) tableEmp.getModel();
                model.setRowCount(0);
                showTable();
                clear();
                JOptionPane.showMessageDialog(null, "Record updated Successfully", "Error", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (SQLIntegrityConstraintViolationException ex) {
            JOptionPane.showMessageDialog(null, "NIC - " + nic + " already exists", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void addUserDetails() {

        query = "INSERT INTO user(empID, EmployeePriviledge, CustomerPriviledge, SupplierPriviledge, ProductPriviledge, StockPriviledge, OrderPriviledge, SalesPriviledge, SalaryPriviledge, UtilityPriviledge, FinancePriviledge, UserPriviledge, NotificationPriviledge) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )";

        try {

            PreparedStatement ps = conn.prepareStatement(query);

            ps.setInt(1, tempID);
            ps.setInt(2, emp);
            ps.setInt(3, cust);
            ps.setInt(4, supp);
            ps.setInt(5, prod);
            ps.setInt(6, stock);
            ps.setInt(7, ord);
            ps.setInt(8, sale);
            ps.setInt(9, sal);
            ps.setInt(10, util);
            ps.setInt(11, fin);
            ps.setInt(12, user);
            ps.setInt(13, notif);

            ps.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException ex) {
            //JOptionPane.showMessageDialog(null, "Employee : " +emp_fname.getText()+ " " + emp_lname.getText() + " ( NIC - " + emp_nic.getText() + " ) is already added", "Error", JOptionPane.INFORMATION_MESSAGE);
            ex.printStackTrace();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Something went wrong", "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void activateUser() {

        String tempUID = "OC" + empID;
        String tempNIC = nic;

        query = "UPDATE employee SET status = 'active' where EmployeeID = '" + empID + "' ";
        String query1 = "update user set Username = '" + tempUID + "', Password = '" + tempNIC + "' where empID = '" + empID + "'";
        String query2 = "delete from emp_deleted where empID = '" + empID + "'";

        try {

            stmt = conn.createStatement();
            Statement stmt1 = conn.createStatement();
            Statement stmt2 = conn.createStatement();

            if (stmt.executeUpdate(query) == 1) {

                stmt1.executeUpdate(query1);
                DefaultTableModel model = (DefaultTableModel) tableEmp.getModel();
                model.setRowCount(0);
                showTable();
                clear();
                JOptionPane.showMessageDialog(null, "User has been activated Successfully", "Error", JOptionPane.INFORMATION_MESSAGE);

                stmt2.executeUpdate(query2);
                DefaultTableModel model1 = (DefaultTableModel) empFired.getModel();
                model1.setRowCount(0);
                showDelTable();
                clear();

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Something went wrong", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void deactivateUser() {

        int rowCount = 0;

        query = "UPDATE employee SET status = 'inactive' where EmployeeID = '" + empID + "' ";
        String query1 = " INSERT INTO emp_deleted(empID, del_Date) VALUES ('" + empID + "',NOW())";
        String query2 = "select count(*) from emp_deleted where empID = '" + empID + "'";
        String query3 = "update user set Username = '', Password = '' where empID = '" + empID + "' ";

        try {
            Connection conn = new ConnectorNew().ConnectorNew();
            stmt = conn.createStatement();
            Statement stmt1 = conn.createStatement();
            Statement stmt2 = conn.createStatement();
            Statement stmt3 = conn.createStatement();
            ResultSet rs1;
            ResultSet rs2;
            ResultSet rs3;

            if (stmt.executeUpdate(query) == 1 /*&& */) {
                DefaultTableModel model = (DefaultTableModel) tableEmp.getModel();
                model.setRowCount(0);
                showTable();

                stmt2 = conn.createStatement();
                rs2 = stmt2.executeQuery(query2);
                while (rs2.next()) {
                    rowCount = rs2.getInt("count(*)");
                }

                if (rowCount == 0) {

                    if (stmt1.executeUpdate(query1) == 1) {
                        stmt3.executeUpdate(query3);
                        DefaultTableModel model1 = (DefaultTableModel) empFired.getModel();
                        model1.setRowCount(0);
                        showDelTable();

                        clear();
                        JOptionPane.showMessageDialog(null, "Employee : " + fname + " " + lname + " ( nic - " + nic + " ) is removed successfully", "Error", JOptionPane.INFORMATION_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Employee has been already deleted", "Error", JOptionPane.ERROR_MESSAGE);
                }

            }

            conn.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Something went wrong", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void getPriv() {

        if (btn_emp.isSelected()) {
            emp = 1;
        } else {
            emp = 0;
        }
        if (btn_cus.isSelected()) {
            cust = 1;
        } else {
            cust = 0;
        }
        if (btn_supp.isSelected()) {
            supp = 1;
        } else {
            supp = 0;
        }
        if (btn_prod.isSelected()) {
            prod = 1;
        } else {
            prod = 0;
        }
        if (btn_stock.isSelected()) {
            stock = 1;
        } else {
            stock = 0;
        }
        if (btn_order.isSelected()) {
            ord = 1;
        } else {
            ord = 0;
        }
        if (btn_sales.isSelected()) {
            sale = 1;
        } else {
            this.sale = 0;
        }
        if (btn_sal.isSelected()) {
            sal = 1;
        } else {
            sal = 0;
        }
        if (btn_util.isSelected()) {
            util = 1;
        } else {
            util = 0;
        }
        if (btn_finance.isSelected()) {
            fin = 1;
        } else {
            fin = 0;
        }
        if (btn_user.isSelected()) {
            user = 1;
        } else {
            user = 0;
        }
        if (btn_notif.isSelected()) {
            notif = 1;
        } else {
            notif = 0;
        }

    }

    public ArrayList<employee> getEmployeeList() {

        ArrayList<employee> employeesList = new ArrayList<employee>();
        conn = new ConnectorNew().ConnectorNew();
        query = "select * from employee";

        try {

            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            employee em1;
            while (rs.next()) {
                em1 = new employee(
                        rs.getInt("EmployeeID"),
                        rs.getString("Firstname"),
                        rs.getString("Middlename"),
                        rs.getString("Lastname"),
                        rs.getInt("logCount"),
                        rs.getString("Mobile"),
                        rs.getString("Address"),
                        rs.getString("nic"),
                        rs.getString("Status"),
                        rs.getString("Gender"),
                        rs.getString("DateOfBirth"),
                        rs.getString("Position"),
                        rs.getString("StartDate"),
                        rs.getString("Email"));

                employeesList.add(em1);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Something went wrong", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return employeesList;

    }

    public ArrayList<employee> getDeletedList() {

        ArrayList<employee> deletedList = new ArrayList<employee>();
        conn = new ConnectorNew().ConnectorNew();
        query = "SELECT recID, em.EmployeeID, em.Firstname, em.Lastname, em.Gender, em.Position, em.nic, del.del_Date from employee em, emp_deleted del where em.EmployeeID = del.empID ORDER BY recID ASC";

        try {

            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            employee em1;
            while (rs.next()) {
                em1 = new employee(
                        rs.getInt("recID"),
                        rs.getInt("EmployeeID"),
                        rs.getString("Firstname"),
                        rs.getString("Lastname"),
                        rs.getString("Gender"),
                        rs.getString("Position"),
                        rs.getString("nic"),
                        rs.getString("del_Date"));

                deletedList.add(em1);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return deletedList;

    }

    public void showTable() {

        ArrayList<employee> list = getEmployeeList();
        DefaultTableModel model = (DefaultTableModel) tableEmp.getModel();
        Object[] row = new Object[15];

        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).ID;
            row[1] = list.get(i).fname;
            row[2] = list.get(i).mname;
            row[3] = list.get(i).lname;
            row[4] = list.get(i).logCount;
            row[5] = list.get(i).mobile;
            row[6] = list.get(i).address;
            row[7] = list.get(i).nic;
            row[8] = list.get(i).status;
            row[9] = list.get(i).gender;
            row[10] = list.get(i).dob;
            row[11] = list.get(i).position;
            row[12] = list.get(i).uname;
            row[13] = list.get(i).strtDte;
            row[14] = list.get(i).email;

            model.addRow(row);

        }

    }

    public ArrayList<employee> getsearchList() {

        ArrayList<employee> searchedList = new ArrayList<employee>();
        conn = new ConnectorNew().ConnectorNew();
        query = "SELECT * from employee where EmployeeID like '" + srch + "' OR Firstname like '" + srch + "' OR Middlename like '" + srch + "' OR Lastname like '" + srch + "' OR logCount like '" + srch + "' OR Mobile like '" + srch + "' OR Address like '" + srch + "' OR nic like '" + srch + "' OR Status like '" + srch + "' OR Gender like '" + srch + "' OR DateOfBirth like '" + srch + "' OR Position like '" + srch + "' OR StartDate like '" + srch + "' OR Email like '" + srch + "' ";

        try {

            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            employee em1;
            while (rs.next()) {
                em1 = new employee(
                        rs.getInt("EmployeeID"),
                        rs.getString("Firstname"),
                        rs.getString("Middlename"),
                        rs.getString("Lastname"),
                        rs.getInt("logCount"),
                        rs.getString("Mobile"),
                        rs.getString("Address"),
                        rs.getString("nic"),
                        rs.getString("Status"),
                        rs.getString("Gender"),
                        rs.getString("DateOfBirth"),
                        rs.getString("Position"),
                        rs.getString("StartDate"),
                        rs.getString("Email"));

                searchedList.add(em1);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return searchedList;

    }

    public void showSearch() {

        ArrayList<employee> list = getsearchList();
        DefaultTableModel model = (DefaultTableModel) tableEmp.getModel();
        Object[] row = new Object[15];

        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).ID;
            row[1] = list.get(i).fname;
            row[2] = list.get(i).mname;
            row[3] = list.get(i).lname;
            row[4] = list.get(i).logCount;
            row[5] = list.get(i).mobile;
            row[6] = list.get(i).address;
            row[7] = list.get(i).nic;
            row[8] = list.get(i).status;
            row[9] = list.get(i).gender;
            row[10] = list.get(i).dob;
            row[11] = list.get(i).position;
            row[12] = list.get(i).uname;
            row[13] = list.get(i).strtDte;
            row[14] = list.get(i).email;

            model.addRow(row);

        }

    }

    public void showDelTable() {

        ArrayList<employee> list = getDeletedList();
        DefaultTableModel model = (DefaultTableModel) empFired.getModel();
        Object[] row = new Object[15];

        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).recID;
            row[1] = list.get(i).ID1;
            row[2] = list.get(i).fname1;
            row[3] = list.get(i).lname1;
            row[4] = list.get(i).gender1;
            row[5] = list.get(i).position1;
            row[6] = list.get(i).nic1;
            row[7] = list.get(i).strtDte1;

            model.addRow(row);

        }

        try {

            stmt = conn.createStatement();
            rs = stmt.executeQuery("   SELECT recID, em.EmployeeID, em.Firstname, em.Lastname, em.Gender, em.Position, em.nic, del.del_Date from employee em, emp_deleted del where em.EmployeeID = del.empID ORDER BY recID ASC");

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void clear() {
        emp_ID.setText("");
        emp_fname.setText("");
        emp_mname.setText("");
        emp_lname.setText("");
        emp_email.setText("");
        emp_addr.setText("");
        emp_mobile.setText("");
        emp_position.setText("");
        emp_nic.setText("");

        resetDate(emp_dob);

        btn_emp.setSelected(false);
        btn_emp.setBackground(Color.white);

        btn_cus.setSelected(false);
        btn_cus.setBackground(Color.white);

        btn_supp.setSelected(false);
        btn_supp.setBackground(Color.white);

        btn_prod.setSelected(false);
        btn_prod.setBackground(Color.white);

        btn_stock.setSelected(false);
        btn_stock.setBackground(Color.white);

        btn_order.setSelected(false);
        btn_order.setBackground(Color.white);

        btn_sales.setSelected(false);
        btn_sales.setBackground(Color.white);

        btn_sal.setSelected(false);
        btn_sal.setBackground(Color.white);

        btn_util.setSelected(false);
        btn_util.setBackground(Color.white);

        btn_finance.setSelected(false);
        btn_finance.setBackground(Color.white);

        btn_user.setSelected(false);
        btn_user.setBackground(Color.white);

        btn_notif.setSelected(false);
        btn_notif.setBackground(Color.white);
    }

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        clear();
        setStars();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void emp_nicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emp_nicActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emp_nicActionPerformed

    public void initialize() {
        srch = "%" + getString(emp_srch) + "%";
        empID = getString(emp_ID);
        fname = getString(emp_fname);
        mname = getString(emp_mname);
        lname = getString(emp_lname);
        gender = getRadio(male_radio, female_radio);
        email = getString(emp_email);
        address = getAddress(emp_addr);
        dob = getDate(emp_dob);
        mobile = getString(emp_mobile);
        position = getString(emp_position);
        nic = getString(emp_nic);
        //pw = getString(emp_pw);
    }

    //Custom Functions
    public void fullValidate() {

        //int sum = 0;
        int count = 0;

        //while(sum >= 8) {
        if (strValidate(emp_fname) == 0) {
            sum += 1;
            starFname.setVisible(false);
        } else {

            starFname.setVisible(true);
        }

        if (strValidate(emp_mname) == 0) {
            sum += 1;
            starMname.setVisible(false);
        } else {
            starMname.setVisible(true);
        }

        if (strValidate(emp_lname) == 0) {
            sum += 1;
            starLname.setVisible(false);
        } else {
            starLname.setVisible(true);
        }

        if (addressValidate(emp_addr) == 0) {
            sum += 1;
            starAddress.setVisible(false);
        } else {
            starAddress.setVisible(true);
        }

        if (strValidate(emp_position) == 0) {
            sum += 1;
            starPos.setVisible(false);
        } else {
            starPos.setVisible(true);
        }

        if (strValidate(emp_mobile) == 0) {
            sum += 1;
            starMob.setVisible(false);
        } else {
            //JOptionPane.showMessageDialog(null, "Invalid mobile", "Error", JOptionPane.ERROR_MESSAGE);
            starMob.setVisible(true);
            //return sum;
        }

        if (strValidate(emp_email) == 0) {
            sum += 1;
            starMail.setVisible(false);
        } else {
            //JOptionPane.showMessageDialog(null, "Invalid Email", "Error", JOptionPane.ERROR_MESSAGE);
            starMail.setVisible(true);

        }

        if (strValidate(emp_nic) == 0) {
            sum += 1;
            starNIC.setVisible(false);
        } else {
            //JOptionPane.showMessageDialog(null, "Invalid Email", "Error", JOptionPane.ERROR_MESSAGE);
            starNIC.setVisible(true);

        }

        if (privHide.isVisible() == true) {

            if (privValidate() == true) {
                sum += 1;
                starUserPriv.setVisible(false);
            } else {
                starUserPriv.setVisible(true);
            }

        } else {
            sum += 1;
            starUserPriv.setVisible(false);
        }

        if (sum == 9) {

            //while(sum == 11) {
            if (phoneValidate(emp_mobile) == 0) {
                sum += 1;
                starMob.setVisible(false);

                if (nicValidate(emp_nic) == 0) {
                    sum += 1;
                    starNIC.setVisible(false);

                    if (emailValidate(emp_email) == 0) {
                        sum += 1;
                        starMail.setVisible(false);

                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid Email", "Error", JOptionPane.ERROR_MESSAGE);
                        starMail.setVisible(true);

                    }
                } else {

                    JOptionPane.showMessageDialog(null, "Invalid NIC", "Error", JOptionPane.ERROR_MESSAGE);
                    starNIC.setVisible(true);

                }

            } else {
                JOptionPane.showMessageDialog(null, "Invalid mobile", "Error", JOptionPane.ERROR_MESSAGE);
                starMob.setVisible(true);
            }
            // }

        } else {
            JOptionPane.showMessageDialog(null, "Some fields need to be filled", "Error", JOptionPane.ERROR_MESSAGE);
        }

        //emp_fname.setText(String.v);
        //}
    }

    public void resetDate(JXDatePicker date1) {
        Calendar cals = Calendar.getInstance();
        date1.setDate(cals.getTime());
    }

    public String getDate(JXDatePicker date1) {
        SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
        return formater.format(date1.getDate());
    }

    public String getString(JTextField textName) {
        return textName.getText();
    }

    public String getAddress(JTextArea address) {
        return address.getText();
    }

    public String getRadio(JRadioButton x, JRadioButton y) {
        if (x.isSelected()) {
            return "Male";
        } else {
            return "Female";
        }
    }

    public void setStars() {
        starFname.setVisible(false);
        starMname.setVisible(false);
        starLname.setVisible(false);
        starAddress.setVisible(false);
        starPos.setVisible(false);
        starNIC.setVisible(false);
        starMail.setVisible(false);
        starPass.setVisible(false);
        starUserPriv.setVisible(false);
        starMob.setVisible(false);
        starGen.setVisible(false);

    }

    public int strValidate(JTextField textName) {
        if (textName.getText().equals(null) || textName.getText().equals("") || textName.getText().isEmpty() == true) {
            textName.setText("");
            return -1;
        } else {
            return 0;
        }
    }

    public int nicValidate(JTextField textName) {
        if (textName.getText().length() == 10 || textName.getText().length() == 12) {
            if (textName.getText().length() == 10) {
                if (textName.getText().substring(9).toLowerCase().equals("v")) {

                    String date = getDate(emp_dob);
                    date = date.substring(2, 4);

                    String nic = textName.getText().substring(0, 2);

                    if (!(nic.equals(date))) {
                        JOptionPane.showMessageDialog(null, "Date of birth year should be 19" + nic, "Error", JOptionPane.ERROR_MESSAGE);
                        return 0;
                    } else {

                        String genderValid = textName.getText().substring(2, 5);

                        if (Integer.parseInt(genderValid) >= 500) {
                            if (getRadio(male_radio, female_radio) == "Female") {
                                starGen.setVisible(false);
                                sum += 1;
                                return 0;
                            } else {
                                JOptionPane.showMessageDialog(null, "Your gender should be Female", "Error", JOptionPane.ERROR_MESSAGE);
                                starGen.setVisible(true);

                                return 0;
                            }
                        } else {
                            if (getRadio(male_radio, female_radio) == "Male") {
                                starGen.setVisible(false);
                                sum += 1;
                                return 0;
                            } else {
                                JOptionPane.showMessageDialog(null, "Your gender should be Male", "Error", JOptionPane.ERROR_MESSAGE);
                                starGen.setVisible(true);

                                return 0;
                            }
                        }

                    }

                } else {
                    //JOptionPane.showMessageDialog(null, "Invalid NIC", "Error", JOptionPane.ERROR_MESSAGE);
                    textName.setText("");
                    return -1;
                }

            } else if (textName.getText().length() == 12) {
                return 0;
            } else {
                //JOptionPane.showMessageDialog(null, "Invalid NIC", "Error", JOptionPane.ERROR_MESSAGE);
                textName.setText("");
                return -1;
            }

        } else {
            //JOptionPane.showMessageDialog(null, "Invalid NIC", "Error", JOptionPane.ERROR_MESSAGE);
            textName.setText("");
            return -1;
        }
    }

    public int phoneValidate(JTextField no) {
        String num = no.getText();
        num = num.replace(" ", "");

        boolean valid = num.matches("[0-9]{10}");

        if (valid == true) {
            if (num.substring(0, 1).equals("0")) {
                return 0;
            } else {

                emp_mobile.setText("");
                return -1;
            }
        } else {
            //JOptionPane.showMessageDialog(null, "Invalid Phone", "Error", JOptionPane.ERROR_MESSAGE);
            emp_mobile.setText("");
            return -1;
        }
    }

    public int addressValidate(JTextArea no) {

        if (no.getText().isEmpty() || no.getText().equals(null) || no.getText().equals("")) {
            return -1;
        } else {
            return 0;
        }

    }

    public int emailValidate(JTextField no) {

        String mail = no.getText();

        if (mail.matches("^[A-Za-z0-9_.]+[@][A-Za-z.]+[.]+[a-z]+$")) {
            return 0;
        } else {
            //JOptionPane.showMessageDialog(null, "Invalid Email", "Error", JOptionPane.ERROR_MESSAGE);
            no.setText("");
            return -1;
        }

    }

    public boolean passValidate(JTextField pass) {

        int upper = 0;
        int lower = 0;
        String passw = pass.getText();

        if (!(passw.length() >= 8)) {
            JOptionPane.showMessageDialog(null, "Password should contain at least 8 Characters", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        for (int i = 0; i < passw.length(); i++) {
            if (Character.isUpperCase(passw.charAt(i))) {
                upper += 1;
            }

            if (Character.isLowerCase(passw.charAt(i))) {
                lower += 1;
            }

        }

        if (upper >= 1 && lower >= 1) {
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Password should contain at least Upper case and a Lower case character", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

    }

    public boolean privValidate() {
        if (btn_emp.isSelected() || btn_cus.isSelected() || btn_supp.isSelected() || btn_prod.isSelected() || btn_stock.isSelected() || btn_order.isSelected() || btn_sales.isSelected() || btn_sal.isSelected() || btn_util.isSelected() || btn_finance.isSelected() || btn_user.isSelected() || btn_notif.isSelected()) {
            return true;
        } else {
            //JOptionPane.showMessageDialog(null, "1 Priviledge at least must be given", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }


    private void btn_notifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_notifActionPerformed
        if (btn_notif.isSelected()) {
            btn_notif.setBackground(new Color(105, 105, 105));
        } else {
            btn_notif.setBackground(Color.white);
        }
    }//GEN-LAST:event_btn_notifActionPerformed

    private void btn_empActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_empActionPerformed
        if (btn_emp.isSelected()) {
            btn_emp.setBackground(new Color(105, 105, 105));
        } else {
            btn_emp.setBackground(Color.white);
        }
    }//GEN-LAST:event_btn_empActionPerformed

    private void btn_cusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cusActionPerformed
        if (btn_cus.isSelected()) {
            btn_cus.setBackground(new Color(105, 105, 105));
        } else {
            btn_cus.setBackground(Color.white);
        }
    }//GEN-LAST:event_btn_cusActionPerformed

    private void btn_suppActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suppActionPerformed
        if (btn_supp.isSelected()) {
            btn_supp.setBackground(new Color(105, 105, 105));
        } else {
            btn_supp.setBackground(Color.white);
        }
    }//GEN-LAST:event_btn_suppActionPerformed

    private void btn_prodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_prodActionPerformed
        if (btn_prod.isSelected()) {
            btn_prod.setBackground(new Color(105, 105, 105));
        } else {
            btn_prod.setBackground(Color.white);
        }
    }//GEN-LAST:event_btn_prodActionPerformed

    private void btn_stockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_stockActionPerformed
        if (btn_stock.isSelected()) {
            btn_stock.setBackground(new Color(105, 105, 105));
        } else {
            btn_stock.setBackground(Color.white);
        }
    }//GEN-LAST:event_btn_stockActionPerformed

    private void btn_orderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_orderActionPerformed
        if (btn_order.isSelected()) {
            btn_order.setBackground(new Color(105, 105, 105));
        } else {
            btn_order.setBackground(Color.white);
        }
    }//GEN-LAST:event_btn_orderActionPerformed

    private void btn_salesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salesActionPerformed
        if (btn_sales.isSelected()) {
            btn_sales.setBackground(new Color(105, 105, 105));
        } else {
            btn_sales.setBackground(Color.white);
        }
    }//GEN-LAST:event_btn_salesActionPerformed

    private void btn_salActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salActionPerformed
        if (btn_sal.isSelected()) {
            btn_sal.setBackground(new Color(105, 105, 105));
        } else {
            btn_sal.setBackground(Color.white);
        }
    }//GEN-LAST:event_btn_salActionPerformed

    private void btn_utilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_utilActionPerformed
        if (btn_util.isSelected()) {
            btn_util.setBackground(new Color(105, 105, 105));
        } else {
            btn_util.setBackground(Color.white);
        }
    }//GEN-LAST:event_btn_utilActionPerformed

    private void btn_financeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_financeActionPerformed
        if (btn_finance.isSelected()) {
            btn_finance.setBackground(new Color(105, 105, 105));
        } else {
            btn_finance.setBackground(Color.white);
        }
    }//GEN-LAST:event_btn_financeActionPerformed

    private void btn_userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_userActionPerformed
        if (btn_user.isSelected()) {
            btn_user.setBackground(new Color(105, 105, 105));
        } else {
            btn_user.setBackground(Color.white);
        }
    }//GEN-LAST:event_btn_userActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        privHide.setVisible(true);
        fullValidate();
        if (sum >= 13) {

            getPriv();
            initialize();
            insert();
            //emp_fname.setText(String.valueOf(cust));

        }

        sum = 0;


    }//GEN-LAST:event_jButton4ActionPerformed


    private void female_radioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_female_radioActionPerformed


    }//GEN-LAST:event_female_radioActionPerformed

    private void emp_dobActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emp_dobActionPerformed

    }//GEN-LAST:event_emp_dobActionPerformed

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked

    }//GEN-LAST:event_jButton4MouseClicked

    private void tableEmpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableEmpMouseClicked

        try {
            int i = tableEmp.getSelectedRow();
            TableModel model = tableEmp.getModel();
            emp_ID.setText(model.getValueAt(i, 0).toString());
            emp_status.setText(model.getValueAt(i, 8).toString());
            emp_fname.setText(model.getValueAt(i, 1).toString());
            emp_mname.setText(model.getValueAt(i, 2).toString());
            emp_lname.setText(model.getValueAt(i, 3).toString());
            emp_mobile.setText(model.getValueAt(i, 5).toString());
            emp_addr.setText(model.getValueAt(i, 6).toString());
            emp_nic.setText(model.getValueAt(i, 7).toString());

            String date = model.getValueAt(i, 10).toString();
            Date date1 = Date.valueOf(date);
            emp_dob.setDate(date1);

            emp_position.setText(model.getValueAt(i, 11).toString());
            emp_email.setText(model.getValueAt(i, 14).toString());
            emp_ID.setText(model.getValueAt(i, 0).toString());

            if (model.getValueAt(i, 9).toString().equals("Male")) {
                male_radio.setSelected(true);
            } else {
                female_radio.setSelected(true);
            }

        } catch (Exception e) {
        }

        /*emp_fname.setText(model.getValueAt(i,1).toString());
        emp_fname.setText(model.getValueAt(i,1).toString());
        emp_fname.setText(model.getValueAt(i,1).toString());
        emp_fname.setText(model.getValueAt(i,1).toString());
        emp_fname.setText(model.getValueAt(i,1).toString());
        emp_fname.setText(model.getValueAt(i,1).toString());*/
    }//GEN-LAST:event_tableEmpMouseClicked

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        if (emp_ID.getText().equals(null) || emp_ID.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "No employee has been selected to Activate", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            if (emp_status.getText().equals("active")) {
                JOptionPane.showMessageDialog(null, "Employee already activated", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                initialize();
                activateUser();
            }

        }

    }//GEN-LAST:event_jButton7ActionPerformed

    private void emp_fnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emp_fnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emp_fnameActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        privHide.setVisible(false);

        if (emp_ID.getText().equals(null) || emp_ID.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "No employee has been selected to Update", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            fullValidate();
            if (sum >= 13) {
                initialize();
                update();

            }

            sum = 0;

        }


    }//GEN-LAST:event_btn_updateActionPerformed

    private void emp_statusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emp_statusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emp_statusActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        if (emp_ID.getText().equals(null) || emp_ID.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "No employee has been selected to Remove", "Error", JOptionPane.ERROR_MESSAGE);
        } else {

            initialize();
            deactivateUser();

        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void tableFiredMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableFiredMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tableFiredMouseClicked

    private void btn_allActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_allActionPerformed

        initialize();
        DefaultTableModel model = (DefaultTableModel) tableEmp.getModel();
        model.setRowCount(0);
        showTable();


    }//GEN-LAST:event_btn_allActionPerformed

    private void btn_srchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_srchActionPerformed

        if (emp_srch.getText().equals(null) || emp_srch.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Search is empty", "Error", JOptionPane.ERROR_MESSAGE);
        } else {

            initialize();
            DefaultTableModel model = (DefaultTableModel) tableEmp.getModel();
            model.setRowCount(0);
            showSearch();

        }
    }//GEN-LAST:event_btn_srchActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        emp_fname.setText("Erwin");
        emp_mname.setText("Donald");
        emp_lname.setText("Fernando");
        male_radio.setSelected(true);
        emp_mobile.setText("0714254784");
        emp_position.setText("Managing Director");
        emp_email.setText("Manoj@gmail.com");
        String date = "1997-09-03";
        Date date1 = Date.valueOf(date);
        emp_dob.setDate(date1);
        emp_nic.setText("971236541V");
        emp_addr.setText("Colombo");
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
            java.util.logging.Logger.getLogger(employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new employee().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel NIC;
    private javax.swing.JLabel NIC1;
    private javax.swing.JButton btn_all;
    private javax.swing.JToggleButton btn_cus;
    private javax.swing.JToggleButton btn_emp;
    private javax.swing.JToggleButton btn_finance;
    private javax.swing.JToggleButton btn_notif;
    private javax.swing.JToggleButton btn_order;
    private javax.swing.JToggleButton btn_prod;
    private javax.swing.JToggleButton btn_sal;
    private javax.swing.JToggleButton btn_sales;
    private javax.swing.JButton btn_srch;
    private javax.swing.JToggleButton btn_stock;
    private javax.swing.JToggleButton btn_supp;
    private javax.swing.JButton btn_update;
    private javax.swing.JToggleButton btn_user;
    private javax.swing.JToggleButton btn_util;
    private javax.swing.JTable empFired;
    private javax.swing.JScrollPane empScroll;
    private javax.swing.JTextField emp_ID;
    private javax.swing.JTextArea emp_addr;
    private org.jdesktop.swingx.JXDatePicker emp_dob;
    private javax.swing.JTextField emp_email;
    private javax.swing.JTextField emp_fname;
    private javax.swing.JTextField emp_lname;
    private javax.swing.JTextField emp_mname;
    private javax.swing.JTextField emp_mobile;
    private javax.swing.JTextField emp_nic;
    private javax.swing.JTextField emp_position;
    private javax.swing.JTextField emp_srch;
    private javax.swing.JTextField emp_status;
    private javax.swing.JRadioButton female_radio;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JRadioButton male_radio;
    private javax.swing.JLabel privHide;
    private javax.swing.JLabel starAddress;
    private javax.swing.JLabel starFname;
    private javax.swing.JLabel starGen;
    private javax.swing.JLabel starLname;
    private javax.swing.JLabel starMail;
    private javax.swing.JLabel starMname;
    private javax.swing.JLabel starMob;
    private javax.swing.JLabel starNIC;
    private javax.swing.JLabel starPass;
    private javax.swing.JLabel starPos;
    private javax.swing.JLabel starUserPriv;
    private javax.swing.JTable tableEmp;
    private javax.swing.JTable tableFired;
    private javax.swing.JLabel title;
    private javax.swing.JLabel title1;
    private javax.swing.JPanel userleft;
    // End of variables declaration//GEN-END:variables
}
