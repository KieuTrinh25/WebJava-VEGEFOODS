package connect;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectUtils {
public static Connection getConnection() throws ClassNotFoundException, SQLException{
		
		return ConnectMySQL.getConn();
	}
	public static void closeQuiely(Connection conn) {
		try {
			conn.close();
		}catch(Exception ex) {
			
		}
	}
	public static void rollbackQuiely(Connection conn) {
		try {
			conn.rollback();
		}catch(Exception ex) {
			
		}
	}
}
