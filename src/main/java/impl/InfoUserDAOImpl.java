package impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import dao.InfoUserDAO;
import db.MySQLDriver;
import model.InfoUser;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InfoUser find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<InfoUser> findByProperty(String column, Object value) {
		// TODO Auto-generated method stub
		return null;
	}



}
