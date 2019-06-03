package printer;

import java.text.MessageFormat;
import javax.swing.JTable;


public class printer {
    
    private MessageFormat header; 
    private String tablename;
    private String searchField;
    private JTable jTable;
    
    public printer(String tablename, String searchField, JTable jTable){
        this.tablename = tablename;
        this.searchField = searchField;
        this.jTable = jTable;
    }
    
    public void print(){
    if (searchField.equals("") || searchField.equals(null) || searchField == null) {
            header = new MessageFormat("Report Print " + tablename + " Filtered By None");
        } else {
            header = new MessageFormat("Report Print " + tablename + " Filtered By " + searchField);
        }
        MessageFormat footer = new MessageFormat("Page");
        
        try {
            jTable.print(JTable.PrintMode.FIT_WIDTH, header, footer);
        } catch (java.awt.print.PrinterException e) {
            e.printStackTrace();
        }
    }
}
