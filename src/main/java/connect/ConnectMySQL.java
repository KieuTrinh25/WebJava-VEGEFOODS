package connect;

import java.sql.*;

public class ConnectMySQL {
	private final static String DB_URL = "jdbc:mysql://localhost:3306/db";
    private final static String DB_USER = "root";
    private final static String BD_PASS = "";
	 private static ConnectMySQL instance;
	    
	    public static ConnectMySQL getInstance(){
	        if(instance == null) instance = new ConnectMySQL();
	        return instance;
	    }
	    
	public static Connection getConn() {
		 Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
	        return DriverManager.getConnection(DB_URL, DB_USER, BD_PASS);
		} catch (Exception e) {
			e.printStackTrace();
		}
	return conn;
        
    }
	public static void main(String[] args) {
	 
//		try {
//	       // System.out.print(ConnectMySQL().getConn());
//	        Connection conn = new ConnectMySQL().getConn();
//	        PreparedStatement ps = conn.prepareStatement("select * from users");
//	        ResultSet rs = ps.executeQuery();
//	        while (rs.next()) {
//			   System.out.println(rs.getString(2));
//	        }
//        } catch (Exception e) {
//	            e.printStackTrace();
//		}
		System.out.println(getConn());
	}

 

 
 	 
	
}
