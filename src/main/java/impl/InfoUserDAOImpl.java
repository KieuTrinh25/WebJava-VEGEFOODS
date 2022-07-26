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

import dao.InfoUserDAO;
import db.MySQLDriver;
import model.InfoUser;
import model.User;

public class InfoUserDAOImpl implements InfoUserDAO{

	@Override
	public boolean insert(InfoUser infoUser) {
		  Connection conn = MySQLDriver.getInstance().getConnection();
		    try {
		        String sql = "INSERT INTO INFO_USERS VALUES(null,?,?,?,?)";            
		        PreparedStatement stmt = conn.prepareStatement(sql);
		        stmt.setString(1, infoUser.getFull_name());
		        stmt.setString(2, infoUser.getAddress());
		        stmt.setString(3, infoUser.getNote());
		        stmt.setInt(4, infoUser.getUsers_id());
		        stmt.execute();
		    } catch (SQLException ex) {
		    	ex.printStackTrace();
		        return false;
		    }
		    return true;
	}

	@Override
	public boolean update(InfoUser infoUser) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int infoUserId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<InfoUser> all() {
		List<InfoUser> infoUserList = new ArrayList<InfoUser>();
		Connection conn = MySQLDriver.getInstance().getConnection();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from info_users");
			while(rs.next()) {
				int id = rs.getInt("id");
				String fullName = rs.getString("full_name");
				String address = rs.getString("address");
				String note = rs.getString("note");
				int users_id = rs.getInt("users_id");
				
				infoUserList.add(new InfoUser(id, fullName, address, note, users_id));
			}
		}catch(SQLException ex) {
			 Logger.getLogger(InfoUserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
		}
		return infoUserList;
	}

	@Override
	public InfoUser find(int id) {
		Connection conn = MySQLDriver.getInstance().getConnection();
        try {
            String sql = "SELECT * FROM info_users WHERE ID=? LIMIT 1";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
				String fullName = rs.getString("full_name");
				String address = rs.getString("address");
				String note = rs.getString("note");
				int users_id = rs.getInt("users_id");
                
                return new InfoUser(id, fullName, address, note, users_id);
            }
        } catch (SQLException ex) {
            return null;
        }
        return null;
	}

	@Override
	public List<InfoUser> findByProperty(String column, Object value) {
		List<InfoUser> infoUserList = new ArrayList<InfoUser>();
		Connection conn = MySQLDriver.getInstance().getConnection();
		try {
			String sql = "select * from info_users where id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, column);
			stmt.setString(2, value.toString());
			 ResultSet rs = stmt.executeQuery();
			 while(rs.next()) {
				int id = rs.getInt("id"); 
				String fullName = rs.getString("full_name");
				String address = rs.getString("address");
				String note = rs.getString("note");
				int users_id = rs.getInt("users_id");
				infoUserList.add(new InfoUser(id, fullName, address, note, users_id));
		 }
		}catch(SQLException ex) {
			 Logger.getLogger(InfoUserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
		}
		return infoUserList;
	}



}
