package impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import dao.UserDAO;
import db.MySQLDriver;
import model.User;

public class UserDAOImpl implements UserDAO{

	@Override
	public boolean insert(User user) {
		  Connection conn = MySQLDriver.getInstance().getConnection();
		    try {
		        String sql = "INSERT INTO USERS VALUES(null,?,?,?)";            
		        PreparedStatement stmt = conn.prepareStatement(sql);
		        stmt.setString(1, user.getPhone());
		        stmt.setString(2, user.getPassword());
		        stmt.setString(3, user.getRole());
		        stmt.execute();
		    } catch (SQLException ex) {
		        return false;
		    }
		    return true;
	}

	@Override
	public boolean update(User user) {
		Connection conn = MySQLDriver.getInstance().getConnection();
	    try {
	        String sql = "UPDATE USERS SET PHONE = ?, PASSWORD = ?, ROLE = ? WHERE ID = ?";            
	        PreparedStatement stmt = conn.prepareStatement(sql);
	        stmt.setString(1, user.getPhone());
	        stmt.setString(2, user.getPassword());
	        stmt.setString(3, user.getRole());
	        stmt.setInt(4, user.getId());
	        stmt.execute();
	    } catch (SQLException ex) {
	        return false;
	    }
	    return true;
	}

	@Override
	public boolean delete(int userId) {
		 Connection conn = MySQLDriver.getInstance().getConnection();
	    try {
	        String sql = "DELETE FROM USER WHERE ID = ?";            
	        PreparedStatement stmt = conn.prepareStatement(sql);
	         
	        stmt.setInt(1, userId);
	        stmt.execute();
	    } catch (SQLException ex) {
	        return false;
	    }
	    return true;
	}

	@Override
	public List<User> all() {
		List<User> userList = new ArrayList<User>();
		Connection conn = MySQLDriver.getInstance().getConnection();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from users");
			while(rs.next()) {
				 int id = rs.getInt("id");
				String phone = rs.getString("phone");
				String password = rs.getString("password");
				String role = rs.getString("role");
				
				userList.add(new User(id, phone, password, role));
			}
		}catch(SQLException ex) {
			 Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
		}
		return userList;
	}

	@Override
	public User find(int id) {
		Connection conn = MySQLDriver.getInstance().getConnection();
        try {
            String sql = "SELECT * FROM USERS WHERE ID=? LIMIT 1";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
            	String phone = rs.getString("phone");
				String password = rs.getString("password");
				String role = rs.getString("role");
                
                return new User(id, phone, password, role);
            }
        } catch (SQLException ex) {
            return null;
        }
        return null;
	}

	@Override
	public List<User> findByProperty(String column, Object value) {
		List<User> userList = new ArrayList<User>();
		Connection conn = MySQLDriver.getInstance().getConnection();
		try {
			String sql = "select * from users where id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, column);
			stmt.setString(2, value.toString());
			 ResultSet rs = stmt.executeQuery();
			 while(rs.next()) {
				 int id = rs.getInt("id");
				 String phone = rs.getString("phone");
				 String password = rs.getString("password");
				 String role = rs.getString("role");
				 
				 userList.add(new User(id, phone, password, role));
			 }
		}catch(SQLException ex) {
			 Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
		}
		return userList;
	}

	@Override
	public User login(String phone, String password) {
		 Connection conn = MySQLDriver.getInstance().getConnection();
		try {
			String sql ="select * from users where phone = ? and password = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, phone);
			stmt.setString(2, password);
			 ResultSet rs = stmt.executeQuery();
			 if(rs.next()) {
				 int id = rs.getInt("id");
				 String role = rs.getString("role");
				 
				 return new User(id, phone, password, role);
			 }
		}catch(SQLException ex) {
			return null;
		}
		return null;
	}

	@Override
	public boolean register(String phone, String password) {
		if(checkUserExists(phone)) return false;
		insert(new User( phone, password, "user"));
		return true;
	}

	@Override
	public boolean checkUserExists(String phone) {
		 Connection conn = MySQLDriver.getInstance().getConnection();
		try {
			String sql = "select * from users where phone = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, phone);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				return true;
			}
		}catch(SQLException ex) {
			return false;
		}
		return false;
	}

	
	
}
