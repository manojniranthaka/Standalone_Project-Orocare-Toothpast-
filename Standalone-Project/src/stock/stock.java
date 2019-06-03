/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stock;

import connection.ConnectorNew;
import employee.employee;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import org.jdesktop.swingx.JXDatePicker;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.format.DateTimeFormatter;

/**
 *
 * @author Sahan Jayawardena
 */
public class stock extends javax.swing.JFrame {

    String name, type, location, expDate, manufactDate, addedDate, stockID, prodID, qty, unitCost, sellPrice, prodSrch;

    String stockName = "";
    String rawName = "";

    String name1, type1, location1, expDate1, manufactDate1, addedDate1, stockID1, prodID1, qty1, unitCost1, rawSrch, rawStkID;
    //int emp1, cust1, supp1, prod1, stock1, ord1, sale1, sal1, util1, fin1, user1, notif1;
    int sum = 0;
    int tempID;

    
    String query;
    String query1;
    String query2;
    String query3;
    String query4;
    String query5;
    String query6;
    Statement stmt = null;
    Statement stmt1 = null;
    Statement stmt2 = null;
    Statement stmt3 = null;
    Statement stmt4 = null;
    Statement stmt5 = null;
    Statement stmt6 = null;
    ResultSet rs = null;
    ResultSet rs1 = null;
    ResultSet rs2 = null;
    ResultSet rs3 = null;
    ResultSet rs4 = null;
    ResultSet rs5 = null;
    ResultSet rs6 = null;
    
    int initialCount = 0;
    int actualCount = 0;
    int initialCount1 = 0;
    int actualCount1 = 0;
    
    List<String> initialArr = new ArrayList<String>();
    List<String> initialArr1 = new ArrayList<String>();
    List<String> actualArr = new ArrayList<String>();
    List<String> actualArr1 = new ArrayList<String>();

    public void initialize() {
        stockID = getString(stk_ID);
        prodSrch = "%" + getString(prod_search) + "%";
        prodID = getString(stock_prod_ID);
        location = getString(prod_loc).toLowerCase();
        qty = getString(prod_qty);
        unitCost = getString(prod_Price);
        sellPrice = getString(prod_sale_price);
        expDate = getDate(prod_expiry);
        manufactDate = getDate(prod_manufact);
        stockName = "Stock for Product ID - " + prodID + " at Location - " + location + " is currently getting low. " + qty + " Units Left !";

    }

    public void initialize1() {
        rawSrch = "%" + getString(raw_Search) + "%";
        rawStkID = getString(raw_ID);
        prodID1 = getString(stock_prod_ID1);
        location1 = getString(prod_loc1).toLowerCase();
        qty1 = getString(prod_qty1);
        unitCost1 = getString(prod_Price1);
        expDate1 = getDate(prod_expiry1);
        rawName = "Stock for Material ID - " + prodID1 + " at Location - " + location1 + " is currently getting low";
    }
    
    
    public void syncTable() {

        Timer t = new Timer(4000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateProductCount();
                updateTableRecords();
            }
        });
        t.start();

    }
    
    public void initProductCount() {
        
        query1 = "select count(*) from stockproduct";
        Connection conn = new ConnectorNew().ConnectorNew();
        
        try {

            
            stmt1 = conn.createStatement();
            rs1 = stmt1.executeQuery(query1);
            while (rs1.next()) {
                initialCount = rs1.getInt("count(*)");
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
    
    public void updateProductCount() {
        
        Connection conn = new ConnectorNew().ConnectorNew();
        query1 = "select count(*) from stockproduct";
        
        try {

            stmt1 = conn.createStatement();
            rs1 = stmt1.executeQuery(query1);
            while (rs1.next()) {
                actualCount = rs1.getInt("count(*)");
            }

             if(initialCount != actualCount) {
                initialCount = actualCount;
                DefaultTableModel model = (DefaultTableModel) prod_table.getModel();
                model.setRowCount(0);
                showTable();
                
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
    
    
    public void initTableRecords() {
        
        Connection conn = new ConnectorNew().ConnectorNew();
        query1 = "select * from stockproduct";
        
        try {

            
                stmt1 = conn.createStatement();
                rs1 = stmt1.executeQuery(query1);
                while (rs1.next()) {
                    initialArr.add(rs1.getString("updDate")) ;
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
    
    
    public void updateTableRecords() {
        
        Connection conn = new ConnectorNew().ConnectorNew();
        query1 = "select * from stockproduct";
        
        try {
            
            
                stmt1 = conn.createStatement();
                rs1 = stmt1.executeQuery(query1);
                actualArr.clear();
                while (rs1.next()) {
                    actualArr.add(rs1.getString("updDate")) ;
                }
            
                if(initialArr.size() != actualArr.size()) {
                    initialArr.clear();
                    initTableRecords();
                }
                    
                    for(int i=0; i<actualArr.size(); i++) {
                        if( !(actualArr.get(i).equals(initialArr.get(i))) ) {
                            DefaultTableModel model = (DefaultTableModel) prod_table.getModel();
                            model.setRowCount(0);
                            showTable();
                            initialArr.clear();
                            initTableRecords();
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
    
    
    
    
    public void syncTable1() {

        Timer t = new Timer(2000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateRawCount();
                updateRawTableRecords();
            }
        });
        t.start();

    }
    
    public void initRawCount() {
        
        query1 = "select count(*) from stockraw";
        Connection conn = new ConnectorNew().ConnectorNew();
        
        try {

            stmt1 = conn.createStatement();
            rs1 = stmt1.executeQuery(query1);
            while (rs1.next()) {
                initialCount1 = rs1.getInt("count(*)");
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
    
    public void updateRawCount() {
        
        query1 = "select count(*) from stockraw";
        Connection conn = new ConnectorNew().ConnectorNew();
        
        try {

            stmt1 = conn.createStatement();
            rs1 = stmt1.executeQuery(query1);
            while (rs1.next()) {
                actualCount1 = rs1.getInt("count(*)");
            }

             if(initialCount1 != actualCount1) {
                initialCount1 = actualCount1;
                DefaultTableModel model = (DefaultTableModel) prod_table1.getModel();
                model.setRowCount(0);
                showTable1();
                
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
    
    
    
    public void initRawTableRecords() {
        
        query1 = "select * from stockraw";
        Connection conn = new ConnectorNew().ConnectorNew();
        
        try {

            
                stmt1 = conn.createStatement();
                rs1 = stmt1.executeQuery(query1);
                while (rs1.next()) {
                    initialArr1.add(rs1.getString("updDate")) ;
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
    
    
    public void updateRawTableRecords() {
        
        query1 = "select * from stockraw";
        Connection conn = new ConnectorNew().ConnectorNew();
        
        try {
            
            
                stmt1 = conn.createStatement();
                rs1 = stmt1.executeQuery(query1);
                actualArr1.clear();
                while (rs1.next()) {
                    actualArr1.add(rs1.getString("updDate")) ;
                }
            
                if(initialArr1.size() != actualArr1.size()) {
                    initialArr1.clear();
                    initRawTableRecords();
                }
                    
                    for(int i=0; i<actualArr1.size(); i++) {
                        if( !(actualArr1.get(i).equals(initialArr1.get(i))) ) {
                            DefaultTableModel model = (DefaultTableModel) prod_table1.getModel();
                            model.setRowCount(0);
                            showTable1();
                            initialArr1.clear();
                            initRawTableRecords();
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
    
    
    

    public String getDate(JXDatePicker date1) {
        SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
        return formater.format(date1.getDate());
    }

    public String getString(JTextField textName) {
        return textName.getText();
    }

    public int strValidate(JTextField textName) {

        if (textName.getText().equals(null) || textName.getText().equals("") || textName.getText().isEmpty() == true) {
            return -1;
        } 
        
        else {
           
            return 0;
        }

    }
    

    public boolean checkInteger(JTextField textName) {
        boolean isValid = false;

        try {
            Integer.parseInt(textName.getText());

            // s is a valid integer
            if (Integer.valueOf(textName.getText()) > 0) {
                isValid = true;
            } else {
                isValid = false;
            }

        } catch (NumberFormatException ex) {
            // s is not an integer
        }

        return isValid;
    }

    public boolean checkDouble(JTextField textName) {
        boolean isValid = false;

        try {
            Double.parseDouble(textName.getText());

            // s is a valid integer
            if (Double.valueOf(textName.getText()) > 0) {
                isValid = true;
            } else {
                isValid = false;
            }

        } catch (NumberFormatException ex) {
            // s is not an integer
        }

        return isValid;
    }

    public int strValid(JTextField textName) {
        try{
            Integer.parseInt(textName.getText());
        }
        
        catch(Exception ex) {
            return 0;
        }
        
        return -1;
    }
    
    public int dateDiff(JXDatePicker exp, JXDatePicker manufact) {

        DateTime exp1 = new DateTime(exp.getDate());
        DateTime manufact1 = new DateTime(manufact.getDate());

        Days d = Days.daysBetween(manufact1, exp1);
        int days = d.getDays();
        return days;

    }

    public int manufactValid(JXDatePicker manufact) {

        DateTime end = new DateTime();
        DateTime start = new DateTime(manufact.getDate());

        Days d = Days.daysBetween(start, end);
        int days = d.getDays();
        return days;

    }

    public void setStars() {
        starLoc.setVisible(false);
        starUnit.setVisible(false);
        starManu.setVisible(false);
        starQt.setVisible(false);
        starSp.setVisible(false);
        starEx.setVisible(false);

    }

    public void setStars1() {
        starRaw.setVisible(false);
        starRawName.setVisible(false);
        starUnit1.setVisible(false);
        starQt1.setVisible(false);
        starLoc1.setVisible(false);
        starEx1.setVisible(false);

    }

    public void fullValidate() {

        if (strValidate(prod_loc) == 0) {
            sum += 1;
            starLoc.setVisible(false);
        } else {
            starLoc.setVisible(true);
        }

        if (strValidate(prod_Price) == 0) {
            sum += 1;
            starUnit.setVisible(false);
        } else {
            starUnit.setVisible(true);
        }

        if (strValidate(prod_qty) == 0) {
            sum += 1;
            starQt.setVisible(false);
        } else {
            starQt.setVisible(true);
        }

        if (strValidate(prod_sale_price) == 0) {
            sum += 1;
            starSp.setVisible(false);
        } else {
            starSp.setVisible(true);
        }

        if (sum == 4) {
            
            if(strValid(prod_loc) == 0) {
                sum += 1;
                starLoc.setVisible(false);
                
                if (checkInteger(prod_qty) == true) {
                sum += 1;
                starQt.setVisible(false);

                    if (checkDouble(prod_Price) == true) {
                        sum += 1;
                        starUnit.setVisible(false);

                        if (checkDouble(prod_sale_price) == true) {
                            sum += 1;
                            starSp.setVisible(false);

                            if (manufactValid(prod_manufact) >= 0) {
                                sum += 1;
                                starManu.setVisible(false);

                                if (dateDiff(prod_expiry, prod_manufact) >= 1) {
                                    sum += 1;
                                    starEx.setVisible(false);
                                } else {
                                    starEx.setVisible(true);
                                    JOptionPane.showMessageDialog(null, "Expiry Date should be greater than Manufactured Date", "Error", JOptionPane.ERROR_MESSAGE);
                                    resetDate(prod_expiry);
                                }
                            } else {
                                starManu.setVisible(true);
                                JOptionPane.showMessageDialog(null, "You can't predict the future", "Error", JOptionPane.ERROR_MESSAGE);
                                resetDate(prod_manufact);
                            }

                        } else {
                            starSp.setVisible(true);
                            JOptionPane.showMessageDialog(null, "Invalid Sale Price", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                } else {
                    starUnit.setVisible(true);
                    JOptionPane.showMessageDialog(null, "Invalid Unit Price", "Error", JOptionPane.ERROR_MESSAGE);
                }

            } else {
                starQt.setVisible(true);
                JOptionPane.showMessageDialog(null, "Invalid Quanitity", "Error", JOptionPane.ERROR_MESSAGE);
            }
                
            }
            
            else {
                starLoc.setVisible(true);
                JOptionPane.showMessageDialog(null, "Invalid Location", "Error", JOptionPane.ERROR_MESSAGE);
            }

            
        } else {
            JOptionPane.showMessageDialog(null, "Some fields need to be filled", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void fullValidate1() {
        if (strValidate(prod_loc1) == 0) {
            sum += 1;
            starLoc1.setVisible(false);
        } else {
            starLoc1.setVisible(true);
        }

        if (strValidate(prod_qty1) == 0) {
            sum += 1;
            starQt1.setVisible(false);
        } else {
            starQt1.setVisible(true);
        }

        if (strValidate(prod_Price1) == 0) {
            sum += 1;
            starUnit1.setVisible(false);
        } else {
            starUnit1.setVisible(true);
        }

        if (sum == 3) {

            if(strValid(prod_loc1) == 0) {
                sum += 1;
                starLoc1.setVisible(false);
                
                    if (checkInteger(prod_qty1) == true) {
                    sum += 1;
                    starQt1.setVisible(false);

                        if (checkDouble(prod_Price1) == true) {
                            sum += 1;
                            starUnit1.setVisible(false);

                        } else {
                            starUnit1.setVisible(true);
                            JOptionPane.showMessageDialog(null, "Invalid Unit Price", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                } else {
                    starQt1.setVisible(true);
                    JOptionPane.showMessageDialog(null, "Invalid Quantity", "Error", JOptionPane.ERROR_MESSAGE);
                }
                
            }
            
            else {
                starLoc1.setVisible(true);
                JOptionPane.showMessageDialog(null, "Invalid Product Location", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Some fields need to be filled", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void update() {

        
        
        query1 = " UPDATE stockProduct SET avl_qty = '" + qty + "', unitCost = '" + unitCost + "', exp_Date = '" + expDate + "', manu_Date = '" + manufactDate + "', sellPrice = '" + sellPrice + "', updDate = NOW() WHERE (stockID = '" + stockID + "' AND prodID = '" + prodID + "' AND location='" + location + "')";
        query2 = "delete from notify_prod where stockID = '" + stockID + "' AND prodID = '" + prodID + "' AND location = '" + location + "' AND status = 'notRead' AND type is null";
        query3 = "delete from notify_prod where stockID = '" + stockID + "' AND prodID = '" + prodID + "' AND location = '" + location + "' AND status = 'notRead' AND type = 'exp'";
        
        
        
        Connection conn = new ConnectorNew().ConnectorNew();
        
        try {

            stmt1 = conn.createStatement();
            if (stmt1.executeUpdate(query1) == 1) {
                DefaultTableModel model = (DefaultTableModel) prod_table.getModel();
                model.setRowCount(0);
                showTable();
                JOptionPane.showMessageDialog(null, "Stock Updated Successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
            }

            if (Integer.parseInt(qty) > 20) {
                stmt2 = conn.createStatement();
                stmt2.executeUpdate(query2);
                
            }
       
            int dayCount = dateDiff(prod_expiry, prod_manufact);
            if(dayCount > 60) {
                stmt3 = conn.createStatement();
                stmt3.executeUpdate(query3);
            }
            
            clearAll();
            conn.close();
            
        } catch (SQLIntegrityConstraintViolationException ex) {
            JOptionPane.showMessageDialog(null, "Stock : " + prod_names.getSelectedItem() + ", Product ID - " + stock_prod_ID.getText() + " is already added", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, "Something went wrong", "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void update1() {

  
        query1 = "UPDATE stockRaw SET qty='" + qty1 + "',unitCost='" + unitCost1 + "',expDate='" + expDate1 + "', updDate = NOW() WHERE (stockID = '" + rawStkID + "' AND rawID = '" + prodID1 + "' AND location='" + location1 + "')";
        query2 = "delete from notify_raw where rawID = '" + prodID1 + "' AND stockID = '" + rawStkID + "' AND location = '" + location1 + "' AND status = 'notRead' AND type is NULL";
        query3 = "delete from notify_raw where stockID = '" + rawStkID + "' AND rawID = '" + prodID1 + "' AND location = '" + location1 + "' AND status = 'notRead' AND type = 'exp'";

        Connection conn = new ConnectorNew().ConnectorNew();
        
        try {

            stmt1 = conn.createStatement();
            if (stmt1.executeUpdate(query1) == 1) {
                DefaultTableModel model = (DefaultTableModel) prod_table1.getModel();
                model.setRowCount(0);
                showTable1();
                JOptionPane.showMessageDialog(null, "Stock Updated Successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
            }

            if (Integer.parseInt(qty1) > 20) {
                stmt2 = conn.createStatement();
                stmt2.executeUpdate(query2);
            }
            
            DateTime curr = new DateTime();
            DateTime exp = new DateTime(prod_expiry1.getDate());
            
            Days days = Days.daysBetween(curr, exp);
            int diff = days.getDays();
            
            if(diff > 60) {
                stmt3 = conn.createStatement();
                stmt3.executeUpdate(query3);
            }

            
            clearAll1();
            conn.close();
            
        } catch (SQLIntegrityConstraintViolationException ex) {
            JOptionPane.showMessageDialog(null, "Stock : " + prod_names1.getSelectedItem() + ", Material ID - " + prodID1 + " is already added", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Something went wrong", "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void insert() {


        query1 = "INSERT INTO stockProduct(prodID, location, avl_qty,"
                + "unitCost, exp_Date, manu_Date, sellPrice, added_Date, updDate) "
                + "VALUES ('" + prodID + "', '" + location + "', '" + qty + "', '" + unitCost + "', '" + expDate + "', '" + manufactDate + "', '" + sellPrice + "', NOW(), NOW() )";

      
        
        Connection conn = new ConnectorNew().ConnectorNew();
        
        try {

           
                stmt1 = conn.createStatement();
                if (stmt1.executeUpdate(query1) == 1) {
                    DefaultTableModel model = (DefaultTableModel) prod_table.getModel();
                    model.setRowCount(0);
                    showTable();
                    clearAll();
                    JOptionPane.showMessageDialog(null, "Stock Added Successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                }

                

            conn.close();
            
        } //atch(SQLIntegrityConstraintViolationException ex) {
        //JOptionPane.showMessageDialog(null, "Employee : " +emp_fname.getText()+ " " + emp_lname.getText() + " ( NIC - " + emp_nic.getText() + " ) is already added", "Error", JOptionPane.ERROR_MESSAGE);
        //}
        //catch(SQLException ex) {
        //}
        catch (SQLIntegrityConstraintViolationException ex) {
            JOptionPane.showMessageDialog(null, "Stock : " + prod_names.getSelectedItem() + ", Product ID - " + prodID + " is already added", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Something went wrong", "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void insert1() {

      

        query1 = "INSERT INTO stockRaw(rawID, location, qty,"
                + "unitCost, expDate, adDate, updDate) "
                + "VALUES ('" + prodID1 + "', '" + location1 + "', '" + qty1 + "', '" + unitCost1 + "', '" + expDate1 + "', NOW(), NOW() )";

        
        
        Connection conn = new ConnectorNew().ConnectorNew();
        
        try {

                stmt1 = conn.createStatement();
                if (stmt1.executeUpdate(query1) == 1) {
                    DefaultTableModel model = (DefaultTableModel) prod_table1.getModel();
                    model.setRowCount(0);
                    showTable1();
                    clearAll1();
                    JOptionPane.showMessageDialog(null, "Stock Material Added Successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                }

            conn.close();

        } catch (SQLIntegrityConstraintViolationException ex) {
            JOptionPane.showMessageDialog(null, "Stock : " + prod_names1.getSelectedItem() + ", Raw Material ID - " + prodID1 + " , Location -" + location1 + "  is already added", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Something went wrong", "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void deleteStock() {

        //String tempID = emp_ID.getText();
        query = "DELETE FROM stockProduct WHERE stockID = '" + stockID + "' AND prodID = '" + prodID + "' AND location = '" + location + "'";
        query1 = "DELETE FROM notify_prod WHERE stockID = '" + stockID + "' AND prodID = '" + prodID + "' AND location = '" + location + "'";

        Connection conn = new ConnectorNew().ConnectorNew();
        
        try {

            stmt = conn.createStatement();
            stmt1 = conn.createStatement();

            if (stmt.executeUpdate(query) == 1) {

                stmt1.executeUpdate(query1);
                DefaultTableModel model = (DefaultTableModel) prod_table.getModel();
                model.setRowCount(0);
                showTable();
                clearAll();

                JOptionPane.showMessageDialog(null, "Stock for Product ID - " + prodID + ", Location - " + location + " has removed successfully", "Succeed", JOptionPane.INFORMATION_MESSAGE);
            }
            
            conn.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Something went wrong", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void deleteStock1() {

        //String tempID = emp_ID.getText();
        query = "DELETE FROM stockRaw WHERE stockID ='" + rawStkID + "'";
        query1 = "DELETE FROM notify_raw WHERE stockID = '" + stockID + "' AND rawID = '" + prodID + "' AND location = '" + location + "'";
        
        Connection conn = new ConnectorNew().ConnectorNew();
        
        try {

            stmt = conn.createStatement();
            stmt1 = conn.createStatement();

            if (stmt.executeUpdate(query) == 1) {
                
                stmt1.executeUpdate(query1);
                DefaultTableModel model = (DefaultTableModel) prod_table1.getModel();
                model.setRowCount(0);
                showTable1();
                clearAll1();

                JOptionPane.showMessageDialog(null, "Stock for Material ID - " + rawStkID + ", Location - " + location1 + " has removed successfully", "Succeed", JOptionPane.INFORMATION_MESSAGE);

            }
            
            conn.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Something went wrong", "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public stock() {
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        userleft.setBackground(new Color(0, 191, 255, 80));
        stock_prod_ID.setEnabled(false);
        stock_prod_ID1.setEnabled(false);
        stk_ID.setEnabled(false);
        btn_add.setEnabled(false);
        btn_add1.setEnabled(false);
        btn_update.setEnabled(false);
        stk_ID.setVisible(false);
        raw_ID.setVisible(false);
        clearAll();
        clearAll1();
        showTable();
        showTable1();
        fillLst();
        setStars();
        setStars1();
        //btn_add.setContentAreaFilled(false);
        initProductCount();
        initRawCount();
        initTableRecords();
        initRawTableRecords();
        syncTable();
        syncTable1();
        
        
    }

    public stock(String stockID, String prodID, String Name, String location, String unitCost, String qty, String expDate, String manufactDate, String sellPrice, String addedDate) {
        this.stockID = stockID;
        this.prodID = prodID;
        this.name = Name;
        this.qty = qty;
        this.location = location;
        this.unitCost = unitCost;
        this.expDate = expDate;
        this.manufactDate = manufactDate;
        this.sellPrice = sellPrice;
        this.addedDate = addedDate;

        //this.stockName = "Stock Name : " + name + " , ( Product ID : " + this.prodID + " ) is currently getting low";
    }

    public stock(String stockID, String prodID, String Name, String location, String qty, String unitCost, String expDate, String addedDate) {
        this.stockID1 = stockID;
        this.prodID1 = prodID;
        this.name1 = Name;
        this.qty1 = qty;
        this.location1 = location;
        this.unitCost1 = unitCost;
        this.expDate1 = expDate;
        this.addedDate1 = addedDate;
        //this.rawName = "Material Name : " + name + " , ( Material ID : " + this.prodID1 + " ) is currently getting low";

    }

    public ArrayList<stock> getProdList() {

        Connection conn = new ConnectorNew().ConnectorNew();
        ArrayList<stock> prodList = new ArrayList<stock>();
        conn = new ConnectorNew().ConnectorNew();
        query = "SELECT stpr.stockID, stpr.prodID, pr.Name, stpr.location, stpr.avl_qty, stpr.unitCost, stpr.exp_Date, stpr.manu_Date, stpr.sellPrice, stpr.added_Date\n"
                + "from product pr, stockProduct stpr\n"
                + "where pr.ProductID = stpr.prodID ORDER BY stockID asc";

        try {

            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            stock stPr;
            while (rs.next()) {
                stPr = new stock(
                        rs.getString("stockID"),
                        rs.getString("prodID"),
                        rs.getString("Name"),
                        rs.getString("location"),
                        rs.getString("avl_qty"),
                        rs.getString("unitCost"),
                        rs.getString("exp_Date"),
                        rs.getString("manu_Date"),
                        rs.getString("sellPrice"),
                        rs.getString("added_Date"));

                prodList.add(stPr);
            }
            
            conn.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Something went wrong", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return prodList;

    }

    public void showTable() {

        ArrayList<stock> list = getProdList();
        DefaultTableModel model = (DefaultTableModel) prod_table.getModel();
        Object[] row = new Object[10];

        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).stockID;
            row[1] = list.get(i).prodID;
            row[2] = list.get(i).name;
            row[3] = list.get(i).location;
            row[4] = list.get(i).unitCost;
            row[5] = list.get(i).qty;
            row[6] = list.get(i).expDate;
            row[7] = list.get(i).manufactDate;
            row[8] = list.get(i).sellPrice;
            row[9] = list.get(i).addedDate;

            model.addRow(row);

        }

    }

    public ArrayList<stock> getRawList() {

        Connection conn = new ConnectorNew().ConnectorNew();
        ArrayList<stock> rawList = new ArrayList<stock>();
        conn = new ConnectorNew().ConnectorNew();
        query = "SELECT str.stockID, str.rawID, rm.rawName, str.location, str.qty, str.unitCost, str.expDate, str.adDate\n"
                + "from raw_mat rm, stockRaw str\n"
                + "WHERE rm.rawID = str.rawID Order By stockID asc";

        try {

            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            stock stRaw;
            while (rs.next()) {
                stRaw = new stock(
                        rs.getString("stockID"),
                        rs.getString("rawID"),
                        rs.getString("rawName"),
                        rs.getString("location"),
                        rs.getString("qty"),
                        rs.getString("unitCost"),
                        rs.getString("expDate"),
                        rs.getString("adDate"));

                rawList.add(stRaw);
            }
            
            conn.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Something went wrong", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return rawList;

    }

    public void showTable1() {

        ArrayList<stock> list = getRawList();
        DefaultTableModel model = (DefaultTableModel) prod_table1.getModel();
        Object[] row = new Object[8];

        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).stockID1;
            row[1] = list.get(i).prodID1;
            row[2] = list.get(i).name1;
            row[3] = list.get(i).location1;
            row[4] = list.get(i).qty1;
            row[5] = list.get(i).unitCost1;
            row[6] = list.get(i).expDate1;
            row[7] = list.get(i).addedDate1;

            model.addRow(row);

        }
    }

    public ArrayList<stock> getsearchProdList() {

        Connection conn = new ConnectorNew().ConnectorNew();
        ArrayList<stock> searchProdList = new ArrayList<stock>();
        conn = new ConnectorNew().ConnectorNew();
        query = "SELECT stpr.stockID, stpr.prodID, pr.Name, stpr.location, stpr.avl_qty, stpr.unitCost, stpr.exp_Date, stpr.manu_Date, stpr.sellPrice, stpr.added_Date\n"
                + "from product pr, stockProduct stpr\n"
                + "where pr.ProductID = stpr.prodID AND (stockID like '" + prodSrch + "' OR prodID like '" + prodSrch + "' OR Name like '" + prodSrch + "' OR location like '" + prodSrch + "'"
                + "OR avl_qty like '" + prodSrch + "' OR unitCost like '" + prodSrch + "' OR exp_Date like '" + prodSrch + "' OR manu_Date like '" + prodSrch + "' OR sellPrice like '" + prodSrch + "' OR added_Date like '" + prodSrch + "')";

        try {

            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            stock stPr;
            while (rs.next()) {
                stPr = new stock(
                        rs.getString("stockID"),
                        rs.getString("prodID"),
                        rs.getString("Name"),
                        rs.getString("location"),
                        rs.getString("avl_qty"),
                        rs.getString("unitCost"),
                        rs.getString("exp_Date"),
                        rs.getString("manu_Date"),
                        rs.getString("sellPrice"),
                        rs.getString("added_Date"));

                searchProdList.add(stPr);
            }
            
            conn.close();

        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, "Something went wrong", "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return searchProdList;

    }

    public ArrayList<stock> getsearchRawList() {

        Connection conn = new ConnectorNew().ConnectorNew();
        ArrayList<stock> searchRawList = new ArrayList<stock>();
        conn = new ConnectorNew().ConnectorNew();
        query = "SELECT str.stockID, str.rawID, rm.rawName, str.location, str.qty, str.unitCost, str.expDate, str.adDate\n"
                + "from raw_mat rm, stockRaw str\n"
                + "WHERE rm.rawID = str.rawID AND (str.stockID like '" + rawSrch + "' OR str.rawID like '" + rawSrch + "' OR rm.rawName like '" + rawSrch + "' OR str.location like '" + rawSrch + "' OR"
                + " str.qty like '" + rawSrch + "' OR str.unitCost like '" + rawSrch + "' OR str.expDate like '" + rawSrch + "' OR str.adDate like '" + rawSrch + "')";

        try {

            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            stock stRaw;
            while (rs.next()) {
                stRaw = new stock(
                        rs.getString("stockID"),
                        rs.getString("rawID"),
                        rs.getString("rawName"),
                        rs.getString("location"),
                        rs.getString("qty"),
                        rs.getString("unitCost"),
                        rs.getString("expDate"),
                        rs.getString("adDate"));

                searchRawList.add(stRaw);
            }

            conn.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Something went wrong", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return searchRawList;

    }

    public void showSearch1() {

        ArrayList<stock> list = getsearchRawList();
        DefaultTableModel model = (DefaultTableModel) prod_table1.getModel();
        Object[] row = new Object[8];

        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).stockID1;
            row[1] = list.get(i).prodID1;
            row[2] = list.get(i).name1;
            row[3] = list.get(i).location1;
            row[4] = list.get(i).qty1;
            row[5] = list.get(i).unitCost1;
            row[6] = list.get(i).expDate1;
            row[7] = list.get(i).addedDate1;

            model.addRow(row);

        }

    }

    public void showSearch() {

        ArrayList<stock> list = getsearchProdList();
        DefaultTableModel model = (DefaultTableModel) prod_table.getModel();
        Object[] row = new Object[10];

        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).stockID;
            row[1] = list.get(i).prodID;
            row[2] = list.get(i).name;
            row[3] = list.get(i).location;
            row[4] = list.get(i).unitCost;
            row[5] = list.get(i).qty;
            row[6] = list.get(i).expDate;
            row[7] = list.get(i).manufactDate;
            row[8] = list.get(i).sellPrice;
            row[9] = list.get(i).addedDate;

            model.addRow(row);

        }

    }

    public void fillLst() {

        String query = "SELECT ProductID, Name from product";
        String query1 = "SELECT rawID, rawName from raw_mat";

        Connection conn = new ConnectorNew().ConnectorNew();
        
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);

            while (rs.next()) {

                String item = rs.getString("Name");
                prod_names.addItem(item);

            }

            stmt1 = conn.createStatement();
            rs1 = stmt1.executeQuery(query1);

            while (rs1.next()) {

                String item1 = rs1.getString("rawName");
                prod_names1.addItem(item1);

            }
            
            conn.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Something went wrong", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void resetList() {
        prod_names.setSelectedIndex(0);
    }

    public void resetList1() {
        prod_names1.setSelectedIndex(0);
    }

    public void resetDate(JXDatePicker date1) {
        Calendar cals = Calendar.getInstance();
        date1.setDate(cals.getTime());
    }

    public void fillPrID(String pr) {

        String query = "SELECT ProductID from product where Name = '" + pr + "'";
        Connection conn = new ConnectorNew().ConnectorNew();
        
        
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);

            while (rs.next()) {

                stock_prod_ID.setText(rs.getString("ProductID"));

            }
            
            conn.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Something went wrong", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void fillPrID1(String pr) {

        String query = "SELECT rawID from raw_mat where rawName = '" + pr + "'";

        Connection conn = new ConnectorNew().ConnectorNew();
        
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);

            while (rs.next()) {

                stock_prod_ID1.setText(rs.getString("rawID"));

            }
            
            conn.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Something went wrong", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void clear() {

        stock_prod_ID.setText("");
        prod_loc.setText("");
        prod_qty.setText("");
        prod_Price.setText("");
        prod_sale_price.setText("");
        resetDate(prod_manufact);
        resetDate(prod_expiry);
    }

    public void clear1() {
        //prID1.setText("");
        stock_prod_ID1.setText("");
        prod_loc1.setText("");
        prod_qty1.setText("");
        prod_Price1.setText("");
        //prod_sale_price1.setText("");
        //resetDate(prod_manufact);
        resetDate(prod_expiry1);
    }

    public void clearAll() {

        stock_prod_ID.setText("");
        resetList();
        prod_loc.setText("");
        prod_qty.setText("");
        prod_Price.setText("");
        prod_sale_price.setText("");
        resetDate(prod_manufact);
        resetDate(prod_expiry);
    }

    public void clearAll1() {
        //prID.setText("");
        stock_prod_ID1.setText("");
        resetList1();
        prod_loc1.setText("");
        prod_qty1.setText("");
        prod_Price1.setText("");
        raw_Search.setText("");
        //prod_sale_price.setText("");
        //resetDate(prod_manufact);
        resetDate(prod_expiry1);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        stock_prod_ID = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        prod_qty = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        prod_table = new javax.swing.JTable();
        raw_Search = new javax.swing.JTextField();
        prod_loc = new javax.swing.JTextField();
        prod_sale_price = new javax.swing.JTextField();
        prod_manufact = new org.jdesktop.swingx.JXDatePicker();
        jLabel17 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        prod_expiry = new org.jdesktop.swingx.JXDatePicker();
        jLabel18 = new javax.swing.JLabel();
        prod_Price = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        btn_add = new javax.swing.JButton();
        btn_update = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        prod_loc1 = new javax.swing.JTextField();
        stock_prod_ID1 = new javax.swing.JTextField();
        prod_qty1 = new javax.swing.JTextField();
        prod_Price1 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        prod_expiry1 = new org.jdesktop.swingx.JXDatePicker();
        jLabel21 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        prod_table1 = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        title1 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        prod_search = new javax.swing.JTextField();
        title2 = new javax.swing.JLabel();
        prod_names = new javax.swing.JComboBox<>();
        prod_names1 = new javax.swing.JComboBox<>();
        starLoc = new javax.swing.JLabel();
        starUnit = new javax.swing.JLabel();
        starManu = new javax.swing.JLabel();
        starQt = new javax.swing.JLabel();
        starSp = new javax.swing.JLabel();
        starEx = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        starLoc1 = new javax.swing.JLabel();
        raw_ID = new javax.swing.JTextField();
        starRawName = new javax.swing.JLabel();
        stk_ID = new javax.swing.JTextField();
        starQt1 = new javax.swing.JLabel();
        starRaw = new javax.swing.JLabel();
        starEx1 = new javax.swing.JLabel();
        starUnit1 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        btn_update1 = new javax.swing.JButton();
        btn_add1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        title = new javax.swing.JLabel();
        userleft = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        stock_prod_ID.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.blue, 2));
        stock_prod_ID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stock_prod_IDActionPerformed(evt);
            }
        });
        getContentPane().add(stock_prod_ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 160, 160, 30));

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel4.setForeground(java.awt.Color.white);
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Product ID");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 140, 160, -1));

        prod_qty.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.blue, 2));
        getContentPane().add(prod_qty, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 220, 160, 30));

        jLabel15.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel15.setForeground(java.awt.Color.white);
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Quantity");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 200, 160, -1));

        jLabel12.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel12.setForeground(java.awt.Color.white);
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Unit Price");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 260, 160, -1));

        prod_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "stockID", "prodID", "prodName", "location", "avlQty", "unitPrce", "expDate", "manuDate", "sellPrice", "addedDate"
            }
        ));
        prod_table.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        prod_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                prod_tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(prod_table);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 390, 420, 240));

        raw_Search.setForeground(new java.awt.Color(75, 0, 130));
        raw_Search.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        raw_Search.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(83, 43, 11), 2));
        getContentPane().add(raw_Search, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 90, 140, 30));

        prod_loc.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.blue, 2));
        prod_loc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prod_locActionPerformed(evt);
            }
        });
        getContentPane().add(prod_loc, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 220, 160, 30));

        prod_sale_price.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.blue, 2));
        getContentPane().add(prod_sale_price, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 280, 160, 30));

        prod_manufact.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.blue, 2));
        getContentPane().add(prod_manufact, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 340, 160, -1));

        jLabel17.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel17.setForeground(java.awt.Color.white);
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Manufact Date");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 320, 160, -1));

        jLabel16.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel16.setForeground(java.awt.Color.white);
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Sale Price");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 260, 160, -1));

        jLabel13.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel13.setForeground(java.awt.Color.white);
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Location");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 200, 160, -1));

        prod_expiry.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.blue, 2));
        getContentPane().add(prod_expiry, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 340, 160, -1));

        jLabel18.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel18.setForeground(java.awt.Color.white);
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Expiry Date");
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 320, 160, -1));

        prod_Price.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255), 2));
        getContentPane().add(prod_Price, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 280, 160, 30));

        jButton1.setBackground(java.awt.Color.blue);
        jButton1.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Show All");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.white, 2));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 90, 80, 30));

        btn_add.setBackground(java.awt.Color.blue);
        btn_add.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btn_add.setForeground(new java.awt.Color(255, 255, 255));
        btn_add.setText("Add");
        btn_add.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });
        getContentPane().add(btn_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 650, 90, 30));

        btn_update.setBackground(java.awt.Color.blue);
        btn_update.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btn_update.setForeground(new java.awt.Color(255, 255, 255));
        btn_update.setText("Update");
        btn_update.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });
        getContentPane().add(btn_update, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 650, 90, 30));

        jButton5.setBackground(java.awt.Color.blue);
        jButton5.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Remove");
        jButton5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 650, 90, 30));

        jLabel6.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel6.setForeground(java.awt.Color.white);
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Raw Material ID");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 140, 160, -1));

        jLabel14.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel14.setForeground(java.awt.Color.white);
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Location");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 200, 160, -1));

        prod_loc1.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.blue, 2));
        prod_loc1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prod_loc1ActionPerformed(evt);
            }
        });
        getContentPane().add(prod_loc1, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 220, 160, 30));

        stock_prod_ID1.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.blue, 2));
        stock_prod_ID1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stock_prod_ID1ActionPerformed(evt);
            }
        });
        getContentPane().add(stock_prod_ID1, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 160, 160, 30));

        prod_qty1.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.blue, 2));
        getContentPane().add(prod_qty1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 220, 160, 30));

        prod_Price1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255), 2));
        getContentPane().add(prod_Price1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 280, 160, 30));

        jLabel19.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel19.setForeground(java.awt.Color.white);
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Unit Price");
        getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 260, 160, -1));

        prod_expiry1.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.blue, 2));
        getContentPane().add(prod_expiry1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 340, 160, -1));

        jLabel21.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel21.setForeground(java.awt.Color.white);
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Expiry Date");
        getContentPane().add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 320, 160, -1));

        prod_table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "stockID", "matID", "matName", "location", "avlQty", "unitPrce", "expDate", "addedDate"
            }
        ));
        prod_table1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        prod_table1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                prod_table1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(prod_table1);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 390, 420, 240));

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator1.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        jSeparator1.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 60, 30, 630));

        title1.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        title1.setForeground(new java.awt.Color(255, 255, 255));
        title1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title1.setText("Raw Materials");
        getContentPane().add(title1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 50, 200, 30));

        jButton4.setBackground(java.awt.Color.blue);
        jButton4.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Show All");
        jButton4.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.white, 2));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 90, 80, 30));

        prod_search.setForeground(new java.awt.Color(75, 0, 130));
        prod_search.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        prod_search.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(83, 43, 11), 2));
        getContentPane().add(prod_search, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 90, 140, 30));

        title2.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        title2.setForeground(new java.awt.Color(255, 255, 255));
        title2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title2.setText("Product Items");
        getContentPane().add(title2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 50, 190, 30));

        prod_names.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None" }));
        prod_names.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.blue, 2));
        prod_names.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prod_namesActionPerformed(evt);
            }
        });
        getContentPane().add(prod_names, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 160, 160, 30));

        prod_names1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None" }));
        prod_names1.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.blue, 2));
        prod_names1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prod_names1ActionPerformed(evt);
            }
        });
        getContentPane().add(prod_names1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 160, 160, 30));

        starLoc.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        starLoc.setForeground(java.awt.Color.red);
        starLoc.setText("*");
        getContentPane().add(starLoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 190, 20, 60));

        starUnit.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        starUnit.setForeground(java.awt.Color.red);
        starUnit.setText("*");
        getContentPane().add(starUnit, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 250, 20, 60));

        starManu.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        starManu.setForeground(java.awt.Color.red);
        starManu.setText("*");
        getContentPane().add(starManu, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 310, 20, 60));

        starQt.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        starQt.setForeground(java.awt.Color.red);
        starQt.setText("*");
        getContentPane().add(starQt, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 190, 20, 60));

        starSp.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        starSp.setForeground(java.awt.Color.red);
        starSp.setText("*");
        getContentPane().add(starSp, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 250, 20, 60));

        starEx.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        starEx.setForeground(java.awt.Color.red);
        starEx.setText("*");
        getContentPane().add(starEx, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 310, 20, 60));

        jLabel20.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel20.setForeground(java.awt.Color.white);
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Raw Mat Name");
        getContentPane().add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 140, 160, -1));

        jLabel7.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel7.setForeground(java.awt.Color.white);
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Product Name");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 140, 160, -1));

        jButton2.setBackground(java.awt.Color.blue);
        jButton2.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Search");
        jButton2.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.white, 2));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 90, 80, 30));

        jLabel23.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel23.setForeground(java.awt.Color.white);
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("Quantity");
        getContentPane().add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 200, 160, -1));

        starLoc1.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        starLoc1.setForeground(java.awt.Color.red);
        starLoc1.setText("*");
        getContentPane().add(starLoc1, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 190, 20, 60));
        getContentPane().add(raw_ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 50, 70, -1));

        starRawName.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        starRawName.setForeground(java.awt.Color.red);
        starRawName.setText("*");
        getContentPane().add(starRawName, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 130, 20, 60));

        stk_ID.setEditable(false);
        getContentPane().add(stk_ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 30, 100, -1));

        starQt1.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        starQt1.setForeground(java.awt.Color.red);
        starQt1.setText("*");
        getContentPane().add(starQt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 190, 20, 60));

        starRaw.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        starRaw.setForeground(java.awt.Color.red);
        starRaw.setText("*");
        getContentPane().add(starRaw, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 130, 20, 60));

        starEx1.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        starEx1.setForeground(java.awt.Color.red);
        starEx1.setText("*");
        getContentPane().add(starEx1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 310, 20, 60));

        starUnit1.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        starUnit1.setForeground(java.awt.Color.red);
        starUnit1.setText("*");
        getContentPane().add(starUnit1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 250, 20, 60));

        jButton7.setBackground(java.awt.Color.blue);
        jButton7.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("Search");
        jButton7.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.white, 2));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 90, 80, 30));

        jButton8.setBackground(java.awt.Color.blue);
        jButton8.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setText("Clear");
        jButton8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 650, 90, 30));

        jButton9.setBackground(java.awt.Color.blue);
        jButton9.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jButton9.setForeground(new java.awt.Color(255, 255, 255));
        jButton9.setText("Remove");
        jButton9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 650, 90, 30));

        btn_update1.setBackground(java.awt.Color.blue);
        btn_update1.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btn_update1.setForeground(new java.awt.Color(255, 255, 255));
        btn_update1.setText("Update");
        btn_update1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        btn_update1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_update1ActionPerformed(evt);
            }
        });
        getContentPane().add(btn_update1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 650, 90, 30));

        btn_add1.setBackground(java.awt.Color.blue);
        btn_add1.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btn_add1.setForeground(new java.awt.Color(255, 255, 255));
        btn_add1.setText("Add");
        btn_add1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        btn_add1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_add1ActionPerformed(evt);
            }
        });
        getContentPane().add(btn_add1, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 650, 90, 30));

        jButton3.setBackground(java.awt.Color.blue);
        jButton3.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Raw Materials");
        jButton3.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.white, 2));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 30, 90, 30));

        jButton6.setBackground(java.awt.Color.blue);
        jButton6.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Clear");
        jButton6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 650, 90, 30));

        title.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        title.setForeground(new java.awt.Color(255, 255, 255));
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("Stock Management");
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
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/stock2.png"))); // NOI18N
        userleft.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 300, 110));

        getContentPane().add(userleft, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 720));

        jButton10.setText("DEMO");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 80, -1, -1));

        jButton11.setText("DEMO");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 80, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/gray2.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-1, 0, 1390, -1));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/gray2.png"))); // NOI18N
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(-1, 0, 1390, -1));

        setSize(new java.awt.Dimension(1382, 759));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed

        clearAll();

    }//GEN-LAST:event_jButton6ActionPerformed

    private void prod_locActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prod_locActionPerformed
        // TODO add your handzing code here:
    }//GEN-LAST:event_prod_locActionPerformed

    private void prod_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_prod_tableMouseClicked

        resetList();
        prod_loc.setEnabled(false);
        int i = prod_table.getSelectedRow();
        TableModel model = prod_table.getModel();
        //prID.setText(model.getValueAt(i, 0).toString());
        stk_ID.setText(model.getValueAt(i, 0).toString());
        stock_prod_ID.setText(model.getValueAt(i, 1).toString());
        prod_loc.setText(model.getValueAt(i, 3).toString());
        prod_qty.setText(model.getValueAt(i, 4).toString());
        prod_Price.setText(model.getValueAt(i, 5).toString());

        String dateMan = model.getValueAt(i, 7).toString();
        Date date1 = Date.valueOf(dateMan);
        prod_manufact.setDate(date1);

        String dateExp = model.getValueAt(i, 6).toString();
        Date date2 = Date.valueOf(dateExp);
        prod_expiry.setDate(date2);

        prod_sale_price.setText(model.getValueAt(i, 8).toString());


    }//GEN-LAST:event_prod_tableMouseClicked

    private void prod_loc1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prod_loc1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_prod_loc1ActionPerformed

    private void stock_prod_ID1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stock_prod_ID1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stock_prod_ID1ActionPerformed

    private void prod_table1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_prod_table1MouseClicked

        resetList1();
        int i = prod_table1.getSelectedRow();
        TableModel model = prod_table1.getModel();
        raw_ID.setText(model.getValueAt(i, 0).toString());
        stock_prod_ID1.setText(model.getValueAt(i, 1).toString());
        prod_loc1.setText(model.getValueAt(i, 3).toString());
        prod_qty1.setText(model.getValueAt(i, 4).toString());
        prod_Price1.setText(model.getValueAt(i, 5).toString());

        String dateExp = model.getValueAt(i, 6).toString();
        Date date2 = Date.valueOf(dateExp);
        prod_expiry1.setDate(date2);


    }//GEN-LAST:event_prod_table1MouseClicked

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        clearAll1();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void stock_prod_IDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stock_prod_IDActionPerformed

    }//GEN-LAST:event_stock_prod_IDActionPerformed

    private void prod_namesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prod_namesActionPerformed

        prod_loc.setEnabled(true);
        if (!(prod_names.getSelectedItem().equals("None"))) {
            clear();
            btn_update.setEnabled(false);
            btn_add.setEnabled(true);
            fillPrID(prod_names.getSelectedItem().toString());
        } else {
            stock_prod_ID.setText("");
            btn_add.setEnabled(false);
            btn_update.setEnabled(true);
        }

    }//GEN-LAST:event_prod_namesActionPerformed

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed

        fullValidate();
        if (sum >= 10) {
            initialize();
            insert();
        }

        sum = 0;
    }//GEN-LAST:event_btn_addActionPerformed


    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed

        if (stk_ID.equals(null) || stk_ID.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "No stock record has been selected to Update", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            initialize();
            fullValidate();
            if (sum >= 10) {
                 update();
            }
            sum = 0;
        }
    }//GEN-LAST:event_btn_updateActionPerformed


    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        if (stk_ID.equals(null) || stk_ID.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "No stock record has been selected to Remove", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            initialize();
            deleteStockItem();

        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void deleteStockItem() {
        query = "DELETE FROM stockProduct WHERE stockID = '" + stockID + "'";
        Connection conn = new ConnectorNew().ConnectorNew();
        
        
        try {

            stmt = conn.createStatement();

            if (stmt.executeUpdate(query) > 0) {

                DefaultTableModel model = (DefaultTableModel) prod_table.getModel();
                model.setRowCount(0);
                showTable();
                clearAll();

                JOptionPane.showMessageDialog(null, "Stock for Product ID - " + prodID + ", Location - " + location + " has removed successfully", "Succeed", JOptionPane.INFORMATION_MESSAGE);
            }
            
            conn.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Something went wrong", "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }


    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed

        if (prod_search.getText().equals("")) {

            JOptionPane.showMessageDialog(null, "No Search Parameter found", "Error", JOptionPane.ERROR_MESSAGE);

        } else {

            initialize();
            DefaultTableModel model = (DefaultTableModel) prod_table.getModel();
            model.setRowCount(0);
            showSearch();
        }


    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        DefaultTableModel model = (DefaultTableModel) prod_table.getModel();
        model.setRowCount(0);
        showTable();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void prod_names1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prod_names1ActionPerformed

        if (!(prod_names1.getSelectedItem().equals("None"))) {
            clear1();
            btn_update1.setEnabled(false);
            btn_add1.setEnabled(true);
            fillPrID1(prod_names1.getSelectedItem().toString());
        } else {
            stock_prod_ID1.setText("");
            btn_add1.setEnabled(false);
            btn_update1.setEnabled(true);
        }
    }//GEN-LAST:event_prod_names1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (raw_Search.getText().equals("") || raw_Search.getText() == null) {

            JOptionPane.showMessageDialog(null, "No Search Parameter found", "Error", JOptionPane.ERROR_MESSAGE);

        } else {

            //initialize();
            rawSrch = "%" + getString(raw_Search) + "%";
            DefaultTableModel model = (DefaultTableModel) prod_table1.getModel();
            model.setRowCount(0);
            raw_Search.setText("");
            showSearch1();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        DefaultTableModel model = (DefaultTableModel) prod_table1.getModel();
        model.setRowCount(0);
        showTable1();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btn_update1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_update1ActionPerformed

        if (raw_ID.equals(null) || raw_ID.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "No Material record has been selected to Update", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            fullValidate1();

            if (sum >= 6) {
                initialize1();
                update1();
            }

            sum = 0;

        }

    }//GEN-LAST:event_btn_update1ActionPerformed


    private void btn_add1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_add1ActionPerformed
        fullValidate1();

        if (sum >= 6) {
            initialize1();
            insert1();
        }

        sum = 0;
    }//GEN-LAST:event_btn_add1ActionPerformed


    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        if (raw_ID.equals(null) || raw_ID.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "No Material Stock record has been selected to Remove", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            initialize1();
            deleteStock1();
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        new RawMaterial().setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        prod_loc.setText("Nugegoda");
        prod_qty.setText("100");
        prod_sale_price.setText("250");
        prod_Price.setText("50");
        String dateString = "2019-08-01";
        Date date = Date.valueOf(dateString);
        prod_expiry.setDate(date);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        prod_loc1.setText("Nugegoda");
        prod_qty1.setText("100");
        prod_Price1.setText("250");
        String dateString = "2019-08-01";
        Date date = Date.valueOf(dateString);
        prod_expiry1.setDate(date);
    }//GEN-LAST:event_jButton11ActionPerformed

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
            java.util.logging.Logger.getLogger(stock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(stock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(stock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(stock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new stock().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_add1;
    private javax.swing.JButton btn_update;
    private javax.swing.JButton btn_update1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField prod_Price;
    private javax.swing.JTextField prod_Price1;
    private org.jdesktop.swingx.JXDatePicker prod_expiry;
    private org.jdesktop.swingx.JXDatePicker prod_expiry1;
    private javax.swing.JTextField prod_loc;
    private javax.swing.JTextField prod_loc1;
    private org.jdesktop.swingx.JXDatePicker prod_manufact;
    private javax.swing.JComboBox<String> prod_names;
    private javax.swing.JComboBox<String> prod_names1;
    private javax.swing.JTextField prod_qty;
    private javax.swing.JTextField prod_qty1;
    private javax.swing.JTextField prod_sale_price;
    private javax.swing.JTextField prod_search;
    private javax.swing.JTable prod_table;
    private javax.swing.JTable prod_table1;
    private javax.swing.JTextField raw_ID;
    private javax.swing.JTextField raw_Search;
    private javax.swing.JLabel starEx;
    private javax.swing.JLabel starEx1;
    private javax.swing.JLabel starLoc;
    private javax.swing.JLabel starLoc1;
    private javax.swing.JLabel starManu;
    private javax.swing.JLabel starQt;
    private javax.swing.JLabel starQt1;
    private javax.swing.JLabel starRaw;
    private javax.swing.JLabel starRawName;
    private javax.swing.JLabel starSp;
    private javax.swing.JLabel starUnit;
    private javax.swing.JLabel starUnit1;
    private javax.swing.JTextField stk_ID;
    private javax.swing.JTextField stock_prod_ID;
    private javax.swing.JTextField stock_prod_ID1;
    private javax.swing.JLabel title;
    private javax.swing.JLabel title1;
    private javax.swing.JLabel title2;
    private javax.swing.JPanel userleft;
    // End of variables declaration//GEN-END:variables
}
