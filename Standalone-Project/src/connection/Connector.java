package connection;
import java.sql.*;

public class Connector {
    public Connection myConn;
	public Statement myStmt;
	public ResultSet myRs;
		
	public Connector(){	
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/orocare", "root", "");
			myStmt = myConn.createStatement();
		}catch(Exception e) {	
			System.out.println(e);
		}
	}
        
        public Connection getConnection(){
            return myConn;
        }
        
        
        public ResultSet getResultSet(){
            return this.myRs;
        }
        
        public Statement getStatement(){
            return this.myStmt;
        }
        
}
