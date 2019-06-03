package dashboard;

import connection.Connector;
import connection.ConnectorNew;
import stock.stock;
import customer.customer;
import digitalClock.digitalClock;
import product.product;
import user.user;
import utility.utility;
import supplier.supplier;
import sales.sales;
import salary.salary;
import order.order;
import finance.finance;
import employee.employee;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

import java.util.TimerTask;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import login.tempUser;
import notification.notify;

public class dashboard extends javax.swing.JFrame {

    String query;
    String query1;
    String query2;
    String query3;
    String query4;
    String query5;
    String query6;
    Statement stmt;
    Statement stmt1;
    Statement stmt2;
    Statement stmt3;
    Statement stmt4;
    Statement stmt5;
    Statement stmt6;
    ResultSet rs;
    ResultSet rs1;
    ResultSet rs2;
    ResultSet rs3;
    ResultSet rs4;
    ResultSet rs5;
    ResultSet rs6;

    String ID = "";
    String location = "";
    String qty = "";
    int cnt = 0;
    int cnt1 = 0;

    public dashboard() {
        initComponents();
        title.setVisible(true);
        tempUser tempus = tempUser.getTempUserInstance();
        String username = tempus.getUsername();

        digitalClock clock = new digitalClock(timeStamp, "TIME");
        digitalClock clock2 = new digitalClock(dateStamp, "DATE");
        digitalClock clock3 = new digitalClock(dayStamp, "DAY");

        //notifyLowProduct();
        //notifyLowRaw();
        //checkProdExp();
        //checkRawExp();
        
        setButtons();
        tempUserLabel.setText("Logged in as : " + username);
        
        syncTable();

    }

    private void notifyLowProduct() {
        query = "SELECT * FROM stockproduct WHERE avl_qty <= 20";
        Connection conn = new ConnectorNew().ConnectorNew();
        
        int stockID = 0;
        int prodID = 0;
        int count = 0;
        int row = 0;
        String location = "";
        
        try {
            
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                stockID = rs.getInt("stockID");
                prodID = rs.getInt("prodID");
                location = rs.getString("location");
                
                query1 = "select count(*) from notify_prod where prodID = '" + prodID + "' AND stockID = '" + stockID + "' AND location = '" + location + "' AND type is null AND status = 'notRead'";
                stmt1 = conn.createStatement();
                rs1 = stmt1.executeQuery(query1);
                
                while(rs1.next()) {
                    count = rs1.getInt("count(*)");
                }
                
                if(!(count >= 1)) {
                    String desc = "Stock for Product ID : " + prodID + ", Stock No : " + stockID + " at location : " + location + " is currently getting low";
                    query2 = "INSERT INTO notify_prod(prodID, stockID, location, description, status, adDate, updDate) VALUES ('"+prodID+"','"+stockID+"','"+location+"',"
                            + "'"+desc+"','notRead',NOW(),NOW())";
                    
                    stmt2 = conn.createStatement();
                    if(stmt2.executeUpdate(query2) == 1) {
                        JOptionPane.showMessageDialog(null, "Stock for Product ID : " + prodID + ", Stock No : " + stockID + " at location : " + location + " is currently getting low", "Warning", JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
            
            query3 = "select count(*) from notify_prod where status = 'read' ";
            stmt3 = conn.createStatement();
            rs3 = stmt3.executeQuery(query3);
            while(rs3.next()) {
                row = rs3.getInt("count(*)");
            }
            
            if(row >= 10) {
                query4 = "delete from notify_prod where status = 'read'";
                stmt4 = conn.createStatement();
                stmt4.executeUpdate(query4);
            }
            
            conn.close();
        } 
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Something went wrong", "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }

    private void notifyLowRaw() {
        query = "SELECT * FROM stockraw WHERE qty <= 20";
        Connection conn = new ConnectorNew().ConnectorNew();
        
        int stockID = 0;
        int rawID = 0;
        int count = 0;
        int row = 0;
        String location = "";
        
        try {
            
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                stockID = rs.getInt("stockID");
                rawID = rs.getInt("rawID");
                location = rs.getString("location");
                
                query1 = "select count(*) from notify_raw where rawID = '" + rawID + "' AND stockID = '" + stockID + "' AND location = '" + location + "' AND type is null AND status = 'notRead'";
                stmt1 = conn.createStatement();
                rs1 = stmt1.executeQuery(query1);
                
                while(rs1.next()) {
                    count = rs1.getInt("count(*)");
                }
                
                if(!(count >= 1)) {
                    String desc = "Stock for Material ID : " + rawID + ", Stock No : " + stockID + " at location : " + location + " is currently getting low";
                    query2 = "INSERT INTO notify_raw(rawID, stockID, location, description, status, adDate, updDate) VALUES ('"+rawID+"','"+stockID+"','"+location+"',"
                            + "'"+desc+"','notRead',NOW(),NOW())";
                    
                    stmt2 = conn.createStatement();
                    if(stmt2.executeUpdate(query2) == 1) {
                        JOptionPane.showMessageDialog(null, "Stock for Material ID : " + rawID + ", Stock No : " + stockID + " at location : " + location + " is currently getting low", "Warning", JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
            
            
            query3 = "select count(*) from notify_raw where status = 'read' ";
            stmt3 = conn.createStatement();
            rs3 = stmt3.executeQuery(query3);
            while(rs3.next()) {
                row = rs3.getInt("count(*)");
            }
            
            if(row >= 10) {
                query4 = "delete from notify_raw where status = 'read'";
                stmt4 = conn.createStatement();
                stmt4.executeUpdate(query4);
            }
            
            conn.close();
        } 
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Something went wrong", "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }

    private void checkProdExp() {
        String query = "SELECT *,DATEDIFF(exp_Date,NOW()) FROM stockproduct WHERE DATEDIFF(exp_Date,NOW()) < 60 ";
        Connection conn = new ConnectorNew().ConnectorNew();
        
        int stockID = 0;
        int prodID = 0;
        int count = 0;
        String location = "";
        String exp = "";
        String remain = "";
        
        try {
            
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                stockID = rs.getInt("stockID");
                prodID = rs.getInt("prodID");
                location = rs.getString("location");
                exp = rs.getString("exp_Date");
                remain = rs.getString("DATEDIFF(exp_Date,NOW())");
                
                query1 = "select count(*) from notify_prod where prodID = '" + prodID + "' AND stockID = '" + stockID + "' AND location = '" + location + "' AND type = 'éxp' AND status = 'notRead'";
                stmt1 = conn.createStatement();
                rs1 = stmt1.executeQuery(query1);
                
                while(rs1.next()) {
                    count = rs1.getInt("count(*)");
                }
                
                if(!(count >= 1)) {
                    String desc = "Stock for Product ID - " + prodID + ", on Location - " + location + " is near to get expired. (Expiry Date : " + exp + " , " + remain + " days remaining.";
                    query2 = "INSERT INTO notify_prod(prodID, stockID, location, description, status, type, adDate, updDate) VALUES ('"+prodID+"','"+stockID+"','"+location+"',"
                            + "'"+desc+"','notRead', 'exp', NOW(), NOW())";
                    
                    stmt2 = conn.createStatement();
                    if(stmt2.executeUpdate(query2) == 1) {
                        JOptionPane.showMessageDialog(null, "Stock for Product ID : " + prodID + ", on Location : " + location + " is near to get expired. (Expiry Date : " + exp + " , " + remain + " days remaining.", "Warning", JOptionPane.WARNING_MESSAGE);
                    }
                }
                
                if(Integer.parseInt(remain) <= 0) {
                    query3 = "delete from stockproduct where stockID = '"+stockID+"' ";
                    query4 = " delete from notify_prod where prodID = '"+prodID+"' AND stockID = '"+stockID+"' AND prodID = '"+location+"' AND status = 'notRead' ";
                    
                    stmt3 = conn.createStatement();
                    if(stmt3.executeUpdate(query3) == 1){
                        
                        stmt4 = conn.createStatement();
                        stmt4.executeUpdate(query4);
                        JOptionPane.showMessageDialog(null, "Stock for Product ID : " + prodID + " has been deleted due to Product Expiry", "Warning", JOptionPane.WARNING_MESSAGE);
                        
                    }
                }
                
               
            } 
            
            conn.close();
        } 
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Something went wrong", "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }

    private void checkRawExp() {
        String query = "SELECT *,DATEDIFF(expDate,NOW()) FROM stockraw WHERE DATEDIFF(expDate,NOW()) < 60 ";
        Connection conn = new ConnectorNew().ConnectorNew();
        
        int stockID = 0;
        int rawID = 0;
        int count = 0;
        String location = "";
        String exp = "";
        String remain = "";
        
        try {
            
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                stockID = rs.getInt("stockID");
                rawID = rs.getInt("rawID");
                location = rs.getString("location");
                exp = rs.getString("expDate");
                remain = rs.getString("DATEDIFF(expDate,NOW())");
                
                query1 = "select count(*) from notify_raw where rawID = '" + rawID + "' AND stockID = '" + stockID + "' AND location = '" + location + "' AND type = 'éxp' AND status = 'notRead'";
                stmt1 = conn.createStatement();
                rs1 = stmt1.executeQuery(query1);
                
                while(rs1.next()) {
                    count = rs1.getInt("count(*)");
                }
                
                if(!(count >= 1)) {
                    String desc = "Stock for Material ID - " + rawID + ", on Location - " + location + " is near to get expired. (Expiry Date : " + exp + " , " + remain + " days remaining.";
                    query2 = "INSERT INTO notify_raw(rawID, stockID, location, description, status, type, adDate, updDate) VALUES ('"+rawID+"','"+stockID+"','"+location+"',"
                            + "'"+desc+"','notRead', 'exp', NOW(), NOW())";
                    
                    stmt2 = conn.createStatement();
                    if(stmt2.executeUpdate(query2) == 1) {
                        JOptionPane.showMessageDialog(null, "Stock for Material ID : " + rawID + ", on Location : " + location + " is near to get expired. (Expiry Date : " + exp + " , " + remain + " days remaining.", "Warning", JOptionPane.WARNING_MESSAGE);
                    }
                }
                
                
                if(Integer.parseInt(remain) <= 0) {
                    query3 = "delete from stockraw where stockID = '"+stockID+"' ";
                    query4 = " delete from notify_raw where rawID = '"+rawID+"' AND stockID = '"+stockID+"' AND location = '"+location+"' AND status = 'notRead' ";
                    
                    stmt3 = conn.createStatement();
                    if(stmt3.executeUpdate(query3) == 1){
                        
                        stmt4 = conn.createStatement();
                        stmt4.executeUpdate(query4);
                        JOptionPane.showMessageDialog(null, "Stock for Material ID : " + rawID + " has been deleted due to Material Expiry", "Warning", JOptionPane.WARNING_MESSAGE);
                        
                    }
                }
                
                
                
             
            } 
            
            conn.close();
        } 
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Something went wrong", "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }

    
    public void syncTable() {

        Timer t = new Timer(3000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                getCountNotify();
                notifyLowProduct();
                notifyLowRaw();
                checkProdExp();
                checkRawExp();
                
            }
        });
        t.start();

    }

    

    
    

    public void getCountNotify() {

        int row1 = 0;
        int row2 = 0;

        query = "select count(*) from notify_prod where status = 'notRead'";
        query1 = "select count(*) from notify_raw where status = 'notRead'";

        try {
            Connection conn = new ConnectorNew().ConnectorNew();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                row1 = rs.getInt("count(*)");
            }

            stmt1 = conn.createStatement();
            rs1 = stmt1.executeQuery(query1);
            while (rs1.next()) {
                row2 = rs1.getInt("count(*)");
            }
            if ((row1 + row2) == 0) {
                notifi.setText("");
            } else {
                notifi.setText("");
                notifi.setText(String.valueOf("(" + (row1 + row2) + ")"));
            }

            conn.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Something went wrong", "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    

    

    public void setButtons() {
        tempUser temp1 = tempUser.getTempUserInstance();

        if (temp1.getType().equals("Internal")) {
            String query = "SELECT * from user WHERE UserID = '" + temp1.getID() + "'";
            connection.Connector con1 = new Connector();
            Statement statement = con1.getStatement();

            int uPriviledge = 1;
            int ePriviledge = 1;
            int cPriviledge = 1;
            int sPriviledge = 1;
            int pPriviledge = 1;
            int stPriviledge = 1;
            int orPriviledge = 1;
            int salesPriviledge = 1;
            int salaPriviledge = 1;
            int utilPriviledge = 1;
            int finanPriviledge = 1;
            int notiPriviledge = 1;

            try {
                ResultSet rs = statement.executeQuery(query);
                while (rs.next()) {
                    uPriviledge = rs.getInt("UserPriviledge");
                    ePriviledge = rs.getInt("EmployeePriviledge");
                    cPriviledge = rs.getInt("CustomerPriviledge");
                    sPriviledge = rs.getInt("SupplierPriviledge");
                    pPriviledge = rs.getInt("ProductPriviledge");
                    stPriviledge = rs.getInt("StockPriviledge");
                    orPriviledge = rs.getInt("OrderPriviledge");
                    salesPriviledge = rs.getInt("SalesPriviledge");
                    salaPriviledge = rs.getInt("SalaryPriviledge");
                    utilPriviledge = rs.getInt("UtilityPriviledge");
                    finanPriviledge = rs.getInt("FinancePriviledge");
                    notiPriviledge = rs.getInt("NotificationPriviledge");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            if (uPriviledge == 0) {
                userbtn.setEnabled(false);
            }
            if (ePriviledge == 0) {
                emp_btn.setEnabled(false);
            }
            if (cPriviledge == 0) {
                cus_btn.setEnabled(false);
            }
            if (sPriviledge == 0) {
                sup_btn.setEnabled(false);
            }
            if (pPriviledge == 0) {
                prod_btn.setEnabled(false);
            }
            if (stPriviledge == 0) {
                stock_btn.setEnabled(false);
            }
            if (orPriviledge == 0) {
                order_btn.setEnabled(false);
            }
            if (salesPriviledge == 0) {
                sales_btn.setEnabled(false);
            }
            if (salaPriviledge == 0) {
                salary_btn.setEnabled(false);
            }
            if (utilPriviledge == 0) {
                util_btn.setEnabled(false);
            }
            if (finanPriviledge == 0) {
                finance_btn.setEnabled(false);
            }
            if (notiPriviledge == 0) {
                notif.setEnabled(false);
            }
        } else {
            profText.setVisible(false);
            profLabel.setVisible(false);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        wind = new javax.swing.JPanel();
        profLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        profText = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        notif = new javax.swing.JLabel();
        notifi = new javax.swing.JLabel();
        timeStamp = new javax.swing.JLabel();
        dateStamp = new javax.swing.JLabel();
        dayStamp = new javax.swing.JLabel();
        tempUserLabel = new javax.swing.JLabel();
        title = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        sup_btn = new javax.swing.JButton();
        finance_btn = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        cus_btn = new javax.swing.JButton();
        salary_btn = new javax.swing.JButton();
        emp_btn = new javax.swing.JButton();
        prod_btn = new javax.swing.JButton();
        stock_btn = new javax.swing.JButton();
        order_btn = new javax.swing.JButton();
        sales_btn = new javax.swing.JButton();
        util_btn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        userbtn = new javax.swing.JButton();
        back1 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Main Dashboard");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        wind.setBackground(new java.awt.Color(0, 0, 0));
        wind.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        profLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        profLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/user1.png"))); // NOI18N
        profLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                profLabelMouseClicked(evt);
            }
        });
        wind.add(profLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 490, 190, 130));
        wind.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 66, -1, 132));

        profText.setFont(new java.awt.Font("Calibri", 1, 28)); // NOI18N
        profText.setForeground(new java.awt.Color(255, 255, 255));
        profText.setText("User Profile");
        wind.add(profText, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 630, -1, 30));

        jLabel31.setFont(new java.awt.Font("Calibri", 1, 28)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("Toothpaste");
        wind.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 451, -1, 30));

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logof.png"))); // NOI18N
        wind.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 380, 220, 90));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/dash2.png"))); // NOI18N
        wind.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, 220, 190));

        notif.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        notif.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/not.png"))); // NOI18N
        notif.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                notifMouseClicked(evt);
            }
        });
        wind.add(notif, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, 180, 60));

        notifi.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        notifi.setForeground(new java.awt.Color(255, 255, 255));
        wind.add(notifi, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, -1, -1));

        timeStamp.setFont(new java.awt.Font("Digital-7 Mono", 1, 35)); // NOI18N
        timeStamp.setForeground(java.awt.Color.white);
        timeStamp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        timeStamp.setText("Time Stamp");
        wind.add(timeStamp, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 360, 60));

        dateStamp.setFont(new java.awt.Font("Digital-7 Mono", 0, 25)); // NOI18N
        dateStamp.setForeground(new java.awt.Color(255, 255, 255));
        dateStamp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dateStamp.setText("DATE STAMP");
        wind.add(dateStamp, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 360, 50));

        dayStamp.setFont(new java.awt.Font("Digital-7 Mono", 0, 25)); // NOI18N
        dayStamp.setForeground(java.awt.Color.white);
        dayStamp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dayStamp.setText("DAY STAMP");
        wind.add(dayStamp, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 360, 50));

        getContentPane().add(wind, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 360, 720));

        tempUserLabel.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        tempUserLabel.setForeground(java.awt.Color.white);
        tempUserLabel.setText("Logged In as : ");
        getContentPane().add(tempUserLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 30, 310, 40));

        title.setFont(new java.awt.Font("Calibri", 1, 48)); // NOI18N
        title.setForeground(new java.awt.Color(255, 255, 255));
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("Main Dashboard");
        getContentPane().add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 0, 1010, 100));

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/supplier1.png"))); // NOI18N
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 270, 240, 50));

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 22)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Salary");
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 470, 240, 30));

        jLabel9.setFont(new java.awt.Font("Calibri", 1, 22)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Employee");
        jLabel9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 170, 240, 30));

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/employee1.png"))); // NOI18N
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 120, 240, 50));

        jLabel11.setFont(new java.awt.Font("Calibri", 1, 22)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Customer");
        jLabel11.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 170, 240, 30));

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cus1.png"))); // NOI18N
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 120, 240, 50));

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/product1.png"))); // NOI18N
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 270, 240, 50));

        jLabel14.setFont(new java.awt.Font("Calibri", 1, 22)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Product");
        jLabel14.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 320, 240, 30));

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/stock1.png"))); // NOI18N
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 270, 240, 50));

        jLabel16.setFont(new java.awt.Font("Calibri", 1, 22)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Stock");
        jLabel16.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 320, 240, 30));

        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/order1.png"))); // NOI18N
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 420, 240, 50));

        jLabel18.setFont(new java.awt.Font("Calibri", 1, 22)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Order");
        jLabel18.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 470, 240, 30));

        jLabel19.setFont(new java.awt.Font("Calibri", 1, 22)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Sales");
        jLabel19.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 470, 240, 30));

        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/sales1.png"))); // NOI18N
        getContentPane().add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 420, 240, 50));

        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/util2.png"))); // NOI18N
        getContentPane().add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 570, 240, 50));

        jLabel23.setFont(new java.awt.Font("Calibri", 1, 22)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("Finance");
        jLabel23.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 620, 240, 30));

        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/finance1.png"))); // NOI18N
        getContentPane().add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 570, 240, 50));

        jLabel26.setFont(new java.awt.Font("Calibri", 1, 22)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("Supplier");
        jLabel26.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 320, 240, 30));

        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/salary1.png"))); // NOI18N
        getContentPane().add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 420, 240, 50));

        sup_btn.setBackground(new java.awt.Color(0, 0, 51));
        sup_btn.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        sup_btn.setForeground(new java.awt.Color(255, 255, 255));
        sup_btn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        sup_btn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        sup_btn.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        sup_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sup_btnActionPerformed(evt);
            }
        });
        getContentPane().add(sup_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 250, 240, 120));

        finance_btn.setBackground(new java.awt.Color(102, 102, 102));
        finance_btn.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        finance_btn.setForeground(new java.awt.Color(255, 255, 255));
        finance_btn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        finance_btn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        finance_btn.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        finance_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finance_btnActionPerformed(evt);
            }
        });
        getContentPane().add(finance_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 550, 240, 120));

        jLabel22.setFont(new java.awt.Font("Calibri", 1, 22)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("Utility");
        jLabel22.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 620, 240, 30));

        cus_btn.setBackground(new java.awt.Color(255, 204, 0));
        cus_btn.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        cus_btn.setForeground(new java.awt.Color(255, 255, 255));
        cus_btn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        cus_btn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cus_btn.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        cus_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cus_btnActionPerformed(evt);
            }
        });
        getContentPane().add(cus_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 100, 240, 120));

        salary_btn.setBackground(new java.awt.Color(0, 153, 0));
        salary_btn.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        salary_btn.setForeground(new java.awt.Color(255, 255, 255));
        salary_btn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        salary_btn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        salary_btn.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        salary_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salary_btnActionPerformed(evt);
            }
        });
        getContentPane().add(salary_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 400, 240, 120));

        emp_btn.setBackground(new java.awt.Color(255, 102, 0));
        emp_btn.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        emp_btn.setForeground(new java.awt.Color(255, 255, 255));
        emp_btn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        emp_btn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        emp_btn.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        emp_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emp_btnActionPerformed(evt);
            }
        });
        getContentPane().add(emp_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 100, 240, 120));

        prod_btn.setBackground(new java.awt.Color(0, 51, 153));
        prod_btn.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        prod_btn.setForeground(new java.awt.Color(255, 255, 255));
        prod_btn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        prod_btn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        prod_btn.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        prod_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prod_btnActionPerformed(evt);
            }
        });
        getContentPane().add(prod_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 250, 240, 120));

        stock_btn.setBackground(new java.awt.Color(0, 204, 255));
        stock_btn.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        stock_btn.setForeground(new java.awt.Color(255, 255, 255));
        stock_btn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        stock_btn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        stock_btn.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        stock_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stock_btnActionPerformed(evt);
            }
        });
        getContentPane().add(stock_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 250, 240, 120));

        order_btn.setBackground(new java.awt.Color(51, 0, 51));
        order_btn.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        order_btn.setForeground(new java.awt.Color(255, 255, 255));
        order_btn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        order_btn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        order_btn.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        order_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                order_btnActionPerformed(evt);
            }
        });
        getContentPane().add(order_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 400, 240, 120));

        sales_btn.setBackground(new java.awt.Color(51, 51, 0));
        sales_btn.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        sales_btn.setForeground(new java.awt.Color(255, 255, 255));
        sales_btn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        sales_btn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        sales_btn.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        sales_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sales_btnActionPerformed(evt);
            }
        });
        getContentPane().add(sales_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 400, 240, 120));

        util_btn.setBackground(new java.awt.Color(0, 0, 0));
        util_btn.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        util_btn.setForeground(new java.awt.Color(255, 255, 255));
        util_btn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        util_btn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        util_btn.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        util_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                util_btnActionPerformed(evt);
            }
        });
        getContentPane().add(util_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 550, 240, 120));

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 22)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("User");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 170, 240, 30));

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/user2.png"))); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 120, 240, 50));

        userbtn.setBackground(new java.awt.Color(153, 0, 0));
        userbtn.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        userbtn.setForeground(new java.awt.Color(255, 255, 255));
        userbtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        userbtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        userbtn.setInheritsPopupMenu(true);
        userbtn.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        userbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userbtnActionPerformed(evt);
            }
        });
        getContentPane().add(userbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 100, 240, 120));

        back1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/gray2.png"))); // NOI18N
        getContentPane().add(back1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 1380, 730));

        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/sales1.png"))); // NOI18N
        getContentPane().add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 420, 240, 50));

        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/sales1.png"))); // NOI18N
        getContentPane().add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 420, 240, 50));

        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/sales1.png"))); // NOI18N
        getContentPane().add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 420, 240, 50));

        setSize(new java.awt.Dimension(1382, 759));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void userbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userbtnActionPerformed
        new user().setVisible(true);
    }//GEN-LAST:event_userbtnActionPerformed

    private void emp_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emp_btnActionPerformed
        new employee().setVisible(true);
    }//GEN-LAST:event_emp_btnActionPerformed

    private void cus_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cus_btnActionPerformed
        new customer().setVisible(true);
    }//GEN-LAST:event_cus_btnActionPerformed

    private void sup_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sup_btnActionPerformed
        new supplier().setVisible(true);
    }//GEN-LAST:event_sup_btnActionPerformed

    private void prod_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prod_btnActionPerformed
        new product().setVisible(true);
    }//GEN-LAST:event_prod_btnActionPerformed

    private void stock_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stock_btnActionPerformed
        new stock().setVisible(true);
    }//GEN-LAST:event_stock_btnActionPerformed

    private void order_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_order_btnActionPerformed
        new order().setVisible(true);
    }//GEN-LAST:event_order_btnActionPerformed

    private void sales_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sales_btnActionPerformed
        new sales().setVisible(true);
    }//GEN-LAST:event_sales_btnActionPerformed

    private void salary_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salary_btnActionPerformed
        new salary().setVisible(true);
    }//GEN-LAST:event_salary_btnActionPerformed

    private void util_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_util_btnActionPerformed
        new utility().setVisible(true);
    }//GEN-LAST:event_util_btnActionPerformed

    private void finance_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finance_btnActionPerformed
        new finance().setVisible(true);
    }//GEN-LAST:event_finance_btnActionPerformed

    private void notifMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_notifMouseClicked
        new notify().setVisible(true);
    }//GEN-LAST:event_notifMouseClicked

    private void profLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profLabelMouseClicked
        new profile.userProfile().setVisible(true);
    }//GEN-LAST:event_profLabelMouseClicked

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
            java.util.logging.Logger.getLogger(dashboard.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dashboard.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dashboard.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dashboard.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new dashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel back1;
    private javax.swing.JButton cus_btn;
    private javax.swing.JLabel dateStamp;
    private javax.swing.JLabel dayStamp;
    private javax.swing.JButton emp_btn;
    private javax.swing.JButton finance_btn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel notif;
    private javax.swing.JLabel notifi;
    private javax.swing.JButton order_btn;
    private javax.swing.JButton prod_btn;
    private javax.swing.JLabel profLabel;
    private javax.swing.JLabel profText;
    private javax.swing.JButton salary_btn;
    private javax.swing.JButton sales_btn;
    private javax.swing.JButton stock_btn;
    private javax.swing.JButton sup_btn;
    private javax.swing.JLabel tempUserLabel;
    private javax.swing.JLabel timeStamp;
    private javax.swing.JLabel title;
    private javax.swing.JButton userbtn;
    private javax.swing.JButton util_btn;
    private javax.swing.JPanel wind;
    // End of variables declaration//GEN-END:variables

}
