/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package salary;

import connection.ConnectorNew;
import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import stock.stock;

/**
 *
 * @author Sahan Jayawardena
 */
public class salary extends javax.swing.JFrame {

    String salID, empID, fname, lname, nic, all, ded, epf, etf, epfRate, etfRate, leaves, netSal, calcSal, mnth, addDate;
    String empID11, fname1, lname1, nic1;

    boolean clicked = false;

    int sum = 0;

    Connection conn = new ConnectorNew().ConnectorNew();
    String query;
    String query1;
    String query2;
    String query3;
    Statement stmt = null;
    Statement stmt1 = null;
    Statement stmt2 = null;
    Statement stmt3 = null;
    ResultSet rs = null;
    ResultSet rs1 = null;
    ResultSet rs2 = null;
    ResultSet rs3 = null;

    /**
     * Creates new form salary
     */
    public salary() {
        initComponents();
        userleft.setBackground(new Color(124, 252, 0, 80));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        empID1.setEnabled(false);
        btn_add.setEnabled(false);
        sal_epf.setEnabled(false);
        sal_etf.setEnabled(false);
        sal_calc.setEnabled(false);
        sal_mnth.setEnabled(false);
        empID1.setVisible(false);
        txt_salID.setVisible(false);
        setStars();
        fillLst();
        showTable();
        showTable1();
    }

    public void initialize() {
        salID = getString(txt_salID);
        empID = getString(empID1);
        all = getString(sal_all);
        ded = getString(sal_ded);
        epf = getString(sal_epf);
        etf = getString(sal_etf);
        epfRate = getString(sal_epfr);
        etfRate = getString(sal_etfr);
        leaves = getString(sal_leaves);
        netSal = getString(sal_net);
        calcSal = getString(sal_calc);
        mnth = getMonth();

    }

    public void fullValidate() {

        if (strValidate(sal_all) == 0) {
            sum += 1;
            starAll.setVisible(false);
        } else {
            starAll.setVisible(true);
        }

        if (strValidate(sal_leaves) == 0) {
            sum += 1;
            starLeave.setVisible(false);
        } else {
            starLeave.setVisible(true);
        }

        if (strValidate(sal_ded) == 0) {
            sum += 1;
            starDed.setVisible(false);
        } else {
            starDed.setVisible(true);
        }

        if (strValidate(sal_net) == 0) {
            sum += 1;
            starnetSal.setVisible(false);
        } else {
            starnetSal.setVisible(true);
        }

        if (strValidate(sal_epfr) == 0) {
            sum += 1;
            starEpf.setVisible(false);
        } else {
            starEpf.setVisible(true);
        }

        if (strValidate(sal_etfr) == 0) {
            sum += 1;
            starEtf.setVisible(false);
        } else {
            starEtf.setVisible(true);
        }

        if (sum == 6) {

            if (floatValidate(sal_all) == 0) {
                sum += 1;
                starAll.setVisible(false);

                if (numValidate(sal_leaves) == 0) {
                    sum += 1;
                    starLeave.setVisible(false);

                    if (floatValidate(sal_ded) == 0) {
                        sum += 1;
                        starDed.setVisible(false);

                        if (floatValidate(sal_net) == 0) {
                            sum += 1;
                            starnetSal.setVisible(false);

                            if (floatValidate(sal_epfr) == 0) {
                                sum += 1;
                                starEpf.setVisible(false);

                                if (floatValidate(sal_etfr) == 0) {
                                    sum += 1;
                                    starEtf.setVisible(false);

                                    if (sal_mnth.getSelectedIndex() == 0) {
                                        starMnth.setVisible(true);
                                        JOptionPane.showMessageDialog(null, "Month is not selected", "Error", JOptionPane.ERROR_MESSAGE);
                                    } else {
                                        sum += 1;
                                        starMnth.setVisible(false);

                                        if (floatValidate(sal_epf) == 0) {
                                            sum += 1;
                                            starCalc.setVisible(false);
                                        } else {
                                            starCalc.setVisible(true);
                                            JOptionPane.showMessageDialog(null, "Press Calculate Salary Button for the salary calculation", "Error", JOptionPane.ERROR_MESSAGE);
                                        }
                                    }

                                } else {
                                    starEtf.setVisible(true);
                                    JOptionPane.showMessageDialog(null, "Invalid ETF rate", "Error", JOptionPane.ERROR_MESSAGE);
                                }

                            } else {
                                starEpf.setVisible(true);
                                JOptionPane.showMessageDialog(null, "Invalid EPF rate", "Error", JOptionPane.ERROR_MESSAGE);
                            }

                        } else {
                            starnetSal.setVisible(true);
                            JOptionPane.showMessageDialog(null, "Invalid number for Net Salary", "Error", JOptionPane.ERROR_MESSAGE);
                        }

                    } else {
                        starDed.setVisible(true);
                        JOptionPane.showMessageDialog(null, "Invalid number for Deductions", "Error", JOptionPane.ERROR_MESSAGE);
                    }

                } else {
                    starLeave.setVisible(true);
                    JOptionPane.showMessageDialog(null, "Invalid number of leaves", "Error", JOptionPane.ERROR_MESSAGE);
                }

            } else {
                starAll.setVisible(true);
                JOptionPane.showMessageDialog(null, "Invalid Allowance", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Some of the fields need to be filled", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void fullValidate1() {

        if (strValidate(sal_all) == 0) {
            sum += 1;
            starAll.setVisible(false);
        } else {
            starAll.setVisible(true);
        }

        if (strValidate(sal_leaves) == 0) {
            sum += 1;
            starLeave.setVisible(false);
        } else {
            starLeave.setVisible(true);
        }

        if (strValidate(sal_ded) == 0) {
            sum += 1;
            starDed.setVisible(false);
        } else {
            starDed.setVisible(true);
        }

        if (strValidate(sal_net) == 0) {
            sum += 1;
            starnetSal.setVisible(false);
        } else {
            starnetSal.setVisible(true);
        }

        if (strValidate(sal_epfr) == 0) {
            sum += 1;
            starEpf.setVisible(false);
        } else {
            starEpf.setVisible(true);
        }

        if (strValidate(sal_etfr) == 0) {
            sum += 1;
            starEtf.setVisible(false);
        } else {
            starEtf.setVisible(true);
        }

        if (sum == 6) {

            if (floatValidate(sal_all) == 0) {
                sum += 1;
                starAll.setVisible(false);

                if (numValidate(sal_leaves) == 0) {
                    sum += 1;
                    starLeave.setVisible(false);

                    if (floatValidate(sal_ded) == 0) {
                        sum += 1;
                        starDed.setVisible(false);

                        if (floatValidate(sal_net) == 0) {
                            sum += 1;
                            starnetSal.setVisible(false);

                            if (floatValidate(sal_epfr) == 0) {
                                sum += 1;
                                starEpf.setVisible(false);

                                if (floatValidate(sal_etfr) == 0) {
                                    sum += 1;
                                    starEtf.setVisible(false);

                                    if (floatValidate(sal_epf) == 0) {
                                        sum += 1;
                                        starCalc.setVisible(false);
                                    } else {
                                        starCalc.setVisible(true);
                                        JOptionPane.showMessageDialog(null, "Press Calculate Salary Button for the salary calculation", "Error", JOptionPane.ERROR_MESSAGE);
                                    }

                                } else {
                                    starEtf.setVisible(true);
                                    JOptionPane.showMessageDialog(null, "Invalid ETF rate", "Error", JOptionPane.ERROR_MESSAGE);
                                }

                            } else {
                                starEpf.setVisible(true);
                                JOptionPane.showMessageDialog(null, "Invalid EPF rate", "Error", JOptionPane.ERROR_MESSAGE);
                            }

                        } else {
                            starnetSal.setVisible(true);
                            JOptionPane.showMessageDialog(null, "Invalid number for Net Salary", "Error", JOptionPane.ERROR_MESSAGE);
                        }

                    } else {
                        starDed.setVisible(true);
                        JOptionPane.showMessageDialog(null, "Invalid number for Deductions", "Error", JOptionPane.ERROR_MESSAGE);
                    }

                } else {
                    starLeave.setVisible(true);
                    JOptionPane.showMessageDialog(null, "Invalid number of leaves", "Error", JOptionPane.ERROR_MESSAGE);
                }

            } else {
                starAll.setVisible(true);
                JOptionPane.showMessageDialog(null, "Invalid Allowance", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Some of the fields need to be filled", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void setStars() {
        starAll.setVisible(false);
        starLeave.setVisible(false);
        starDed.setVisible(false);
        starnetSal.setVisible(false);
        starEpf.setVisible(false);
        starMnth.setVisible(false);
        starEtf.setVisible(false);
        starCalc.setVisible(false);
    }

    public int floatValidate(JTextField num) {
        try {
            Double.parseDouble(num.getText());
            if (Double.valueOf(num.getText()) > 0) {
                return 0;
            } else {
                return -1;
            }

        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public int numValidate(JTextField num) {
        try {
            Integer.parseInt(num.getText());
            if (Integer.valueOf(num.getText()) > 0) {
                return 0;
            } else {
                return -1;
            }

        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public int strValidate(JTextField textName) {
        if (textName.getText().equals(null) || textName.getText().equals("") || textName.getText().isEmpty() == true) {
            textName.setText("");
            return -1;
        } else {
            return 0;
        }
    }

    public salary(String salID, String empID, String fname, String lname, String nic, String all, String ded, String epf, String etf, String epfRate, String etfRate, String leaves, String netSal, String calcSal, String mnth, String addDate) {

        this.salID = salID;
        this.empID = empID;
        this.fname = fname;
        this.lname = lname;
        this.nic = nic;
        this.all = all;
        this.ded = ded;
        this.epf = epf;
        this.etf = etf;
        this.epfRate = epfRate;
        this.etfRate = etfRate;
        this.leaves = leaves;
        this.netSal = netSal;
        this.calcSal = calcSal;
        this.mnth = mnth;
        this.addDate = addDate;

    }

    public salary(String empID11, String fname1, String lname1, String nic1) {
        this.empID11 = empID11;
        this.fname1 = fname1;
        this.lname1 = lname1;
        this.nic1 = nic1;
    }

    public String getString(JTextField textName) {
        return textName.getText();
    }

    public void resetList() {
        emp_selName.setSelectedIndex(0);
    }

    public void resetList1() {
        sal_mnth.setSelectedIndex(0);
    }

    public void fillLst() {

        query = "SELECT * from employee";
        //String query1 =  "SELECT rawID, rawName from raw_mat";

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);

            while (rs.next()) {

                String item = rs.getString("nic");

                emp_selName.addItem(item);

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Something went wrong", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void fillPrID(String pr) {

        String query = "SELECT * from employee where nic = '" + pr + "'";

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);

            while (rs.next()) {

                empID1.setText(rs.getString("EmployeeID"));

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Something went wrong", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void selectMonth(String month) {

        int index = 0;

        if (month.equals("January")) {
            index = 1;
        } else if (month.equals("February")) {
            index = 2;
        } else if (month.equals("March")) {
            index = 3;
        } else if (month.equals("April")) {
            index = 4;
        } else if (month.equals("May")) {
            index = 5;
        } else if (month.equals("June")) {
            index = 6;
        } else if (month.equals("July")) {
            index = 7;
        } else if (month.equals("August")) {
            index = 8;
        } else if (month.equals("September")) {
            index = 9;
        } else if (month.equals("October")) {
            index = 10;
        } else if (month.equals("November")) {
            index = 11;
        } else if (month.equals("December")) {
            index = 12;
        } else {
            index = 0;
        }

        sal_mnth.setSelectedIndex(index);

    }

    public String getMonth() {

        int index = sal_mnth.getSelectedIndex();
        //txt_test.setText(String.valueOf(index));
        String mnth = "";

        if (index == 1) {
            mnth = "January";

        } else if (index == 2) {
            mnth = "February";
        } else if (index == 3) {
            mnth = "March";
        } else if (index == 4) {
            mnth = "April";
        } else if (index == 5) {
            mnth = "May";
        } else if (index == 6) {
            mnth = "June";
        } else if (index == 7) {
            mnth = "July";
        } else if (index == 8) {
            mnth = "August";
        } else if (index == 9) {
            mnth = "September";
        } else if (index == 10) {
            mnth = "October";
        } else if (index == 11) {
            mnth = "November";
        } else if (index == 12) {
            mnth = "December";
        } else {
            mnth = "None";
        }

        return mnth;

    }

    public void clear() {

        sal_all.setText("");
        sal_epf.setText("");
        sal_etf.setText("");
        sal_leaves.setText("");
        sal_ded.setText("");
        sal_epfr.setText("");
        sal_etfr.setText("");
        sal_net.setText("");
        sal_calc.setText("");
        txt_salID.setText("");
        resetList1();
    }

    public void clearAll() {

        sal_all.setText("");
        sal_epf.setText("");
        sal_etf.setText("");
        sal_leaves.setText("");
        sal_ded.setText("");
        sal_epfr.setText("");
        sal_etfr.setText("");
        sal_net.setText("");
        sal_calc.setText("");
        txt_salID.setText("");
        resetList();
        resetList1();
    }

    public void calculateSalary() {

        double netSal = Double.parseDouble(sal_net.getText());
        double epfRate = Double.parseDouble(sal_epfr.getText());
        double etfRate = Double.parseDouble(sal_etfr.getText());
        double allow = Double.parseDouble(sal_all.getText());
        double deduct = Double.parseDouble(sal_ded.getText());

        double epf = netSal * (epfRate / 100.0);
        double etf = netSal * (etfRate / 100.0);

        double calcSal = (netSal + allow - deduct) - epf;

        sal_calc.setText(String.valueOf(calcSal));
        sal_epf.setText(String.valueOf(epf));
        sal_etf.setText(String.valueOf(etf));

    }

    public void insert() {

        int count = 0;
        conn = new ConnectorNew().ConnectorNew();
        query = "select count(*) from salary where EmployeeID = '" + empID + "' AND month = '" + mnth + "'";

        try {

            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                count = rs.getInt("count(*)");
            }

            if (count == 0) {
                query1 = "INSERT INTO salary (EmployeeID, Allowance, Deduction, Epf, Etf, epfRate, etfRate, "
                        + "Leaves, netSalary, calculatedSalary, month, Date)"
                        + "VALUES ('" + empID + "','" + all + "','" + ded + "','" + epf + "',"
                        + "'" + etf + "','" + epfRate + "','" + etfRate + "','" + leaves + "','" + netSal + "','" + calcSal + "',"
                        + "'" + mnth + "',NOW())";

                if (stmt.executeUpdate(query1) == 1) {
                    DefaultTableModel model = (DefaultTableModel) sal_table.getModel();
                    model.setRowCount(0);
                    showTable();
                    clearAll();
                    JOptionPane.showMessageDialog(null, "Salary added successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Salary for Employee ID - " + empID + " is already added for the month of " + mnth + " .", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Something went wrong", "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void update() {

        query = "UPDATE salary SET Allowance='" + all + "', Deduction='" + ded + "', Epf='" + epf + "',"
                + "Etf='" + etf + "',epfRate='" + epfRate + "', etfRate='" + etfRate + "',"
                + "Leaves='" + leaves + "',netSalary='" + netSal + "',"
                + "calculatedSalary='" + calcSal + "' WHERE SalaryID = '" + salID + "' AND month = '" + mnth + "'";

        //String query1 = " INSERT INTO notify_prod(prodID, description, adDate) VALUES ('"+prodID+"', '"+stockName+"', NOW() ) ";
        try {

            stmt = conn.createStatement();
            if (stmt.executeUpdate(query) == 1) {
                DefaultTableModel model = (DefaultTableModel) sal_table.getModel();
                model.setRowCount(0);
                showTable();
                clearAll();
                JOptionPane.showMessageDialog(null, "Salary Updated Successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (SQLIntegrityConstraintViolationException ex) {
            //JOptionPane.showMessageDialog(null, "Stock : " +prod_names.getSelectedItem()+ ", Product ID - " + stock_prod_ID.getText() + " is already added", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Something went wrong", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void deleteSalary() {

        //String tempID = emp_ID.getText();
        query = "DELETE FROM salary WHERE SalaryID = '" + salID + "' AND month = '" + mnth + "' ";

        try {

            stmt = conn.createStatement();

            if (stmt.executeUpdate(query) == 1) {
                DefaultTableModel model = (DefaultTableModel) sal_table.getModel();
                model.setRowCount(0);
                showTable();
                clearAll();

                JOptionPane.showMessageDialog(null, "Salary record has removed successfully", "Succeed", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Something went wrong", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public ArrayList<salary> getSalList() {

        ArrayList<salary> salList = new ArrayList<salary>();
        conn = new ConnectorNew().ConnectorNew();
        query = "SELECT sal.SalaryID, em.EmployeeID, em.Firstname, em.Lastname, em.nic, sal.Allowance, sal.Deduction, sal.Epf, sal.Etf, sal.epfRate, sal.etfRate, sal.Leaves, sal.netSalary, sal.calculatedSalary, sal.month, sal.Date\n"
                + "from employee em, salary sal\n"
                + "where em.EmployeeID = sal.EmployeeID";

        try {

            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            salary stPr;
            while (rs.next()) {
                stPr = new salary(
                        rs.getString("salaryID"),
                        rs.getString("EmployeeID"),
                        rs.getString("Firstname"),
                        rs.getString("Lastname"),
                        rs.getString("nic"),
                        rs.getString("Allowance"),
                        rs.getString("Deduction"),
                        rs.getString("Epf"),
                        rs.getString("Etf"),
                        rs.getString("epfRate"),
                        rs.getString("etfRate"),
                        rs.getString("Leaves"),
                        rs.getString("netSalary"),
                        rs.getString("calculatedSalary"),
                        rs.getString("month"),
                        rs.getString("Date"));

                salList.add(stPr);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Something went wrong", "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return salList;

    }

    public void showTable() {

        ArrayList<salary> list = getSalList();
        DefaultTableModel model = (DefaultTableModel) sal_table.getModel();
        Object[] row = new Object[16];

        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).salID;
            row[1] = list.get(i).empID;
            row[2] = list.get(i).fname;
            row[3] = list.get(i).lname;
            row[4] = list.get(i).nic;
            row[5] = list.get(i).all;
            row[6] = list.get(i).ded;
            row[7] = list.get(i).epf;
            row[8] = list.get(i).etf;
            row[9] = list.get(i).epfRate;
            row[10] = list.get(i).etfRate;
            row[11] = list.get(i).leaves;
            row[12] = list.get(i).netSal;
            row[13] = list.get(i).calcSal;
            row[14] = list.get(i).mnth;
            row[15] = list.get(i).addDate;

            model.addRow(row);

        }

    }

    public ArrayList<salary> getEmpList() {

        ArrayList<salary> empList = new ArrayList<salary>();
        conn = new ConnectorNew().ConnectorNew();
        query = "select * from employee";

        try {

            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            salary stPr;
            while (rs.next()) {
                stPr = new salary(
                        rs.getString("EmployeeID"),
                        rs.getString("Firstname"),
                        rs.getString("Lastname"),
                        rs.getString("nic"));

                empList.add(stPr);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Something went wrong", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return empList;

    }

    public void showTable1() {

        ArrayList<salary> list = getEmpList();
        DefaultTableModel model = (DefaultTableModel) empTable.getModel();
        Object[] row = new Object[16];

        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).empID11;
            row[1] = list.get(i).fname1;
            row[2] = list.get(i).lname1;
            row[3] = list.get(i).nic1;

            model.addRow(row);

        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        title = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        sal_table = new javax.swing.JTable();
        btn_add = new javax.swing.JButton();
        btn_update = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        sal_net = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        sal_ded = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        sal_leaves = new javax.swing.JTextField();
        sal_epfr = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        sal_epf = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        btnCalc = new javax.swing.JButton();
        emp_selName = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        sal_calc = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        empID1 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        empTable = new javax.swing.JTable();
        sal_etfr = new javax.swing.JTextField();
        sal_mnth = new javax.swing.JComboBox<>();
        starAll = new javax.swing.JLabel();
        starLeave = new javax.swing.JLabel();
        starDed = new javax.swing.JLabel();
        starnetSal = new javax.swing.JLabel();
        starEpf = new javax.swing.JLabel();
        starMnth = new javax.swing.JLabel();
        starCalc = new javax.swing.JLabel();
        starEtf = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txt_salID = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        sal_etf = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        sal_all = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        userleft = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        title.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        title.setForeground(new java.awt.Color(255, 255, 255));
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("Salary Management");
        getContentPane().add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, 1070, 70));

        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 179, 0), 2));
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 60, 140, 30));

        jButton1.setBackground(new java.awt.Color(0, 179, 0));
        jButton1.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Search");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.white, 2));
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1260, 60, 80, 30));

        sal_table.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(63, 63, 63), 2));
        sal_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "salID", "empID", "empFname", "empLname", "empNic", "allowance", "deduction", "epf", "etf", "epfRate", "etfRate", "leaves", "netSal", "calcSal", "month", "addedDate"
            }
        ));
        sal_table.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        sal_table.setPreferredSize(new java.awt.Dimension(1000, 1000));
        sal_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sal_tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(sal_table);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 120, 420, 260));

        btn_add.setBackground(new java.awt.Color(0, 179, 0));
        btn_add.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btn_add.setForeground(new java.awt.Color(255, 255, 255));
        btn_add.setText("Add");
        btn_add.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.white, 2));
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });
        getContentPane().add(btn_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 630, 90, 30));

        btn_update.setBackground(new java.awt.Color(0, 179, 0));
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

        jButton9.setBackground(new java.awt.Color(0, 179, 0));
        jButton9.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jButton9.setForeground(new java.awt.Color(255, 255, 255));
        jButton9.setText("Remove");
        jButton9.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.white, 2));
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 630, 90, 30));

        jButton10.setBackground(new java.awt.Color(0, 179, 0));
        jButton10.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jButton10.setForeground(new java.awt.Color(255, 255, 255));
        jButton10.setText("Clear");
        jButton10.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.white, 2));
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 630, 90, 30));

        sal_net.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 179, 0), 2));
        sal_net.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                sal_netFocusGained(evt);
            }
        });
        sal_net.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sal_netActionPerformed(evt);
            }
        });
        getContentPane().add(sal_net, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 390, 160, 30));

        jLabel17.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel17.setForeground(java.awt.Color.white);
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Net Salary");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 370, 160, -1));

        sal_ded.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 179, 0), 2));
        sal_ded.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                sal_dedFocusGained(evt);
            }
        });
        getContentPane().add(sal_ded, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 310, 160, 30));

        jLabel13.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel13.setForeground(java.awt.Color.white);
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Deductions");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 290, 160, -1));

        sal_leaves.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 179, 0), 2));
        sal_leaves.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sal_leavesActionPerformed(evt);
            }
        });
        getContentPane().add(sal_leaves, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 310, 160, 30));

        sal_epfr.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 179, 0), 2));
        sal_epfr.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                sal_epfrFocusGained(evt);
            }
        });
        getContentPane().add(sal_epfr, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 390, 80, 30));

        jLabel16.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel16.setForeground(java.awt.Color.white);
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("EPF Rate");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 370, 80, -1));

        sal_epf.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 179, 0), 2));
        getContentPane().add(sal_epf, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 230, 160, 30));

        jLabel19.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel19.setForeground(java.awt.Color.white);
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("ETF Rate");
        getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 370, 80, -1));

        btnCalc.setBackground(java.awt.Color.green);
        btnCalc.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnCalc.setForeground(new java.awt.Color(255, 255, 255));
        btnCalc.setText("Calculate Salary");
        btnCalc.setBorder(new javax.swing.border.LineBorder(java.awt.Color.white, 2, true));
        btnCalc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcActionPerformed(evt);
            }
        });
        getContentPane().add(btnCalc, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 550, 140, 30));

        emp_selName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None" }));
        emp_selName.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.green, 2));
        emp_selName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emp_selNameActionPerformed(evt);
            }
        });
        getContentPane().add(emp_selName, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 150, 160, 30));

        jLabel7.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel7.setForeground(java.awt.Color.white);
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Employee");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 130, 160, -1));

        sal_calc.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 179, 0), 2));
        sal_calc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sal_calcActionPerformed(evt);
            }
        });
        getContentPane().add(sal_calc, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 470, 160, 30));

        jLabel20.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel20.setForeground(java.awt.Color.white);
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Calculated Salary");
        getContentPane().add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 450, 160, -1));

        jLabel6.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel6.setForeground(java.awt.Color.white);
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("EPF");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 210, 160, -1));
        getContentPane().add(empID1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 60, 70, -1));

        empTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "empID", "fname", "lname", "nic"
            }
        ));
        empTable.setPreferredSize(new java.awt.Dimension(1000, 1000));
        jScrollPane2.setViewportView(empTable);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 450, 420, 140));

        sal_etfr.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 179, 0), 2));
        sal_etfr.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                sal_etfrFocusGained(evt);
            }
        });
        getContentPane().add(sal_etfr, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 390, 80, 30));

        sal_mnth.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));
        sal_mnth.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.green, 2));
        sal_mnth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sal_mnthActionPerformed(evt);
            }
        });
        getContentPane().add(sal_mnth, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 470, 160, 30));

        starAll.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        starAll.setForeground(java.awt.Color.red);
        starAll.setText("*");
        getContentPane().add(starAll, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 120, 20, 60));

        starLeave.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        starLeave.setForeground(java.awt.Color.red);
        starLeave.setText("*");
        getContentPane().add(starLeave, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 280, 20, 60));

        starDed.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        starDed.setForeground(java.awt.Color.red);
        starDed.setText("*");
        getContentPane().add(starDed, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 280, 20, 60));

        starnetSal.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        starnetSal.setForeground(java.awt.Color.red);
        starnetSal.setText("*");
        getContentPane().add(starnetSal, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 360, 20, 60));

        starEpf.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        starEpf.setForeground(java.awt.Color.red);
        starEpf.setText("*");
        getContentPane().add(starEpf, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 370, 20, 60));

        starMnth.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        starMnth.setForeground(java.awt.Color.red);
        starMnth.setText("*");
        getContentPane().add(starMnth, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 440, 20, 60));

        starCalc.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        starCalc.setForeground(java.awt.Color.red);
        starCalc.setText("*");
        getContentPane().add(starCalc, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 520, 20, 60));

        starEtf.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        starEtf.setForeground(java.awt.Color.red);
        starEtf.setText("*");
        getContentPane().add(starEtf, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 370, 20, 60));

        jLabel11.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel11.setForeground(java.awt.Color.white);
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Employee Table");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 420, 160, -1));
        getContentPane().add(txt_salID, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 80, 80, -1));

        jLabel18.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel18.setForeground(java.awt.Color.white);
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Leaves");
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 290, 160, -1));

        jLabel10.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel10.setForeground(java.awt.Color.white);
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Month");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 450, 160, -1));

        sal_etf.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 179, 0), 2));
        sal_etf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sal_etfActionPerformed(evt);
            }
        });
        getContentPane().add(sal_etf, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 230, 160, 30));

        jLabel12.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel12.setForeground(java.awt.Color.white);
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("ETF");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 210, 160, -1));

        sal_all.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 179, 0), 2));
        sal_all.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                sal_allFocusGained(evt);
            }
        });
        getContentPane().add(sal_all, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 150, 160, 30));

        jLabel9.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel9.setForeground(java.awt.Color.white);
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Allowance");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 130, 160, -1));

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
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/salary2.png"))); // NOI18N
        userleft.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 300, 110));

        getContentPane().add(userleft, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 720));

        jButton2.setText("DEMO");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 90, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/gray2.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-1, 0, 1390, -1));

        setSize(new java.awt.Dimension(1382, 759));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        clearAll();

    }//GEN-LAST:event_jButton10ActionPerformed

    private void sal_netActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sal_netActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sal_netActionPerformed

    private void sal_leavesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sal_leavesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sal_leavesActionPerformed

    private void sal_etfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sal_etfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sal_etfActionPerformed

    private void btnCalcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcActionPerformed

        if(validateForm() != -1)
            calculateSalary();

    }//GEN-LAST:event_btnCalcActionPerformed

    private void sal_calcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sal_calcActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sal_calcActionPerformed

    private void emp_selNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emp_selNameActionPerformed

        if (!(emp_selName.getSelectedItem().equals("None"))) {
            clear();
            sal_mnth.setEnabled(true);
            btn_update.setEnabled(false);
            btn_add.setEnabled(true);
            fillPrID(emp_selName.getSelectedItem().toString());
        } else {
            empID1.setText("");
            sal_mnth.setEnabled(false);
            btn_add.setEnabled(false);
            btn_update.setEnabled(true);
        }

    }//GEN-LAST:event_emp_selNameActionPerformed

    private void sal_mnthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sal_mnthActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sal_mnthActionPerformed

    private void sal_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sal_tableMouseClicked
        resetList();
        sal_mnth.setEnabled(false);
        int i = sal_table.getSelectedRow();
        TableModel model = sal_table.getModel();
        //prID.setText(model.getValueAt(i, 0).toString());
        txt_salID.setText(model.getValueAt(i, 0).toString());
        sal_all.setText(model.getValueAt(i, 5).toString());
        sal_epf.setText(model.getValueAt(i, 7).toString());
        sal_etf.setText(model.getValueAt(i, 8).toString());
        sal_leaves.setText(model.getValueAt(i, 11).toString());
        sal_ded.setText(model.getValueAt(i, 6).toString());
        sal_epfr.setText(model.getValueAt(i, 9).toString());
        sal_etfr.setText(model.getValueAt(i, 10).toString());
        sal_net.setText(model.getValueAt(i, 12).toString());
        sal_calc.setText(model.getValueAt(i, 13).toString());
        String mnth = (model.getValueAt(i, 14).toString());

        selectMonth(mnth);

        //sal_name.setText(model.getValueAt(i, 1).toString());
        //empID1.setText(model.getValueAt(i, 0).toString());
        //sal_name.setText(model.getValueAt(i, 1).toString());
    }//GEN-LAST:event_sal_tableMouseClicked

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        fullValidate();
        if (sum >= 14) {

            initialize();
            insert();

        }

        sum = 0;
    }//GEN-LAST:event_btn_addActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        if (txt_salID.equals(null) || txt_salID.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "No salary record has been selected to Update", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            fullValidate1();
            if (sum >= 13) {

                initialize();
                update();
            }

            sum = 0;
        }
    }//GEN-LAST:event_btn_updateActionPerformed

    private void sal_netFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_sal_netFocusGained
        sal_net.setText("");
        sal_calc.setText("");
        sal_epf.setText("");
        sal_etf.setText("");
        sal_etf.setText("");

    }//GEN-LAST:event_sal_netFocusGained

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        if (txt_salID.equals(null) || txt_salID.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "No salary record has been selected to Remove", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            initialize();
            deleteSalary();

        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void sal_allFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_sal_allFocusGained
        sal_net.setText("");
    }//GEN-LAST:event_sal_allFocusGained

    private void sal_dedFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_sal_dedFocusGained
        sal_net.setText("");
    }//GEN-LAST:event_sal_dedFocusGained

    private void sal_epfrFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_sal_epfrFocusGained
        sal_net.setText("");
    }//GEN-LAST:event_sal_epfrFocusGained

    private void sal_etfrFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_sal_etfrFocusGained
        sal_net.setText("");
    }//GEN-LAST:event_sal_etfrFocusGained

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        sal_etfr.setText("0.5");
        sal_epfr.setText("0.8");
        sal_all.setText("15000");
        sal_ded.setText("1500");
        sal_net.setText("20000");
        sal_leaves.setText("2");
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(salary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(salary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(salary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(salary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new salary().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCalc;
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_update;
    private javax.swing.JTextField empID1;
    private javax.swing.JTable empTable;
    private javax.swing.JComboBox<String> emp_selName;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField sal_all;
    private javax.swing.JTextField sal_calc;
    private javax.swing.JTextField sal_ded;
    private javax.swing.JTextField sal_epf;
    private javax.swing.JTextField sal_epfr;
    private javax.swing.JTextField sal_etf;
    private javax.swing.JTextField sal_etfr;
    private javax.swing.JTextField sal_leaves;
    private javax.swing.JComboBox<String> sal_mnth;
    private javax.swing.JTextField sal_net;
    private javax.swing.JTable sal_table;
    private javax.swing.JLabel starAll;
    private javax.swing.JLabel starCalc;
    private javax.swing.JLabel starDed;
    private javax.swing.JLabel starEpf;
    private javax.swing.JLabel starEtf;
    private javax.swing.JLabel starLeave;
    private javax.swing.JLabel starMnth;
    private javax.swing.JLabel starnetSal;
    private javax.swing.JLabel title;
    private javax.swing.JTextField txt_salID;
    private javax.swing.JPanel userleft;
    // End of variables declaration//GEN-END:variables

    private int validateForm() {

        String allowance = sal_all.getText();
        String deduction = sal_ded.getText();
        String leaves = sal_leaves.getText();
        String netSal = sal_net.getText();
        String epf = sal_epfr.getText();
        String etf = sal_etfr.getText();

        if (strValidate(sal_all) == -1) {
            message("Allowance Field Empty !");
            starGenerator(true, starAll);
            return -1;
        } else {
            starGenerator(false, starAll);
        }

        if (!allowance.matches("[0-9]+(\\.){0,1}[0-9]+")) {
            message("Allowance  Field is Invalid !");
            starGenerator(true, starAll);
            return -1;
        } else {
            starGenerator(false, starAll);
        }

        if (strValidate(sal_leaves) == -1) {
            message("Leave Field Empty !");
            starGenerator(true, starLeave);
            return -1;
        } else {
            starGenerator(false, starLeave);
        }               
        
        
        if (!leaves.matches("[0-9]+")) {
            message("Leaves Field is Invalid !");
            starGenerator(true, starLeave);
            return -1;
        } else {
            starGenerator(false, starLeave);
        }
        
        
        if (strValidate(sal_ded) == -1) {
            message("Deduction Field Empty !");
            starGenerator(true, starDed);
            return -1;
        } else {
            starGenerator(false, starDed);
        }

        if (!deduction.matches("[0-9]+(\\.){0,1}[0-9]+")) {
            message("Deduction Field is Invalid !");
            starGenerator(true, starDed);
            return -1;
        } else {
            starGenerator(false, starDed);
        }

        

        if (strValidate(sal_epfr) == -1) {
            message("EPF Field Empty !");
            starGenerator(true, starEpf);
            return -1;
        } else {
            starGenerator(false, starEpf);
        }            
        
        if (floatValidate(sal_epfr) == -1) {
            message("EPF  Field is Invalid !");
            starGenerator(true, starEpf);
            return -1;
        } else {
            starGenerator(false, starEpf);
        }

        if (strValidate(sal_etfr) == -1) {
            message("ETF Field Empty !");
            starGenerator(true, starEtf);
            return -1;
        } else {
            starGenerator(false, starEtf);
        }           
        
        if (floatValidate(sal_etfr) == -1) {
            message("ETF  Field is Invalid !");
            starGenerator(true, starEtf);
            return -1;
        } else {
            starGenerator(false, starEtf);
        }

        

        
        if (strValidate(sal_net) == -1) {
            message("Net Salary Field Empty !");
            starGenerator(true, starnetSal);
            return -1;
        } else {
            starGenerator(false, starnetSal);
        }        
        
        
        if (!netSal.matches("[0-9]+(\\.){0,1}[0-9]+")) {
            message("NetSal  Field is Invalid !");
            starGenerator(true, starnetSal);
            return -1;
        } else {
            starGenerator(false, starnetSal);
        }
        return 0;
    }

    private void message(String message) {
        JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    private void starGenerator(boolean cond, JLabel jLabel) {
        jLabel.setVisible(cond);
    }

}
