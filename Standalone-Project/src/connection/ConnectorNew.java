package connection;
import java.sql.*;


public class ConnectorNew {
        public Connection myConn;
	public Statement myStmt;
	public ResultSet myRs;
		
	public Connection ConnectorNew(){	
		try{
			Class.forName("com.mysql.jdbc.Driver");
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/orocare", "root", "");
			
                        return myConn;
                        
		}catch(Exception e) {	
			e.printStackTrace();
                        return null;
		}
	}
}

